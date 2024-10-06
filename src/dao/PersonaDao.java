package dao;

import entidad.Persona;

public interface PersonaDao 
{
	public boolean insert(Persona persona);

	public boolean existeDni(String dni);
}