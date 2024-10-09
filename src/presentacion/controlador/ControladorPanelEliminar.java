package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import entidad.Persona;
import negocio.PersonaNegocio;
import presentacion.vista.PanelEliminar;

public class ControladorPanelEliminar implements ActionListener{

    private PanelEliminar panelEliminar;
    private PersonaNegocio personaNegocio;

    public ControladorPanelEliminar(PanelEliminar panelEliminar, PersonaNegocio personaNegocio) {
        this.panelEliminar = panelEliminar;
        this.personaNegocio = personaNegocio;      
        this.panelEliminar.getBtnEliminar().addActionListener(this);  
        cargarListaPersonas();
      
    }
    
    private void cargarListaPersonas() {
        List<Persona> personas = personaNegocio.selectPersonas();
        DefaultListModel<String> modeloLista = new DefaultListModel<>();

        for (Persona persona : personas) {
            String infoPersona = persona.getNombre() + " " + persona.getApellido();
            modeloLista.addElement(infoPersona);
        }

        panelEliminar.getListPersonasEliminar().setModel(modeloLista);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == panelEliminar.getBtnEliminar()) {
            String selectedValue = panelEliminar.getListPersonasEliminar().getSelectedValue();
            
            if (selectedValue != null) {
                int confirmacion = JOptionPane.showConfirmDialog(
                        panelEliminar, 
                        "¿Está seguro de que desea eliminar a " + selectedValue + "?", 
                        "Confirmar eliminación", 
                        JOptionPane.YES_NO_OPTION);
          
                if (confirmacion == JOptionPane.YES_OPTION) {
                    panelEliminar.mostrarMensaje("Eliminando persona: " + selectedValue);              

                    cargarListaPersonas(); 
                } else {
                    panelEliminar.mostrarMensaje("La eliminación ha sido cancelada.");
                }
            } else {
                panelEliminar.mostrarMensaje("Debe seleccionar una persona para eliminar.");
            }
        }
    }

}


