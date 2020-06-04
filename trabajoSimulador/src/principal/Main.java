/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

import database.Database;
import exceptions.AunNoConfiguradaException;
import personajes.*;

/**
 * El Main de este programa, donde se declaran las principales variables y se inicio el hilo de este programa
 *
 * @author Adrian Mata
 */
public class Main {

	protected static SerVivo[][] ser = new SerVivo[2][2];

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		Random alea = new Random();
		int rand;

		// Inicializa la matriz con animales aleatorios, valiendonos del polimorfismo
		for (int i = 0; i < ser.length; i++) {
			for (int j = 0; j < ser[i].length; j++) {
				rand = alea.nextInt(3);

				if (rand == 0) {
					ser[i][j] = new Vaca();
				} else if (rand == 1) {
					ser[i][j] = new Cerdo();
				} else {
					ser[i][j] = new Gallina();
				}
			}
		}

		//Se le pasa a la ventana la matriz de animales para que trabaje con ella es su archivo
		Ventana ventana = new Ventana(ser);
		ventana.setVisible(true);

		

	}


}
