package es.uco.pw.business.jugador;

import java.time.LocalDate;

import java.time.Period;

/**
 * La clase Jugador representa un jugador con sus detalles personales, como nombre,
 * apellidos, fecha de nacimiento, fecha de inscripción y correo electrónico.
 * Proporciona métodos para calcular la antigüedad del jugador desde su inscripción.
 */


public class JugadorDTO {

	 	private String nombre;
	    private String apellidos;
	    private LocalDate fechaNacimiento;
	    private LocalDate fechaInscripcion;
	    private String email;
	    private String dni;
	   

	    /**
	     * Constructor vacío que inicializa la fecha de inscripción con la fecha actual.
	     */
	    public JugadorDTO() {
	    	//this.nombre=null;
	    	//this.apellidos=null;
	    	//this.fechaNacimiento=LocalDate.parse("0000-00-00");
	        this.fechaInscripcion = LocalDate.now();
	        //this.email=null;
	        //this.dni=null;
	    }

	    /**
	     * Constructor parametrizado que inicializa los atributos del jugador.
	     *
	     * @param nombre           El nombre del jugador.
	     * @param apellidos        Los apellidos del jugador.
	     * @param fechaNacimiento  La fecha de nacimiento del jugador.
	     * @param email            El correo electrónico del jugador.
	    
	     */
	    public JugadorDTO(String nombre, String apellidos, LocalDate fechaNacimiento, String email, String dni ) {
	        this.nombre = nombre;
	        this.apellidos = apellidos;
	        this.fechaNacimiento = fechaNacimiento;
	        this.fechaInscripcion = LocalDate.now();  // Fecha de inscripción es la fecha actual
	        this.email = email;
	        this.dni= dni;
	    }
	    
	    /**
	     * Constructor parametrizado que inicializa los atributos del jugador.
	     *
	     * @param nombre           El nombre del jugador.
	     * @param apellidos        Los apellidos del jugador.
	     * @param fechaNacimiento  La fecha de nacimiento del jugador.
	     * @param fechaInscripcion La fecha de inscripción del jugador.
	     * @param email            El correo electrónico del jugador.
	    
	     */
	    public JugadorDTO(String nombre, String apellidos, LocalDate fechaNacimiento, LocalDate fechaInscripcion, String email, String dni ) {
	        this.nombre = nombre;
	        this.apellidos = apellidos;
	        this.fechaNacimiento = fechaNacimiento;
	        this.fechaInscripcion = fechaInscripcion;
	        this.email = email;
	        this.dni= dni;
	    }

	    /**
	     * Obtiene el nombre del jugador.
	     *
	     * @return El nombre del jugador.
	     */
	    public String getNombre() {
	        return nombre;
	    }

	    /**
	     * Establece el nombre del jugador.
	     *
	     * @param nombre El nombre del jugador.
	     */
	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    /**
	     * Obtiene los apellidos del jugador.
	     *
	     * @return Los apellidos del jugador.
	     */
	    public String getApellidos() {
	        return apellidos;
	    }

	    /**
	     * Establece los apellidos del jugador.
	     *
	     * @param apellidos Los apellidos del jugador.
	     */
	    public void setApellidos(String apellidos) {
	        this.apellidos = apellidos;
	    }

	    /**
	     * Obtiene la fecha de nacimiento del jugador.
	     *
	     * @return La fecha de nacimiento del jugador.
	     */
	    public LocalDate getFechaNacimiento() {
	        return fechaNacimiento;
	    }

	    /**
	     * Establece la fecha de nacimiento del jugador.
	     *
	     * @param fechaNacimiento La fecha de nacimiento del jugador.
	     */
	    public void setFechaNacimiento(LocalDate fechaNacimiento) {
	        this.fechaNacimiento = fechaNacimiento;
	    }

	    /**
	     * Obtiene la fecha de inscripción del jugador.
	     *
	     * @return La fecha de inscripción del jugador.
	     */
	    public LocalDate getFechaInscripcion() {
	        return fechaInscripcion;
	    }

	    /**
	     * Establece la fecha de inscripción del jugador.
	     *
	     * @param fechaInscripcion La fecha de inscripción del jugador.
	     */
	    public void setFechaInscripcion(LocalDate fechaInscripcion) {
	        this.fechaInscripcion = fechaInscripcion;
	    }

	    /**
	     * Obtiene el correo electrónico del jugador.
	     *
	     * @return El correo electrónico del jugador.
	     */
	    public String getEmail() {
	        return email;
	    }

	    /**
	     * Establece el correo electrónico del jugador.
	     *
	     * @param email El correo electrónico del jugador.
	     */
	    public void setEmail(String email) {
	        this.email = email;
	    }
	    
	    /**
	     * Establece el dni del jugador.
	     *
	     * @param dni El dni  del jugador.
	     */

	    public String getDni() {
			return dni;
		}

		public void setDni(String dni) {
			this.dni = dni;
		}

		/**
	     * Devuelve una representación en formato String de los datos del jugador.
	     *
	     * @return Una cadena con el nombre, apellidos, fecha de nacimiento, 
	     *         fecha de inscripción y correo electrónico del jugador.
	     */
	    @Override
	    public String toString() {
	        return "Nombre: " + nombre +
	               "  Apellidos: " + apellidos +
	               "  Fecha de nacimiento: " + fechaNacimiento +
	               "  Fecha de inscripción: " + fechaInscripcion +
	               "  Correo electrónico: " + email +
	        	   "  DNI: " + dni;
	    }

	    /**
	     * Calcula la antigüedad del jugador desde la fecha de inscripción.
	     *
	     * @return La cantidad de años que el jugador ha estado registrado.
	     */
	    public int calcularAntiguedad() {
	        LocalDate fechaActual = LocalDate.now();
	        return Period.between(this.fechaInscripcion, fechaActual).getYears();
	    }

	    /**
	     * Imprime la antigüedad del jugador en la consola, indicando cuántos años
	     * ha estado registrado el jugador.
	     */
	    public void imprimirAntiguedad() {
	        int antiguedad = calcularAntiguedad();
	        System.out.println("El usuario " + this.nombre + " " + this.apellidos +
	                " lleva registrado " + antiguedad + " años.");
	    }
	
	
}