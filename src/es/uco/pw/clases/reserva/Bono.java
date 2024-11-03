package es.uco.pw.clases.reserva;

import java.time.LocalDate;
//import java.util.ArrayList;
import es.uco.pw.clases.pista.tamanopista;

public class Bono {
	private String idBono;
	private String idUsuario;
	private int numeroSesion;
	private LocalDate fechaCreacion;
    private LocalDate fechaCaducidad;
    private tamanopista tipoPista;
    // private ArrayList<Reserva> reservas;
   // private final int MAX_RESERVAS = 5;

	public Bono() {
		this.idBono = "";
		this.idUsuario = "";
		this.numeroSesion = -1;
		this.fechaCreacion = null;
		this.fechaCaducidad = null;
		this.tipoPista = tamanopista.none;
		// this.reservas = null;
	}
	
	public Bono(String idBono, String idUsuario, LocalDate fechaCreacion, tamanopista tipoPista) {
		this.idBono = idBono;
		this.idUsuario = idUsuario;
		this.numeroSesion = 0;
		this.fechaCreacion = fechaCreacion;
		this.fechaCaducidad = fechaCreacion.plusYears(1);
		this.tipoPista = tipoPista;
		// this.reservas = new ArrayList<>();
	}
	
	public Bono(String idBono, String idUsuario, int numeroSesion, LocalDate fechaCreacion, LocalDate fechaCaducidad, tamanopista tipoPista) {
		this.idBono = idBono;
		this.idUsuario = idUsuario;
		this.numeroSesion = numeroSesion;
		this.fechaCreacion = fechaCreacion;
		this.fechaCaducidad = fechaCreacion.plusYears(1);
		this.tipoPista = tipoPista;
		// this.reservas = new ArrayList<>();
	}

	public String getIdBono() {
		return idBono;
	}

	public void setIdBono(String idBono) {
		this.idBono = idBono;
	}
	
	public String getIdUsuario() {
		return idUsuario;
	}
	
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public int getNumeroSesion() {
		return numeroSesion;
	}

	public void setNumeroSesion(int numeroSesion) {
		this.numeroSesion = numeroSesion;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public LocalDate getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(LocalDate fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	public tamanopista getTipoPista() {
		return tipoPista;
	}

	public void setTipoPista(tamanopista tipoPista) {
		this.tipoPista = tipoPista;
	}

	/* public ArrayList<Reserva> getReservas() {
		return reservas;
	}
	*/

	/* public void setReservas(ArrayList<Reserva> reservas) {
		this.reservas = reservas;
	}
	*/
	
	/*public boolean agregarReserva(Reserva reserva) {
		if(reservas.size() < MAX_RESERVAS) {
			reservas.add(reserva);
			return true;
		}
		return false;
	}
	*/
	
	public boolean esValido() {
		return LocalDate.now().isBefore(this.fechaCaducidad);
	}
	
	
	@Override
    public String toString() {
        return "ID bono: '" + idBono + "'" +
        		", ID usuario: '" + idUsuario + "'" +
                ", Numero de sesión: " + numeroSesion +
                ", Fecha de creación: " + fechaCreacion +
                ", Fecha de caducidad: " + fechaCaducidad +
                ", Tipo de pista: " + tipoPista;
    }
}
