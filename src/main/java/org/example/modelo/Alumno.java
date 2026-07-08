package org.example.modelo;

import java.util.Objects;

public class Alumno {
    private int numExpediente;
    private String nombre;
    private int edad;
    private String carrera;
    private int cuatrimestres;

    public Alumno() {
    }

    public Alumno(int numExpediente, String nombre, int edad, String carrera, int cuatrimestres) {
        this.numExpediente = numExpediente;
        this.nombre = nombre;
        this.edad = edad;
        this.carrera = carrera;
        this.cuatrimestres = cuatrimestres;
    }

    public int getNumExpediente() {
        return numExpediente;
    }

    public void setNumExpediente(int numExpediente) {
        this.numExpediente = numExpediente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getCuatrimestres() {
        return cuatrimestres;
    }

    public void setCuatrimestres(int cuatrimestres) {
        this.cuatrimestres = cuatrimestres;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "numExpediente=" + numExpediente +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", carrera='" + carrera + '\'' +
                ", cuatrimestres=" + cuatrimestres +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Alumno)) return false;
        Alumno alumno = (Alumno) o;
        return numExpediente == alumno.numExpediente;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numExpediente);
    }
}
