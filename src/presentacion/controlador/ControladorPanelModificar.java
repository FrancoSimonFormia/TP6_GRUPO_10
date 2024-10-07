package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
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
        
        this.panelModificar.getBtnModificar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				JTextField txtNombre = panelModificar.getTxtNombre();
				JTextField txtApellido = panelModificar.getTxtApellido();
				JTextField txtDni = panelModificar.getTxtDni();
				
				KeyListener SoloLetrasKeyListener = new SoloLetrasKeyListener();
				txtNombre.addKeyListener(SoloLetrasKeyListener);
				txtApellido.addKeyListener(SoloLetrasKeyListener);
				
		        String dni = txtDni.getText();
		        String nombre = txtNombre.getText();
		        String apellido = txtApellido.getText();

		        if (dni.isEmpty() || nombre.isEmpty() || apellido.isEmpty()) {
		            panelModificar.mostrarMensaje("Debe completar todos los campos.");
		            return;
		        }

		        if (!esSoloLetras(nombre)) {
		        	panelModificar.mostrarMensaje("El nombre solo puede contener letras.");
		            return;
		        }

		        if (!esSoloLetras(apellido)) {
		        	panelModificar.mostrarMensaje("El apellido solo puede contener letras.");
		            return;
		        }
		        
		        Persona nuevaPersona = new Persona(dni, nombre, apellido);

		        boolean estado = personaNegocio.update(nuevaPersona);
		        
		        String mensaje = estado ? "Persona modificada con Èxito" : "Error al modificar la persona";
		        panelModificar.mostrarMensaje(mensaje);

		        if (estado) {
		        	panelModificar.limpiarCampos();
		        	cargarListaPersonas();
		        }
			}
        	
        });
        
     }

    private boolean esSoloLetras(String cadena) {
        return cadena.matches("[a-zA-Z·ÈÌÛ˙¡…Õ”⁄Ò—\\s]+");
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

