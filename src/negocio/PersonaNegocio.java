package negocio;

import entidad.Persona;

public interface PersonaNegocio {

	public boolean insert(Persona persona);

	public boolean existeDni(String dni);
}
