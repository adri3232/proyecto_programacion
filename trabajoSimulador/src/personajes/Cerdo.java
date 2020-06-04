package personajes;

/**
 * Clase que define las caracteristicas exclusivas de un animal del tipo Cerdo
 * 
 * @author Adrian Mata
 *
 */
public class Cerdo extends Animal {

	/**
	 * Constructor de la clase Cerdo con todas sus variables
	 *
	 * @param comida Se inicializa a 50 la variable
	 * @param agua   Se inicializa a 100 la variable
	 */
	public Cerdo() {
		super((byte) 50);
	}

	/**
	 * Se permite ajustar la velocidad a la que baja la comida en el Cerdo
	 * 
	 */
	public void tiempo() {

		super.tiempo((byte) -10);
	}

}
