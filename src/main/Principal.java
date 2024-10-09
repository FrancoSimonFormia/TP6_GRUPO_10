package main;

import java.awt.EventQueue;

import presentacion.controlador.ControladorVentanaPrincipal;
import presentacion.vista.VentanaPrincipal;

public class Principal {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
			        VentanaPrincipal vista = new VentanaPrincipal();
			        ControladorVentanaPrincipal controlador = new ControladorVentanaPrincipal(vista);
			        controlador.inicializar();
			        
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
		});
	}

	
}
