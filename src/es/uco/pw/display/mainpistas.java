package es.uco.pw.display;

import java.util.ArrayList;
import java.util.Scanner;


import es.uco.pw.clases.material.Material;
import es.uco.pw.clases.pista.Pista;

import es.uco.pw.clases.pista.tamanopista;
import es.uco.pw.gestores.gestordepistas;

public class mainpistas
{

	public static void main(String[] args)
	{
		gestordepistas gestorPistas = gestordepistas.getInstance();
		gestorPistas.cargarBD();
		
		System.out.println(gestorPistas.toString());
		
		Scanner scanner = new Scanner(System.in);
		int opcion = 0;

		do
		{
			System.out.println("----- Menú Gestor de Pistas -----");
			System.out.println("1) Agregar una nueva pista");
			System.out.println("2) Listar pistas no disponibles");
			System.out.println("3) Buscar pistas libres según número de jugadores y tipo");
			System.out.println("4) Salir");
			opcion = scanner.nextInt();
			
			if (opcion == 1)
			{
					agregarNuevaPista(gestorPistas, scanner);
			}
			else if (opcion == 2)
			{
					gestorPistas.listarPistasNoDisponibles();
			}
			else if (opcion == 3)
			{
					buscarLibres(gestorPistas, scanner);
			}
			else if (opcion == 4)
			{
					System.out.println("Saliendo.");
			}
			else
			{
					System.out.println("Opción no válida.");
			}
			
		} while (opcion != 4);

		scanner.close();
	}

	// Método para agregar una nueva pista
	private static void agregarNuevaPista(gestordepistas gestorPistas, Scanner scanner)
	{
		scanner.nextLine();
		
		System.out.print("Introduce el nombre de la pista: ");
		String nombre = scanner.nextLine();
		
		System.out.print("¿Está disponible? (true/false): ");
		boolean disponible = scanner.nextBoolean();
		
		System.out.print("¿Es interior? (true/false): ");
		boolean esInterior = scanner.nextBoolean();
		
		System.out.print("Introduce el tamaño de pista (minibasket, adultos, tres_vs_tres, none): ");
		tamanopista tamano = tamanopista.valueOf(scanner.next().toLowerCase());
		
		System.out.print("Introduce el número máximo de jugadores: ");
		int maxJugadores = scanner.nextInt();
		
		gestorPistas.listarMateriales();		
		System.out.print("Introduce el número de los materiales que quiera asociar (introduce 0 para terminar): ");
		int OpcionMaterial;
		ArrayList<Material> materialesSeleccionados = new ArrayList<>();
		do
		{
			OpcionMaterial = scanner.nextInt();
			if(OpcionMaterial != 0)
			{
				Material materialSeleccionado = gestorPistas.buscarMaterialPorId(OpcionMaterial);
	            
	            if(materialSeleccionado != null)
	            {
	                    materialesSeleccionados.add(materialSeleccionado);
	            }
	            else
	            {
	                System.out.println("Error: Material no encontrado.");
	            }
			}
		} while (OpcionMaterial != 0);
		
		if (materialesSeleccionados.isEmpty())
		{
	        System.out.println("Error: No se han seleccionado materiales");
	        System.out.println("Error: La pista no ha sido agregada.");
	    }
		else
		{
			Pista nuevaPista = new Pista(nombre, disponible, esInterior, tamano, maxJugadores);
			for(Material material : materialesSeleccionados)
			{
		        nuevaPista.asociarMaterial_Pista(material);
		    }
			if(gestorPistas.addPista(nuevaPista))
			{
				System.out.println("Pista agregada exitosamente.");
			}
			else
			{
				System.out.println("Error: La pista no ha sido agregada.");
			}	
		}
	}

	// Método para buscar pistas libres según el número de jugadores y si es interior/exterior
	private static void buscarLibres(gestordepistas gestorPistas, Scanner scanner)
	{
		System.out.print("Ingrese el número de jugadores: ");
		int numJugadores = scanner.nextInt();
		
		System.out.print("¿Es interior? (true/false): ");
		boolean esInterior = scanner.nextBoolean();
		
		gestorPistas.buscarPistasLibres(numJugadores, esInterior);
	}

}
