package org.example.dao;

import org.example.config.Conexion;
import org.example.modelo.Alumno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AlumnoDAO {

    public boolean nuevoAlumno(Alumno alumno) {
        boolean registrado = false;
        String sql = "INSERT INTO alumnos (numExpediente, nombre, edad, carrera, cuatrimestre) VALUES (?,?,?,?,?)";
        try (Connection conexion = Conexion.conectar();
             PreparedStatement stm = conexion.prepareStatement(sql)) {
            stm.setInt(1, alumno.getNumExpediente());
            stm.setString(2, alumno.getNombre());
            stm.setInt(3, alumno.getEdad());
            stm.setString(4, alumno.getCarrera());
            stm.setInt(5, alumno.getCuatrimestres());
            int filasAfectadas = stm.executeUpdate();
            registrado = filasAfectadas > 0;
            if (registrado) {
                System.out.println("Alumno agregado correctamente");
            }
        } catch (SQLException err) {
            System.out.println("ERROR AL AGREGAR ALUMNO: " + err.getMessage());
        }
        return registrado;
    }
    public Alumno buscarAlumno(int numExpediente) {
        Alumno alumno = null;
        String sql = "SELECT * FROM alumnos WHERE numExpediente = ?";
        try (Connection conexion = Conexion.conectar();
             PreparedStatement stm = conexion.prepareStatement(sql)) {
            stm.setInt(1, numExpediente);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    alumno = new Alumno();
                    alumno.setNumExpediente(rs.getInt("numExpediente"));
                    alumno.setNombre(rs.getString("nombre"));
                    alumno.setCarrera(rs.getString("carrera"));
                    alumno.setCuatrimestres(rs.getInt("cuatrimestre"));
                    alumno.setEdad(rs.getInt("edad"));
                }
            }
        } catch (SQLException err) {
            System.out.println("Error al buscar el alumno: " + err.getMessage());
        }
        return alumno;
    }

    public ArrayList<Alumno> extraerAlumnos() {
        ArrayList<Alumno> alumnosBD = new ArrayList<>();
        String sql = "SELECT * FROM alumnos";
        try (Connection conexion = Conexion.conectar();
             PreparedStatement stm = conexion.prepareStatement(sql);
             ResultSet rs = stm.executeQuery()) {
            while (rs.next()) {
                Alumno alumno = new Alumno();
                alumno.setNumExpediente(rs.getInt("numExpediente"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setCarrera(rs.getString("carrera"));
                alumno.setCuatrimestres(rs.getInt("cuatrimestre"));
                alumno.setEdad(rs.getInt("edad"));
                alumnosBD.add(alumno);
            }
        } catch (SQLException err) {
            System.out.println("Error al extraer los datos: " + err.getMessage());
        }
        return alumnosBD;
    }

    public boolean eliminarAlumno(int numExpediente) {
        boolean eliminado = false;
        String sql = "DELETE FROM alumnos WHERE numExpediente = ?";
        try (Connection conexion = Conexion.conectar();
             PreparedStatement stm = conexion.prepareStatement(sql)) {
            stm.setInt(1, numExpediente);
            int filasAfectadas = stm.executeUpdate();
            eliminado = filasAfectadas > 0;
            if (eliminado) {
                System.out.println("Alumno eliminado correctamente");
            } else {
                System.out.println("No se encontro un alumno con ese numero de expediente");
            }
        } catch (SQLException err) {
            System.out.println("Error al eliminar el alumno: " + err.getMessage());
        }
        return eliminado;
    }

    public boolean modificarAlumno(Alumno alumno) {
        boolean modificado = false;
        String sql = "UPDATE alumnos SET nombre = ?, edad = ?, carrera = ?, cuatrimestre = ? WHERE numExpediente = ?";
        try (Connection conexion = Conexion.conectar();
             PreparedStatement stm = conexion.prepareStatement(sql)) {
            stm.setString(1, alumno.getNombre());
            stm.setInt(2, alumno.getEdad());
            stm.setString(3, alumno.getCarrera());
            stm.setInt(4, alumno.getCuatrimestres());
            stm.setInt(5, alumno.getNumExpediente());
            int filasAfectadas = stm.executeUpdate();
            modificado = filasAfectadas > 0;
            if (modificado) {
                System.out.println("Alumno modificado correctamente");
            } else {
                System.out.println("No se encontro un alumno con ese numero de expediente");
            }
        } catch (SQLException err) {
            System.out.println("Error al modificar el alumno: " + err.getMessage());
        }
        return modificado;
    }
}
