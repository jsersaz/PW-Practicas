package Ejercicio1;

import java.time.LocalDate;
import java.time.Period;

public class Jugador {
    private String nombre;
    private String apellidos;
    private LocalDate fechaNacimiento;
    private LocalDate fechaInscripcion;
    private String email;

    // Constructor vacío
    public Jugador() {
    	this.fechaInscripcion = LocalDate.now();
    }

    // Constructor parametrizado
    public Jugador(String nombre, String apellidos, LocalDate fechaNacimiento, String email) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaInscripcion = LocalDate.now();  // Fecha de inscripción es la fecha actual
        this.email = email;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Método toString
    @Override
    public String toString() {
        return "Nombre: " + nombre +
               "  Apellidos: " + apellidos +
               "  Fecha de nacimiento: " + fechaNacimiento +
               "  Fecha de inscripción: " + fechaInscripcion +
               "  Correo electrónico: " + email;
    }

    // Método para calcular antigüedad
    public int calcularAntiguedad() {
        LocalDate fechaActual = LocalDate.now();
        return Period.between(this.fechaInscripcion, fechaActual).getYears();
    }

    // Imprimir antigüedad
    public void imprimirAntiguedad() {
        int antiguedad = calcularAntiguedad();
        System.out.println("El usuario " + this.nombre + " " + this.apellidos +
                " lleva registrado " + antiguedad + " años.");
    }
}
