package ejercicio3;

import java.time.LocalDate;
import java.util.Properties;
import java.util.Scanner;

import ejercicio1.Jugador;
import ejercicio3.Gestordeusuarios;


public class MainGestordeusuarios
{
	public static void main(String[] args) 
	{
		Properties properties;
		Gestordeusuarios g = Gestordeusuarios.obtenerUsuarios();
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
				if(opcion==1)
				{
					Jugador j = new Jugador(nombrenuevo, apellidosnuevos, nuevaFechaNacimientoDate, nuevoEmail);
					if(g.addJugador(j)==true)
					{
						System.out.println("El usuario se ha añadido correctamente");
					}else{
						System.out.println("No se ha podido añadir al nuevo usuario");	
					}
				}else{
					System.out.println("Introduce el email del jugador al que quieres modificar los anteriores parámetros:");
					String emailBuscar = scanner.nextLine();
					if(g.modificarJugador(nombrenuevo, apellidosnuevos, nuevaFechaNacimientoDate, nuevoEmail, emailBuscar)==true){
						System.out.println("Los datos se han modificado correctamente");
					}else{
						System.out.println("No se han podido modificar los datos");
					}
				}
				g.backupFichero();
			}else if(opcion==3)
			{
				g.print();
			}else if(opcion==4)
			{
				System.out.println("Saliendo del main de gestor de usuarios...");
			}else{
				System.out.println("Opción no válida.");
			}
		}
	}
}
