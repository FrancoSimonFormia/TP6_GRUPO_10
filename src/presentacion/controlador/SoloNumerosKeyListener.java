package presentacion.controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SoloNumerosKeyListener implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();

        // Si el caracter no es un numero, se ignora
        if (!Character.isDigit(c)) {
            e.consume();
        }
	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

}
