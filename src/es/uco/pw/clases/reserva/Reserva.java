package es.uco.pw.clases.reserva;

import java.time.LocalDate;

public class Reserva {
	/** Identificador único de la reserva */
    protected String idReserva;
    
    /** Identificador único del solicitante de la reserva */
    protected String idUsuario;

    /** Fecha de la reserva */
    protected LocalDate fecha;

    /** Duración de la reserva en minutos */
    protected int duracion;

    /** Identificador de la pista reservada */
    protected String idPista;

    /** Precio de la reserva */
    protected float precio;

    /** Descuento aplicado a la reserva */
    protected float descuento;

    /** Identificador del bono asociado a la reserva, si aplica */
    protected String idBono;

    /** Número de sesión de la reserva dentro del bono, si aplica */
    protected int numeroSesion;

    /**
     * Constructor vacío de la clase Reserva.
     * Inicializa los valores por defecto.
     */
    public Reserva() {
        this.idReserva = "";
        this.idUsuario = "";
        this.fecha = LocalDate.of(1970, 1, 1);
        this.duracion = 0;
        this.idPista = "";
        this.precio = 0;
        this.descuento = 0;
        this.idBono = "SIN-BONO";
        this.numeroSesion = -1;
    }

    /**
     * Constructor que inicializa una reserva con detalles básicos.
     *
     * @param id_reserva Identificador de la reserva
     * @param id_usuario Identificador del usuario que hace la reserva
     * @param fecha Fecha de la reserva
     * @param duracion Duración de la reserva en minutos
     * @param id_pista Identificador de la pista
     * @param precio Precio de la reserva
     * @param descuento Descuento aplicado a la reserva
     */
    public Reserva(String id_reserva, String id_usuario, LocalDate fecha, int duracion, String id_pista, float precio, float descuento) {
        this.idReserva = id_reserva;
        this.idUsuario = id_usuario;
        this.fecha = fecha;
        this.duracion = duracion;
        this.idPista = id_pista;
        this.precio = precio;
        this.descuento = descuento;
        this.idBono = "";
        this.numeroSesion = -1;
    }

    /**
     * Constructor que inicializa una reserva con detalles de bono.
     *
     * @param id_reserva Identificador de la reserva
     * @param id_usuario Identificador del usuario que hace la reserva
     * @param fecha Fecha de la reserva
     * @param duracion Duración de la reserva en minutos
     * @param id_pista Identificador de la pista
     * @param precio Precio de la reserva
     * @param descuento Descuento aplicado a la reserva
     * @param idBono Identificador del bono asociado a la reserva
     * @param numeroSesion Número de sesión dentro del bono
     */
    public Reserva(String id_reserva, String id_usuario, LocalDate fecha, int duracion, String id_pista, float precio, float descuento, String idBono, int numeroSesion) {
        this.idReserva = id_reserva;
        this.idUsuario = id_usuario;
        this.fecha = fecha;
        this.duracion = duracion;
        this.idPista = id_pista;
        this.precio = precio;
        this.descuento = descuento;
        this.idBono = idBono;
        this.numeroSesion = numeroSesion;
    }

    /**
     * Obtiene el identificador de la reserva.
     *
     * @return Identificador de la reserva
     */
    public String getIdReserva() {
        return idReserva;
    }

    /**
     * Establece el identificador de la reserva.
     *
     * @param idReserva Identificador de la reserva
     */
    public void setIdReserva(String idReserva) {
        this.idReserva = idReserva;
    }

    /**
     * Obtiene el identificador del usuario que hace la reserva.
     *
     * @return Identificador del usuario que hace reserva
     */
    public String getIdUsuario() {
        return idUsuario;
    }
    
    /**
     * Establece el identificador del usuario que hace la reserva.
     *
     * @param idReserva Identificador del usuario que hace la reserva
     */
    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    /**
     * Obtiene la fecha de la reserva.
     *
     * @return Fecha de la reserva
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha de la reserva.
     *
     * @param fecha Fecha de la reserva
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene la duración de la reserva.
     *
     * @return Duración de la reserva en minutos
     */
    public int getDuracion() {
        return duracion;
    }

    /**
     * Establece la duración de la reserva.
     *
     * @param duracion Duración de la reserva en minutos
     */
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    /**
     * Obtiene el identificador de la pista reservada.
     *
     * @return Identificador de la pista
     */
    public String getIdPista() {
        return idPista;
    }

    /**
     * Establece el identificador de la pista reservada.
     *
     * @param idPista Identificador de la pista
     */
    public void setIdPista(String idPista) {
        this.idPista = idPista;
    }

    /**
     * Obtiene el precio de la reserva.
     *
     * @return Precio de la reserva
     */
    public float getPrecio() {
        return precio;
    }

    /**
     * Establece el precio de la reserva.
     *
     * @param precio Precio de la reserva
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    /**
     * Obtiene el descuento aplicado a la reserva.
     *
     * @return Descuento aplicado a la reserva
     */
    public float getDescuento() {
        return descuento;
    }

    /**
     * Establece el descuento aplicado a la reserva.
     *
     * @param descuento Descuento aplicado a la reserva
     */
    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    /**
     * Obtiene el identificador del bono asociado a la reserva.
     *
     * @return Identificador del bono, o null si no hay bono asociado
     */
    public String getIdBono() {
        return idBono;
    }

    /**
     * Establece el identificador del bono asociado a la reserva.
     *
     * @param idBono Identificador del bono
     */
    public void setIdBono(String idBono) {
        this.idBono = idBono;
    }

    /**
     * Obtiene el número de sesión de la reserva dentro del bono.
     *
     * @return Número de sesión dentro del bono, o -1 si no aplica
     */
    public int getNumeroSesion() {
        return numeroSesion;
    }

    /**
     * Establece el número de sesión de la reserva dentro del bono.
     *
     * @param numeroSesion Número de sesión dentro del bono
     */
    public void setNumeroSesion(int numeroSesion) {
        this.numeroSesion = numeroSesion;
    }
    
    /**
     * Devuelve una representación en forma de cadena de la reserva.
     *
     * @return Cadena que representa los detalles de la reserva
     */
    @Override
    public String toString() {
        return "ID reserva: '" + idReserva + "'" +
                ", ID usuario: '" + idUsuario + "'" +
                ", ID bono: '" + (idBono != null ? idBono : "sin bono") + "'" +
                ", Número de sesion: " + numeroSesion +
                ", Fecha y hora: " + fecha +
                ", Duracion: " + duracion + " minutos" +
                ", ID pista: '" + idPista + "'" +
                ", Precio: " + precio + " euros" +
                ", Descuento: " + descuento + " euros";
    }
}
