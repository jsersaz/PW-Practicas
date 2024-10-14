package es.uco.pw.ejercicio2;

import java.time.LocalDate;

public abstract class Reserva {
	protected String idReserva;
	protected LocalDate fecha;
	protected int duracion;
	protected int idPista;
	protected float precio;
	protected float descuento;
	protected String idBono;
	protected int numeroSesion;
	
	public Reserva() {
		this.idReserva = "";
		this.fecha = LocalDate.of(1970, 1, 1);
		this.duracion = 0;
		this.idPista = -1;
		this.precio = 0;
		this.descuento = 0;
		this.idBono = "";
		this.numeroSesion = -1;
	}
	
	public Reserva(String id_reserva, LocalDate fecha, int duracion, int id_pista, float precio, float descuento) {
		this.idReserva = id_reserva;
		this.fecha = fecha;
		this.duracion = duracion;
		this.idPista = id_pista;
		this.precio = precio;
		this.descuento = descuento;
		this.idBono = null;
		this.numeroSesion = -1;
	}
	
	public Reserva(String id_reserva, LocalDate fecha, int duracion, int id_pista, float precio, float descuento, String idBono, int numeroSesion){
		this.idReserva = id_reserva;
		this.fecha = fecha;
		this.duracion = duracion;
		this.idPista = id_pista;
		this.precio = precio;
		this.idBono = idBono;
		this.numeroSesion = numeroSesion;
	}
	
	public String getIdReserva() {
		return idReserva;
	}
	
	public void setIdReserva(String idReserva) {
		this.idReserva = idReserva;
	}
	
	public LocalDate getFecha() {
		return fecha;
	}
	
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	public int getDuracion() {
		return duracion;
	}
	
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	
	public int getIdPista() {
		return idPista;
	}
	
	public void setId_pista(int idPista) {
		this.idPista = idPista;
	}
	
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	public float getDescuento() {
		return descuento;
	}
	
	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	public String getIdBono() {
		return idBono;
	}

	public void setIdBono(String idBono) {
		this.idBono = idBono;
	}

	public int getNumeroSesion() {
		return numeroSesion;
	}

	public void setNumeroSesion(int numeroSesion) {
		this.numeroSesion = numeroSesion;
	}
}