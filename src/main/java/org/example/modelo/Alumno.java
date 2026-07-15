package org.example.modelo;

import java.util.Objects;

public class Alumno extends PersonaUT implements Ensenable, Evaluable {
    private int numExpediente;
    private int edad;
    private String carrera;
    private int cuatrimestres;

    public Alumno() {
        super("Sin nombre");
    }

    public Alumno(int numExpediente, String nombre, int edad, String carrera, int cuatrimestres) {
        super(nombre);
        this.numExpediente = numExpediente;
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
    public String mostrarTipoPersona(){
        return "TIPO: ALUMNO";
    }
    @Override
    public void aprender(){
        System.out.println(getNombre() + "esta aprendiendo en la carrera de "+ carrera);
    }
    @Override
    public void recibirEvaluacion(){
        System.out.println(getNombre() + "recibio una evaluacion del cuatrimetre "+ cuatrimestres);
    }

    @Override
    public String toString() {
        return super.toString() +"\n" +
                "{ numExpediente=" + numExpediente +
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
