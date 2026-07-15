package org.example.modelo;

public abstract class PersonaUT {
    private String nombre;

    public PersonaUT(String nombre) {
        setNombre(nombre);
    }

    public String getNombre() {
        return nombre.toUpperCase();
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            System.out.println("Error el nombre es requerido");
        } else {
            this.nombre = nombre;
        }
    }

    public abstract String mostrarTipoPersona();

    @Override
    public String toString() {
        return mostrarTipoPersona() + "\n" +
                "Nombre: " + getNombre();
    }
}