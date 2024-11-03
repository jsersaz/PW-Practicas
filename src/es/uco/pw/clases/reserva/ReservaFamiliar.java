package es.uco.pw.clases.reserva;

import java.time.LocalDate;

/**
 * Clase que representa una reserva familiar en una pista.
 * Extiende la clase abstracta {@link Reserva} e incluye atributos adicionales para el
 * número de adultos y niños que participarán en la reserva.
 */
public class ReservaFamiliar extends Reserva {

    /** Número de adultos que participan en la reserva. */
    private int numeroAdultos;

    /** Número de niños que participan en la reserva. */
    private int numeroNinos;

    /**
     * Constructor por defecto de la clase {@code ReservaFamiliar}.
     * Inicializa los valores a los valores predeterminados.
     */
    public ReservaFamiliar() {
        super();
        this.numeroAdultos = -1;
        this.numeroNinos = -1;
    }

    /**
     * Constructor con parámetros para inicializar una reserva familiar.
     *
     * @param idReserva Identificador de la reserva
     * @param idUsuario Identificador del usuario que hace la reserva
     * @param fecha Fecha de la reserva
     * @param duracion Duración de la reserva en minutos
     * @param idPista Identificador de la pista reservada
     * @param precio Precio de la reserva
     * @param descuento Descuento aplicado a la reserva
     * @param numeroAdultos Número de adultos en la reserva
     * @param numeroNinos Número de niños en la reserva
     */
    public ReservaFamiliar(String idReserva, String idUsuario, LocalDate fecha, int duracion, String idPista, float precio, float descuento, int numeroAdultos, int numeroNinos) {
        super(idReserva, idUsuario, fecha, duracion, idPista, precio, descuento);
        this.numeroAdultos = numeroAdultos;
        this.numeroNinos = numeroNinos;
    }

    /**
     * Constructor con parámetros para inicializar una reserva familiar y asociarla a un bono.
     *
     * @param idReserva Identificador de la reserva
     * @param idUsuario Identificador del usuario que hace la reserva
     * @param fecha Fecha de la reserva
     * @param duracion Duración de la reserva en minutos
     * @param idPista Identificador de la pista reservada
     * @param precio Precio de la reserva
     * @param descuento Descuento aplicado a la reserva
     * @param numeroAdultos Número de adultos en la reserva
     * @param numeroNinos Número de niños en la reserva
     * @param idBono Identificador del bono asociado a la reserva
     * @param numeroSesion Número de sesión dentro del bono
     */
    public ReservaFamiliar(String idReserva, String idUsuario, LocalDate fecha, int duracion, String idPista, float precio, float descuento, int numeroAdultos, int numeroNinos, String idBono, int numeroSesion) {
        super(idReserva, idUsuario, fecha, duracion, idPista, precio, descuento, idBono, numeroSesion);
        this.numeroAdultos = numeroAdultos;
        this.numeroNinos = numeroNinos;
    }

    /**
     * Obtiene el número de adultos en la reserva.
     *
     * @return Número de adultos en la reserva
     */
    public int getNumeroAdultos() {
        return numeroAdultos;
    }

    /**
     * Establece el número de adultos en la reserva.
     *
     * @param numeroAdultos Número de adultos en la reserva
     */
    public void setNumeroAdultos(int numeroAdultos) {
        this.numeroAdultos = numeroAdultos;
    }

    /**
     * Obtiene el número de niños en la reserva.
     *
     * @return Número de niños en la reserva
     */
    public int getNumeroNinos() {
        return numeroNinos;
    }

    /**
     * Establece el número de niños en la reserva.
     *
     * @param numeroNinos Número de niños en la reserva
     */
    public void setNumeroNinos(int numeroNinos) {
        this.numeroNinos = numeroNinos;
    }

    /**
     * Devuelve una representación en cadena de la reserva familiar.
     *
     * @return Cadena de texto con los detalles de la reserva
     */
    @Override
    public String toString() {
        return "Reserva familiar {" +
                "ID reserva: '" + idReserva + "'" +
                ", ID usuario: '" + idUsuario + "'" +
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

