package es.uco.pw.clases.reserva;

import java.time.LocalDate;

/**
 * Clase que representa una reserva infantil.
 * Extiende la clase {@link Reserva} y añade el atributo específico para el número de niños.
 */
public class ReservaInfantil extends Reserva {
    private int numeroNinos;

    /**
     * Constructor por defecto que inicializa los valores a predeterminados.
     */
    public ReservaInfantil() {
        super();
        this.numeroNinos = -1;
    }

    /**
     * Constructor que permite crear una reserva infantil con los parámetros especificados.
     *
     * @param idReserva Identificador de la reserva
     * @param idUsuario Identificador del usuario que hace la reserva
     * @param fecha Fecha de la reserva
     * @param duracion Duración de la reserva en minutos
     * @param idPista Identificador de la pista reservada
     * @param precio Precio de la reserva
     * @param descuento Descuento aplicado a la reserva
     * @param numeroNinos Número de niños participantes en la reserva
     */
    public ReservaInfantil(String idReserva, String idUsuario, LocalDate fecha, int duracion, String idPista, float precio, float descuento, int numeroNinos) {
        super(idReserva, idUsuario, fecha, duracion, idPista, precio, descuento);
        this.numeroNinos = numeroNinos;
    }

    /**
     * Constructor que permite crear una reserva infantil con bono.
     *
     * @param idReserva Identificador de la reserva
     * @param idUsuario Identificador del usuario que hace la reserva
     * @param fecha Fecha de la reserva
     * @param duracion Duración de la reserva en minutos
     * @param idPista Identificador de la pista reservada
     * @param precio Precio de la reserva
     * @param descuento Descuento aplicado a la reserva
     * @param numeroNinos Número de niños participantes en la reserva
     * @param idBono Identificador del bono asociado
     * @param numeroSesion Número de sesión del bono
     */
    public ReservaInfantil(String idReserva, String idUsuario, LocalDate fecha, int duracion, String idPista, float precio, float descuento, int numeroNinos, String idBono, int numeroSesion) {
        super(idReserva, idUsuario, fecha, duracion, idPista, precio, descuento, idBono, numeroSesion);
        this.numeroNinos = numeroNinos;
    }

    /**
     * Obtiene el número de niños participantes en la reserva.
     *
     * @return Número de niños
     */
    public int getNumeroNinos() {
        return numeroNinos;
    }

    /**
     * Establece el número de niños participantes en la reserva.
     *
     * @param numeroNinos Número de niños a establecer
     */
    public void setNumeroNinos(int numeroNinos) {
        this.numeroNinos = numeroNinos;
    }

    /**
     * Devuelve una representación en formato de cadena de la reserva infantil.
     *
     * @return Cadena de texto que representa la reserva infantil
     */
    @Override
    public String toString() {
        return "Reserva infantil {" +
                "ID reserva: '" + idReserva + "'" +
                ", ID usuario: '" + idUsuario + "'" +
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