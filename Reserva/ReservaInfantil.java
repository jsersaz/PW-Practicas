package es.uco.pw.ejercicio2;

import java.time.LocalDate;

public class ReservaInfantil extends AbstractReserva {
	private int numeroNinos;

	public ReservaInfantil() {
		super();
		this.numeroNinos = -1;
	}
	
	public ReservaInfantil(String idReserva, LocalDate fecha, int duracion, int idPista, float precio, float descuento, int numeroNinos) {
		super(idReserva, fecha, duracion, idPista, precio, descuento);
		this.numeroNinos = numeroNinos;
	}
	
	public ReservaInfantil(String idReserva, LocalDate fecha, int duracion, int idPista, float precio, float descuento, int numeroNinos, String idBono, int numeroSesion) {
		super(idReserva, fecha, duracion, idPista, precio, descuento);
		this.numeroNinos = numeroNinos;
	}
	
	public int getNumeroNinos() {
		return numeroNinos;
	}

	public void setNumeroNinos(int numeroNinos) {
		this.numeroNinos = numeroNinos;
	}
	
	@Override
	public String toString() {
		return "Reserva infantil {" +
				"ID reserva: '" + idReserva + "'" +
				", ID bono: '" + (idBono != null ? idBono : "sin bono") + "'" +
				", Número de sesion: " + numeroSesion +
				", Fecha y hora: " + fecha +
				", Duracion: " + duracion + " minutos" +
				", ID pista: '" + idPista + "'" +
				", Precio: " + precio + " euros" +
				", Descuento: " + descuento + " euros" +
				", Número de niños: " + numeroNinos + "}";
	}
}
