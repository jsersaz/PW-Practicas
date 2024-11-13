package es.uco.pw.business.reserva;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Properties;

import es.uco.pw.business.jugador.JugadorDTO;
import es.uco.pw.business.material.Estado;
import es.uco.pw.business.material.MaterialDTO;
import es.uco.pw.business.material.Tipo;
import es.uco.pw.business.pista.PistaDTO;
import es.uco.pw.business.pista.tamanopista;
import es.uco.pw.business.reserva.BonoDTO;
import es.uco.pw.business.reserva.ReservaDTO;
import es.uco.pw.business.reserva.ReservaInfantilDTO;
import es.uco.pw.business.reserva.ReservaFamiliarDTO;
import es.uco.pw.business.reserva.ReservaIndividualDTO;
import es.uco.pw.business.reserva.ReservaAdultosDTO;
import es.uco.pw.business.reserva.ReservaBonoDTO;
import es.uco.pw.business.reserva.ReservaFactoryDTO;
import es.uco.pw.data.dao.ReservaDAO;

/**
 * Clase que gestiona las reservas de pistas deportivas y bonos asociados.
 */
public class gestordereservas {
    private ArrayList<ReservaDTO> reservas; // Lista de reservas realizadas
    private ArrayList<BonoDTO> bonos; // Lista de bonos existentes
    private ArrayList<JugadorDTO> jugadores;
    private ArrayList<PistaDTO> pistas;
    private static gestordereservas gestor; // Instancia única del gestor
    private static Properties properties; // Propiedades de configuración

