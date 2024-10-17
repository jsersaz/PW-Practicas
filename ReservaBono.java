package es.uco.pw.ejercicio2;

import java.time.LocalDate;
import java.util.ArrayList;

public class ReservaBono extends ReservaFactory{	
	private ArrayList<Reserva> reservasHechas;
	
	public ReservaBono() {
		this.reservasHechas = new ArrayList<Reserva>();
	}
	
	public ReservaInfantil crearReservaInfantil(String idReserva, LocalDate fecha, int duracion, int idPista, float precio, float descuento, int numeroNinos) {
		if(this.reservasHechas.size() == 5) {
			return null;
		}
		Reserva nuevaReserva = new ReservaInfantil(idReserva, fecha, duracion, idPista, precio, descuento, numeroNinos);
		this.reservasHechas.add(nuevaReserva);
		return (ReservaInfantil) this.reservasHechas.get(0);
	}
	
	public ReservaFamiliar crearReservaFamiliar(String idReserva, LocalDate fecha, int duracion, int idPista, float precio, float descuento, int numeroAdultos, int numeroNinos) {
		if(this.reservasHechas.size() == 5) {
			return null;
		}
		Reserva nuevaReserva = new ReservaFamiliar(idReserva, fecha, duracion, idPista, precio, descuento, numeroAdultos, numeroNinos);
		this.reservasHechas.add(nuevaReserva);
		return (ReservaFamiliar) this.reservasHechas.get(0);
	}
	
	public ReservaAdultos crearReservaAdultos(String idReserva, LocalDate fecha, int duracion, int idPista, float precio, float descuento, int numeroParticipantes) {
		if(this.reservasHechas.size() == 5) {
			return null;
		}
		Reserva nuevaReserva = new ReservaAdultos(idReserva, fecha, duracion, idPista, precio, descuento, numeroParticipantes);
		this.reservasHechas.add(nuevaReserva);
		return (ReservaAdultos) this.reservasHechas.get(0);
	}
}
