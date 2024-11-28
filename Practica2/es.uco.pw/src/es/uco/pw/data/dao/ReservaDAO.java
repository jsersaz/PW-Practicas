package es.uco.pw.data.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
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
		        try (FileInputStream input = new FileInputStream("sql.properties")) {
		            prop.load(input);
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		   
	}
	
	
	 public int insertarReservaInfantil(ReservaInfantilDTO reservaInfantil)
	 {
		 int status = 0;
		 DBConnection connection = new DBConnection();
		 String sql;
		 
		 try {
			 sql = prop.getProperty("addReserva");
			 con = (Connection) connection.getConnection();
			 PreparedStatement ps = con.prepareStatement(sql);
			 
			 ps.setString(1, reservaInfantil.getIdReserva());
			 ps.setString(2, reservaInfantil.getIdUsuario());
			 ps.setDate(3, Date.valueOf(reservaInfantil.getFecha()));
			 ps.setInt(4, reservaInfantil.getDuracion());
			 ps.setString(5, reservaInfantil.getIdPista());
			 ps.setFloat(6, reservaInfantil.getPrecio());
			 ps.setFloat(7, reservaInfantil.getDescuento());
			 ps.setString(8, reservaInfantil.getIdPista());
			 ps.setString(9, reservaInfantil.getIdBono());
			 ps.setString(10, reservaInfantil.getIdUsuario());
			 
			 status = ps.executeUpdate();
		 } catch(Exception e) {System.out.println(e);}
		 
		 try {
			 sql = prop.getProperty("addInfantil");
			 con = (Connection) connection.getConnection();
			 PreparedStatement ps = con.prepareStatement(sql);
			 
			 ps.setString(1, reservaInfantil.getIdReserva());
			 ps.setInt(2, reservaInfantil.getNumeroNinos());
			 
			 status = ps.executeUpdate();
		 } catch(Exception e) {System.out.println(e);}
		 
		 connection.closeConnection();
		 return status;
		 
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
	 }
	 

	 public int insertarReservaFamiliar(ReservaFamiliarDTO reservaFamiliar) {
		 int status = 0;
		 DBConnection connection = new DBConnection();
		 String sql;
		 
		 try {
			 sql = prop.getProperty("addReserva");
			 con = (Connection) connection.getConnection();
			 PreparedStatement ps = con.prepareStatement(sql);
			 
			 ps.setString(1, reservaFamiliar.getIdReserva());
			 ps.setString(2, reservaFamiliar.getIdUsuario());
			 ps.setDate(3, Date.valueOf(reservaFamiliar.getFecha()));
			 ps.setInt(4, reservaFamiliar.getDuracion());
			 ps.setString(5, reservaFamiliar.getIdPista());
			 ps.setFloat(6, reservaFamiliar.getPrecio());
			 ps.setFloat(7, reservaFamiliar.getDescuento());
			 ps.setString(8, reservaFamiliar.getIdPista());
			 ps.setString(9, reservaFamiliar.getIdBono());
			 ps.setString(10, reservaFamiliar.getIdUsuario());
			 
			 status = ps.executeUpdate();
		 } catch(Exception e) {System.out.println(e);}
		 
		 try {
			 sql = prop.getProperty("addFamiliar");
			 con = (Connection) connection.getConnection();
			 PreparedStatement ps = con.prepareStatement(sql);
			 
			 ps.setString(1, reservaFamiliar.getIdReserva());
			 ps.setInt(2, reservaFamiliar.getNumeroAdultos());
			 ps.setInt(3, reservaFamiliar.getNumeroNinos());
			 
			 status = ps.executeUpdate();
		 } catch(Exception e) {System.out.println(e);}
		 
		 connection.closeConnection();
		 return status;
	 }
	 
	 
	 public int insertarReservaAdultos(ReservaAdultosDTO reservaAdultos) {
		 int status = 0;
		 DBConnection connection = new DBConnection();
		 String sql;
		 
		 try {
			 sql = prop.getProperty("addReserva");
			 con = (Connection) connection.getConnection();
			 PreparedStatement ps = con.prepareStatement(sql);
			 
			 ps.setString(1, reservaAdultos.getIdReserva());
			 ps.setString(2, reservaAdultos.getIdUsuario());
			 ps.setDate(3, Date.valueOf(reservaAdultos.getFecha()));
			 ps.setInt(4, reservaAdultos.getDuracion());
			 ps.setString(5, reservaAdultos.getIdPista());
			 ps.setFloat(6, reservaAdultos.getPrecio());
			 ps.setFloat(7, reservaAdultos.getDescuento());
			 ps.setString(8, reservaAdultos.getIdPista());
			 ps.setString(9, reservaAdultos.getIdBono());
			 ps.setString(10, reservaAdultos.getIdUsuario());
			 
			 status = ps.executeUpdate();
		 } catch(Exception e) {System.out.println(e);}
		 
		 try {
			 sql = prop.getProperty("addAdulto");
			 con = (Connection) connection.getConnection();
			 PreparedStatement ps = con.prepareStatement(sql);
			 
			 ps.setString(1, reservaAdultos.getIdReserva());
			 ps.setInt(2, reservaAdultos.getNumeroParticipantes());
			 
			 status = ps.executeUpdate();
		 } catch(Exception e) {System.out.println(e);}
		 
		 connection.closeConnection();
		 return status;
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