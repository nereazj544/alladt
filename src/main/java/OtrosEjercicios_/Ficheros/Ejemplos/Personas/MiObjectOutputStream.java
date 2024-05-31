package OtrosEjercicios_.Ficheros.Ejemplos.Personas;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class MiObjectOutputStream extends ObjectOutputStream {

	protected MiObjectOutputStream() throws IOException, SecurityException {
		super();
	}
	
	public MiObjectOutputStream(FileOutputStream out) throws IOException {
		super(out);
	}
	
	@Override
	protected void writeStreamHeader() throws IOException {
		//se reescribe este metodo para que no haga nada
	}
	
}
