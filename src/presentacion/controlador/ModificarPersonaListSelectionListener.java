package presentacion.controlador;

import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import entidad.Persona;
import presentacion.vista.PanelModificar;

public class ModificarPersonaListSelectionListener implements ListSelectionListener {

	private PanelModificar panelModificar;
	
	public ModificarPersonaListSelectionListener(PanelModificar panelModifcar) {
		this.panelModificar = panelModifcar;
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		
		JList listPersonas = new JList<>();
		listPersonas = panelModificar.getListPersonas();
		
		JTextField txtNombre = panelModificar.getTxtNombre();
		JTextField txtApellido = panelModificar.getTxtApellido();
		JTextField txtDni = panelModificar.getTxtDni();
		
		if(listPersonas.getSelectedIndex() != -1) {
			
			Persona aux = (Persona)listPersonas.getSelectedValue();
			
			txtNombre.setText(aux.getNombre());
			txtApellido.setText(aux.getApellido());
			txtDni.setText(aux.getDni());
		}
		
	}

}
