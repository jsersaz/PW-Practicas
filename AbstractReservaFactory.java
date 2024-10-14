package es.uco.pw.ejercicio2;

import java.time.LocalDate;

public abstract class AbstractReservaFactory {
	public abstract Reserva crearReservaIndividual(String tipo, String idReserva, LocalDate fecha, int duracion, int idPista, float precio, float descuento, int... participantes);
	public abstract Reserva crearReservaBono(String tipo, String idReserva, LocalDate fecha, int duracion, int idPista, float precio, float descuento, String idBono, int numeroSesion, int... participantes);
}
