package es.uco.pw.ejercicio2;

import java.time.LocalDate;

public class ReservaAdultos extends AbstractReserva {
	private int numeroParticipantes;

	public ReservaAdultos() {
		super();
		this.numeroParticipantes = -1;
	}
		
	public ReservaAdultos(String idReserva, LocalDate fecha, int duracion, int idPista, float precio, float descuento, int numeroParticipantes) {
		super(idReserva, fecha, duracion, idPista, precio, descuento);
		this.numeroParticipantes = numeroParticipantes;
	}
	
	public ReservaAdultos(String idReserva, LocalDate fecha, int duracion, int idPista, float precio, float descuento, int numeroParticipantes, String idBono, int numeroSesion) {
		super(idReserva, fecha, duracion, idPista, precio, descuento);
		this.numeroParticipantes = numeroParticipantes;
	}
		
	public int getNumeroParticipantes() {
		return numeroParticipantes;
	}

	public void setNumeroParticipantes(int numeroParticipantes) {
		this.numeroParticipantes = numeroParticipantes;
	}
		
	@Override
	public String toString() {
		return "Reserva adultos {" +
				"ID reserva: '" + idReserva + "'" +
				", ID bono: '" + (idBono != null ? idBono : "sin bono") + "'" +
				", Número de sesion: " + numeroSesion +
				", Fecha y hora: " + fecha +
				", Duracion: " + duracion + " minutos" +
				", ID pista: '" + idPista + "'" +
				", Precio: " + precio + " euros" +
				", Descuento: " + descuento + " euros" +
				", Número de participantes: " + numeroParticipantes + "}";
	}
}
