package presentacion.controlador;

import java.util.List;

import javax.swing.DefaultListModel;
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
    }

    private void cargarListaPersonas() {
        List<Persona> personas = personaNegocio.selectPersonas();
        
        DefaultListModel<String> modeloLista = new DefaultListModel<>();

        for (Persona persona : personas) {
            String infoPersona = persona.getDni() + " - " + persona.getNombre() + " " + persona.getApellido();
            modeloLista.addElement(infoPersona);
        }

        panelModificar.getListPersonas().setModel(modeloLista);
    }

}

