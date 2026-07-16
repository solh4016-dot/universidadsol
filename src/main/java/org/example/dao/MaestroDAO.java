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

    public boolean modificarMaestro(Maestro maestro) {
        boolean modificado = false;
        String sql = "UPDATE maestros SET nombre = ?, puesto = ?, cedulaProfesional = ?, edad = ? WHERE numEmpleado = ?";
        try (Connection conexion = Conexion.conectar();
             PreparedStatement stm = conexion.prepareStatement(sql)) {
            stm.setString(1, maestro.getNombre());
            stm.setString(2, maestro.getPuesto());
            stm.setString(3, maestro.getCedulaProfesional());
            stm.setInt(4, maestro.getEdad());
            stm.setInt(5, maestro.getNumEmpleado());
            int filasAfectadas = stm.executeUpdate();
            modificado = filasAfectadas > 0;
            if (modificado) {
                System.out.println("Maestro modificado correctamente");
            } else {
                System.out.println("No se encontro un maestro con ese numero de empleado");
            }
        } catch (SQLException err) {
            System.out.println("Error al modificar el maestro: " + err.getMessage());
        }
        return modificado;
    }
    public boolean eliminarMaestro(int numEmpleado) {
        boolean eliminado = false;
        String sql = "DELETE FROM maestros WHERE numEmpleado = ?";
        try (Connection conexion = Conexion.conectar();
             PreparedStatement stm = conexion.prepareStatement(sql)) {
            stm.setInt(1, numEmpleado);
            int filasAfectadas = stm.executeUpdate();
            eliminado = filasAfectadas > 0;
            if (eliminado) {
                System.out.println("Maestro eliminado correctamente");
            } else {
                System.out.println("No se encontro un maestro con ese numero de empleado");
            }
        } catch (SQLException err) {
            System.out.println("Error al eliminar el maestro: " + err.getMessage());
        }
        return eliminado;
    }
    public Maestro buscarMaestro(int numEmpleado) {
        Maestro maestro = null;
        String sql = "SELECT * FROM maestros WHERE numEmpleado = ?";
        try (Connection conexion = Conexion.conectar();
             PreparedStatement stm = conexion.prepareStatement(sql)) {
            stm.setInt(1, numEmpleado);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    maestro = new Maestro();
                    maestro.setNumEmpleado(rs.getInt("numEmpleado"));
                    maestro.setNombre(rs.getString("nombre"));
                    maestro.setPuesto(rs.getString("puesto"));
                    maestro.setCedulaProfesional(rs.getString("cedulaProfesional"));
                    maestro.setEdad(rs.getInt("edad"));
                }
            }
        } catch (SQLException err) {
            System.out.println("Error al buscar el maestro: " + err.getMessage());
        }
        return maestro;
    }
}