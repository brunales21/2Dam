package com.iesinfantaelena;

import java.io.Serializable;

public class ObjetosTCPPersona implements Serializable{
	String nombre;
	int edad;
	
	public ObjetosTCPPersona(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}
	
	public String getNombre() {return nombre;}
	public void setNombre(String nombre) {this.nombre = nombre;}
	
	public int getEdad() {return edad;}
	public void setEdad(int edad) {this.edad = edad;}

}
