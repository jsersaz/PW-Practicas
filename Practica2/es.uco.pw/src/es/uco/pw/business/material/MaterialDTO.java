package es.uco.pw.business.material;


/**
 * La clase Material representa un recurso material con un identificador, tipo, 
 * indicación de si es para uso exterior, y su estado actual.
 * 
 */


import es.uco.pw.business.pista.PistaDTO;
public class MaterialDTO {
	private int identificador;
	private Tipo tipo;
	private boolean uso_exterior;
	private Estado estado;
	private PistaDTO pistaAsociada;
	
	/**
	 * Constructor vacío que inicializa los atributos del material con valores predeterminados.
	 * El identificador es 0, el tipo es none, el uso exterior está habilitado (true),
	 * y el estado es none.
	 */
	public MaterialDTO() {
		this.identificador = 0;
		this.tipo = Tipo.none;
		this.uso_exterior = true;
		this.estado = Estado.none;
		this.pistaAsociada = null;
	}
	
	/**
	 * Constructor parametrizado que permite inicializar los atributos del material
	 * con valores proporcionados.
	 *
	 * @param identificador  El identificador único del material.
	 * @param tipo           El tipo del material (definido por la enumeración Tipo).
	 * @param uso_exterior   Indica si el material está diseñado para uso en exteriores.
	 * @param estado         El estado actual del material (definido por la enumeración Estado).
	 */
	public MaterialDTO(int identificador, Tipo tipo, boolean uso_exterior, Estado estado, PistaDTO pistaDTO) {
		this.identificador = identificador;
		this.tipo = tipo;
		this.uso_exterior = uso_exterior;
		this.estado = estado;
		this.pistaAsociada = pistaDTO;
	}
	
	/**
	 * Obtiene el identificador del material.
	 *
	 * @return El identificador del material.
	 */
	public int getIdentificador() {
		return identificador;
	}
	
	/**
	 * Obtiene el tipo del material.
	 *
	 * @return El tipo del material (enumeración Tipo).
	 */
	public Tipo getTipo() {
		return tipo;
	}
	
	/**
	 * Indica si el material es apto para uso en exteriores.
	 *
	 * @return true si el material es para uso exterior, false en caso contrario.
	 */
	public boolean isUso() {
		return uso_exterior;
	}
	
	/**
	 * Obtiene el estado actual del material.
	 *
	 * @return El estado del material (enumeración Estado).
	 */
	public Estado getEstado() {
		return estado;
	}
	
	/**
	 * Obtiene la pista actualmente asociada a este material, si existe.
	 *
	 * @return La pista asociada o null si no hay una asociación.
	 */
	public PistaDTO getPistaAsociada() {
        return pistaAsociada;
    }
	
	/**
	 * Establece el identificador del material.
	 *
	 * @param identificador El nuevo identificador del material.
	 */
	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
	
	/**
	 * Establece el tipo del material.
	 *
	 * @param tipo El nuevo tipo del material.
	 */
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
	/**
	 * Establece si el material es para uso en exteriores.
	 *
	 * @param uso_exterior true si es para uso exterior, false en caso contrario.
	 */
	public void setUso(boolean uso_exterior) {
		this.uso_exterior = uso_exterior;
	}
	
	/**
	 * Establece el estado actual del material.
	 *
	 * @param estado El nuevo estado del material.
	 */
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	/**
	 * Asocia este material a una pista específica.
	 *
	 * @param pistaDTO La pista con la cual se desea asociar el material.
	 */
	public void setPistaAsociada(PistaDTO pistaDTO)
	{
        this.pistaAsociada = pistaDTO;
    }
	
	/**
	 * Verifica si el material está asociado a alguna pista.
	 *
	 * @return true si el material está asociado a una pista, false en caso contrario.
	 */
	public boolean isAsociado()
	{
        return (pistaAsociada != null);
    }
}
