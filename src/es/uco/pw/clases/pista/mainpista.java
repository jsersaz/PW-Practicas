package es.uco.pw.clases.pista;


import es.uco.pw.clases.material.Material;
import es.uco.pw.clases.material.Estado;
import es.uco.pw.clases.material.Tipo;


import java.util.List;
import java.util.ArrayList;

/**
 * Clase mainpista.
 * Clase principal para realizar pruebas sobre la funcionalidad de la clase Pista y sus interacciones
 * con los materiales asociados.
 */
public class mainpista {

    public static void main(String[] args) {
        
        // 1. Prueba del constructor vacío de Pista
        Pista pista1 = new Pista();
        System.out.println("=== Pista1 (Constructor Vacío) ===");
        System.out.println(pista1);

        // 2. Prueba del constructor parametrizado de Pista
        Pista pista2 = new Pista("Pista Deportiva 1", true, false, tamanopista.adultos, 10);
        System.out.println("\n=== Pista2 (Constructor Parametrizado) ===");
        System.out.println(pista2);
        
        // 3. Creación de materiales para asociar a las pistas
        Material pelota1 = new Material(1, Tipo.pelotas, true, Estado.disponible);
        Material pelota2 = new Material(2, Tipo.pelotas, false, Estado.disponible);
        Material canasta1 = new Material(3, Tipo.canastas, true, Estado.disponible);
        Material cono1 = new Material(4, Tipo.conos, true, Estado.disponible);
        Material cono2 = new Material(5, Tipo.conos, false, Estado.mal_estado);
        
        // 4. Prueba de asociar materiales a la pista1
        System.out.println("\n=== Prueba de asociar materiales a Pista1 (Constructor Vacío) ===");
        pista1.asociarMaterial_Pista(pelota1);
        pista1.asociarMaterial_Pista(canasta1);
        pista1.asociarMaterial_Pista(cono1);
        System.out.println(pista1);
        
        // 5. Prueba de asociar un material no apto (material de exterior en pista interior)
        System.out.println("\n=== Intento de asociar material no apto (pelota de exterior en pista interior) a Pista2 ===");
        if (!pista2.asociarMaterial_Pista(pelota2)) {
            System.out.println("No se puede asociar el material: Pelota de exterior a Pista2 (pista interior).");
        }
        
        // 6. Prueba de asociar un material en mal estado
        System.out.println("\n=== Intento de asociar material en mal estado (cono2) a Pista2 ===");
        if (!pista2.asociarMaterial_Pista(cono2)) {
            System.out.println("No se puede asociar el material: Cono en mal estado a Pista2.");
        }

        // 7. Asociar más materiales a pista2
        pista2.asociarMaterial_Pista(pelota1); // apto para exterior
        pista2.asociarMaterial_Pista(cono1);   // apto para exterior
        System.out.println(pista2);
        
        // 8. Consultar materiales disponibles en pista2
        System.out.println("\n=== Materiales disponibles en Pista2 ===");
        List<Material> materialesDisponibles = pista2.consultarMaterialesDisponibles();
        for (Material material : materialesDisponibles) {
            System.out.println("Material disponible: " + material.getTipo() + " - ID: " + material.getIdentificador());
        }
        
        // 9. Prueba de sobrepasar el límite de materiales
        System.out.println("\n=== Intento de asociar más materiales de los permitidos ===");
        for (int i = 0; i < 12; i++) {
            Material nuevaPelota = new Material(i + 10, Tipo.pelotas, true, Estado.disponible);
            if (!pista1.asociarMaterial_Pista(nuevaPelota)) {
                System.out.println("No se puede asociar la pelota " + (i + 1) + " a Pista1 (límite alcanzado).");
            }
        }
        
        // Muestra final de Pista1 y Pista2
        System.out.println("\n=== Estado Final de Pista1 ===");
        System.out.println(pista1);
        
        System.out.println("\n=== Estado Final de Pista2 ===");
        System.out.println(pista2);
    }
}
