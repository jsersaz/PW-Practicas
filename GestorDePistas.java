package ejercicio3;

import java.util.ArrayList;
import java.util.List;

public class GestorDePistas {
    private ArrayList<ejercicio1.Pista> pistas; // Creamos una lista de pistas
    private ArrayList<ejercicio1.Material> materiales; // Creamos una lista de materiales

    // Constructor vacío (sin parametros)
    public GestorDePistas() {
        this.pistas = new ArrayList<>();
        this.materiales = new ArrayList<>();
    }

    // Punto1 -> Función para crear una pista
    public void crearPista(String nombre, boolean tipoInterior, ejercicio1.tamanopista tamano, int maxJugadores) {
    	ejercicio1.Pista nuevaPista = new ejercicio1.Pista(nombre, true, tipoInterior, tamano, maxJugadores);
        pistas.add(nuevaPista);
    }

    // Punto 1-> Función para crear un material
    public void crearMaterial(int id, ejercicio1.Tipo tipo, boolean usoExterior, ejercicio1.Estado estado) {
    	ejercicio1.Material nuevoMaterial = new ejercicio1.Material(id, tipo, usoExterior, estado);
        materiales.add(nuevoMaterial);
    }

    // Punto 2-> Asocia un material a una pista disponible
    public boolean asociarMaterialAPista(String nombrePista, ejercicio1.Material material) {
        for (ejercicio1.Pista pista : pistas) {
            if (pista.getNombre().equals(nombrePista) && pista.isEstado()) { // Si la pista está disponible
                if (material.getEstado() == ejercicio1.Estado.disponible) { // Si el material está disponible
                	// Comprobamos si el material ya está asignado a otra pista
                    for (ejercicio1.Pista p : pistas) { 
                        if (p.getMaterialAsociados().contains(material)) {
                            System.out.println("El material no está disponible.");
                            return false;
                        }
                    }
                    System.out.println("Material asociado a la " + nombrePista + " con éxito.");
                    return pista.asociarMaterial_Pista(material);
                } else {
                    System.out.println("El material está en mantenimiento.");
                }
            }
        }
        System.out.println("La " + nombrePista + " no está disponible.");
        return false;
    }

    // Punto 3-> Función que lista las pistas no disponibles
    public void listarPistasNoDisponibles() {
    	int cont = 0;
        for (ejercicio1.Pista pista : pistas) {
        	if (!pista.isEstado())  {
                System.out.println("La " + pista.getNombre() + " no está disponible.");
                cont ++;
            }
        }
        if (cont == 0)
        {
        	System.out.println("Todas las pistas están disponibles");
        }
    }


    // Función que devuelve las pistas libres que soporten minimo X jugadores
    public List<ejercicio1.Pista> encontrarPistasLibres(int nJugadores, boolean tipoInterior) {
    	System.out.println("Pistas libres que soportan al menos " + nJugadores + " jugadores:");
        List<ejercicio1.Pista> pistasLibres = new ArrayList<>();
        for (ejercicio1.Pista pista : pistas) {
            if ((pista.isEstado()) && (pista.getMaxJugadores() >= nJugadores) && (pista.isTipoInterior() == tipoInterior)) {
                pistasLibres.add(pista);
            }
        }
        return pistasLibres;
    }
}
