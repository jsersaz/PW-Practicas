package es.uco.pw.ejercicio2;

import java.time.LocalDate;

public class ReservaIndividual extends ReservaFactory{
	public ReservaInfantil crearReservaInfantil(String idReserva, LocalDate fecha, int duracion, int idPista, float precio, float descuento, int numeroNinos) {
		return new ReservaInfantil(idReserva, fecha, duracion, idPista, precio, descuento, numeroNinos);
	}
	
	public ReservaFamiliar crearReservaFamiliar(String idReserva, LocalDate fecha, int duracion, int idPista, float precio, float descuento, int numeroAdultos, int numeroNinos) {
		return new ReservaFamiliar(idReserva, fecha, duracion, idPista, precio, descuento, numeroAdultos, numeroNinos);
	}
	
	public ReservaAdultos crearReservaAdultos(String idReserva, LocalDate fecha, int duracion, int idPista, float precio, float descuento, int numeroParticipantes) {
		return new ReservaAdultos(idReserva, fecha, duracion, idPista, precio, descuento, numeroParticipantes);
	}
}
