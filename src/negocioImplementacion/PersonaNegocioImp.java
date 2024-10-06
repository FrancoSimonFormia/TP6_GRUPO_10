package negocioImplementacion;


import dao.PersonaDao;
import daoImplementacion.PersonaDaoImp;
import entidad.Persona;
import negocio.PersonaNegocio;

public class PersonaNegocioImp implements PersonaNegocio{

	PersonaDao pdao = new PersonaDaoImp();
	
	@Override
	public boolean insert(Persona persona) {
		
		boolean estado=false;
		if(persona.getDni().trim().length()>0 && persona.getNombre().trim().length()>0 && persona.getApellido().trim().length()>0)
		{
			estado=pdao.insert(persona);
		}
		return estado;
	}

}
