package presentacion.controlador;

import java.util.List;
import javax.swing.DefaultListModel;
import entidad.Persona;
import negocio.PersonaNegocio;
import presentacion.vista.PanelListar;

public class ControladorPanelListar {

    private PanelListar PanelListar;
    private PersonaNegocio personaNegocio;

    public ControladorPanelListar(PanelListar PanelListar, PersonaNegocio personaNegocio) {
        this.PanelListar = PanelListar;
        this.personaNegocio = personaNegocio;      
        cargarListaPersonas();
      
    }
    
    private void cargarListaPersonas() {
        List<Persona> personas = personaNegocio.selectPersonas();
        DefaultListModel<String> modeloLista = new DefaultListModel<>();

        for (Persona persona : personas) {
            String infoPersona = persona.getNombre() + " " + persona.getApellido() + " " + persona.getDni();
            modeloLista.addElement(infoPersona);
        }

        PanelListar.getListPersonasEliminar().setModel(modeloLista);
    }


}


