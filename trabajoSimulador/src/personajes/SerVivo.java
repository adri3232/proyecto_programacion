/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personajes;

import java.util.Random;

import exceptions.AunNoConfiguradaException;

/**
 * Clase que definen la caracteristicas compartidas de cualquier tipo de ser
 * vivo
 *
 * @author adrian mata
 */
public abstract class SerVivo {

	private byte agua;// El nivel de hidratacion de la entidad de 0 a 100, siendo 100 totalmente
						// hidratado y 0 nada

	/**
	 * Constructor de la clase SerVivo con todas sus variables, inicializando el agua a 100 para toda clase que herede de el
	 *
	 */
	public SerVivo() {
		this.agua = 100;
	}

	/**
	 * getter de la clase SerVivo para la variable agua
	 *
	 * @return un byte con la cantidad de agua
	 */
	public byte getAgua() {
		return agua;
	}

	/**
	 * Setter de la clase SerVivo para la variable agua
	 *
	 * @param agua
	 */
	public void setAgua(byte agua) {

		this.agua = agua;
	}

	/**
	 * Funcion que aumenta en 10 el nivel de agua hasta un tope de 100 y lanza una excepcion si el usario intenta usarla estando la variable a 100
	 * 
	 * @throws AunNoConfiguradaException excepcion personalizada con un mensaje nuestro
	 */
	public void beber() throws AunNoConfiguradaException {

		if (this.agua + 10 > 100) {
			throw new AunNoConfiguradaException("No puedes dar de beber mas a este animal");
		} else {
			this.agua += 10;
		}

	}

	/**
	 * Funcion para reducir las variable agua de los seres vivos, simulando el paso
	 * del tiempo,sin llegar a pasar de 100
	 *
	 */
	public void tiempo() {

		if (this.agua - 10 < 0) {

		} else {
			this.agua += -10;
		}

	}

	/**
	 * Funcion para indicar que esta fuera del juego una entidad(EN DESUSO)
	 *
	 * @deprecated
	 * @return true si ha muerto o false si no
	 */
	public boolean muerto() {
		return agua <= 0;
	}

	/**
	 * Evento que aumenta el agua de los seres vivos,sin pasarse de 100 en agua
	 * 
	 */
	public void lluvia() {

		if (this.agua + 10 > 100) {

		} else {
			this.agua += 10;
		}

	}

	/**
	 * Funcion que controla los eventos que afectan a los seres vivos como la lluvia
	 * con pseudoaleatorios,cumpliendo que no aumente el agua cuando esta esta a cero
	 * 
	 */
	public void sucesos() {
		Random alea = new Random();
		int rand = alea.nextInt(2);

		if (rand == 0 && this.agua != 0) {
			lluvia();
		}
	}

	
	@Override
	public String toString() {
		return "agua: " + agua;
	}

}
