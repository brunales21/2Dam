package com.example.tarea2;

public class PreferenciasPersona extends Persona {
    private String bebida;
    private String animalPreferido;
    private String emailAdress;
    private String phoneNumber;

    public PreferenciasPersona(String nombre, int edad, String bebida, String animalPreferido, String emailAdress, String phoneNumber) {
        super(nombre, edad);
        this.bebida = bebida;
        this.animalPreferido = animalPreferido;
        this.emailAdress = emailAdress;
        this.phoneNumber = phoneNumber;
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
        return "PreferenciasPersona{" +
                "bebida='" + bebida + '\'' +
                ", animalPreferido='" + animalPreferido + '\'' +
                ", emailAdress='" + emailAdress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }
}
