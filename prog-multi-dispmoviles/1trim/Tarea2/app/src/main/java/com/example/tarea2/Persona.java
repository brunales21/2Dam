package com.example.tarea2;

import java.util.InputMismatchException;

public class Persona {
    protected String nombre;
    protected String edad;

    public Persona(String nombre, String edad) {
        this.nombre = nombre;
        setEdad(edad);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        StringBuilder edadLimpia = new StringBuilder();
        for (int i = 0; i < edad.length(); i++) {
            if (!Character.isLetter(edad.charAt(i))) {
                edadLimpia.append(edad.charAt(i));
            }
        }
        this.edad = edadLimpia.toString();
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }
}