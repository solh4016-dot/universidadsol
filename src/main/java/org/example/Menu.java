package org.example;

import org.example.dao.AlumnoDAO;
import org.example.dao.MaestroDAO;
import org.example.modelo.Alumno;
import org.example.modelo.Maestro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Menu {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static AlumnoDAO alumnoDAO = new AlumnoDAO();
    static Alumno alumno = new Alumno();
    static MaestroDAO maestroDAO = new MaestroDAO();

    // ---- Modulo: Alumnos ----

    private static void registrar() {
        try {
            System.out.println("Numero de expediente: ");
            alumno.setNumExpediente(Integer.parseInt(br.readLine()));
            System.out.println("Nombre del alumno: ");
            alumno.setNombre(br.readLine());
            System.out.println("Edad del alumno: ");
            alumno.setEdad(Integer.parseInt(br.readLine()));
            System.out.println("Carrera del alumno (TI, Qui, Mec, Mkt): ");
            alumno.setCarrera(br.readLine());
            System.out.println("Cuatrimestre del alumno: ");
            alumno.setCuatrimestres(Integer.parseInt(br.readLine()));

            alumnoDAO.nuevoAlumno(alumno);
        } catch (Exception e) {
            System.out.println("Error al ingresar: " + e.getMessage());
        }
    }

    private static void listar() {
        ArrayList<Alumno> alumnos = alumnoDAO.extraerAlumnos();
        System.out.println("Lista de alumnos inscritos:");
        for (Alumno a : alumnos) {
            System.out.println(a);
        }
    }

    private static void modificar() {
        try {
            System.out.println("Numero de expediente del alumno a modificar: ");
            int numExpediente = Integer.parseInt(br.readLine());

            Alumno alumnoModificado = new Alumno();
            alumnoModificado.setNumExpediente(numExpediente);

            System.out.println("Nuevo nombre del alumno: ");
            alumnoModificado.setNombre(br.readLine());
            System.out.println("Nueva edad del alumno: ");
            alumnoModificado.setEdad(Integer.parseInt(br.readLine()));
            System.out.println("Nueva carrera del alumno (TI, Qui, Mec, Mkt): ");
            alumnoModificado.setCarrera(br.readLine());
            System.out.println("Nuevo cuatrimestre del alumno: ");
            alumnoModificado.setCuatrimestres(Integer.parseInt(br.readLine()));

            alumnoDAO.modificarAlumno(alumnoModificado);
        } catch (Exception e) {
            System.out.println("Error al modificar: " + e.getMessage());
        }
    }

    private static void eliminar() {
        try {
            System.out.println("Numero de expediente del alumno a eliminar: ");
            int numExpediente = Integer.parseInt(br.readLine());
            alumnoDAO.eliminarAlumno(numExpediente);
        } catch (Exception e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }
    }

    private static void buscar() {
        try {
            System.out.println("Numero de expediente del alumno a buscar: ");
            int numExpediente = Integer.parseInt(br.readLine());
            Alumno encontrado = alumnoDAO.buscarAlumno(numExpediente);
            if (encontrado != null) {
                System.out.println("Alumno encontrado:");
                System.out.println(encontrado);
            } else {
                System.out.println("No se encontro un alumno con ese numero de expediente");
            }
        } catch (Exception e) {
            System.out.println("Error al buscar: " + e.getMessage());
        }
    }

    private static void registrarMaestro() {
        try {
            Maestro maestro = new Maestro();

            System.out.println("Numero de empleado: ");
            maestro.setNumEmpleado(Integer.parseInt(br.readLine()));
            System.out.println("Nombre del maestro: ");
            maestro.setNombre(br.readLine());
            System.out.println("Puesto: ");
            maestro.setPuesto(br.readLine());
            System.out.println("Cedula profesional: ");
            maestro.setCedulaProfesional(br.readLine());
            System.out.println("Edad del maestro: ");
            maestro.setEdad(Integer.parseInt(br.readLine()));

            maestroDAO.nuevoMaestro(maestro);
        } catch (IllegalArgumentException e) {
            System.out.println("Datos invalidos: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al ingresar: " + e.getMessage());
        }
    }

    private static void listarMaestros() {
        ArrayList<Maestro> maestros = maestroDAO.extraerMaestros();
        System.out.println("Lista de maestros registrados:");
        for (Maestro m : maestros) {
            System.out.println(m);
        }
    }

    private static void modificarMaestro() {
        try {
            System.out.println("Numero de empleado del maestro a modificar: ");
            int numEmpleado = Integer.parseInt(br.readLine());

            Maestro maestroModificado = new Maestro();
            maestroModificado.setNumEmpleado(numEmpleado);

            System.out.println("Nuevo nombre del maestro: ");
            maestroModificado.setNombre(br.readLine());
            System.out.println("Nuevo puesto: ");
            maestroModificado.setPuesto(br.readLine());
            System.out.println("Nueva cedula profesional: ");
            maestroModificado.setCedulaProfesional(br.readLine());
            System.out.println("Nueva edad del maestro: ");
            maestroModificado.setEdad(Integer.parseInt(br.readLine()));

            maestroDAO.modificarMaestro(maestroModificado);
        } catch (IllegalArgumentException e) {
            System.out.println("Datos invalidos: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al modificar: " + e.getMessage());
        }
    }

    // ---- Menu principal ----

    public static void menu() {
        try {
            int salir = 0;
            while (salir != 9) {
                System.out.println("Menu");
                System.out.println("1. Registrar Alumno");
                System.out.println("2. Listar Alumnos");
                System.out.println("3. Modificar Alumno");
                System.out.println("4. Eliminar Alumno");
                System.out.println("5. Buscar Alumno");
                System.out.println("6. Registrar Maestro");
                System.out.println("7. Listar Maestros");
                System.out.println("8. Modificar Maestro");
                System.out.println("9. Salir\n");

                salir = Integer.parseInt(br.readLine());

                switch (salir) {
                    case 1:
                        registrar();
                        break;
                    case 2:
                        listar();
                        break;
                    case 3:
                        modificar();
                        break;
                    case 4:
                        eliminar();
                        break;
                    case 5:
                        buscar();
                        break;
                    case 6:
                        registrarMaestro();
                        break;
                    case 7:
                        listarMaestros();
                        break;
                    case 8:
                        modificarMaestro();
                        break;
                    case 9:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opcion invalida");
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar: " + e.getMessage());
        }
    }
}
