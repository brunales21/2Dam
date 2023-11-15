package com.example.tarea2;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Objects;

public class PreferenciasPersona extends Persona {
    private String bebida;
    private String animalPreferido;
    private String emailAdress;
    private String phoneNumber;
    private String dni;

    public PreferenciasPersona(String nombre, String edad, String bebida, String animalPreferido, String emailAdress, String phoneNumber, String dni) throws NumberFormatException {
        super(nombre, edad);
        this.bebida = bebida;
        this.animalPreferido = animalPreferido;
        this.emailAdress = emailAdress;
        this.phoneNumber = phoneNumber;
        this.dni = dni;
    }

    public boolean comprobarDni(String dni) {
        if (dni.length() != 9) {
            return false;
        }
        Map<Integer, String > map = crearMapaDNI();
        String letra = String.valueOf(dni.charAt(dni.length()-1));
        try {
            int n = Integer.parseInt(dni.substring(0, dni.length()-1));
            int num = n%23;
            return map.get(num).equalsIgnoreCase(letra);
        } catch (Exception e) {
            return false;
        }
    }

    private Map<Integer, String> crearMapaDNI() {
        Map<Integer, String> dniMap = new HashMap<>();

        // Asignar números del 0 al 22 con los caracteres correspondientes
        dniMap.put(0, "T");
        dniMap.put(1, "R");
        dniMap.put(2, "W");
        dniMap.put(3, "A");
        dniMap.put(4, "G");
        dniMap.put(5, "M");
        dniMap.put(6, "Y");
        dniMap.put(7, "F");
        dniMap.put(8, "P");
        dniMap.put(9, "D");
        dniMap.put(10, "X");
        dniMap.put(11, "B");
        dniMap.put(12, "N");
        dniMap.put(13, "J");
        dniMap.put(14, "Z");
        dniMap.put(15, "S");
        dniMap.put(16, "Q");
        dniMap.put(17, "V");
        dniMap.put(18, "H");
        dniMap.put(19, "L");
        dniMap.put(20, "C");
        dniMap.put(21, "K");
        dniMap.put(22, "E");

        return dniMap;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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
