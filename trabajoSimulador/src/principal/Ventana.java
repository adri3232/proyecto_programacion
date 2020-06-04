package principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.Database;
import entornoJuego.Eventos;
import exceptions.AunNoConfiguradaException;
import personajes.Animal;
import personajes.SerVivo;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JMenuBar;
import java.awt.GridLayout;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;

public class Ventana extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JPanel panelSuperior;
	private JPanel panelInferior;
	private JTextField textInferiorIzquierda;
	private JTextField textSuperiorIzquierdo;
	private JTextField textSuperiorDerecha;
	private JTextField textInferiorDerecha;
	private JTextField textConsola;
	private JMenu mnComer;
	private JMenu mnBeber;
	private JMenuItem mntmComerSuperiorIzquierda;
	private JMenuItem mntmComerSuperiorDerecha;
	private JMenuItem mntmComerInferiorDerecha;
	private JMenuItem mntmComerInferiorIzquierda;
	private JMenuItem mntmBeberSuperiorIzquierda;
	private JMenu mnPuntuacion;
	private JMenuItem mntmBeberSuperiorDerecha;
	private JMenuItem mntmBeberInferiorIzquierda;
	private JMenuItem mntmBeberInferiorDerecha;
	private JMenuItem mntmVerPuntuacion;
	private byte turnos=0;//Variable que cuenta los turnos

	/**
	 * Create the frame.
	 */
	public Ventana(SerVivo[][] ser) {
		setTitle("SimuladorGranja");// Para que el programa inicie mostrando animales
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnComer = new JMenu("Dar de comer");
		menuBar.add(mnComer);

		mntmComerSuperiorIzquierda = new JMenuItem("Superior Izquierda");

		mnComer.add(mntmComerSuperiorIzquierda);

		mntmComerSuperiorDerecha = new JMenuItem("Superior Derecha");

		mnComer.add(mntmComerSuperiorDerecha);

		mntmComerInferiorIzquierda = new JMenuItem("Inferior Izquierda");

		mnComer.add(mntmComerInferiorIzquierda);

		mntmComerInferiorDerecha = new JMenuItem("Inferior Derecha");

		mnComer.add(mntmComerInferiorDerecha);

		mnBeber = new JMenu("Dar de beber");
		menuBar.add(mnBeber);

		mntmBeberSuperiorIzquierda = new JMenuItem("Superior Izquierda");

		mnBeber.add(mntmBeberSuperiorIzquierda);

		mntmBeberSuperiorDerecha = new JMenuItem("Superior Derecha");

		mnBeber.add(mntmBeberSuperiorDerecha);

		mntmBeberInferiorIzquierda = new JMenuItem("Inferior Izquierda");

		mnBeber.add(mntmBeberInferiorIzquierda);

		mntmBeberInferiorDerecha = new JMenuItem("Inferior Derecha");

		mnBeber.add(mntmBeberInferiorDerecha);

		mnPuntuacion = new JMenu("Puntuacion");
		menuBar.add(mnPuntuacion);

		mntmVerPuntuacion = new JMenuItem("Puntuar");

		mnPuntuacion.add(mntmVerPuntuacion);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 1, 0, 0));

		panelSuperior = new JPanel();
		contentPane.add(panelSuperior);
		panelSuperior.setLayout(new GridLayout(2, 2, 0, 0));

		textSuperiorIzquierdo = new JTextField();
		textSuperiorIzquierdo.setText(ser[0][0].getClass().getName().substring(11) + ":  " + ser[0][0] + "");
		textSuperiorIzquierdo.setBackground(Color.WHITE);
		textSuperiorIzquierdo.setEditable(false);
		panelSuperior.add(textSuperiorIzquierdo);
		textSuperiorIzquierdo.setColumns(10);

		textSuperiorDerecha = new JTextField();
		textSuperiorDerecha.setText(ser[0][1].getClass().getName().substring(11) + ":  " + ser[0][1] + "");
		textSuperiorDerecha.setBackground(Color.WHITE);
		textSuperiorDerecha.setEditable(false);
		panelSuperior.add(textSuperiorDerecha);
		textSuperiorDerecha.setColumns(10);

		textInferiorIzquierda = new JTextField();
		textInferiorIzquierda.setText(ser[1][0].getClass().getName().substring(11) + ":  " + ser[1][0] + "");
		textInferiorIzquierda.setBackground(Color.WHITE);
		textInferiorIzquierda.setEditable(false);
		panelSuperior.add(textInferiorIzquierda);
		textInferiorIzquierda.setColumns(10);

		textInferiorDerecha = new JTextField();
		textInferiorDerecha.setText(ser[1][1].getClass().getName().substring(11) + ":  " + ser[1][1] + "");
		textInferiorDerecha.setBackground(Color.WHITE);
		textInferiorDerecha.setEditable(false);
		panelSuperior.add(textInferiorDerecha);
		textInferiorDerecha.setColumns(10);

		panelInferior = new JPanel();
		contentPane.add(panelInferior);
		panelInferior.setLayout(new BorderLayout(0, 0));

		textConsola = new JTextField();
		textConsola.setHorizontalAlignment(SwingConstants.CENTER);
		textConsola.setText("Escriba aqui su nombre");
		textConsola.setBackground(Color.WHITE);
		panelInferior.add(textConsola);
		textConsola.setColumns(10);

		mntmComerSuperiorIzquierda.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				try {
					siguienteTurno(ser, "comer", "SuperiorIzquierda");
				} catch (AunNoConfiguradaException e1) {
					// TODO Auto-generated catch block
					textConsola.setText(e1.toString());
				}
				turnos++;
			}
		});

		mntmComerSuperiorDerecha.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				try {
					siguienteTurno(ser, "comer", "SuperiorDerecha");
				} catch (AunNoConfiguradaException e1) {
					// TODO Auto-generated catch block
					textConsola.setText(e1.toString());
				}
				turnos++;
			}
		});

		mntmComerInferiorIzquierda.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				try {
					siguienteTurno(ser, "comer", "InferiorIzquierda");
				} catch (AunNoConfiguradaException e1) {
					// TODO Auto-generated catch block
					textConsola.setText(e1.toString());
				}
				turnos++;
			}
		});

		mntmComerInferiorDerecha.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				try {
					siguienteTurno(ser, "comer", "InferiorDerecha");
				} catch (AunNoConfiguradaException e1) {
					// TODO Auto-generated catch block
					textConsola.setText(e1.toString());
				}
				turnos++;
			}
		});

		mntmBeberSuperiorIzquierda.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				try {
					siguienteTurno(ser, "beber", "SuperiorIzquierda");
				} catch (AunNoConfiguradaException e1) {
					// TODO Auto-generated catch block
					textConsola.setText(e1.toString());
				}
				turnos++;
			}
		});

		mntmBeberSuperiorDerecha.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				try {
					siguienteTurno(ser, "beber", "SuperiorDerecha");
				} catch (AunNoConfiguradaException e1) {
					// TODO Auto-generated catch block
					textConsola.setText(e1.toString());
				}
				turnos++;
			}
		});

		mntmBeberInferiorIzquierda.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				try {
					siguienteTurno(ser, "beber", "InferiorIzquierda");
				} catch (AunNoConfiguradaException e1) {
					// TODO Auto-generated catch block
					textConsola.setText(e1.toString());
				}
				turnos++;
			}
		});

		mntmBeberInferiorDerecha.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				try {
					siguienteTurno(ser, "beber", "InferiorDerecha");
				} catch (AunNoConfiguradaException e1) {
					// TODO Auto-generated catch block
					textConsola.setText(e1.toString());
				}
				turnos++;
			}
		});

		mntmVerPuntuacion.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				puntuacion(ser,turnos);
			}
		});
	}

	/**
	 * FUncion diseñada para simular los turnos de un juego aplicando otras funciones como la reduccion de estadisticas
	 * 
	 * @param ser
	 * @param accion
	 * @param lugar
	 * @throws AunNoConfiguradaException
	 */
	public void siguienteTurno(SerVivo[][] ser, String accion, String lugar) throws AunNoConfiguradaException {

		if (accion.equalsIgnoreCase("comer")) {
			switch (lugar) {

			case "SuperiorIzquierda":
				((Animal) ser[0][0]).comer();
				break;

			case "SuperiorDerecha":
				((Animal) ser[0][1]).comer();
				break;

			case "InferiorIzquierda":
				((Animal) ser[1][0]).comer();
				break;

			case "InferiorDerecha":
				((Animal) ser[1][1]).comer();
				break;
			}
		} else {
			switch (lugar) {

			case "SuperiorIzquierda":
				ser[0][0].beber();
				break;

			case "SuperiorDerecha":
				ser[0][1].beber();
				break;

			case "InferiorIzquierda":
				ser[1][0].beber();
				break;

			case "InferiorDerecha":
				ser[1][1].beber();
				break;
			}
		}

		Eventos.tiempo(ser);

		textSuperiorIzquierdo.setText(ser[0][0].getClass().getName().substring(11) + ":  " + ser[0][0] + "");
		textSuperiorDerecha.setText(ser[0][1].getClass().getName().substring(11) + ":  " + ser[0][1] + "");
		textInferiorIzquierda.setText(ser[1][0].getClass().getName().substring(11) + ":  " + ser[1][0] + "");
		textInferiorDerecha.setText(ser[1][1].getClass().getName().substring(11) + ":  " + ser[1][1] + "");
	}

	/**
	 * Funcion que introduce los turnos que aguanto el jugador y su nombre el la base de datos, luego los muestra
	 * 
	 * @param ser
	 * @param turnos
	 */
	public void puntuacion(SerVivo[][] ser,byte turnos) {

		for (int i = 0; i < ser.length; i++) {
			for (int j = 0; j < ser[i].length; j++) {
				
				if(ser[i][j].getAgua()==0 || ((Animal) ser[i][j]).getComida()==0) {
					
					Database.initialize();
					try {
						Database.executeInsert(turnos+"", textConsola.getText());
						textConsola.setText(Database.executeSelect("select * from puntuacion") + "");
					} catch (SQLException ex) {
						ex.printStackTrace();
					} catch (AunNoConfiguradaException ex) {
						ex.printStackTrace();
					}
					break;
				}
			}
		}

		

	}
}
