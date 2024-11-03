package es.uco.pw.clases.pista;

/**
 * Enumeración tamanopista.
 * Representa los diferentes tamaños de una pista, utilizados en distintos tipos de actividades deportivas.
 */
public enum tamanopista {
    
    /**
     * Tamaño de pista para minibasket, un formato reducido generalmente utilizado para niños.
     */
    minibasket,
    
    /**
     * Tamaño de pista para adultos, el estándar para competiciones deportivas completas.
     */
    adultos,
    
    /**
     * Tamaño de pista para tres contra tres, un formato de juego reducido con menor espacio.
     */
    tres_vs_tres,
    
    /**
     * Valor por defecto cuando no se ha asignado ningún tamaño de pista.
     */
    none
}
