package daoImplementacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.PersonaDao;
import entidad.Persona;


public class PersonaDaoImp implements PersonaDao
{
	private static final String insert = "INSERT INTO personas(Dni, nombre, apellido) VALUES(?, ?, ?)";
	private static final String verificarDni = "SELECT COUNT(*) FROM personas WHERE Dni = ?";	
	private static final String selectPersonas = "SELECT Dni, nombre, apellido FROM personas";
		
	public boolean existeDni(String dni) {
	    PreparedStatement statement;
	    Connection conexion = Conexion.getConexion().getSQLConexion();
	    boolean existe = false;

	    try {
	        statement = conexion.prepareStatement(verificarDni);
	        statement.setString(1, dni);
	        ResultSet resultado = statement.executeQuery();

	        if (resultado.next() && resultado.getInt(1) > 0) {
	            existe = true; 
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return existe;
	}
	
	public boolean insert(Persona persona)
	{

		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(insert);
			statement.setString(1, persona.getDni());
			statement.setString(2, persona.getNombre());
			statement.setString(3, persona.getApellido());
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isInsertExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		return isInsertExitoso;
	}

	@Override
	public List<Persona> selectPersonas() {
		 PreparedStatement statement;
		    ResultSet resultSet;
		    ArrayList<Persona> personas = new ArrayList<>();
		    Connection conexion = Conexion.getConexion().getSQLConexion();

		    try {
		        statement = conexion.prepareStatement(selectPersonas);
		        resultSet = statement.executeQuery();

		        while (resultSet.next()) {
		            Persona persona = new Persona();
		            persona.setDni(resultSet.getString("Dni"));
		            persona.setNombre(resultSet.getString("nombre"));
		            persona.setApellido(resultSet.getString("apellido"));
		            personas.add(persona);
		        }
		      
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return personas;
		}
}

