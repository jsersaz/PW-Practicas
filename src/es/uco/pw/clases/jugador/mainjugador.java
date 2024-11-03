package es.uco.pw.clases.jugador;

import java.time.LocalDate;

/**
 * La clase mainjugador contiene el método principal para ejecutar pruebas 
 * relacionadas con la clase Jugador. 
 * Se crean instancias de Jugador, se asignan valores a sus atributos, 
 * y se muestran sus datos y antigüedad en el sistema.
 */
public class mainjugador {
    
    /**
     * Método principal que ejecuta el programa para crear y manipular objetos Jugador.
     *
     * @param args Argumentos de línea de comandos (no se utilizan en este programa).
     */
    public static void main(String[] args) {
        // Crear una instancia de Jugador usando el constructor vacío
        Jugador jugador1 = new Jugador();
        
        // Usar los setters para asignar valores a los atributos
        jugador1.setNombre("Juan");
        jugador1.setApellidos("Pérez");
        jugador1.setFechaNacimiento(LocalDate.of(1990, 5, 15)); // Fecha de nacimiento: 15 de mayo de 1990
        jugador1.setEmail("juan.perez@example.com");
        
        // Mostrar los datos del jugador usando el método toString()
        System.out.println("Datos del jugador 1:");
        System.out.println(jugador1.toString());
        
        // Calcular y mostrar la antigüedad del jugador
        jugador1.imprimirAntiguedad();
        
        System.out.println(); // Separador para mejor legibilidad
        
        // Crear una instancia de Jugador usando el constructor parametrizado
        Jugador jugador2 = new Jugador("María", "García", LocalDate.of(1985, 8, 20), "maria.garcia@example.com", "1");
        
        // Mostrar los datos del jugador 2 usando el método toString()
        System.out.println("Datos del jugador 2:");
        System.out.println(jugador2.toString());
        
        // Calcular y mostrar la antigüedad del jugador
        jugador2.imprimirAntiguedad();
    }
}