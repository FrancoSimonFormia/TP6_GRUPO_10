package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

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
        
        
        KeyListener soloNumerosKeyListener = new SoloNumerosKeyListener();
        this.panelAgregar.getTxtDni().addKeyListener(soloNumerosKeyListener);

        
        KeyListener soloLetrasKeyListener = new SoloLetrasKeyListener();
        this.panelAgregar.getTxtNombre().addKeyListener(soloLetrasKeyListener);
        this.panelAgregar.getTxtApellido().addKeyListener(soloLetrasKeyListener);
    }
    
    private boolean esSoloLetras(String cadena) {
        return cadena.matches("[a-zA-Z·ÈÌÛ˙¡…Õ”⁄Ò—\\s]+");
    }
    
    private boolean esSoloNumeros(String cadena) {
        return cadena.matches("\\d+");
    }

    private void AgregarPersona(ActionEvent a) {
    	
        String dni = panelAgregar.getDni();
        String nombre = panelAgregar.getNombre();
        String apellido = panelAgregar.getApellido();

        if (dni.isEmpty() || nombre.isEmpty() || apellido.isEmpty()) {
            panelAgregar.mostrarMensaje("Debe completar todos los campos.");
            return;
        }

        if (!esSoloLetras(nombre)) {
            panelAgregar.mostrarMensaje("El nombre solo puede contener letras.");
            return;
        }

        if (!esSoloLetras(apellido)) {
            panelAgregar.mostrarMensaje("El apellido solo puede contener letras.");
            return;
        }
        
        if (!esSoloNumeros(dni)) {
            panelAgregar.mostrarMensaje("El DNI solo puede contener n˙meros.");
            return;
        }
        
        if (PersonaNegocio.existeDni(dni)) {
            panelAgregar.mostrarMensaje("El DNI ya est· registrado.");
            return;
        }
        
        Persona nuevaPersona = new Persona(dni, nombre, apellido);

        boolean estado = PersonaNegocio.insert(nuevaPersona);
        
        String mensaje = estado ? "Persona agregada con Èxito" : "Error al agregar la persona";
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

