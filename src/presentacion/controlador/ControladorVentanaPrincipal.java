package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import negocio.PersonaNegocio;
import negocioImplementacion.PersonaNegocioImp;
import presentacion.vista.PanelAgregar;
import presentacion.vista.PanelEliminar;
import presentacion.vista.PanelListar;
import presentacion.vista.PanelModificar;
import presentacion.vista.VentanaPrincipal;

public class ControladorVentanaPrincipal implements ActionListener {
    private VentanaPrincipal ventana;
    private PersonaNegocio personaNegocio;

    public ControladorVentanaPrincipal(VentanaPrincipal ventana) {
        this.ventana = ventana;
        this.personaNegocio = new PersonaNegocioImp();
        
        ventana.getMntmAgregar().addActionListener(e -> mostrarPanelAgregar());
        ventana.getMntmModificar().addActionListener(e -> mostrarPanelModificar());
        ventana.getMntmEliminar().addActionListener(e -> mostrarPanelEliminar());
        ventana.getMntmListar().addActionListener(e -> ventana.mostrarPanel(new PanelListar()));
    }

    private void mostrarPanelAgregar() {
        PanelAgregar panelAgregar = new PanelAgregar();
        new ControladorPanelAgregar(panelAgregar, personaNegocio);
        ventana.mostrarPanel(panelAgregar);
    }
    
    private void mostrarPanelModificar() {
        PanelModificar panelModificar = new PanelModificar();
        new ControladorPanelModificar(panelModificar, personaNegocio);
        ventana.mostrarPanel(panelModificar);
    }

    private void mostrarPanelEliminar() {
        PanelEliminar panelEliminar = new PanelEliminar();
        new ControladorPanelEliminar(panelEliminar, personaNegocio); 
        ventana.mostrarPanel(panelEliminar);
    }

    public void inicializar() {
        this.ventana.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {}
}

		
	