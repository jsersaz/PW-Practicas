package ejercicio3;

import ejercicio1.Material;
import ejercicio1.Pista;
import ejercicio1.Estado;
import ejercicio1.Tipo;
import ejercicio1.tamanopista;

public class MainGestorDePistas {
	public static void main(String[] args) {
        GestorDePistas gestor = new GestorDePistas();

        // Creamos algunas pistas
        gestor.crearPista("Pista 1", true, tamanopista.minibasket, 4);
        gestor.crearPista("Pista 2", false, tamanopista.adultos, 6);
        gestor.crearPista("Pista 3", true, tamanopista.tres_vs_tres, 2);

        // Crear algunos materiales
        gestor.crearMaterial(1, Tipo.pelotas, true, Estado.disponible);
        gestor.crearMaterial(2, Tipo.canastas, false, Estado.disponible);
        gestor.crearMaterial(3, Tipo.conos, true, Estado.mal_estado);

        // Intentar asociar un material disponible a una pista disponible
        Material materialPelotas = new Material(1, Tipo.pelotas, true, Estado.disponible);
        boolean asociado = gestor.asociarMaterialAPista("Pista 1", materialPelotas); // Material asociado con la Pista 1 con éxito
        System.out.println("¿Se ha asociado el material a la Pista 1?: " + asociado); // TRUE

        // Intentar asociar un material en mal_estado
        Material materialConos = new Material(3, Tipo.conos, false, Estado.mal_estado);
        boolean asociadoConos = gestor.asociarMaterialAPista("Pista 2", materialConos); // El material está en mantenimiento
        System.out.println("¿Se ha asociado el material a la Pista 2?: " + asociadoConos); // FALSE

        gestor.listarPistasNoDisponibles(); // La Pista 2 no está disponible

        // Buscar pistas libres que soporten al menos 4 jugadores y sean interiores (Pista 1)
        for (Pista pista : gestor.encontrarPistasLibres(4, true)) {
            System.out.println(pista.getNombre());
        }
    }
}
