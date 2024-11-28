package es.uco.pw.display;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.Scanner;

import es.uco.pw.business.jugador.JugadorDTO;
import es.uco.pw.business.pista.PistaDTO;
import es.uco.pw.business.pista.tamanopista;
import es.uco.pw.business.reserva.BonoDTO;
import es.uco.pw.business.reserva.ReservaDTO;
import es.uco.pw.business.reserva.gestordereservas;

public class mainreservas {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        gestordereservas gestor = gestordereservas.getGestor();
        gestor.cargarReservas();
        gestor.cargarBonos();
        gestor.cargarJugadores();
        gestor.cargarBD();

        // Crear algunos jugadores y pistas para el ejemplo
        // Jugador jugador1 = new Jugador("Juan", "Pérez", LocalDate.of(2004, 1, 1), LocalDate.of(2018, 1, 1), "juan@example.com", "1");
        // Jugador jugador2 = new Jugador("Ana", "Gómez", LocalDate.of(2001, 5, 15), LocalDate.of(2022, 5, 15), "ana@example.com", "2");
        // Pista pista1 = new Pista("Pista A", true, true, tamanopista.minibasket, 4);
        // Pista pista2 = new Pista("Pista B", true, false, tamanopista.adultos, 6);

        int opcion = 0;
        while (opcion != 7) {
            System.out.println("\nGestor de reservas");
            System.out.println("1. Alta reserva Individual");
            System.out.println("2. Alta reserva bono");
            System.out.println("3. Crear un bono");
            System.out.println("4. Cancelar reserva");
            System.out.println("5. Consultar número de reservas futuras");
            System.out.println("6. Consultar reservas por día y pista");
            System.out.println("7. Salir");
            System.out.print("Selecciona una opción: ");
            
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Introduce DNI para hacer la reserva: ");
                    String dni = scanner.nextLine();
                    JugadorDTO jugador = gestor.obtenerJugador(dni);
                    System.out.println("Usuario: " + jugador.getNombre() + " " + jugador.getApellidos());

                    System.out.println("Introduce el nombre de la pista: ");
                    String nombre = scanner.nextLine();
                    PistaDTO pista = gestor.obtenerPista(nombre);
                    System.out.println(pista.toString());
                    
                    System.out.print("Introduce la fecha de la reserva (YYYY-MM-DD): ");
                    String fechaStr = scanner.nextLine();
                    LocalDate fechaReserva = LocalDate.parse(fechaStr);

                    System.out.print("Introduce la duración de la reserva (60, 90 o 120 minutos): ");
                    String duracion = scanner.nextLine();
                    int duracion1= Integer.parseInt(duracion);
                    
                    System.out.print("Introduce el tipo de reserva ('infantil', 'familiar' o 'adultos'): ");
                    String tipoReserva = scanner.nextLine();
                    
                    int numeroNinos;
                    int numeroAdultos;
                    System.out.print("Introduce el número de niños: ");
            		numeroNinos = scanner.nextInt();
            		System.out.print("Introduce el número de adultos: ");
            		numeroAdultos = scanner.nextInt();

                    BonoDTO bonoNull = new BonoDTO();
                    boolean reservaCreada = gestor.hacerReservaIndividual(bonoNull, jugador, pista, fechaReserva, duracion1, tipoReserva, numeroNinos, numeroAdultos);
                    if (reservaCreada) {
                        System.out.println("Reserva creada exitosamente.");
                        gestor.backupReservas();
                    } else {
                        System.out.println("Error al crear la reserva. Verifica las condiciones.");
                    }
                    break;

                case 2:
                	System.out.print("Introduce DNI para hacer la reserva: ");
                    dni = scanner.nextLine();
                    jugador = gestor.obtenerJugador(dni);
                    System.out.println("Usuario: " + jugador.getNombre() + " " + jugador.getApellidos());

                    System.out.println("Introduce el nombre de la pista: ");
                    nombre = scanner.nextLine();
                    pista = gestor.obtenerPista(nombre);
                    System.out.println(pista.toString());

                    System.out.print("Introduce la fecha de la reserva (YYYY-MM-DD): ");
                    fechaStr = scanner.nextLine();
                    fechaReserva = LocalDate.parse(fechaStr);

                    System.out.print("Introduce la duración de la reserva (60, 90 o 120 minutos): ");            
                    String duracion2 = scanner.nextLine();
                    int duracion3 = Integer.parseInt(duracion2);
                    
                    System.out.println("Introduce el tipo de reserva ('infantil', 'familiar' o 'adultos'):");
                    tipoReserva = scanner.nextLine();
                    
                    System.out.println("Introduce el número de niños: ");
            		String numeroNinos1 = scanner.nextLine();
            		numeroNinos = Integer.parseInt(numeroNinos1);
            		System.out.println("Introduce el número de adultos: ");
            		String numeroAdultos1 = scanner.nextLine();
            		numeroAdultos = Integer.parseInt(numeroAdultos1);
                    
                    System.out.print("Introduce el ID del bono: ");
                    String idBono = scanner.nextLine();
                    
                    BonoDTO bono = new BonoDTO();
                    bono = gestor.obtenerBono(jugador.getDni(), idBono);
                    
                    boolean bonoCreado = gestor.hacerReservaBono(bono, jugador, pista, fechaReserva, duracion3, tipoReserva, numeroNinos, numeroAdultos);
                    if (bonoCreado) {
                        System.out.println("Reserva dentro del bono creada exitosamente.");
                        gestor.backupReservas();
                        gestor.backupBonos();
                    } else {
                        System.out.println("Error al crear la reserva dentro del bono.");
                    }
                    break;
                    
                case 3:
                    System.out.print("Introduce el ID del bono: ");
                    String IDBono = scanner.nextLine();
                    
                    System.out.print("Introduce tu DNI: ");
                    String idUsuario = scanner.nextLine();

                    System.out.print("Introduce la fecha de inicio (YYYY-MM-DD): ");
                    String fechaInicioStr = scanner.nextLine();
                    LocalDate fechaInicio = LocalDate.parse(fechaInicioStr);

                    System.out.printf("Introduce el tamaño de pista ('minibasket', 'adultos' o 'tres_vs_tres'): ");
                    String tipoPista = scanner.nextLine();
                    tamanopista tamano = tamanopista.valueOf(tipoPista.toLowerCase());
                    if(tamano != tamanopista.none) {
                    	System.out.println("Tamaño de pista seleccionado: " + tamano);
                    }
                    else {
                    	System.out.println("Error. El tamaño de pista ingresado no es válido.");
                    }
                    
                    boolean bonoNuevo = gestor.crearBono(IDBono, idUsuario, fechaInicio, tamano);
                    if (bonoNuevo == true){
                    	System.out.println("Bono creado correctamente");
                    }
                    gestor.backupBonos();
                    break;
                    
                case 4:
                	System.out.print("Introduce tu DNI: ");
                    String DNICancelar = scanner.nextLine();
                	
                    System.out.print("Introduce el ID de la reserva a cancelar: ");
                    String idReservaCancelar = scanner.nextLine();
                    ReservaDTO reserva = gestor.obtenerReserva(idReservaCancelar);

                    boolean cancelada = gestor.cancelarReserva(reserva, DNICancelar);
                    if (cancelada) {
                        System.out.println("Reserva cancelada exitosamente.");
                        gestor.backupReservas();
                    } else {
                        System.out.println("Error al cancelar la reserva. Verifica el ID o la fecha.");
                    }
                    break;

                case 5:
                    int reservasFuturas = gestor.consultarReservasFuturas();
                    System.out.println("Número de reservas futuras: " + reservasFuturas);
                    break;

                case 6:
                    System.out.print("Introduce la fecha (YYYY-MM-DD) para consultar: ");
                    fechaStr = scanner.nextLine();
                    LocalDate fechaConsulta = LocalDate.parse(fechaStr);

                    System.out.print("Introduce el ID de la pista: ");
                    String idPista = scanner.nextLine();

                    ArrayList<ReservaDTO> reservasPorDiaYPista = gestor.consultarReservasPorDiaYPista(fechaConsulta, idPista);
                    System.out.println("Reservas para " + fechaConsulta + " en la pista '" + idPista + "':");
                    for (ReservaDTO reservaBuscar : reservasPorDiaYPista) {
                        System.out.println(reservaBuscar.toString());
                    }
                    break;

                case 7:
                    opcion = 7;
                    mainprincipal.main(args);
                    break;

                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
                    break;
            }
        }
    }
}