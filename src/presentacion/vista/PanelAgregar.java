package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;

public class PanelAgregar extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblDni;
	
	private JButton btnAceptar;
	
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	
	public PanelAgregar() {
		setLayout(null);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setBounds(100, 25, 100, 20);
		add(lblNombre);
		
		lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblApellido.setBounds(100, 70, 100, 20);
		add(lblApellido);
		
		lblDni = new JLabel("DNI");
		lblDni.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDni.setBounds(100, 115, 100, 20);
		add(lblDni);
		
		btnAceptar = new JButton("ACEPTAR");
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAceptar.setBounds(100, 150, 116, 30);
		add(btnAceptar);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(270, 25, 116, 22);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(270, 70, 116, 22);
		add(txtApellido);
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(270, 115, 116, 22);
		add(txtDni);
	}
	
	
	public String getNombre() {
	    return txtNombre.getText();
	}

	public String getApellido() {
	    return txtApellido.getText();
	}

	public String getDni() {
	    return txtDni.getText();
	}

	public JButton getBtnAceptar() {
	    return this.btnAceptar;
	}
	
	public void limpiarCampos() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtDni.setText("");
    }

	public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
	
}
