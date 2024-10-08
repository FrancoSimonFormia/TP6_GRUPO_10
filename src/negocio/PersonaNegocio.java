package negocio;

import java.util.List;

import entidad.Persona;

public interface PersonaNegocio {

	public boolean insert(Persona persona);

	public boolean existeDni(String dni);
	
	public boolean update(Persona persona);
	
	public boolean delete(String dni);
	
	List<Persona> selectPersonas();
}
