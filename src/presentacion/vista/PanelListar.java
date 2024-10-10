package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JList;


public class PanelListar extends JPanel {
    
    private JList<String> listPersonasEliminar;

    public PanelListar() {
        setLayout(null);
        
        listPersonasEliminar = new JList<>();
        listPersonasEliminar.setBounds(139, 41, 173, 111);
        add(listPersonasEliminar);

    }

    public JList<String> getListPersonasEliminar() {
        return listPersonasEliminar;
    }

    private static final long serialVersionUID = 1L;
}


