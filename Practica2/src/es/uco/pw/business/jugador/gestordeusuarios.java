 package es.uco.pw.business.jugador;

import java.io.BufferedReader;


import es.uco.pw.business.jugador.JugadorDTO;
import es.uco.pw.business.reserva.BonoDTO;
import es.uco.pw.data.common.DBConnection;
import java.sql.*;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.PreparedStatement;

import java.time.LocalDate;

/**
 * Clase gestordeusuarios que gestiona los usuarios registrados en el sistema.
 * Incluye funcionalidades para cargar, modificar, listar, y respaldar jugadores.
 */
public class gestordeusuarios {

    private Properties properties;
    private Connection connection;

    /**
     * Constructor privado de gestordeusuarios.
     * Inicializa la lista de jugadores y carga propiedades desde un archivo de configuración.
     */
    public gestordeusuarios()
    {
    	properties=new Properties();
        try (BufferedReader lector = new BufferedReader(new FileReader("sql.properties"))) {
            properties.load(lector);
        }  catch (FileNotFoundException e) {
        	e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Carga la lista de jugadores desde el archivo especificado en las propiedades.
     */
    /*public void cargarFichero() {
        try (BufferedReader br = new BufferedReader(new FileReader(properties.getProperty("ficheroJugadores")))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(";");
                if (campos.length >= 5) {
                    try {
                        JugadorDTO player = new JugadorDTO();
                        player.setNombre(campos[0]);
                        player.setApellidos(campos[1]);
                        player.setFechaNacimiento(LocalDate.parse(campos[2]));
                        player.setFechaInscripcion(LocalDate.parse(campos[3]));
                        player.setEmail(campos[4]);
                        player.setDni(campos[5]);
                        this.jugadores.add(player);
                    } catch (NumberFormatException e) {
                        System.out.println("Ha ocurrido un error en la línea: " + linea);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    /**
     * Realiza una copia de seguridad de la lista de jugadores en el archivo especificado en las propiedades.
     */
    /*public void backupFichero() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(properties.getProperty("ficheroJugadores")))) {
            for (JugadorDTO p : this.jugadores) {
                bw.write(p.getNombre());
                bw.write(";");
                bw.write(p.getApellidos());
                bw.write(";");
                String fechanacimiento = p.getFechaNacimiento().toString();
                bw.write(fechanacimiento);
                bw.write(";");
                String fechainscripcion = p.getFechaInscripcion().toString();
                bw.write(fechainscripcion);
                bw.write(";");
                bw.write(p.getEmail());
                bw.write(";");
                bw.write(p.getDni());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    /**
     * Añade un nuevo jugador a la lista de jugadores si no está registrado previamente.
     * @param p El jugador a añadir.
     * @return true si el jugador se añade con éxito; false si ya está registrado.
     */
    public boolean addJugador(JugadorDTO p) 
    {
    	DBConnection coneccion=new DBConnection();
    	connection= coneccion.getConnection();
    	try {
    		String sql = properties.getProperty("addJugador2");
            System.out.println("Consulta SQL: " + sql);
            
            System.out.println(p.getDni()+ " " + p.getNombre()+ " " + p.getApellidos() + " " + p.getFechaNacimiento().toString() + " " + p.getFechaInscripcion().toString() + " " + p.getEmail());
            
    		//PreparedStatement preparedstatement = connection.prepareStatement(properties.getProperty("addJugador"));
            PreparedStatement preparedstatement = connection.prepareStatement(sql);
    		//prep.setInt(1, 1);
    		//prep.setInt(2, 2);
    		
    		preparedstatement.setString(1, p.getDni());
    		preparedstatement.setString(2, p.getNombre());
    		preparedstatement.setString(3, p.getApellidos());
    		preparedstatement.setDate(4, Date.valueOf(p.getFechaNacimiento()));
    		preparedstatement.setDate(5, Date.valueOf(p.getFechaInscripcion()));
    		preparedstatement.setString(6, p.getEmail());
   		int status = preparedstatement.executeUpdate();
	System.out.println(status);
	
    		
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    	}
    	coneccion.closeConnection();
    	return true;
    	/*for (JugadorDTO q : this.jugadores) {
            if (q.getDni().equals(p.getDni())) {
                return false;
            }
        }
        this.jugadores.add(p);
        return true;*/
    }

    /**
     * Modifica la información de un jugador en la lista de jugadores.
     * @param nombrenuevo El nuevo nombre del jugador.
     * @param apellidosnuevos Los nuevos apellidos del jugador.
     * @param nuevaFechaNacimientoDate La nueva fecha de nacimiento del jugador.
     * @param nuevoEmail El nuevo correo electrónico del jugador.
     * @param emailBuscar El correo electrónico del jugador a buscar.
     * @return true si se modifica la información correctamente; false si no se encuentra el jugador.
     */
    /*public boolean modificarJugador(String nombrenuevo, String apellidosnuevos, LocalDate nuevaFechaNacimientoDate, String nuevoEmail, String nuevoDNI, String DNIBuscar) {
        for (JugadorDTO a : this.jugadores) {
            if (a.getDni().equals(DNIBuscar)) {
                a.setNombre(nombrenuevo);
                a.setApellidos(apellidosnuevos);
                a.setFechaNacimiento(nuevaFechaNacimientoDate);
                a.setEmail(nuevoEmail);
                a.setDni(nuevoDNI);
                return true;
            }
        }
        return false;
    }*/
    

    /**
     * Imprime en la consola la lista de jugadores actualmente registrados.
     */
    /*public void print() {
        for (JugadorDTO player : this.jugadores) {
            System.out.println(player.toString());
        }
    }*/
}