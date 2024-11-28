package es.uco.pw.business.reserva;

import java.time.LocalDate;

/**
 * Clase que representa una reserva para adultos, que extiende la clase {@link ReservaDTO}.
 * Incluye el número de participantes en la reserva.
 */
public class ReservaAdultosDTO extends ReservaDTO {
    /** Número de participantes en la reserva */
    private int numeroParticipantes;

    /**
     * Constructor vacío de la clase ReservaAdultos.
     * Inicializa los valores por defecto.
     */
    public ReservaAdultosDTO() {
        super();
        this.numeroParticipantes = -1;
    }

    /**
     * Constructor que inicializa una reserva para adultos con detalles básicos.
     *
     * @param idReserva Identificador de la reserva
     * @param idUsuario Identificador del usuario que hace la reserva
     * @param fecha Fecha de la reserva
     * @param duracion Duración de la reserva en minutos
     * @param idPista Identificador de la pista
     * @param precio Precio de la reserva
     * @param descuento Descuento aplicado a la reserva
     * @param numeroParticipantes Número de participantes en la reserva
     */
    public ReservaAdultosDTO(String idReserva, String idUsuario, LocalDate fecha, int duracion, String idPista, float precio, float descuento, int numeroParticipantes) {
        super(idReserva, idUsuario, fecha, duracion, idPista, precio, descuento);
        this.numeroParticipantes = numeroParticipantes;
    }

    /**
     * Constructor que inicializa una reserva para adultos con detalles de bono.
     *
     * @param idReserva Identificador de la reserva
     * @param idUsuario Identificador del usuario que hace la reserva
     * @param fecha Fecha de la reserva
     * @param duracion Duración de la reserva en minutos
     * @param idPista Identificador de la pista
     * @param precio Precio de la reserva
     * @param descuento Descuento aplicado a la reserva
     * @param numeroParticipantes Número de participantes en la reserva
     * @param idBono Identificador del bono asociado a la reserva
     * @param numeroSesion Número de sesión dentro del bono
     */
    public ReservaAdultosDTO(String idReserva, String idUsuario, LocalDate fecha, int duracion, String idPista, float precio, float descuento, int numeroParticipantes, String idBono, int numeroSesion) {
        super(idReserva, idUsuario, fecha, duracion, idPista, precio, descuento, idBono, numeroSesion);
        this.numeroParticipantes = numeroParticipantes;
    }

    /**
     * Obtiene el número de participantes en la reserva.
     *
     * @return Número de participantes en la reserva
     */
    public int getNumeroParticipantes() {
        return numeroParticipantes;
    }

    /**
     * Establece el número de participantes en la reserva.
     *
     * @param numeroParticipantes Número de participantes en la reserva
     */
    public void setNumeroParticipantes(int numeroParticipantes) {
        this.numeroParticipantes = numeroParticipantes;
    }

    /**
     * Devuelve una representación en forma de cadena de la reserva para adultos.
     *
     * @return Cadena que representa los detalles de la reserva para adultos
     */
    @Override
    public String toString() {
        return "Reserva adultos {" +
                "ID reserva: '" + idReserva + "'" +
                ", ID usuario: '" + idUsuario + "'" +
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
