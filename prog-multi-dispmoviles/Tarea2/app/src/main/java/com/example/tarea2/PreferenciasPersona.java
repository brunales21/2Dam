package com.example.tarea2;

public class PreferenciasPersona extends Persona {
    private String bebida;
    private String animalPreferido;
    public PreferenciasPersona(String nombre, int edad, String bebida, String animalPreferido) {
        super(nombre, edad);
        this.bebida = bebida;
        this.animalPreferido = animalPreferido;
    }

    public String getBebida() {
        return bebida;
    }

    public void setBebida(String bebida) {
        this.bebida = bebida;
    }

    public String getAnimalPreferido() {
        return animalPreferido;
    }

    public void setAnimalPreferido(String animalPreferido) {
        this.animalPreferido = animalPreferido;
    }

    @Override
    public String toString() {
        return
                "bebida='" + bebida + '\'' +
                ", animalPreferido='" + animalPreferido + '\'' +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }
}
