package es.uco.pw.data.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Properties;

import com.mysql.jdbc.Connection;

import es.uco.pw.business.jugador.JugadorDTO;
import es.uco.pw.business.pista.PistaDTO;
import es.uco.pw.business.reserva.BonoDTO;
import es.uco.pw.business.reserva.ReservaAdultosDTO;
import es.uco.pw.business.reserva.ReservaBonoDTO;
import es.uco.pw.business.reserva.ReservaDTO;
import es.uco.pw.business.reserva.ReservaFactoryDTO;
import es.uco.pw.business.reserva.ReservaFamiliarDTO;
import es.uco.pw.business.reserva.ReservaIndividualDTO;
import es.uco.pw.business.reserva.ReservaInfantilDTO;
import es.uco.pw.data.common.DBConnection;



public class ReservaDAO {

	//hacerReservaIndividual (bonoNull, jugador, pista, fechaReserva, duracion1, tipoReserva, numeroNinos, numeroAdultos); Si una función, tiene en su funcionamiento varias, esas tmb se hace
	//.hacerReservaBono(bono, jugador, pista, fechaReserva, duracion3, tipoReserva, numeroNinos, numeroAdultos);
	//.cancelarReserva reserva, DNICancelar)
	//consultarReservasPorDiaYPista(fechaConsulta, idPista)
	//consultar reservas futuras 
	
	
	private Connection con;
	private Properties prop;
	
