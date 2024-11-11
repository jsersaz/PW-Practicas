package es.uco.pw.display;




import java.time.LocalDate;

import java.util.Properties;
import java.util.Scanner;

import es.uco.pw.business.jugador.JugadorDTO;
import es.uco.pw.data.dao.gestordeusuariosDAO;
import es.uco.pw.display.mainprincipal;


public class maingestorusuarios{

	public static void main(String[] args) 
	{
		Properties properties;
		gestordeusuariosDAO g = gestordeusuariosDAO.obtenerUsuarios();
		g.cargarFichero();
		
		Scanner scanner = new Scanner(System.in);
		

		int opcion = 0;
		while(opcion!=4)
		{
			System.out.println("¿Qué quieres hacer?: ");
			System.out.println("1) Dar de alta a un usuario");
			System.out.println("2) Modificar la información de un usuario");
			System.out.println("3) Listar a todos los usuarios que hay registrados");
			System.out.println("4) Salir");
			opcion = scanner.nextInt();	
			if(opcion==1 || opcion==2) 
			{
				scanner.nextLine(); 
				System.out.println("Introduce el nuevo nombre (sin apellidos):");
				String nombrenuevo=scanner.nextLine();
				//j.setNombre(nombrenuevo);
				System.out.println("Introduce los nuevos apellidos:");
				String apellidosnuevos=scanner.nextLine();
				//j.setApellidos(apellidosnuevos);
				System.out.println("Introduce la fecha de nacimiento en formato YYYY-MM-DD):");
				String nuevaFechaNacimiento = scanner.nextLine();
				LocalDate nuevaFechaNacimientoDate = LocalDate.parse(nuevaFechaNacimiento);
				//j.setFechaNacimiento(nuevaFechaNacimientoDate);
				System.out.println("Introduce el nuevo email:");
				String nuevoEmail = scanner.nextLine();
				//j.setEmail(nuevoEmail);
				System.out.println("Introduce el nuevo DNI:");
				String nuevoDNI = scanner.nextLine();
				if(opcion==1)
				{
					JugadorDTO j = new JugadorDTO(nombrenuevo, apellidosnuevos, nuevaFechaNacimientoDate, nuevoEmail, nuevoDNI);
					if(g.addJugador(j)==true)
					{
						System.out.println("El usuario se ha añadido correctamente");
					}else{
						System.out.println("No se ha podido añadir al nuevo usuario");	
					}
				}else{
					System.out.println("Introduce el DNI del jugador al que quieres modificar los anteriores parámetros:");
					String DNIBuscar = scanner.nextLine();
					if(g.modificarJugador(nombrenuevo, apellidosnuevos, nuevaFechaNacimientoDate, nuevoEmail, nuevoDNI, DNIBuscar)==true){
						System.out.println("Los datos se han modificado correctamente");
					}else{
						System.out.println("No se han podido modificar los datos");
					}
				}
				g.backupFichero();
			}else if(opcion==3)
			{
				g.print();
			}else{
				System.out.println("Opción no válida.");
			}
		}
		System.out.println("Saliendo del main de gestor de usuarios...");
		mainprincipal.main(args);
	}
}