    /**
     * Constructor privado para inicializar las listas de reservas y bonos,
     * así como cargar las propiedades desde un archivo.
     */
    private gestordereservas() {
        this.reservas = new ArrayList<ReservaDTO>();
        this.jugadores = new ArrayList<JugadorDTO>();
        this.pistas = new ArrayList<PistaDTO>();
        this.bonos = new ArrayList<BonoDTO>();
        properties = new Properties();

        try (FileInputStream input = new FileInputStream("properties.txt")) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para obtener la instancia única del gestor de reservas.
     *
     * @return la instancia del gestor
     */
    public static gestordereservas getGestor() {
        if (gestor == null) {
            gestor = new gestordereservas();
        }
        return gestor;
    }

    /**
     * Método para validar las condiciones generales de la reserva.
     *
     * @param pista  la pista a reservar
     * @param fecha  la fecha de la reserva
     * @return true si las condiciones son válidas, false en caso contrario
     */
    private boolean validarCondicionesReserva(PistaDTO pista, LocalDate fecha) {
        LocalDate ahora = LocalDate.now();
        if (fecha.isBefore(ahora.plusDays(1))) {
            System.out.println("La reserva debe hacerse con al menos 24 horas de antelación.");
            return false;
        }
        // Validar disponibilidad de la pista
        if (pista.isEstado() == false) {
            System.out.println("La pista no está disponible en la fecha seleccionada.");
            return false;
        }
        return true;
    }

    /**
     * Método para calcular el precio de la reserva según la duración.
     *
     * @param duracion la duración de la reserva en minutos
     * @return el precio correspondiente a la duración
     * @throws IllegalArgumentException si la duración no es válida
     */
    public float calcularPrecio(int duracion) {
        switch (duracion) {
            case 60:
                return 20f;
            case 90:
                return 30f;
            case 120:
                return 40f;
            default:
                throw new IllegalArgumentException("Duración no válida. Debe ser 60, 90 o 120 minutos.");
        }
    }

    /**
     * Método para hacer una reserva individual.
     *
     * @param bono           el bono asociado a la reserva
     * @param jugador        el jugador que realiza la reserva
     * @param pista          la pista a reservar
     * @param fecha          la fecha de la reserva
     * @param duracion       la duración de la reserva en minutos
     * @param tipoReserva    el tipo de reserva (infantil, familiar, adultos)
     * @param numeroNinos    el número de niños en la reserva
     * @param numeroAdultos  el número de adultos en la reserva
     * @return true si la reserva fue exitosa, false en caso contrario
     */
    public boolean hacerReservaIndividual(BonoDTO bono, JugadorDTO jugador, PistaDTO pista, LocalDate fecha, int duracion, String tipoReserva, int numeroNinos, int numeroAdultos) {
        ReservaDAO reservaDAO = new ReservaDAO();
    	
    	if (!validarCondicionesReserva(pista, fecha)) {
            return false;
        }

        float precio = calcularPrecio(duracion);
        float descuento;
        if (jugador.calcularAntiguedad() > 2) {
        	descuento = precio * 0.1f;
        }
        else {descuento = 0.0f;}
        ReservaFactoryDTO reservaIndividualFactory = new ReservaIndividualDTO();
        String idReserva;

        switch (tipoReserva.toLowerCase()) {
            case "infantil":
                idReserva = jugador.getDni() + "-I-I-" + fecha;
                ReservaInfantilDTO reservaInfantil = reservaIndividualFactory.crearReservaInfantil(bono, idReserva, jugador.getDni(), fecha, duracion, pista.getNombre(), precio, descuento, numeroNinos);
                reservas.add(reservaInfantil);
                reservaDAO.insertarReservaInfantil(reservaInfantil);
                break;
            case "familiar":
                idReserva = jugador.getDni() + "-F-I-" + fecha;
                ReservaFamiliarDTO reservaFamiliar = reservaIndividualFactory.crearReservaFamiliar(bono, idReserva, jugador.getDni(), fecha, duracion, pista.getNombre(), precio, descuento, numeroNinos, numeroAdultos);
                reservas.add(reservaFamiliar);
                reservaDAO.insertarReservaFamiliar(reservaFamiliar);
                break;
            case "adultos":
                idReserva = jugador.getDni() + "-A-I-" + fecha;
                ReservaAdultosDTO reservaAdultos = reservaIndividualFactory.crearReservaAdultos(bono, idReserva, jugador.getDni(), fecha, duracion, pista.getNombre(), precio, descuento, numeroAdultos);
                reservas.add(reservaAdultos);
                reservaDAO.insertarReservaAdultos(reservaAdultos);
                break;
            default:
                System.out.println("Error. Tipo de reserva no válido.");
                return false;
        }
        return true;
    }





    
/**
 * Método para hacer una reserva dentro de un bono.
 *
 * Este método valida las condiciones de la reserva, verifica si el bono es válido,
 * calcula el precio de la reserva aplicando un descuento del 5%, y crea una reserva
 * según el tipo especificado (infantil, familiar o adultos) utilizando el patrón de diseño
 * de fábrica. Si la reserva es exitosa, se añade a la lista de reservas.
 *
 * @param bono      El bono utilizado para la reserva.
 * @param jugador   El jugador que realiza la reserva.
 * @param pista     La pista en la que se realizará la reserva.
 * @param fecha     La fecha de la reserva.
 * @param duracion  La duración de la reserva en minutos.
 * @param tipoReserva El tipo de reserva a realizar (infantil, familiar o adultos).
 * @return true si la reserva se realiza correctamente, false en caso contrario.
 */
public boolean hacerReservaBono(BonoDTO bono, JugadorDTO jugador, PistaDTO pista, LocalDate fecha, int duracion, String tipoReserva, int numeroNinos, int numeroAdultos) {
	ReservaDAO reservaDAO = new ReservaDAO();
	
	if(!validarCondicionesReserva(pista, fecha)) {
        return false;
    }

    if(!bono.esValido()) {
        System.out.println("Error. El bono con ID " + bono.getIdBono() + " ha caducado.");
        return false;
    }

    float precio = calcularPrecio(duracion);
    float descuento = precio * 0.05f;
    ReservaFactoryDTO reservaBonoFactory = new ReservaBonoDTO();
    String idReserva;
    switch (tipoReserva.toLowerCase()) {
        case "infantil":
            idReserva = jugador.getDni() + "-I-B-" + fecha;
            ReservaInfantilDTO reservaInfantil = reservaBonoFactory.crearReservaInfantil(bono, idReserva, jugador.getDni(), fecha, duracion, pista.getNombre(), precio, descuento, numeroNinos);
            reservas.add(reservaInfantil);
            reservaDAO.insertarReservaInfantil(reservaInfantil);
            // bono.agregarReserva(reservaInfantil);
            // reserva = new ReservaInfantil(jugador.getDni(), fecha, duracion, pista.getId(), precio, 0, 1);
            break;
        case "familiar":
            idReserva = jugador.getDni() + "-F-B-" + fecha;
            ReservaFamiliarDTO reservaFamiliar = reservaBonoFactory.crearReservaFamiliar(bono, idReserva, jugador.getDni(), fecha, duracion, pista.getNombre(), precio, descuento, numeroNinos, numeroAdultos);
            reservas.add(reservaFamiliar);
            reservaDAO.insertarReservaFamiliar(reservaFamiliar);
            // bono.agregarReserva(reservaFamiliar);
            // reserva = new ReservaFamiliar(jugador.getDni(), fecha, duracion, pista.getId(), precio, 0, 1, 1); // Cambiar la lógica según sea necesario
            break;
        case "adultos":
            idReserva = jugador.getDni() + "-A-B-" + fecha;
            ReservaAdultosDTO reservaAdultos = reservaBonoFactory.crearReservaAdultos(bono, idReserva, jugador.getDni(), fecha, duracion, pista.getNombre(), precio, descuento, numeroAdultos);
            reservas.add(reservaAdultos);
            reservaDAO.insertarReservaAdultos(reservaAdultos);
            // bono.agregarReserva(reservaAdultos);
            // reserva = new ReservaAdultos(jugador.getDni(), fecha, duracion, pista.getId(), precio, 0, 1); // Cambiar la lógica según sea necesario
            break;
        default:
            System.out.println("Error. Tipo de reserva no válido.");
            return false;
    }
    return true;
}

/**
 * Método para crear un bono.
 *
 * Este método crea una nueva instancia de un bono y lo añade a la lista de bonos.
 *
 * @param idBono          El identificador del bono.
 * @param fechaCreacion   La fecha de creación del bono.
 * @param tipoPista      El tipo de pista asociado al bono.
 * @return true si el bono se crea correctamente, false en caso contrario.
 */
public boolean crearBono(String idBono, String idUsuario, LocalDate fechaCreacion, tamanopista tipoPista) {
    BonoDTO bono = new BonoDTO(idBono, idUsuario, fechaCreacion, tipoPista);
    bonos.add(bono);
    return true;
}

/**
 * Método para cancelar una reserva.
 *
 * Este método verifica si la reserva puede ser cancelada según su fecha y el
 * identificador del usuario. Si la cancelación es válida, se elimina la reserva
 * de la lista de reservas.
 *
 * @param reserva  La reserva a cancelar.
 * @param dni      El DNI del usuario que intenta cancelar la reserva.
 * @return true si la reserva se cancela correctamente, false en caso contrario.
 */
public boolean cancelarReserva(ReservaDTO reserva, String dni) {
    LocalDate ahora = LocalDate.now();
    if (reserva.getFecha().isBefore(ahora.plusDays(1))) {
        System.out.println("No se puede cancelar una reserva en las últimas 24 horas.");
        return false;
    }
    if (reserva.getIdUsuario().equals(dni)) {
        reservas.remove(reserva);
        return true;
    } else {
        System.out.println("No pueden cancelar reservas de otros usuarios.");
        return false;
    }
}

/**
 * Método para consultar el número de reservas futuras.
 *
 * Este método cuenta cuántas reservas están programadas para después de la fecha actual.
 *
 * @return El número de reservas futuras.
 */
public int consultarReservasFuturas() {
    int contador = 0;
    LocalDate ahora = LocalDate.now();
    for (ReservaDTO reserva : reservas) {
        if (reserva.getFecha().isAfter(ahora)) {
            contador++;
        }
    }
    return contador;
}

/**
 * Método para consultar reservas por fecha y pista.
 *
 * Este método devuelve una lista de reservas que coinciden con una fecha específica
 * y un identificador de pista.
 *
 * @param fecha   La fecha para filtrar las reservas.
 * @param idPista El identificador de la pista para filtrar las reservas.
 * @return Una lista de reservas que cumplen con los criterios especificados.
 */
public ArrayList<ReservaDTO> consultarReservasPorDiaYPista(LocalDate fecha, String idPista) {
    ArrayList<ReservaDTO> reservasPorDiaYPista = new ArrayList<>();
    for (ReservaDTO reserva : reservas) {
        if (reserva.getFecha().isEqual(fecha) && reserva.getIdPista().equals(idPista)) {
            reservasPorDiaYPista.add(reserva);
        }
    }
    return reservasPorDiaYPista;
}

	/**
 * Método para obtener un bono por su identificador.
 *
 * Este método busca en la lista de bonos y devuelve el bono que coincide con el
 * identificador especificado. Si no se encuentra, se imprime un mensaje de error
 * y se devuelve null.
 *
 * @param idBono El identificador del bono que se desea obtener.
 * @return El bono correspondiente al identificador, o null si no existe.
 */
public BonoDTO obtenerBono(String idUsuario, String idBono) {
	BonoDTO bonoE = new BonoDTO();
    for (BonoDTO bono : bonos) {
        if (bono.getIdBono().equals(idBono)) {
        	bono.setNumeroSesion(bono.getNumeroSesion() + 1);
            bonoE = new BonoDTO(bono.getIdBono(), idUsuario, bono.getNumeroSesion(), bono.getFechaCreacion(), bono.getFechaCaducidad(), bono.getTipoPista());
        }
    }
    return bonoE;
}

/**
 * Método para obtener una reserva por su identificador.
 *
 * Este método busca en la lista de reservas y devuelve la reserva que coincide con el
 * identificador especificado. Si no se encuentra, se imprime un mensaje de error
 * y se devuelve null.
 *
 * @param idReserva El identificador de la reserva que se desea obtener.
 * @return La reserva correspondiente al identificador, o null si no existe.
 */
public ReservaDTO obtenerReserva(String idReserva) {
    for (ReservaDTO reserva : reservas) {
        if (reserva.getIdReserva().equals(idReserva)) {
            return reserva;
        }
    }
    System.out.println("Error. No existe la reserva especificada.");
    return null;
}

/**
 * Método para cargar las reservas desde un archivo.
 *
 * Este método lee las reservas desde un archivo especificado en las propiedades,
 * crea instancias de reserva a partir de cada línea, y las añade a la lista de reservas.
 * Si hay un error en la lectura de una línea, se imprime un mensaje de error.
 */
public void cargarReservas() {
    try (BufferedReader br = new BufferedReader(new FileReader(properties.getProperty("ficheroReservas")))) {
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] campos = linea.split(";");
            if (campos.length >= 3) {
                try {
                    ReservaDTO reserva = new ReservaDTO();
                    reserva.setIdReserva(campos[0]);
                    reserva.setIdUsuario(campos[1]);
                    reserva.setFecha(LocalDate.parse(campos[2]));
                    reserva.setDuracion(Integer.parseInt(campos[3]));
                    reserva.setIdPista(campos[4]);
                    reserva.setPrecio(Float.parseFloat(campos[5]));
                    reserva.setDescuento(Float.parseFloat(campos[6]));
                    reserva.setIdBono(campos[7]);
                    reserva.setNumeroSesion(Integer.parseInt(campos[8]));
                    this.reservas.add(reserva);
                } catch (NumberFormatException e) {
                    System.out.println("Ha ocurrido un error en la línea: " + linea);
                }
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}

/**
 * Método para hacer una copia de seguridad de las reservas en un archivo.
 *
 * Este método escribe las reservas actuales en un archivo especificado en las propiedades.
 * Cada reserva se escribe en una línea con sus atributos separados por punto y coma.
 */
public void backupReservas() {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(properties.getProperty("ficheroReservas")))) {
        for (ReservaDTO r : this.reservas) {
            bw.write(r.getIdReserva());
            bw.write(";");
            bw.write(r.getIdUsuario());
            bw.write(";");
            String fecha = r.getFecha().toString();
            bw.write(fecha);
            bw.write(";");
            bw.write(Integer.toString(r.getDuracion()));
            bw.write(";");
            bw.write(r.getIdPista());
            bw.write(";");
            bw.write(String.valueOf(r.getPrecio()));
            bw.write(";");
            bw.write(String.valueOf(r.getDescuento()));
            bw.write(";");
            bw.write(r.getIdBono());
            bw.write(";");
            bw.write(Integer.toString(r.getNumeroSesion()));
            bw.newLine();
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}

/**
 * Método para cargar los bonos desde un archivo.
 *
 * Este método lee los bonos desde un archivo especificado en las propiedades,
 * crea instancias de bono a partir de cada línea, y las añade a la lista de bonos.
 * Si hay un error en la lectura de una línea, se imprime un mensaje de error.
 */
public void cargarBonos() {
    try (BufferedReader br = new BufferedReader(new FileReader(properties.getProperty("ficheroBonos")))) {
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] campos = linea.split(";");
            if (campos.length >= 1) {
                try {
                    BonoDTO bono = new BonoDTO();
                    bono.setIdBono(campos[0]);
                    bono.setIdUsuario(campos[1]);
                    bono.setNumeroSesion(Integer.parseInt(campos[2]));
                    bono.setFechaCreacion(LocalDate.parse(campos[3]));
                    bono.setFechaCaducidad(LocalDate.parse(campos[4]));
                    tamanopista tamano = tamanopista.valueOf(campos[5]);
                    bono.setTipoPista(tamano);
                    this.bonos.add(bono);
                } catch (NumberFormatException e) {
                    System.out.println("Ha ocurrido un error en la línea: " + linea);
                }
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}

/**
 * Método para hacer una copia de seguridad de los bonos en un archivo.
 *
 * Este método escribe los bonos actuales en un archivo especificado en las propiedades.
 * Cada bono se escribe en una línea con sus atributos separados por punto y coma.
 */
public void backupBonos() {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(properties.getProperty("ficheroBonos")))) {
        for (BonoDTO b : this.bonos) {
            bw.write(b.getIdBono());
            bw.write(";");
            bw.write(b.getIdUsuario());
            bw.write(";");
            bw.write(String.valueOf(b.getNumeroSesion()));
            bw.write(";");
            String fechaCreacion = b.getFechaCreacion().toString();
            bw.write(fechaCreacion);
            bw.write(";");
            String fechaCaducidad = b.getFechaCaducidad().toString();
            bw.write(fechaCaducidad);
            bw.write(";");
            bw.write(b.getTipoPista().toString());
            bw.newLine();
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}


public void cargarJugadores() {
    try (BufferedReader br = new BufferedReader(new FileReader(properties.getProperty("ficheroJugadores")))) {
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] campos = linea.split(";");
            if (campos.length >= 5) {
                try {
                    JugadorDTO player = new JugadorDTO();
                    player.setNombre(campos[0]);
                    player.setApellidos(campos[1]);
                    player.setFechaNacimiento(LocalDate.parse(campos[2]));
                    player.setFechaInscripcion(LocalDate.parse(campos[3]));
                    player.setEmail(campos[4]);
                    player.setDni(campos[5]);
                    this.jugadores.add(player);
                } catch (NumberFormatException e) {
                    System.out.println("Ha ocurrido un error en la línea: " + linea);
                }
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}


/**
 * Busca un jugador existente por su DNI.
 * @param dni El DNI del jugador a buscar.
 * @return jugadorE El jugador correspondiente al DNI. Devuelve un jugador vacío si no se encuentra.
 */
public JugadorDTO obtenerJugador(String dni) {
	JugadorDTO jugadorE = new JugadorDTO();
    for (JugadorDTO jugador : this.jugadores) {
        if (jugador.getDni().equals(dni)) {
            jugadorE = new JugadorDTO(jugador.getNombre(), jugador.getApellidos(), jugador.getFechaNacimiento(), jugador.getFechaInscripcion(), jugador.getEmail(), jugador.getDni());
        }
    }
    return jugadorE;
}


/**
 * Carga los materiales desde el archivo de materiales.
 * 
 * @return una lista de materiales leídos desde el archivo.
 */
private ArrayList<MaterialDTO> cargarMaterialesBD() {
    ArrayList<MaterialDTO> materiales = new ArrayList<>();

    try (BufferedReader br = new BufferedReader(new FileReader(properties.getProperty("ficheroMateriales")))) {
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] campos = linea.split(";");

            MaterialDTO materialLeido = new MaterialDTO();

            materialLeido.setIdentificador(Integer.parseInt(campos[0]));
            Tipo tipo = Tipo.valueOf(campos[1]);
            materialLeido.setTipo(tipo);
            materialLeido.setUso(campos[2].equalsIgnoreCase("true"));
            Estado estado = Estado.valueOf(campos[3]);

            materiales.add(materialLeido);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    return materiales;
}


/**
 * Carga las pistas desde el archivo de pistas y asocia los materiales correspondientes.
 */
public void cargarBD() {
    // Primero cargo todos los materiales del fichero materiales en un array de materiales
    ArrayList<MaterialDTO> materiales = cargarMaterialesBD();

    try (BufferedReader br = new BufferedReader(new FileReader(properties.getProperty("ficheroPistas")))) {
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] campos = linea.split(";");
            PistaDTO pistaLeida = new PistaDTO();

            pistaLeida.setNombre(campos[0]);
            pistaLeida.setEstado(campos[1].equalsIgnoreCase("disponible"));
            pistaLeida.setTipoInterior(campos[2].equalsIgnoreCase("true"));
            tamanopista tamano = tamanopista.valueOf(campos[3]);
            pistaLeida.setTamano(tamano);
            pistaLeida.setMaxJugadores(Integer.parseInt(campos[4]));

            // Ahora proceso los materiales
            String[] materialesLeidos = campos[5].split(",");

            for (int i = 0; i < materialesLeidos.length; i++) {
                for (MaterialDTO m : materiales) {
                    if (m.getIdentificador() == Integer.parseInt(materialesLeidos[i])) {
                        pistaLeida.asociarMaterial_Pista(m);
                    }
                }
            }
            // Guardo la nueva pista en el array
            this.pistas.add(pistaLeida);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}


/**
 * Busca una pista existente por su nombre
 * @param nombre El nombre de la pista a buscar
 * @return pistaE La pista correspondiente al nombre. Devuelve una pista vacía si no se encuentra.
 */
public PistaDTO obtenerPista(String nombre) {
	PistaDTO pistaE = new PistaDTO();
    for (PistaDTO pista : pistas) {
        if (pista.getNombre().equals(nombre)) {
        	pistaE = new PistaDTO(pista.getNombre(), pista.isEstado(), pista.isTipoInterior(), pista.getTamano(), pista.getMaxJugadores(), pista.getMaterialAsociados());
        }
    }
    return pistaE;
}


public void mostrarPistas() {
	for (PistaDTO pistaI : pistas) {
		System.out.println(pistaI.toString());
	}
}


public void mostrarBonos() {
	for (BonoDTO bonoI : bonos) {
		System.out.println(bonoI.toString());
    }
}
}