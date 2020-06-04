package personajes;

/**
 * Clase que define las caracteristicas de una gallina
 * 
 * 
 * @author Adrian Mata
 *
 */
public class Gallina extends Animal{


	 /**
     * Constructor de la clase Gallina con todas sus variables
     *
     * @param comida Se inicializa a 25 la variable
     * @param agua Se inicializa a 100 la variable
     */
    public Gallina() {
        super((byte) 25);
    }

   /**
    * Se ajusta la velocidad a la que baja la comida en la gallina
    * 
    */
    public void tiempo() {
        
        super.tiempo((byte) -5);
    }
}
