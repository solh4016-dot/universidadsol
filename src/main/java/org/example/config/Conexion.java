package org.example.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String url = "jdbc:mysql://localhost:3306/universidad";
    private static final String usuario = "root";
    private static final String password = "root";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("No se encontro el driver de MySQL: " + e.getMessage());
        }
    }

    public static Connection conectar() {
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(url, usuario, password);
            System.out.println("Conexion correcta a MYSQL");
        } catch (SQLException err) {
            System.out.println("Error al conectarse a MYSQL: " + err.getMessage());
        }
        return conexion;
    }
}