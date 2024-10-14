package es.uco.pw.ejercicio2;

import java.time.LocalDate;

public class MainReserva {
    public static void main(String[] args) {
        // Crear una instancia de la fábrica de reservas
        ConcreteReservaFactory reservaFactory = new ConcreteReservaFactory();

        // Crear reservas individuales
        AbstractReserva reservaInfantil = reservaFactory.crearReservaIndividual("infantil", "R001", LocalDate.of(2024, 10, 15), 60, 1, 30.0f, 5.0f, 3);
        AbstractReserva reservaFamiliar = reservaFactory.crearReservaIndividual("familiar", "R002", LocalDate.of(2024, 10, 16), 90, 2, 50.0f, 10.0f, 2, 3);
        AbstractReserva reservaAdultos = reservaFactory.crearReservaIndividual("adultos", "R003", LocalDate.of(2024, 10, 17), 120, 3, 70.0f, 15.0f, 4);

        // Crear reservas usando bonos
        AbstractReserva reservaInfantilBono = reservaFactory.crearReservaBono("infantil", "R004", LocalDate.of(2024, 10, 18), 60, 1, 30.0f, 5.0f, "BONO123", 1, 2);
        AbstractReserva reservaFamiliarBono = reservaFactory.crearReservaBono("familiar", "R005", LocalDate.of(2024, 10, 19), 90, 2, 50.0f, 10.0f, "BONO456", 2, 2, 3);
        AbstractReserva reservaAdultosBono = reservaFactory.crearReservaBono("adultos", "R006", LocalDate.of(2024, 10, 20), 120, 3, 70.0f, 15.0f, "BONO789", 3, 5);

        // Imprimir los detalles de las reservas
        System.out.println(reservaInfantil);
        System.out.println(reservaFamiliar);
        System.out.println(reservaAdultos);
        System.out.println(reservaInfantilBono);
        System.out.println(reservaFamiliarBono);
        System.out.println(reservaAdultosBono);
    }
}
