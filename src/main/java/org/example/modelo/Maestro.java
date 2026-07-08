package org.example.modelo;

import java.util.Objects;

public class Maestro {
    private int numEmpleado;
    private String nombre;
    private String puesto;
    private String cedulaProfesional;
    private int edad;

    public Maestro() {
    }

    public Maestro(int numEmpleado, String nombre, String puesto, String cedulaProfesional, int edad) {
        setNumEmpleado(numEmpleado);
        setNombre(nombre);
        setPuesto(puesto);
        setCedulaProfesional(cedulaProfesional);
        setEdad(edad);
    }

    public int getNumEmpleado() {
        return numEmpleado;
    }

    public void setNumEmpleado(int numEmpleado) {
        if (numEmpleado <= 0) {
            throw new IllegalArgumentException("El numero de empleado debe ser mayor a 0");
        }
        this.numEmpleado = numEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacio");
        }
        this.nombre = nombre.trim();
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        if (puesto == null || puesto.trim().isEmpty()) {
            throw new IllegalArgumentException("El puesto no puede estar vacio");
        }
        this.puesto = puesto.trim();
    }

    public String getCedulaProfesional() {
        return cedulaProfesional;
    }

    public void setCedulaProfesional(String cedulaProfesional) {
        if (cedulaProfesional == null || !cedulaProfesional.trim().matches("\\d{7,8}")) {
            throw new IllegalArgumentException("La cedula profesional debe tener 7 u 8 digitos numericos");
        }
        this.cedulaProfesional = cedulaProfesional.trim();
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad < 21 || edad > 80) {
            throw new IllegalArgumentException("La edad del maestro debe estar entre 21 y 80 anios");
        }
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Maestro{" +
                "numEmpleado=" + numEmpleado +
                ", nombre='" + nombre + '\'' +
                ", puesto='" + puesto + '\'' +
                ", cedulaProfesional='" + cedulaProfesional + '\'' +
                ", edad=" + edad +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Maestro)) return false;
        Maestro maestro = (Maestro) o;
        return numEmpleado == maestro.numEmpleado;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numEmpleado);
    }
}