package es.uco.pw.ejercicio2;

import java.time.LocalDate;

public class ReservaFamiliar extends Reserva {
	private int numeroAdultos;
	private int numeroNinos;
	
	public ReservaFamiliar() {
		super();
		this.numeroAdultos = -1;
		this.numeroNinos = -1;
	}
	
	public ReservaFamiliar(String idReserva, LocalDate fecha, int duracion, int idPista, float precio, float descuento, int numeroAdultos, int numeroNinos) {
		super(idReserva, fecha, duracion, idPista, precio, descuento);
		this.numeroAdultos = numeroAdultos;
		this.numeroNinos = numeroNinos;
	}
	
	public ReservaFamiliar(String idReserva, LocalDate fecha, int duracion, int idPista, float precio, float descuento, int numeroAdultos, int numeroNinos, String idBono, int numeroSesion) {
		super(idReserva, fecha, duracion, idPista, precio, descuento);
		this.numeroAdultos = numeroAdultos;
		this.numeroNinos = numeroNinos;
	}
	
	public int getNumeroAdultos() {
		return numeroAdultos;
	}
	public void setNumeroAdultos(int numeroAdultos) {
		this.numeroAdultos = numeroAdultos;
	}
	public int getNumeroNinos() {
		return numeroNinos;
	}
	public void setNumeroNinos(int numeroNinos) {
		this.numeroNinos = numeroNinos;
	}
	
	@Override
	public String toString() {
		return "Reserva familiar {" +
				"ID reserva: '" + idReserva + "'" +
				", ID bono: '" + (idBono != null ? idBono : "sin bono") + "'" +
				", Número de sesion: " + numeroSesion +
				", Fecha y hora: " + fecha +
				", Duracion: " + duracion + " minutos" +
				", ID pista: '" + idPista + "'" +
				", Precio: " + precio + " euros" +
				", Descuento: " + descuento + " euros" +
				", Numero de adultos: " + numeroAdultos +
				", Número de niños: " + numeroNinos + "}";
	}
}
