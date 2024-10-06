package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import presentacion.vista.PanelAgregar;
import presentacion.vista.PanelEliminar;
import presentacion.vista.PanelListar;
import presentacion.vista.PanelModificar;
import presentacion.vista.VentanaPrincipal;
import negocio.PersonaNegocio;
import negocioImplementacion.PersonaNegocioImp;

public class ControladorVentanaPrincipal implements ActionListener {
	private VentanaPrincipal ventana;
    private PersonaNegocio personaNegocio;

    public ControladorVentanaPrincipal(VentanaPrincipal ventana) {
        this.ventana = ventana;
        this.personaNegocio = new PersonaNegocioImp();
        
        ventana.getMntmAgregar().addActionListener(e -> mostrarPanelAgregar());
        ventana.getMntmModificar().addActionListener(e -> ventana.mostrarPanel(new PanelModificar()));
        ventana.getMntmEliminar().addActionListener(e -> ventana.mostrarPanel(new PanelEliminar()));
        ventana.getMntmListar().addActionListener(e -> ventana.mostrarPanel(new PanelListar()));
    }

    private void mostrarPanelAgregar() {
        PanelAgregar panelAgregar = new PanelAgregar();
       
        new ControladorPanelAgregar(panelAgregar, personaNegocio);
        ventana.mostrarPanel(panelAgregar);
    }
    
    public void inicializar() {
        this.ventana.setVisible(true);
    }

	@Override
	public void actionPerformed(ActionEvent e) {}

		
	}