package alladt.Ficheros.TodoFicheros_Clase.Persona;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MiObjetoOut extends ObjectOutputStream{
	public MiObjetoOut (OutputStream out) throws IOException{
		super(out);
}

	protected MiObjetoOut() throws IOException, SecurityException{
		super();
	}
	
	protected void writeSteadHeader() throws IOException{
		
	}
}
