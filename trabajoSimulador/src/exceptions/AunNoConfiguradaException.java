/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *Clase usada para crear excepciones con mensaje personalizados
 *
 * @author Adrian Mata
 */
public class AunNoConfiguradaException extends Exception{
    
	/**
	 * Constructor de la clase Exception para instanciar dicho objeto con un mensaje a nuestro gusto
	 * 
	 * @param msg El String que queramos poner
	 */
    public AunNoConfiguradaException(String msg){
        super(msg);
    }
}