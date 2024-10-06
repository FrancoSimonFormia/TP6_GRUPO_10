package presentacion.controlador;

import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import entidad.Persona;
import negocio.PersonaNegocio;
import presentacion.vista.PanelModificar;

public class ControladorPanelModificar {
	
	private PanelModificar panelModificar;
    private PersonaNegocio personaNegocio;

    public ControladorPanelModificar(PanelModificar panelModificar, PersonaNegocio personaNegocio) {
        this.panelModificar = panelModificar;
        this.personaNegocio = personaNegocio;
        cargarListaPersonas();
        
        //Carga los datos en las cajas de texto realizada una seleccion
        ListSelectionListener modificarPersonaListSelectionListener = new ModificarPersonaListSelectionListener(panelModificar);
        this.panelModificar.getListPersonas().addListSelectionListener(modificarPersonaListSelectionListener);
        
        
     }

    
   
    
    private void cargarListaPersonas() {
        List<Persona> personas = personaNegocio.selectPersonas();
        
        DefaultListModel<Persona> modeloLista = new DefaultListModel<>();

        for (Persona persona : personas) {
            //String infoPersona = persona.getDni() + " - " + persona.getNombre() + " " + persona.getApellido();
            //modeloLista.addElement(infoPersona);
        	modeloLista.addElement(persona);
        }

        panelModificar.getListPersonas().setModel(modeloLista);
    }

}

