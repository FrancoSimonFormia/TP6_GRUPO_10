package presentacion.controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SoloLetrasKeyListener implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();

        // Si el caracter no es una letra, se ignora
        if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
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
