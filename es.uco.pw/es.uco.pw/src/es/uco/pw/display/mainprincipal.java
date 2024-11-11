
package es.uco.pw.display;


import java.util.Scanner;



import es.uco.pw.data.dao.gestordereservasDAO;
import es.uco.pw.display.mainreservas;

import es.uco.pw.data.dao.gestordeusuariosDAO;
import es.uco.pw.display.maingestorusuarios;

import es.uco.pw.data.dao.gestordepistasDAO;
import es.uco.pw.display.mainpistas;

public class mainprincipal {

	public static void main(String[] args) {
		//String[] args
		
		gestordeusuariosDAO gestor_usuarios = gestordeusuariosDAO.obtenerUsuarios();
		gestordepistasDAO gestor_pistas = gestordepistasDAO.getInstance();
		//gestordereservas gestor_reservas = gestordereservas.getGestor();
		
		int opcionIntroducida;
		System.out.println("**************");
		System.out.println("Bienvenido al programa");
		System.out.println("**************");
		System.out.println("1 > Gestor de usuarios");
		System.out.println("2 > Gestor de pistas");
		System.out.println("3 > Gestor de reservas");
		System.out.println("0 > Salir del programa");
		System.out.println("**************");
		System.out.print("Introduce una opcion > ");
		
		Scanner sc = new Scanner(System.in);
		opcionIntroducida = sc.nextInt();
		
		while(opcionIntroducida != 0)
		{
			switch(opcionIntroducida)
			{
			case 1:
				System.out.println("Gestor de usuarios...");
				maingestorusuarios.main(args);
				break;
				
			case 2:
				System.out.println("Gestor de pistas...");
				maingestorusuarios.main(args);
				break;
				
			case 3:
				System.out.println("Gestor de reservas...");
				mainreservas.main(args);
				break;
				
			default:
				System.out.println("Opción no válida");
				break;
			}
			
		}
		System.out.println("Saliendo del programa...");

	}
}
