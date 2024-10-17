package Ejercicio1;

import java.util.ArrayList;
import java.util.List;

/**
 * La clase Pista representa una pista de juego o entrenamiento, la cual 
 * puede estar disponible o no para reservas, ser interior o exterior, y 
 * tener asociados materiales para su uso.
 */
public class Pista {
	
	private String nombre;
	private boolean estado; // true si está disponible para reservas, false si no
	private boolean tipoInterior; // true para pista interior, false para exterior
	private tamanopista tamano;
	private int maxJugadores;
	private ArrayList<Material> materialAsociados; // materiales asociados para su uso en la pista
	
	// MÉTODOS
	
	/**
	 * Constructor vacío que inicializa una pista con valores predeterminados:
	 * estado disponible, tipo exterior, sin nombre y sin materiales asociados.
	 */
	public Pista() {
	    this.nombre = "";
	    this.estado = true;
	    this.tipoInterior = false;
	    this.tamano = tamanopista.none;
	    this.maxJugadores = 0;
	    this.materialAsociados = new ArrayList<>();
	}
	
	/**
	 * Constructor parametrizado que permite inicializar los atributos de la pista.
	 *
	 * @param nombre        Nombre de la pista.
	 * @param estado        true si la pista está disponible para reservas, false si no.
	 * @param tipoInterior  true para pista interior, false para exterior.
	 * @param tamano        Tamaño de la pista (definido por la enumeración tamanopista).
	 * @param maxJugadores  Máximo número de jugadores permitidos en la pista.
	 */
	public Pista(String nombre, boolean estado, boolean tipoInterior, tamanopista tamano, int maxJugadores) {
	    this.nombre = nombre;
	    this.estado = estado;
	    this.tipoInterior = tipoInterior;
	    this.tamano = tamano;
	    this.maxJugadores = maxJugadores;
	    this.materialAsociados = new ArrayList<>();
	}

	// MÉTODOS GET/SET

	/**
	 * Obtiene el nombre de la pista.
	 *
	 * @return El nombre de la pista.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre de la pista.
	 *
	 * @param nombre El nombre de la pista.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Indica si la pista está disponible para reservas.
	 *
	 * @return true si la pista está disponible, false si no.
	 */
	public boolean isEstado() {
		return estado;
	}

	/**
	 * Establece si la pista está disponible para reservas.
	 *
	 * @param estado true si está disponible, false si no.
	 */
	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	/**
	 * Indica si la pista es de tipo interior.
	 *
	 * @return true si es interior, false si es exterior.
	 */
	public boolean isTipoInterior() {
		return tipoInterior;
	}

	/**
	 * Establece si la pista es de tipo interior.
	 *
	 * @param tipoInterior true si es interior, false si es exterior.
	 */
	public void setTipoInterior(boolean tipoInterior) {
		this.tipoInterior = tipoInterior;
	}

	/**
	 * Obtiene el tamaño de la pista.
	 *
	 * @return El tamaño de la pista (enumeración tamanopista).
	 */
	public tamanopista getTamano() {
		return tamano;
	}

	/**
	 * Establece el tamaño de la pista.
	 *
	 * @param tamano El nuevo tamaño de la pista.
	 */
	public void setTamano(tamanopista tamano) {
		this.tamano = tamano;
	}

	/**
	 * Obtiene el número máximo de jugadores permitidos en la pista.
	 *
	 * @return El número máximo de jugadores.
	 */
	public int getMaxJugadores() {
		return maxJugadores;
	}

	/**
	 * Establece el número máximo de jugadores permitidos en la pista.
	 *
	 * @param maxJugadores El nuevo número máximo de jugadores.
	 */
	public void setMaxJugadores(int maxJugadores) {
		this.maxJugadores = maxJugadores;
	}

	/**
	 * Obtiene la lista de materiales asociados a la pista.
	 *
	 * @return La lista de materiales asociados.
	 */
	public List<Material> getMaterialAsociados() {
		return materialAsociados;
	}

	/**
	 * Establece la lista de materiales asociados a la pista.
	 *
	 * @param materialAsociados La nueva lista de materiales asociados.
	 */
	public void setMaterialAsociados(List<Material> materialAsociados) {
		this.materialAsociados = (ArrayList<Material>) materialAsociados;
	}
    
	/**
	 * Devuelve una representación en cadena de la información de la pista.
	 *
	 * @return Una cadena que representa la pista y sus atributos.
	 */
    @Override
    public String toString() {
        return "Pista: " + this.nombre +
        		", estado =" + (this.estado ? "Disponible" : "No disponible") +
                ", tipoInterior =" + (this.tipoInterior ? "Interior" : "Exterior") +
                ", tamano =" + this.tamano +
                ", maxJugadores =" + this.maxJugadores +
                ", materialAsociados =" + this.materialAsociados;
    }
	
	/**
	 * Devuelve una lista de los materiales asociados a la pista que están en buen estado y no reservados.
	 *
	 * @return Una lista de materiales disponibles.
	 */
    public List<Material> consultarMaterialesDisponibles() { 
        List<Material> materialesDisponibles = new ArrayList<>();
        for(Material m : this.materialAsociados) {
        	if(m.getEstado() == Estado.disponible) {
        		materialesDisponibles.add(m);
        	}
        }
        return materialesDisponibles;
    }  
        
	/**
	 * Asocia un material a la pista, verificando restricciones como la cantidad máxima de cada tipo de material.
	 *
	 * @param material El material a asociar.
	 * @return true si el material se puede asociar, false si se alcanzó el límite permitido para ese tipo.
	 */
	public boolean asociarMaterial_Pista(Material material) {
		int cPelotas = 0;
		int cCanastas = 0;
		int cConos = 0;
		
		// Contar los materiales ya asociados
		for(Material m : materialAsociados) {
			switch (m.getTipo()) {
			case Tipo.pelotas: 
				cPelotas++;
				break;
			case Tipo.canastas:
				cCanastas++;
				break;
			case Tipo.conos:
				cConos++;
				break;
			}
		}
		
		// Verificar si se puede añadir el material
		if (tipoInterior) { // La pista es interior
			if(material.getTipo() == Tipo.pelotas && cPelotas >= 12) {
				return false; // No se pueden añadir más de 12 pelotas
			} else if (material.getTipo() == Tipo.canastas && cCanastas >= 2) {
				return false; // No se pueden añadir más de 2 canastas
			} else if (material.getTipo() == Tipo.conos && cConos >= 20) {
				return false; // No se pueden añadir más de 20 conos
			}
		} else { // La pista es exterior
	        if (!material.isUso()) {
	            return false; // Material no apto para exterior
	        }
	        if(material.getTipo() == Tipo.pelotas && cPelotas >= 12) {
				return false; // No se pueden añadir más de 12 pelotas
			} else if (material.getTipo() == Tipo.canastas && cCanastas >= 2) {
				return false; // No se pueden añadir más de 2 canastas
			} else if (material.getTipo() == Tipo.conos && cConos >= 20) {
				return false; // No se pueden añadir más de 20 conos
			}
		}
		materialAsociados.add(material);
		return true;
	}
}
