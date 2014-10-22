package inputManager;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

	private int keyPre;
	private int keyRe;
	private int keyTyp;

	public KeyManager() {

	}

	public int getKeyPre() {
		return keyPre;
	}

	public int getKeyRe() {
		return keyRe;
	}

	public int getKeyTyp() {
		return keyTyp;
	}

	public void resetAllKey() {
		keyPre = 0;
		keyRe = 0;
		keyTyp = 0;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		keyPre = arg0.getKeyCode();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		keyRe = arg0.getKeyCode();
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		keyTyp = arg0.getKeyCode();
	}

}
