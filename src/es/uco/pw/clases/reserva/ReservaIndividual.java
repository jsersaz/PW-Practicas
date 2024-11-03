package es.uco.pw.clases.reserva;

import java.time.LocalDate;

/**
 * Clase que implementa una fábrica de reservas individuales.
 * Extiende la clase abstracta {@link ReservaFactory} y proporciona métodos para crear
 * diferentes tipos de reservas: infantil, familiar y para adultos.
 */
public class ReservaIndividual extends ReservaFactory {

    /**
     * Crea una reserva infantil.
     *
     * @param idReserva Identificador de la reserva
     * @param fecha Fecha de la reserva
     * @param duracion Duración de la reserva en minutos
     * @param idPista Identificador de la pista reservada
     * @param precio Precio de la reserva
     * @param descuento Descuento aplicado a la reserva
     * @param numeroNinos Número de niños participantes en la reserva
     * @return Instancia de {@link ReservaInfantil} creada con los parámetros especificados
     */
    public ReservaInfantil crearReservaInfantil(Bono bono, String idReserva, String idUsuario, LocalDate fecha, int duracion, String idPista, float precio, float descuento, int numeroNinos) {
        return new ReservaInfantil(idReserva, idUsuario, fecha, duracion, idPista, precio, descuento, numeroNinos);
    }

    /**
     * Crea una reserva familiar.
     *
     * @param idReserva Identificador de la reserva
     * @param fecha Fecha de la reserva
     * @param duracion Duración de la reserva en minutos
     * @param idPista Identificador de la pista reservada
     * @param precio Precio de la reserva
     * @param descuento Descuento aplicado a la reserva
     * @param numeroAdultos Número de adultos participantes en la reserva
     * @param numeroNinos Número de niños participantes en la reserva
     * @return Instancia de {@link ReservaFamiliar} creada con los parámetros especificados
     */
    public ReservaFamiliar crearReservaFamiliar(Bono bono, String idReserva, String idUsuario, LocalDate fecha, int duracion, String idPista, float precio, float descuento, int numeroAdultos, int numeroNinos) {
        return new ReservaFamiliar(idReserva, idUsuario, fecha, duracion, idPista, precio, descuento, numeroAdultos, numeroNinos);
    }

    /**
     * Crea una reserva para adultos.
     *
     * @param idReserva Identificador de la reserva
     * @param fecha Fecha de la reserva
     * @param duracion Duración de la reserva en minutos
     * @param idPista Identificador de la pista reservada
     * @param precio Precio de la reserva
     * @param descuento Descuento aplicado a la reserva
     * @param numeroParticipantes Número de adultos participantes en la reserva
     * @return Instancia de {@link ReservaAdultos} creada con los parámetros especificados
     */
    public ReservaAdultos crearReservaAdultos(Bono bono, String idReserva, String idUsuario, LocalDate fecha, int duracion, String idPista, float precio, float descuento, int numeroParticipantes) {
        return new ReservaAdultos(idReserva, idUsuario, fecha, duracion, idPista, precio, descuento, numeroParticipantes);
    }
}