	public ReservaDAO()
	{
		  		//CONSTRUCTOR, TIENE LAS LLAMADAS EN SQL  QUE TENEMOS QUE HACER A LA BASE DE DATOS
		       prop= new Properties(); 
		        try (FileInputStream input = new FileInputStream("properties.txt")) {
		            prop.load(input);
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		   
	}
	
	
	
	
	
	
	 public boolean hacerReservaIndividual()
	 {
		 DBConnection connection = new DBConnection();
		 con = (Connection) connection.getConnection();
	 
		 /*
		  public boolean hacerReservaIndividual(BonoDTO bono, JugadorDTO jugador, PistaDTO pista, LocalDate fecha, int duracion, String tipoReserva, int numeroNinos, int numeroAdultos) {
		        if (!validarCondicionesReserva(pista, fecha)) {
		            return false;
		        }

		        float precio = calcularPrecio(duracion);
		        float descuento;
		        if (jugador.calcularAntiguedad() > 2) {
		        	descuento = precio * 0.1f;
		        }
		        else {descuento = 0.0f;}
		        ReservaFactoryDTO reservaIndividualFactory = new ReservaIndividualDTO();
		        String idReserva;

		        switch (tipoReserva.toLowerCase()) {
		            case "infantil":
		                idReserva = jugador.getDni() + "-I-I-" + fecha;
		                ReservaInfantilDTO reservaInfantil = reservaIndividualFactory.crearReservaInfantil(bono, idReserva, jugador.getDni(), fecha, duracion, pista.getNombre(), precio, descuento, numeroNinos);
		                reservas.add(reservaInfantil);
		                break;
		            case "familiar":
		                idReserva = jugador.getDni() + "-F-I-" + fecha;
		                ReservaFamiliarDTO reservaFamiliar = reservaIndividualFactory.crearReservaFamiliar(bono, idReserva, jugador.getDni(), fecha, duracion, pista.getNombre(), precio, descuento, numeroNinos, numeroAdultos);
		                reservas.add(reservaFamiliar);
		                break;
		            case "adultos":
		                idReserva = jugador.getDni() + "-A-I-" + fecha;
		                ReservaAdultosDTO reservaAdultos = reservaIndividualFactory.crearReservaAdultos(bono, idReserva, jugador.getDni(), fecha, duracion, pista.getNombre(), precio, descuento, numeroAdultos);
		                reservas.add(reservaAdultos);
		                break;
		            default:
		                System.out.println("Error. Tipo de reserva no válido.");
		                return false;
		        }
		        return true;
		    }
		*/	 
		 connection.closeConnection();
		 return true;
		 
	 }
	 

	 
	 
	 
	 
	 
	 
	 public boolean hacerReservaBono()
	 {
		 DBConnection connection = new DBConnection();
		 con = (Connection) connection.getConnection();
		 
		 /*
	public boolean hacerReservaBono(BonoDTO bono, JugadorDTO jugador, PistaDTO pista, LocalDate fecha, int duracion, String tipoReserva, int numeroNinos, int numeroAdultos) {
	    if(!validarCondicionesReserva(pista, fecha)) {
	        return false;
	    }

	    if(!bono.esValido()) {
	        System.out.println("Error. El bono con ID " + bono.getIdBono() + " ha caducado.");
	        return false;
	    }

	    float precio = calcularPrecio(duracion);
	    float descuento = precio * 0.05f;
	    ReservaFactoryDTO reservaBonoFactory = new ReservaBonoDTO();
	    String idReserva;
	    switch (tipoReserva.toLowerCase()) {
	        case "infantil":
	            idReserva = jugador.getDni() + "-I-B-" + fecha;
	            ReservaInfantilDTO reservaInfantil = reservaBonoFactory.crearReservaInfantil(bono, idReserva, jugador.getDni(), fecha, duracion, pista.getNombre(), precio, descuento, numeroNinos);
	            reservas.add(reservaInfantil);
	            // bono.agregarReserva(reservaInfantil);
	            // reserva = new ReservaInfantil(jugador.getDni(), fecha, duracion, pista.getId(), precio, 0, 1);
	            break;
	        case "familiar":
	            idReserva = jugador.getDni() + "-F-B-" + fecha;
	            ReservaFamiliarDTO reservaFamiliar = reservaBonoFactory.crearReservaFamiliar(bono, idReserva, jugador.getDni(), fecha, duracion, pista.getNombre(), precio, descuento, numeroNinos, numeroAdultos);
	            reservas.add(reservaFamiliar);
	            // bono.agregarReserva(reservaFamiliar);
	            // reserva = new ReservaFamiliar(jugador.getDni(), fecha, duracion, pista.getId(), precio, 0, 1, 1); // Cambiar la lógica según sea necesario
	            break;
	        case "adultos":
	            idReserva = jugador.getDni() + "-A-B-" + fecha;
	            ReservaAdultosDTO reservaAdultos = reservaBonoFactory.crearReservaAdultos(bono, idReserva, jugador.getDni(), fecha, duracion, pista.getNombre(), precio, descuento, numeroAdultos);
	            reservas.add(reservaAdultos);
	            // bono.agregarReserva(reservaAdultos);
	            // reserva = new ReservaAdultos(jugador.getDni(), fecha, duracion, pista.getId(), precio, 0, 1); // Cambiar la lógica según sea necesario
	            break;
	        default:
	            System.out.println("Error. Tipo de reserva no válido.");
	            return false;
	    }
	    return true;
	}
		 
	*/	 
		 
		 connection.closeConnection();
		 return true;
	 }
	 
	 
	 
	 
	 
	 
 	 
	 public boolean cancelarReserva()
	 {
		 DBConnection connection = new DBConnection();
		 con = (Connection) connection.getConnection();
	
/*
  public boolean cancelarReserva(ReservaDTO reserva, String dni) {
    LocalDate ahora = LocalDate.now();
    if (reserva.getFecha().isBefore(ahora.plusDays(1))) {
        System.out.println("No se puede cancelar una reserva en las últimas 24 horas.");
        return false;
    }
    if (reserva.getIdUsuario().equals(dni)) {
        reservas.remove(reserva);
        return true;
    } else {
        System.out.println("No pueden cancelar reservas de otros usuarios.");
        return false;
    }
}
 */	 
		 connection.closeConnection();
		 return true;
	 }
	 
	
	 
	 
	 
	 
	 
	 
	 
	 
	 public ArrayList<ReservaDTO> consultarReservasPorDiaYPista() 
	 {
		
		 DBConnection connection = new DBConnection();
		 con = (Connection) connection.getConnection();
		 
		 ArrayList<ReservaDTO> reservasPorDiaYPista = new ArrayList<>();
		 
	/*	 
	 public ArrayList<ReservaDTO> consultarReservasPorDiaYPista(LocalDate fecha, String idPista) {
		    ArrayList<ReservaDTO> reservasPorDiaYPista = new ArrayList<>();
		    for (ReservaDTO reserva : reservas) {
		        if (reserva.getFecha().isEqual(fecha) && reserva.getIdPista().equals(idPista)) {
		            reservasPorDiaYPista.add(reserva);
		        }
		    }
		    return reservasPorDiaYPista;
		}
		 
	 */
		 
		 
		 connection.closeConnection();
		  return reservasPorDiaYPista;
	 }
}
	
