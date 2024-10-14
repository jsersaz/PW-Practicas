package es.uco.pw.ejercicio2;

import java.time.LocalDate;

public class ConcreteReservaFactory extends AbstractReservaFactory{
	public Reserva crearReservaIndividual(String tipo, String idReserva, LocalDate fecha, int duracion, int idPista, float precio, float descuento, int... participantes) {
		switch(tipo.toLowerCase()) {
			case "infantil":
				return new ReservaInfantil(idReserva, fecha, duracion, idPista, precio, descuento, participantes[0]);
			case "familiar":
				return new ReservaFamiliar(idReserva, fecha, duracion, idPista, precio, descuento, participantes[0], participantes[1]);
			case "adultos":
				return new ReservaAdultos(idReserva, fecha, duracion, idPista, precio, descuento, participantes[0]);
			default:
				throw new IllegalArgumentException("Tipo de reserva no válido: " + tipo);
		}
	}

	public Reserva crearReservaBono(String tipo, String idReserva, LocalDate fecha, int duracion, int idPista, float precio, float descuento, String idBono, int numeroSesion, int... participantes) {
		switch(tipo.toLowerCase()) {
			case "infantil":
				return new ReservaInfantil(idReserva, fecha, duracion, idPista, precio, descuento, participantes[0], idBono, numeroSesion);
			case "familiar":
				return new ReservaFamiliar(idReserva, fecha, duracion, idPista, precio, descuento, participantes[0], participantes[1], idBono, numeroSesion);
			case "adultos":
				return new ReservaAdultos(idReserva, fecha, duracion, idPista, precio, descuento, participantes[0], idBono, numeroSesion);
			default:
				throw new IllegalArgumentException("Tipo de reserva no válido: " + tipo);
		}
	}
}
