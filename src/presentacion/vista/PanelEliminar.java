package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;

public class PanelEliminar extends JPanel {
	public PanelEliminar() {
		setLayout(null);
		
		JLabel lblEliminarUsuarios = new JLabel("Eliminar usuarios");
		lblEliminarUsuarios.setBounds(118, 24, 139, 14);
		add(lblEliminarUsuarios);
		
		JList listPersonasEliminar = new JList();
		listPersonasEliminar.setBounds(118, 49, 173, 111);
		add(listPersonasEliminar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(168, 171, 89, 23);
		add(btnEliminar);
	}

	private static final long serialVersionUID = 1L;
}
