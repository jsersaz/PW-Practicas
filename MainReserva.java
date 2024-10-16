package es.uco.pw.ejercicio2;

import java.time.LocalDate;

public class MainReserva {
    public static void main(String[] args) {
        // Crear una instancia de la fábrica de reservas
        ReservaFactory reservaIndividual = new ReservaIndividual();
        ReservaFactory reservaBono = new ReservaBono();

        // Crear reservas individuales
        Reserva reservaInfantil = reservaIndividual.crearReservaInfantil("infantil1", LocalDate.of(2024, 10, 15), 60, 1, 30.0f, 5.0f, 3);
        Reserva reservaFamiliar = reservaIndividual.crearReservaFamiliar("familiar1", LocalDate.of(2024, 10, 16), 90, 2, 50.0f, 10.0f, 2, 3);
        Reserva reservaAdultos = reservaIndividual.crearReservaAdultos("adultos1", LocalDate.of(2024, 10, 17), 120, 3, 70.0f, 15.0f, 4);

        // Crear reservas usando bonos
        Reserva reservaInfantilBono = reservaBono.crearReservaInfantil("infantil2", LocalDate.of(2024, 10, 18), 60, 1, 30.0f, 5.0f, 1);
        Reserva reservaFamiliarBono = reservaBono.crearReservaFamiliar("familiar2", LocalDate.of(2024, 10, 19), 90, 2, 50.0f, 10.0f, 2, 2);
        Reserva reservaAdultosBono = reservaBono.crearReservaAdultos("adultos2", LocalDate.of(2024, 10, 20), 120, 3, 70.0f, 15.0f, 3);

        // Imprimir los detalles de las reservas
        System.out.println(reservaInfantil);
        System.out.println(reservaFamiliar);
        System.out.println(reservaAdultos);
        System.out.println(reservaInfantilBono);
        System.out.println(reservaFamiliarBono);
        System.out.println(reservaAdultosBono);
    }
}
