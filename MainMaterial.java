package es.uco.pw.ejercicio1;

public class MainMaterial {
    public static void main(String[] args) {
        // 1. Prueba del constructor vacío
        Material material1 = new Material();
        System.out.println("=== Material (Constructor Vacío) ===");
        mostrarMaterial(material1);
        
        // 2. Prueba del constructor parametrizado
        Material material2 = new Material(1, Tipo.canastas, false, Estado.reservado);
        System.out.println("\n=== Material (1, canastas, false, reservado) ===");
        mostrarMaterial(material2);
        
        // 3. Prueba de los setters en material1
        material1.setIdentificador(2);
        material1.setTipo(Tipo.conos);
        material1.setUso(false);
        material1.setEstado(Estado.mal_estado);
        System.out.println("\n=== Material (2, conos, false, mal_estado) ===");
        mostrarMaterial(material1);
        
        // 4. Prueba de los setters en material2
        material2.setIdentificador(3);
        material2.setTipo(Tipo.pelotas);
        material2.setUso(true);
        material2.setEstado(Estado.disponible);
        System.out.println("\n=== Material (3, pelotas, true, disponible) ===");
        mostrarMaterial(material2);
        
    }
    
    // Método auxiliar para mostrar los detalles de un objeto Material
    private static void mostrarMaterial(Material material) {
        System.out.println("Identificador: " + material.getIdentificador());
        System.out.println("Tipo: " + material.getTipo());
        System.out.println("Uso Exterior: " + (material.isUso() ? "Sí" : "No"));
        System.out.println("Estado: " + material.getEstado());
    }
}
