package dao;

import java.util.List;

import entidad.Persona;

public interface PersonaDao 
{
	public boolean insert(Persona persona);

	public boolean existeDni(String dni);
	
	public boolean update(Persona persona);
	
	public boolean delete(Persona persona);
	
	 List<Persona> selectPersonas();
}