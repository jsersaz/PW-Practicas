package es.uco.pw.business.reserva;

import java.time.LocalDate;

/**
 * Clase que implementa una fábrica de reservas individuales.
 * Extiende la clase abstracta {@link ReservaFactoryDTO} y proporciona métodos para crear
 * diferentes tipos de reservas: infantil, familiar y para adultos.
 */
public class ReservaIndividualDTO extends ReservaFactoryDTO {

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
     * @return Instancia de {@link ReservaInfantilDTO} creada con los parámetros especificados
     */
    public ReservaInfantilDTO crearReservaInfantil(BonoDTO bonoDTO, String idReserva, String idUsuario, LocalDate fecha, int duracion, String idPista, float precio, float descuento, int numeroNinos) {
        return new ReservaInfantilDTO(idReserva, idUsuario, fecha, duracion, idPista, precio, descuento, numeroNinos);
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
     * @return Instancia de {@link ReservaFamiliarDTO} creada con los parámetros especificados
     */
    public ReservaFamiliarDTO crearReservaFamiliar(BonoDTO bonoDTO, String idReserva, String idUsuario, LocalDate fecha, int duracion, String idPista, float precio, float descuento, int numeroAdultos, int numeroNinos) {
        return new ReservaFamiliarDTO(idReserva, idUsuario, fecha, duracion, idPista, precio, descuento, numeroAdultos, numeroNinos);
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
     * @return Instancia de {@link ReservaAdultosDTO} creada con los parámetros especificados
     */
    public ReservaAdultosDTO crearReservaAdultos(BonoDTO bonoDTO, String idReserva, String idUsuario, LocalDate fecha, int duracion, String idPista, float precio, float descuento, int numeroParticipantes) {
        return new ReservaAdultosDTO(idReserva, idUsuario, fecha, duracion, idPista, precio, descuento, numeroParticipantes);
    }
}
