package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PanelModificar extends JPanel {
    private static final long serialVersionUID = 1L;
    private JList<String> listPersonas;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtDni;
    private JButton btnModificar;

    public PanelModificar() {
        setLayout(null);
        
        listPersonas = new JList<>();
        listPersonas.setBounds(43, 31, 402, 104);
        add(listPersonas);
        
        JLabel lblNewLabel = new JLabel("Seleccione la persona a modificar");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel.setBounds(43, 11, 249, 19);
        add(lblNewLabel);
        
        txtNombre = new JTextField();
        txtNombre.setBounds(43, 159, 86, 20);
        add(txtNombre);
        txtNombre.setColumns(10);
        
        txtApellido = new JTextField();
        txtApellido.setBounds(151, 159, 86, 20);
        add(txtApellido);
        txtApellido.setColumns(10);
        
        txtDni = new JTextField();
        txtDni.setBounds(260, 158, 86, 20);
        add(txtDni);
        txtDni.setColumns(10);
        
        btnModificar = new JButton("Modificar");
        btnModificar.setBounds(356, 157, 89, 21);
        add(btnModificar);
    }

    public JList<String> getListPersonas() {
        return listPersonas;
    }

}
