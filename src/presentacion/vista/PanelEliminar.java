package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelEliminar extends JPanel {
    
    private JList<String> listPersonasEliminar;
    private JButton btnEliminar;

    public PanelEliminar() {
        setLayout(null);
        
        JLabel lblEliminarUsuarios = new JLabel("Eliminar usuarios");
        lblEliminarUsuarios.setBounds(118, 24, 139, 14);
        add(lblEliminarUsuarios);
        
        listPersonasEliminar = new JList<>();
        listPersonasEliminar.setBounds(118, 49, 173, 111);
        add(listPersonasEliminar);
        
        btnEliminar = new JButton("Eliminar");        
        btnEliminar.setBounds(168, 171, 89, 23);
        add(btnEliminar);
    }

    public JList<String> getListPersonasEliminar() {
        return listPersonasEliminar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    private static final long serialVersionUID = 1L;
    
    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
}


