package es.uco.pw.ejercicio2;

import java.time.LocalDate;

public class Reserva {
	protected String id_reserva;
	protected LocalDate fecha;
	protected int duracion;
	protected int id_pista;
	protected float precio;
	protected float descuento;
	
	public Reserva() {
		this.id_reserva = "";
		this.fecha = LocalDate.of(1970, 1, 1);
		this.duracion = 0;
		this.id_pista = -1;
		this.precio = 0;
		this.descuento = 0;
	}
	
	public Reserva(String id_reserva, LocalDate fecha, int duracion, int id_pista, float precio, float descuento) {
		this.id_reserva = id_reserva;
		this.fecha = fecha;
		this.duracion = duracion;
		this.id_pista = id_pista;
		this.precio = precio;
		this.descuento = descuento;
	}
	
	public String getId_reserva() {
		return id_reserva;
	}
	
	public void setId_reserva(String id_reserva) {
		this.id_reserva = id_reserva;
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
	
	public int getId_pista() {
		return id_pista;
	}
	
	public void setId_pista(int id_pista) {
		this.id_pista = id_pista;
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
}
