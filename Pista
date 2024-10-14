package Practica1;

import java.util.ArrayList;
import java.util.List;


public class Pista {

	
	private String nombre;
	private boolean estado; // Punto 2 -> true si está disponible para reservas, false si no
	private boolean tipoInterior; // / Punto 3 -> true para pista interior, false para exterior
	private tamanopista tamano;
	private int maxJugadores;
	private ArrayList<Material> materialAsociados; // materiales asociados para su uso en la pista
	
	
	//METODOS
	
	//Constructor vacío
	public Pista() {
	    this.nombre = "";
	    this.estado = false;
	    this.tipoInterior = false;
	    this.tamano = tamanopista.none; 
	    this.maxJugadores = 0;
	    this.materialAsociados = new ArrayList<Material>();
	    }
	
	//  Constructor parametrizado
    public Pista(String nombre, boolean estado, boolean tipoInterior, tamanopista tamano, int maxJugadores) {
        this.nombre = nombre;
        this.estado = estado;
        this.tipoInterior = tipoInterior;
        this.tamano = tamano;
        this.maxJugadores = maxJugadores;
        this.materialAsociados = new ArrayList<>();
    }

    
    // MÉTODOS GET/SET
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public boolean isTipoInterior() {
		return tipoInterior;
	}

	public void setTipoInterior(boolean tipoInterior) {
		this.tipoInterior = tipoInterior;
	}

	public tamanopista getTamano() {
		return tamano;
	}

	public void setTamano(tamanopista tamano) {
		this.tamano = tamano;
	}

	public int getMaxJugadores() {
		return maxJugadores;
	}

	public void setMaxJugadores(int maxJugadores) {
		this.maxJugadores = maxJugadores;
	} 

	public List<Material> getMaterialAsociados() {
		return materialAsociados;
	}

	public void setMaterialAsociados(List<Material> materialAsociados) {
		this.materialAsociados = (ArrayList<Material>) materialAsociados;
	}
    
    
    //para imprimir la información de la pista
    @Override
    public String toString() {
        return "Pista: " + this.nombre +
        		", estado =" + (this.estado ? "Disponible" : "No disponible") +
                ", tipoInterior =" + (this.tipoInterior ? "Interior" : "Exterior") +
                ", tamano =" + this.tamano +
                ", maxJugadores =" + this.maxJugadores +
                ", materialAsociados =" + this.materialAsociados;
    }
	
	
	
	 //Devuelve los materiales en buen estado y no reservados
    public List<Material> consultarMaterialesDisponibles() { 
        List<Material> materialesDisponibles = new ArrayList<>();
        for(Material m : this.materialAsociados) // recorrer una lista sin modificarla
        {
        
        	if(m.getEstado() == Estado.disponible) {
        		materialesDisponibles.add(m);
        	}
        	       
        }
        return materialesDisponibles; //Devuelve la lista de materiales disponibles
    }  
        
     //asocia un material a la pista con las restricciones indicadas

	public boolean asociarMaterial_Pista(Material material)
	{
		//Un contador para ver los distintos tipos de material.
		
		int cPelotas= 0;
		int cCanastas= 0;
		int cConos=0;
		
		
		//Primero contamos los materiales ya asociados
		
		for(Material m : materialAsociados)
		{
			switch (m.getTipo())
			{
			case Tipo.pelotas: //ENTIENDO QUE EL FALLO QUE NO PUEDO TENER MAS DE UNA CONSTANTE????--> yo habia puesto simplemente pelotas
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
		
		
		//VERIFICAMOS SI SE PUEDE AÑADIR EL MATERIAL
		
		if(tipoInterior) // esta linea no estoy seguro
		{
				//intentar ponerlo con un try catch, dentro de cada if DA PUNTOS
			
			//LA PISTA ES INFERIOR, SE PERMITEN MATERIALES DE INTERIOR Y EXTERIOR
			if(material.getTipo() == Tipo.pelotas && cPelotas >= 12)
			{
				return false; // No se pueden añadir más de 12 pelotas
			}else if (material.getTipo() == Tipo.canastas && cCanastas >= 2) {
				 return false; // No se pueden añadir más de 2 canastas
			}else if (material.getTipo() == Tipo.conos && cConos >= 20) {
				return false; // No se pueden añadir más de 20 conos
			}
			
		}else {
						
			 // La pista es exterior, solo se permiten materiales de exterior
	        if (!material.isUso()) { // esta linea me lo ha arreglado java ---> yo habia puesto !material.uso_exterior
	            return false; // Material no apto para exterior
	        }
	        if(material.getTipo() == Tipo.pelotas && cPelotas >= 12)
			{
				return false; // No se pueden añadir más de 12 pelotas
			}else if (material.getTipo() == Tipo.canastas && cCanastas >= 2) {
				 return false; // No se pueden añadir más de 2 canastas
			}else if (material.getTipo() == Tipo.conos && cConos >= 20) {
				return false; // No se pueden añadir más de 20 conos
			}
		}
		materialAsociados.add(material);
		return true;
	}
}
