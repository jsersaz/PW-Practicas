package es.uco.pw.ejercicio2;

import java.time.LocalDate;

public abstract class ReservaFactory {
	public abstract ReservaInfantil crearReservaInfantil(String idReserva, LocalDate fecha, int duracion, int idPista, float precio, float descuento, int numeroNinos);
	public abstract ReservaFamiliar crearReservaFamiliar(String idReserva, LocalDate fecha, int duracion, int idPista, float precio, float descuento, int numeroAdultos, int numeroNinos);
	public abstract ReservaAdultos crearReservaAdultos(String idReserva, LocalDate fecha, int duracion, int idPista, float precio, float descuento, int numeroParticipantes);
	
}
