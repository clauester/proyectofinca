package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Miguel Davila
 */
// Clase que se encarga de la conexion con la base de datos
public class CN_Connection {

    //datos para la conexion a la base de datos
    private final String USUARIO = "root";
    private final String CONTRASENIA = "a123456";
    public static final String URL = "jdbc:mysql://localhost:3306/proyecto_const_soft";
    public static Connection conexion;

    //metodo que incia la conexion a la base de datos
    public Connection OpenConnection() {

        try {
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENIA);
            System.out.println("base de datos abierta");
            return conexion;

        } catch (SQLException ex) {
            System.err.println("ERROR, " + ex);
        }

        return conexion;

    }
    
    //metodo que cierra la conexion con la base de datos

    public void CloseConnection() {

        try {
            conexion.close();
            System.out.println("base de datos cerrada");
        } catch (SQLException ex) {
            System.err.println("ERROR, " + ex);
        }
    }

}
