package es.uco.pw.ejercicio1;

import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.Period;
// import java.text.DateFormat;
// import java.time.LocalDateTime;

public class Jugador {
	private String nombre;
	private String apellidos;
	private Date fecha_nacimiento;
	private Date fecha_inscripcion;
	private String email;
	
	public Jugador() {
		
	}
	
	public Jugador(String nombre, String apellidos, Date fecha_nacimiento, Date fecha_inscripcion, String email) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fecha_nacimiento = fecha_nacimiento;
		// LocalDateTime now = LocalDateTime.now();
		this.fecha_inscripcion = new Date();
		this.email = email;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public Date getFecha_inscripcion() {
		return fecha_inscripcion;
	}

	public void setFecha_inscripcion(Date fecha_inscripcion) {
		this.fecha_inscripcion = fecha_inscripcion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString() {
		String infoJugador = "Nombre: " + this.nombre + "  Apellidos: " + this.apellidos + "  Fecha de nacimiento: " + this.fecha_nacimiento
				+ "  Fecha de inscripción: " + this.fecha_inscripcion + "  Correo electrónico: " + this.email;
		return infoJugador;
	}
	
	public void calcularAntiguedad() {
		Date fechaPasada = this.fecha_inscripcion;
		LocalDate fechaPasadaT = fechaPasada.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		
		LocalDate fechaActual = LocalDate.now();
		
		int diferenciaAnyos = Period.between(fechaPasadaT, fechaActual).getYears();
		
		System.out.println("El usuario " + this.nombre + " " + this.apellidos + " lleva registrado " + diferenciaAnyos + " años");
	}
}
