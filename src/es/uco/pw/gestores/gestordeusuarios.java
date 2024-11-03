package es.uco.pw.gestores;

import java.io.BufferedReader;
import es.uco.pw.clases.jugador.Jugador;
import es.uco.pw.clases.reserva.Bono;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.time.LocalDate;

/**
 * Clase gestordeusuarios que gestiona los usuarios registrados en el sistema.
 * Incluye funcionalidades para cargar, modificar, listar, y respaldar jugadores.
 */
public class gestordeusuarios {

    private ArrayList<Jugador> jugadores;
    private static Properties properties;
    private static gestordeusuarios players;

    /**
     * Constructor privado de gestordeusuarios.
     * Inicializa la lista de jugadores y carga propiedades desde un archivo de configuración.
     */
    private gestordeusuarios() {
        jugadores = new ArrayList<Jugador>();
        properties = new Properties();
        try (FileInputStream input = new FileInputStream("properties.txt")) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Obtiene una instancia única de gestordeusuarios.
     * @return La instancia única de gestordeusuarios.
     */
    public static gestordeusuarios obtenerUsuarios() {
        if (players == null) {
            players = new gestordeusuarios();
        }
        return players;
    }

    /**
     * Carga la lista de jugadores desde el archivo especificado en las propiedades.
     */
    public void cargarFichero() {
        try (BufferedReader br = new BufferedReader(new FileReader(properties.getProperty("ficheroJugadores")))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(";");
                if (campos.length >= 5) {
                    try {
                        Jugador player = new Jugador();
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
     * Realiza una copia de seguridad de la lista de jugadores en el archivo especificado en las propiedades.
     */
    public void backupFichero() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(properties.getProperty("ficheroJugadores")))) {
            for (Jugador p : this.jugadores) {
                bw.write(p.getNombre());
                bw.write(";");
                bw.write(p.getApellidos());
                bw.write(";");
                String fechanacimiento = p.getFechaNacimiento().toString();
                bw.write(fechanacimiento);
                bw.write(";");
                String fechainscripcion = p.getFechaInscripcion().toString();
                bw.write(fechainscripcion);
                bw.write(";");
                bw.write(p.getEmail());
                bw.write(";");
                bw.write(p.getDni());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Añade un nuevo jugador a la lista de jugadores si no está registrado previamente.
     * @param p El jugador a añadir.
     * @return true si el jugador se añade con éxito; false si ya está registrado.
     */
    public boolean addJugador(Jugador p) {
        for (Jugador q : this.jugadores) {
            if (q.getDni().equals(p.getDni())) {
                return false;
            }
        }
        this.jugadores.add(p);
        return true;
    }

    /**
     * Modifica la información de un jugador en la lista de jugadores.
     * @param nombrenuevo El nuevo nombre del jugador.
     * @param apellidosnuevos Los nuevos apellidos del jugador.
     * @param nuevaFechaNacimientoDate La nueva fecha de nacimiento del jugador.
     * @param nuevoEmail El nuevo correo electrónico del jugador.
     * @param emailBuscar El correo electrónico del jugador a buscar.
     * @return true si se modifica la información correctamente; false si no se encuentra el jugador.
     */
    public boolean modificarJugador(String nombrenuevo, String apellidosnuevos, LocalDate nuevaFechaNacimientoDate, String nuevoEmail, String nuevoDNI, String DNIBuscar) {
        for (Jugador a : this.jugadores) {
            if (a.getDni().equals(DNIBuscar)) {
                a.setNombre(nombrenuevo);
                a.setApellidos(apellidosnuevos);
                a.setFechaNacimiento(nuevaFechaNacimientoDate);
                a.setEmail(nuevoEmail);
                a.setDni(nuevoDNI);
                return true;
            }
        }
        return false;
    }
    

    /**
     * Imprime en la consola la lista de jugadores actualmente registrados.
     */
    public void print() {
        for (Jugador player : this.jugadores) {
            System.out.println(player.toString());
        }
    }
}
