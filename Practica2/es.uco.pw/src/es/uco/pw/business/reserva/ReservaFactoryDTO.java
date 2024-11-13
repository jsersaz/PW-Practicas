package es.uco.pw.business.reserva;

import java.time.LocalDate;

/**
 * Clase abstracta que define la estructura de una fábrica de reservas.
 * Proporciona métodos abstractos para la creación de reservas de distintos tipos
 * (infantil, familiar y adultos) con sus respectivos parámetros.
 */
public abstract class ReservaFactoryDTO {

    /**
     * Crea una reserva infantil con los detalles especificados.
     *
     * @param BonoDTO Bono con el que se hace la reserva
     * @param idReserva Identificador de la reserva
     * @param fecha Fecha de la reserva
     * @param duracion Duración de la reserva en minutos
     * @param idPista Identificador de la pista
     * @param precio Precio de la reserva
     * @param descuento Descuento aplicado a la reserva
     * @param numeroNinos Número de niños en la reserva
     * @return Instancia de {@link ReservaInfantilDTO} creada con los parámetros dados
     */
    public abstract ReservaInfantilDTO crearReservaInfantil(BonoDTO bonoDTO, String idReserva, String idUsuario, LocalDate fecha, int duracion, String idPista, float precio, float descuento, int numeroNinos);

    /**
     * Crea una reserva familiar con los detalles especificados.
     *
     * @param BonoDTO Bono con el que se hace la reserva
     * @param idReserva Identificador de la reserva
     * @param fecha Fecha de la reserva
     * @param duracion Duración de la reserva en minutos
     * @param idPista Identificador de la pista
     * @param precio Precio de la reserva
     * @param descuento Descuento aplicado a la reserva
     * @param numeroAdultos Número de adultos en la reserva
     * @param numeroNinos Número de niños en la reserva
     * @return Instancia de {@link ReservaFamiliarDTO} creada con los parámetros dados
     */
    public abstract ReservaFamiliarDTO crearReservaFamiliar(BonoDTO bonoDTO, String idReserva, String idUsuario, LocalDate fecha, int duracion, String idPista, float precio, float descuento, int numeroAdultos, int numeroNinos);

    /**
     * Crea una reserva para adultos con los detalles especificados.
     *
     * @param BonoDTO Bono con el que se hace la reserva
     * @param idReserva Identificador de la reserva
     * @param fecha Fecha de la reserva
     * @param duracion Duración de la reserva en minutos
     * @param idPista Identificador de la pista
     * @param precio Precio de la reserva
     * @param descuento Descuento aplicado a la reserva
     * @param numeroParticipantes Número de participantes adultos en la reserva
     * @return Instancia de {@link ReservaAdultosDTO} creada con los parámetros dados
     */
    public abstract ReservaAdultosDTO crearReservaAdultos(BonoDTO bonoDTO, String idReserva, String idUsuario, LocalDate fecha, int duracion, String idPista, float precio, float descuento, int numeroParticipantes);
}
