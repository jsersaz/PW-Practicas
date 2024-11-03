package es.uco.pw.clases.reserva;

import java.time.LocalDate;

/**
 * Clase abstracta que define la estructura de una fábrica de reservas.
 * Proporciona métodos abstractos para la creación de reservas de distintos tipos
 * (infantil, familiar y adultos) con sus respectivos parámetros.
 */
public abstract class ReservaFactory {

    /**
     * Crea una reserva infantil con los detalles especificados.
     *
     * @param Bono Bono con el que se hace la reserva
     * @param idReserva Identificador de la reserva
     * @param fecha Fecha de la reserva
     * @param duracion Duración de la reserva en minutos
     * @param idPista Identificador de la pista
     * @param precio Precio de la reserva
     * @param descuento Descuento aplicado a la reserva
     * @param numeroNinos Número de niños en la reserva
     * @return Instancia de {@link ReservaInfantil} creada con los parámetros dados
     */
    public abstract ReservaInfantil crearReservaInfantil(Bono bono, String idReserva, String idUsuario, LocalDate fecha, int duracion, String idPista, float precio, float descuento, int numeroNinos);

    /**
     * Crea una reserva familiar con los detalles especificados.
     *
     * @param Bono Bono con el que se hace la reserva
     * @param idReserva Identificador de la reserva
     * @param fecha Fecha de la reserva
     * @param duracion Duración de la reserva en minutos
     * @param idPista Identificador de la pista
     * @param precio Precio de la reserva
     * @param descuento Descuento aplicado a la reserva
     * @param numeroAdultos Número de adultos en la reserva
     * @param numeroNinos Número de niños en la reserva
     * @return Instancia de {@link ReservaFamiliar} creada con los parámetros dados
     */
    public abstract ReservaFamiliar crearReservaFamiliar(Bono bono, String idReserva, String idUsuario, LocalDate fecha, int duracion, String idPista, float precio, float descuento, int numeroAdultos, int numeroNinos);

    /**
     * Crea una reserva para adultos con los detalles especificados.
     *
     * @param Bono Bono con el que se hace la reserva
     * @param idReserva Identificador de la reserva
     * @param fecha Fecha de la reserva
     * @param duracion Duración de la reserva en minutos
     * @param idPista Identificador de la pista
     * @param precio Precio de la reserva
     * @param descuento Descuento aplicado a la reserva
     * @param numeroParticipantes Número de participantes adultos en la reserva
     * @return Instancia de {@link ReservaAdultos} creada con los parámetros dados
     */
    public abstract ReservaAdultos crearReservaAdultos(Bono bono, String idReserva, String idUsuario, LocalDate fecha, int duracion, String idPista, float precio, float descuento, int numeroParticipantes);
}
