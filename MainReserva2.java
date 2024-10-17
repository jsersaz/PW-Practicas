package es.uco.pw.ejercicio2;

import java.time.LocalDate;

public class MainReserva2 {
    public static void main(String[] args) {
        // Crear instancias de ReservaFactory
        ReservaFactory reservaIndividualFactory = new ReservaIndividual();
        ReservaFactory reservaBonoFactory = new ReservaBono();
        
        // Crear reservas usando ReservaIndividual
        ReservaInfantil reservaInfantil = reservaIndividualFactory.crearReservaInfantil(
            "R1", LocalDate.of(2024, 10, 20), 60, 1, 100.0f, 10.0f, 3
        );

        ReservaFamiliar reservaFamiliar = reservaIndividualFactory.crearReservaFamiliar(
            "R2", LocalDate.of(2024, 10, 21), 90, 2, 150.0f, 20.0f, 2, 3
        );

        ReservaAdultos reservaAdultos = reservaIndividualFactory.crearReservaAdultos(
            "R3", LocalDate.of(2024, 10, 22), 120, 3, 200.0f, 30.0f, 5
        );

        // Mostrar reservas creadas
        System.out.println(reservaInfantil);
        System.out.println(reservaFamiliar);
        System.out.println(reservaAdultos);

        // Crear reservas usando ReservaBono
        ReservaInfantil reservaBonoInfantil = reservaBonoFactory.crearReservaInfantil(
            "R4", LocalDate.of(2024, 10, 23), 60, 1, 100.0f, 10.0f, 2
        );

        ReservaFamiliar reservaBonoFamiliar = reservaBonoFactory.crearReservaFamiliar(
            "R5", LocalDate.of(2024, 10, 24), 90, 2, 150.0f, 20.0f, 2, 3
        );

        ReservaAdultos reservaBonoAdultos = reservaBonoFactory.crearReservaAdultos(
            "R6", LocalDate.of(2024, 10, 25), 120, 3, 200.0f, 30.0f, 4
        );

        // Mostrar reservas creadas con Bono
        System.out.println(reservaBonoInfantil);
        System.out.println(reservaBonoFamiliar);
        System.out.println(reservaBonoAdultos);

        // Intentar crear más reservas con Bono para probar el límite
        for (int i = 0; i < 3; i++) {
            ReservaAdultos reservaExtra = reservaBonoFactory.crearReservaAdultos(
                "R" + (i + 7), LocalDate.of(2024, 10, 26 + i), 120, 4, 250.0f, 50.0f, 3
            );
            System.out.println(reservaExtra);
        }
    }
}
