package es.uco.pw.clases.material;

/**
 * Enumeración Estado.
 * Representa los posibles estados de un objeto dentro del sistema.
 * Puede ser utilizado, por ejemplo, para representar el estado de una reserva, un recurso, o una instalación.
 */
public enum Estado {
    
    /**
     * Indica que el objeto está disponible.
     */
    disponible,
    
    /**
     * Indica que el objeto está reservado.
     */
    reservado,
    
    /**
     * Indica que el objeto está en mal estado.
     */
    mal_estado,
    
    /**
     * Indica que el objeto no tiene un estado definido.
     */
    none
}
