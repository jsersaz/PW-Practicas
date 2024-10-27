package ejercicio3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import Ejercicio1.Estado;
import Ejercicio1.Material;
import Ejercicio1.Pista;
import Ejercicio1.Tipo;
import Ejercicio1.tamanopista;


public class GestorDePistas {
	
	private ArrayList<Pista> pistas;
	
	private static GestorDePistas instanciaUnica;
	
	private static Properties properties;
	
	private GestorDePistas()
	{
		pistas= new ArrayList<Pista>();
		properties= new Properties();
        try(FileInputStream input=new FileInputStream("properties.txt"))
        {
            properties.load(input);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
	}
	
	public static GestorDePistas getInstance()
	{
		if(instanciaUnica == null)
		{
			instanciaUnica = new GestorDePistas();
		}
		return instanciaUnica;
	}
	
	public boolean nombrePistaExiste(String nombrePista)
	{
        try (BufferedReader br = new BufferedReader(new FileReader(properties.getProperty("ficheroPistas"))))
        {
            String linea;
            while((linea = br.readLine()) != null)
            {
                String[] campos = linea.split(";");
                
                if (campos[0].equalsIgnoreCase(nombrePista.trim()))
                {
                    return true;
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return false; 
    }
	
	public boolean addPista(Pista pistaNueva)
	{
		if(nombrePistaExiste(pistaNueva.getNombre()))
		{
            System.out.println("Error: Ya existe una pista con el nombre " + pistaNueva.getNombre());
            return false;
        }
		
//		for(Material material : pistaNueva.getMaterialAsociados())
//		{
//	        if(material.isAsociado())
//	        {
//	            System.out.println("Error: El material ID " + material.getIdentificador() + " ya está asociado a otra pista.");
//	            return false;
//	        }
//	    }
		
		for(Material material : pistaNueva.getMaterialAsociados())
		{
	        material.setPistaAsociada(pistaNueva);
	    }
		
		for(Pista pista : this.pistas)
		{
			if(pista.getNombre() == pistaNueva.getNombre())
			{
	            System.out.println("Error: El nombre " + pistaNueva.getNombre() + " ya está en otra pista.");
				return false;
			}
		}
		
		this.pistas.add(pistaNueva);
		guardarPistasEnBD();
		return true;
	}
	
	private ArrayList<Material> cargarMaterialesBD()
	{
		ArrayList<Material> materiales = new ArrayList<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(properties.getProperty("ficheroMateriales"))))
		{
	        String linea;
	        while ((linea = br.readLine()) != null)
	        {
	            String[] campos = linea.split(";");
	            
	            Material materialLeido = new Material();
	            
	            materialLeido.setIdentificador(Integer.parseInt(campos[0]));
	            Tipo tipo = Tipo.valueOf(campos[1]);
	            materialLeido.setTipo(tipo);
	            materialLeido.setUso(campos[2].equalsIgnoreCase("true"));
	            Estado estado = Estado.valueOf(campos[3]);
	            
	            materiales.add(materialLeido);
	            
	        }
		}
		catch (IOException e)
		{
	        e.printStackTrace();
	    }
		
		return materiales;
	}
	
	public void cargarBD()
	{
		//Primero cargo todos los materiales del fichero materiales en un array de materiales
		ArrayList<Material> materiales = cargarMaterialesBD();
		
		try (BufferedReader br = new BufferedReader(new FileReader(properties.getProperty("ficheroPistas"))))
		{
	        String linea;
	        while ((linea = br.readLine()) != null)
	        {
	            String[] campos = linea.split(";");
	            Pista pistaLeida = new Pista();
	            
	            pistaLeida.setNombre(campos[0]);
	            pistaLeida.setEstado(campos[1].equalsIgnoreCase("disponible"));
	            pistaLeida.setTipoInterior(campos[2].equalsIgnoreCase("true"));
	            tamanopista tamano = tamanopista.valueOf(campos[3]);
	            pistaLeida.setTamano(tamano);
	            pistaLeida.setMaxJugadores(Integer.parseInt(campos[4]));
	            
	            //Ahora proceso los materiales
	            String [] materialesLeidos = campos[5].split(",");
	            
	            for(int i = 0; i < materialesLeidos.length; i++)
	            {
		            for(Material m : materiales)
		            {
		            	if(m.getIdentificador() == Integer.parseInt(materialesLeidos[i]))
		            	{
		            		pistaLeida.asociarMaterial_Pista(m);
		            	}
		            }
	            }
	            //Guardo la nueva pista en el array
	            this.pistas.add(pistaLeida);
	            
	        }
		}
		catch (IOException e)
		{
	        e.printStackTrace();
	    }
	}

	
	private void guardarPistasEnBD()
	{
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(properties.getProperty("ficheroPistas"))))
        {
            for(Pista pista : this.pistas)
            {
            	bw.write(pista.getNombre());
                bw.write(";");
                bw.write(pista.isEstado() ? "disponible" : "no disponible");
                bw.write(";");
                bw.write(pista.isTipoInterior() ? "true" : "false");
                bw.write(";");
                bw.write(pista.getTamano().name());
                bw.write(";");
                bw.write(String.valueOf(pista.getMaxJugadores()));
                bw.write(";");
                ArrayList<Material> material = pista.getMaterialAsociados();
                for(int i = 0; i < material.size(); i++)
                {
                    bw.write(String.valueOf(material.get(i).getIdentificador()));
                    if(i < (material.size() - 1))
                    {
                        bw.write(",");
                    }
                }
                bw.newLine();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
	
	public void listarMateriales()
	{
	    ArrayList<Material> materiales = cargarMaterialesBD();
	    
	    if (materiales.isEmpty())
	    {
	        System.out.println("No hay materiales en el archivo.");
	    }
	    else
	    {
	        System.out.println("Materiales:");
	        for (Material material : materiales)
	        {
	            System.out.println("-> ID: " + material.getIdentificador() + ", Nombre: " + material.getTipo() + ", Tipo: " + (material.isUso() ? "exterior" : "interior"));
	        }
	    }
	}
	
	public Material buscarMaterialPorId(int id)
	{
	    ArrayList<Material> materiales = cargarMaterialesBD();
	    
	    if(materiales.isEmpty())
	    {
	        System.out.println("Error: No hay materiales en el archivo.");
	    }
	    else
	    {
		    for(Material material : materiales)
		    {
		        if(material.getIdentificador() == id)
		        {
		            return material;
		        }
		    }
	    }
	    return null;
	}
	
	// Listar pistas no disponibles
	public void listarPistasNoDisponibles()
	{
		System.out.println("Pistas no disponibles: ");
		for(Pista pista : this.pistas)
		{
			if (!pista.isEstado())
			{
				System.out.println(pista.getNombre());
			}
		}
	}
	
	// Encontrar pistas libres según número de jugadores y tipo
	public void buscarPistasLibres(int numJugadores, boolean esInterior)
	{
	    System.out.println("Pistas libres para " + numJugadores + " jugadores y tipo " + (esInterior ? "interior" : "exterior") + ":");
		int i=0;	    
	    for(Pista pista : this.pistas)
		{
			if((pista.isEstado()) && (pista.isTipoInterior() == esInterior) && (pista.getMaxJugadores() >= numJugadores))
			{
				System.out.println("-> " + pista.getNombre());
				i++;
			}
		}
	    if(i==0)
	    {
			System.out.println("No hay pistas con esas opciones.");
	    }
	}

	@Override
	public String toString() {
		return "GestorPistas [pistas=" + pistas + "]";
	}

}
