/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entornoJuego;

import java.util.Random;

import personajes.*;

/**
 * Clase que llama a los eventos que afectan a los seres vivos
 *
 * @author Adrian Mata
 */
public abstract class Eventos {

	/**
	 * Funcion que aplica a los seres vivos eventos aleatorios, la lluvia, asi como la reduccion en los valores de las variables con el paso del tiempo
	 * 
	 * @param ser
	 */
    public static void tiempo(SerVivo[][] ser) {
    	
    	for (int i = 0; i < ser.length; i++) {
			for (int j = 0; j < ser[i].length; j++) {

				ser[i][j].tiempo();
				ser[i][j].sucesos();
			}
		}
    }
}
