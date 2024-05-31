package OtrosEjercicios_.Ficheros.Ejemplos.Personas;

import java.io.Serializable;

public class Persona implements Serializable {
	
	private static final long serialVersionUID = 1L;
	public String nombre;
	public int edad;
	
	public Persona(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
	}
	
	public Persona() {
		this.nombre = null;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}
	public int getEdad() {
		return edad;
	} 
	
	
}
