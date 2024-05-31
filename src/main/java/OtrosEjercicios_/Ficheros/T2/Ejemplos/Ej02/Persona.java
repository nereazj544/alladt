package OtrosEjercicios_.Ficheros.T2.Ejemplos.Ej02;

public class Persona {

	private int edad;

	public void escribeEdad(int edadnueva) throws excepcionEdad {
		if (edadnueva < 0 || edadnueva > 100)
			throw new excepcionEdad("Error: edad inv�lida");
		edad = edadnueva;
	}

}
