package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import entidad.Persona;
import negocio.PersonaNegocio;
import presentacion.vista.PanelAgregar;

public class ControladorPanelAgregar implements ActionListener {
	
	private PanelAgregar panelAgregar;
    private PersonaNegocio PersonaNegocio;

    public ControladorPanelAgregar(PanelAgregar panelAgregar, PersonaNegocio PersonaNegocio) {
        this.panelAgregar = panelAgregar;
        this.PersonaNegocio = PersonaNegocio;

        this.panelAgregar.getBtnAceptar().addActionListener(this);
    }

    private void AgregarPersona(ActionEvent a) {
        String dni = panelAgregar.getDni();
        String nombre = panelAgregar.getNombre();
        String apellido = panelAgregar.getApellido();

        if (dni.isEmpty() || nombre.isEmpty() || apellido.isEmpty()) {
            panelAgregar.mostrarMensaje("Debe completar todos los campos.");
            return;
        }

        Persona nuevaPersona = new Persona(dni, nombre, apellido);

        boolean estado = PersonaNegocio.insert(nuevaPersona);
        String mensaje = estado ? "Persona agregada con éxito" : "Error al agregar la persona";
        panelAgregar.mostrarMensaje(mensaje);

        if (estado) {
            panelAgregar.limpiarCampos();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        AgregarPersona(e);
    }
}

