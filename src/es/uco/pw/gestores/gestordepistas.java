package es.uco.pw.gestores;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import es.uco.pw.clases.jugador.Jugador;
import es.uco.pw.clases.material.Estado;
import es.uco.pw.clases.material.Material;
import es.uco.pw.clases.pista.Pista;
import es.uco.pw.clases.material.Tipo;
import es.uco.pw.clases.pista.tamanopista;

/**
 * La clase {@code gestordepistas} gestiona las operaciones relacionadas con las pistas deportivas,
 * incluyendo la adición de nuevas pistas, la carga de datos desde archivos y la búsqueda de pistas
 * disponibles según ciertos criterios.
 */
public class gestordepistas {

    private ArrayList<Pista> pistas;

    private static gestordepistas instanciaUnica;

    private static Properties properties;

    /**
     * Constructor privado de la clase {@code gestordepistas}. 
     * Inicializa la lista de pistas y carga las propiedades desde un archivo.
     */
    private gestordepistas() {
        pistas = new ArrayList<Pista>();
        properties = new Properties();
        try (FileInputStream input = new FileInputStream("properties.txt")) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Devuelve la instancia única de la clase {@code gestordepistas}.
     * 
     * @return la instancia única de {@code gestordepistas}.
     */
    public static gestordepistas getInstance() {
        if (instanciaUnica == null) {
            instanciaUnica = new gestordepistas();
        }
        return instanciaUnica;
    }

    /**
     * Verifica si existe una pista con el nombre proporcionado.
     * 
     * @param nombrePista el nombre de la pista a verificar.
     * @return {@code true} si la pista existe, {@code false} en caso contrario.
     */
    public boolean nombrePistaExiste(String nombrePista) {
        try (BufferedReader br = new BufferedReader(new FileReader(properties.getProperty("ficheroPistas")))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(";");

                if (campos[0].equalsIgnoreCase(nombrePista.trim())) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Añade una nueva pista al gestor si no existe previamente.
     * 
     * @param pistaNueva la nueva pista a añadir.
     * @return {@code true} si se ha añadido la pista, {@code false} si ya existe.
     */
    public boolean addPista(Pista pistaNueva) {
        if (nombrePistaExiste(pistaNueva.getNombre())) {
            System.out.println("Error: Ya existe una pista con el nombre " + pistaNueva.getNombre());
            return false;
        }

        for (Material material : pistaNueva.getMaterialAsociados()) {
            material.setPistaAsociada(pistaNueva);
        }

        for (Pista pista : this.pistas) {
            if (pista.getNombre() == pistaNueva.getNombre()) {
                System.out.println("Error: El nombre " + pistaNueva.getNombre() + " ya está en otra pista.");
                return false;
            }
        }

        this.pistas.add(pistaNueva);
        guardarPistasEnBD();
        return true;
    }

    /**
     * Carga los materiales desde el archivo de materiales.
     * 
     * @return una lista de materiales leídos desde el archivo.
     */
    private ArrayList<Material> cargarMaterialesBD() {
        ArrayList<Material> materiales = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(properties.getProperty("ficheroMateriales")))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(";");

                Material materialLeido = new Material();

                materialLeido.setIdentificador(Integer.parseInt(campos[0]));
                Tipo tipo = Tipo.valueOf(campos[1]);
                materialLeido.setTipo(tipo);
                materialLeido.setUso(campos[2].equalsIgnoreCase("true"));
                Estado estado = Estado.valueOf(campos[3]);

                materiales.add(materialLeido);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return materiales;
    }

    /**
     * Carga las pistas desde el archivo de pistas y asocia los materiales correspondientes.
     */
    public void cargarBD() {
        // Primero cargo todos los materiales del fichero materiales en un array de materiales
        ArrayList<Material> materiales = cargarMaterialesBD();

        try (BufferedReader br = new BufferedReader(new FileReader(properties.getProperty("ficheroPistas")))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(";");
                Pista pistaLeida = new Pista();

                pistaLeida.setNombre(campos[0]);
                pistaLeida.setEstado(campos[1].equalsIgnoreCase("disponible"));
                pistaLeida.setTipoInterior(campos[2].equalsIgnoreCase("true"));
                tamanopista tamano = tamanopista.valueOf(campos[3]);
                pistaLeida.setTamano(tamano);
                pistaLeida.setMaxJugadores(Integer.parseInt(campos[4]));

                // Ahora proceso los materiales
                String[] materialesLeidos = campos[5].split(",");

                for (int i = 0; i < materialesLeidos.length; i++) {
                    for (Material m : materiales) {
                        if (m.getIdentificador() == Integer.parseInt(materialesLeidos[i])) {
                            pistaLeida.asociarMaterial_Pista(m);
                        }
                    }
                }
                // Guardo la nueva pista en el array
                this.pistas.add(pistaLeida);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Guarda todas las pistas en el archivo de pistas.
     */
    private void guardarPistasEnBD() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(properties.getProperty("ficheroPistas")))) {
            for (Pista pista : this.pistas) {
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
                for (int i = 0; i < material.size(); i++) {
                    bw.write(String.valueOf(material.get(i).getIdentificador()));
                    if (i < (material.size() - 1)) {
                        bw.write(",");
                    }
                }
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Lista los materiales disponibles en el archivo de materiales.
     */
    public void listarMateriales() {
        ArrayList<Material> materiales = cargarMaterialesBD();

        if (materiales.isEmpty()) {
            System.out.println("No hay materiales en el archivo.");
        } else {
            System.out.println("Materiales:");
            for (Material material : materiales) {
                System.out.println("-> ID: " + material.getIdentificador() + ", Nombre: " + material.getTipo() + ", Tipo: " + (material.isUso() ? "exterior" : "interior"));
            }
        }
    }

    /**
     * Busca un material por su identificador.
     * 
     * @param id el identificador del material a buscar.
     * @return el material correspondiente, o {@code null} si no se encuentra.
     */
    public Material buscarMaterialPorId(int id) {
        ArrayList<Material> materiales = cargarMaterialesBD();

        if (materiales.isEmpty()) {
            System.out.println("Error: No hay materiales en el archivo.");
        } else {
            for (Material material : materiales) {
                if (material.getIdentificador() == id) {
                    return material;
                }
            }
        }
        return null;
    }

    /**
     * Lista las pistas que no están disponibles.
     */
    // Listar pistas no disponibles
    public void listarPistasNoDisponibles() {
        System.out.println("Pistas no disponibles: ");
        for (Pista pista : this.pistas) {
            if (!pista.isEstado()) {
                System.out.println(pista.getNombre());
            }
        }
    }

    /**
     * Busca las pistas libres según el número de jugadores y el tipo de pista.
     * 
     * @param numJugadores el número de jugadores.
     * @param esInterior {@code true} si la pista es interior, {@code false} si es exterior.
     */
    // Encontrar pistas libres según número de jugadores y tipo
    public void buscarPistasLibres(int numJugadores, boolean esInterior) {
        System.out.println("Pistas libres para " + numJugadores + " jugadores (" + (esInterior ? "interior" : "exterior") + "):");
        for (Pista pista : this.pistas) {
            if((pista.isEstado()) && (pista.isTipoInterior() == esInterior) && (pista.getMaxJugadores() >= numJugadores))
			{
				System.out.println("-> " + pista.getNombre());
				//i++;
			}
        }
    }

	
@Override
	public String toString() {
		return "GestorPistas [pistas=" + pistas + "]";
	}
}


