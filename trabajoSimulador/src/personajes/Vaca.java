/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personajes;

/**
 *Clase que define las caracteristicas de una vaca
 *
 * @author Adrian Mata
 */
public class Vaca extends Animal{


	    /**
	     * Constructor de la clase Vaca con todas sus variables
	     *
	     * @param comida Se inicializa a 100 la variable
	     * @param agua Se inicializa a 100 la variable
	     */
	    public Vaca() {
	        super((byte) 100);
	    }

	   /**
	    * Se permite ajustar la velocidad a la que baja la comida en la Vaca
	    * 
	    */
	    public void tiempo() {
	    	
	        super.tiempo((byte) -10);
	    }

	   
    
}
