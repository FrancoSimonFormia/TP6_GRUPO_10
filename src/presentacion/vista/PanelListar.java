package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JOptionPane;


public class PanelListar extends JPanel {
    
    private JList<String> listPersonasEliminar;

    public PanelListar() {
        setLayout(null);
        
        listPersonasEliminar = new JList<>();
        listPersonasEliminar.setBounds(118, 49, 173, 111);
        add(listPersonasEliminar);

    }

    public JList<String> getListPersonasEliminar() {
        return listPersonasEliminar;
    }

    private static final long serialVersionUID = 1L;
    
    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
}


