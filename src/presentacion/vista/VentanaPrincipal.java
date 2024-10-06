package presentacion.vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VentanaPrincipal extends JFrame {
	
	    private static final long serialVersionUID = 1L;
	    private JPanel contentPane;
	    private JMenuItem mntmAgregar;
	    private JMenuItem mntmModificar;
	    private JMenuItem mntmEliminar;
	    private JMenuItem mntmListar;

	    public VentanaPrincipal() {
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(600, 400, 500, 275);
	        setTitle("Programa");

	        JMenuBar menuBar = new JMenuBar();
	        setJMenuBar(menuBar);

	        JMenu mnPersona = new JMenu("Persona");
	        menuBar.add(mnPersona);

	        mntmAgregar = new JMenuItem("Agregar");
	        mnPersona.add(mntmAgregar);

	        mntmModificar = new JMenuItem("Modificar");
	        mnPersona.add(mntmModificar);

	        mntmEliminar = new JMenuItem("Eliminar");
	        mnPersona.add(mntmEliminar);

	        mntmListar = new JMenuItem("Listar");
	        mnPersona.add(mntmListar);

	        contentPane = new JPanel();
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        contentPane.setLayout(new BorderLayout(0, 0));
	        setContentPane(contentPane);
	    }
	    
	    
	    /// GETTERS ACCESIBLES PARA EL CONTROLADOR
	    
	    public JMenuItem getMntmAgregar() {
	        return mntmAgregar;
	    }

	    public JMenuItem getMntmModificar() {
	        return mntmModificar;
	    }

	    public JMenuItem getMntmEliminar() {
	        return mntmEliminar;
	    }

	    public JMenuItem getMntmListar() {
	        return mntmListar;
	    }

	    public void mostrarPanel(JPanel panel) {
	        contentPane.removeAll();
	        contentPane.add(panel, BorderLayout.CENTER);
	        contentPane.revalidate();
	        contentPane.repaint();
	    }
}
