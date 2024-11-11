package es.uco.pw.business.reserva;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Clase que representa un bono de reservas, que permite la creación de diferentes tipos de reservas
 * (infantil, familiar, adultos) limitadas a un máximo de cinco reservas.
 * Extiende la clase {@link ReservaFactoryDTO}.
 */
public class ReservaBonoDTO extends ReservaFactoryDTO {	
    /** Lista de reservas realizadas en el bono */
    private ArrayList<ReservaDTO> reservasHechas;

    /**
     * Constructor por defecto de la clase ReservaBono.
     * Inicializa la lista de reservas realizadas.
     */
    public ReservaBonoDTO() {
        this.reservasHechas = new ArrayList<ReservaDTO>();
    }

    
    
    
    /* ESTA FUNCIÓN  NO VA   */
    public ReservaDTO obtenerReservaPorId(String idReserva) {
        for (ReservaDTO reserva : reservasHechas) {
            if (reserva.getIdReserva().equals(idReserva)) { // Suponiendo que tienes un método getId() en la clase Reserva
                return reserva; // Retorna la reserva si se encuentra
            }
        }
        return null; // Retorna null si no se encuentra
    }
    
    
    /**
     * Crea una reserva infantil y la añade a la lista de reservas si no se ha alcanzado el límite de cinco reservas.
     *
     * @param idReserva Identificador de la reserva
     * @param fecha Fecha de la reserva
     * @param duracion Duración de la reserva en minutos
     * @param idPista Identificador de la pista
     * @param precio Precio de la reserva
     * @param descuento Descuento aplicado a la reserva
     * @param numeroNinos Número de niños en la reserva
     * @return La reserva infantil creada o {@code null} si se alcanzó el límite de reservas
     */
    public ReservaInfantilDTO crearReservaInfantil(BonoDTO bonoDTO, String idReserva, String idUsuario, LocalDate fecha, int duracion, String idPista, float precio, float descuento, int numeroNinos) {
        if(this.reservasHechas.size() == 5) {
            return null;
        }
        String idBono = bonoDTO.getIdBono();
        int numeroSesion = bonoDTO.getNumeroSesion();
        ReservaDTO nuevaReserva = new ReservaInfantilDTO(idReserva, idUsuario, fecha, duracion, idPista, precio, descuento, numeroNinos, idBono, numeroSesion);
        this.reservasHechas.add(nuevaReserva);
        return (ReservaInfantilDTO) nuevaReserva;
    }

    /**
     * Crea una reserva familiar y la añade a la lista de reservas si no se ha alcanzado el límite de cinco reservas.
     *
     * @param idReserva Identificador de la reserva
     * @param fecha Fecha de la reserva
     * @param duracion Duración de la reserva en minutos
     * @param idPista Identificador de la pista
     * @param precio Precio de la reserva
     * @param descuento Descuento aplicado a la reserva
     * @param numeroAdultos Número de adultos en la reserva
     * @param numeroNinos Número de niños en la reserva
     * @return La reserva familiar creada o {@code null} si se alcanzó el límite de reservas
     */
    public ReservaFamiliarDTO crearReservaFamiliar(BonoDTO bonoDTO, String idReserva, String idUsuario, LocalDate fecha, int duracion, String idPista, float precio, float descuento, int numeroAdultos, int numeroNinos) {
        if(this.reservasHechas.size() == 5) {
            return null;
        }
        String idBono = bonoDTO.getIdBono();
        int numeroSesion = bonoDTO.getNumeroSesion();
        ReservaDTO nuevaReserva = new ReservaFamiliarDTO(idReserva, idUsuario, fecha, duracion, idPista, precio, descuento, numeroAdultos, numeroNinos, idBono, numeroSesion);
        this.reservasHechas.add(nuevaReserva);
        return (ReservaFamiliarDTO) nuevaReserva;
    }

    /**
     * Crea una reserva para adultos y la añade a la lista de reservas si no se ha alcanzado el límite de cinco reservas.
     *
     * @param idReserva Identificador de la reserva
     * @param fecha Fecha de la reserva
     * @param duracion Duración de la reserva en minutos
     * @param idPista Identificador de la pista
     * @param precio Precio de la reserva
     * @param descuento Descuento aplicado a la reserva
     * @param numeroParticipantes Número de participantes adultos en la reserva
     * @return La reserva de adultos creada o {@code null} si se alcanzó el límite de reservas
     */
    public ReservaAdultosDTO crearReservaAdultos(BonoDTO bonoDTO, String idReserva, String idUsuario, LocalDate fecha, int duracion, String idPista, float precio, float descuento, int numeroParticipantes) {
        if(this.reservasHechas.size() == 5) {
            return null;
        }
        String idBono = bonoDTO.getIdBono();
        int numeroSesion = bonoDTO.getNumeroSesion();
        ReservaDTO nuevaReserva = new ReservaAdultosDTO(idReserva, idUsuario, fecha, duracion, idPista, precio, descuento, numeroParticipantes, idBono, numeroSesion);
        this.reservasHechas.add(nuevaReserva);
        return (ReservaAdultosDTO) nuevaReserva;
    }
}
