package org.example.dao;

import org.example.config.Conexion;
import org.example.modelo.Maestro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MaestroDAO {

    public boolean nuevoMaestro(Maestro maestro) {
        boolean registrado = false;
        String sql = "INSERT INTO maestros (numEmpleado, nombre, puesto, cedulaProfesional, edad) VALUES (?,?,?,?,?)";
        try (Connection conexion = Conexion.conectar();
             PreparedStatement stm = conexion.prepareStatement(sql)) {
            stm.setInt(1, maestro.getNumEmpleado());
            stm.setString(2, maestro.getNombre());
            stm.setString(3, maestro.getPuesto());
            stm.setString(4, maestro.getCedulaProfesional());
            stm.setInt(5, maestro.getEdad());
            int filasAfectadas = stm.executeUpdate();
            registrado = filasAfectadas > 0;
            if (registrado) {
                System.out.println("Maestro agregado correctamente");
            }
        } catch (SQLException err) {
            System.out.println("ERROR AL AGREGAR MAESTRO: " + err.getMessage());
        }
        return registrado;
    }

    public ArrayList<Maestro> extraerMaestros() {
        ArrayList<Maestro> maestrosBD = new ArrayList<>();
        String sql = "SELECT * FROM maestros";
        try (Connection conexion = Conexion.conectar();
             PreparedStatement stm = conexion.prepareStatement(sql);
             ResultSet rs = stm.executeQuery()) {
            while (rs.next()) {
                Maestro maestro = new Maestro();
                maestro.setNumEmpleado(rs.getInt("numEmpleado"));
                maestro.setNombre(rs.getString("nombre"));
                maestro.setPuesto(rs.getString("puesto"));
                maestro.setCedulaProfesional(rs.getString("cedulaProfesional"));
                maestro.setEdad(rs.getInt("edad"));
                maestrosBD.add(maestro);
            }
        } catch (SQLException err) {
            System.out.println("Error al extraer los datos: " + err.getMessage());
        }
        return maestrosBD;
    }
}