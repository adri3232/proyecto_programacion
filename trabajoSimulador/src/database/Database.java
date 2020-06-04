/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import exceptions.AunNoConfiguradaException;

/**
 *Clase cuyo objetivo es facilitar la forma en que este programa se comunica con una BBDD ya creada,y con las de otros usarios con distintos credenciales
 *
 * @author Adrian Mata
 */
public abstract class Database {

    private static String host;//La direccion del host 
    private static String port;//El puerto de la BBDD
    private static String database;//El nombre de la base de datos
    private static String user;//El nombre del usuario
    private static String password;//La contraseña
    private static boolean alreadyInitialized;//Para inicializar las variables internas una unica vez

    /**
     * Funcion usada para leer el fichero config.ini y de no existir usar una configuracion predeterminada
     * 
     */
    public static void initialize() {
        if (!alreadyInitialized) {//Para evitar que se vuelve a ejecutar la lectura del archivo, (Evitar problemas si se cambio el archivo de config mientras se ejecuta  el programa)
            File configFile = new File("./config.ini");

            if (configFile.exists()) {
                //Una de las Excepcion que podria saltar si no hubiera permisos adecuados sobre el archivo de configuracion
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(configFile));
                    String line = reader.readLine();
                    while (line != null) {
                        String[] keyValue = line.split("=");
                        switch (keyValue[0]) {
                            case "host":
                                host = keyValue[1];
                                break;

                            case "port":
                                port = keyValue[1];
                                break;

                            case "database":
                                database = keyValue[1];
                                break;

                            case "user":
                                user = keyValue[1];
                                break;

                            case "password":
                                password = keyValue[1];
                                break;
                        }
                        line = reader.readLine();
                    }
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } else {
            	//Valores usuales de una BBDD
                host = "127.0.0.1";
                port = "3306";
                database = "bd_simulador";
                user = "root";
                password = "admin";
            }
        }
        alreadyInitialized = true;
    }

    /**
     * Funcion que realiza una consulta select REQUISITO: tiene que ser una
     * consulta select
     *
     * Se lanza una excpcion si la consulta que devuelve no pudo
     * funcionar(ej:columnas que no existen en la tabla...)
     *
     * @param query la consulta realizada
     * @return
     */
    public static ArrayList<String> executeSelect(String query) throws SQLException, AunNoConfiguradaException {
        if (!alreadyInitialized) {
            throw new AunNoConfiguradaException("Llame a initialize() antes de realizar una consulta");
        }
        Connection conn = null;
        Statement smt = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", user, password);
            smt = conn.createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();//ERROR de no se ha podido conectar a la base de datos, sugerir con error personalizado que se cambie el fichero de config
            conn.close();
            return null;
        }

        ResultSet rs = smt.executeQuery(query);
        ArrayList ret = new ArrayList<String>();
        while (rs.next()) {
            ret.add((rs.getString("puntos") + " " + rs.getString("nombre")));

        }
        conn.close();

        return ret;
    }

    /**
     * Funcion para insertar una fila en una tabla ya dada y con unas columnas definidas
     * 
     * @param puntuacion
     * @param nombre
     * @throws SQLException
     * @throws AunNoConfiguradaException
     */
    public static void executeInsert(String puntuacion,String nombre) throws SQLException, AunNoConfiguradaException {
        if (!alreadyInitialized) {
            throw new AunNoConfiguradaException("Llame a initialize() antes de realizar un Insert");
        }
        Connection conn = null;
        Statement smt = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", user, password);
            smt = conn.createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();//ERROR de no se ha podido conectar a la base de datos, sugerir con error personalizado que se cambie el fichero de config
            conn.close();

        }

        smt.executeUpdate("insert into puntuacion values ("+"'" + puntuacion + "','" + nombre + "')");
        
        conn.close();

    }

    /**
     * Funcion para mostrar datos relativos a la conexion
     * 
     * @return
     */
    public static String getConnectionData() {
        return "cadena de conexion: " + "jbdc:mysql://" + host + ":" + port + "/" + database + "\nuser: " + user + "\npassword: " + password;
    }
}
