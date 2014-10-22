import java.awt.Graphics;

import javax.swing.JPanel;

public class Porte extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int X, Y;

	public Porte() {

	}

	public Porte(int posX, int posY, int id) {
		X = posX;
		Y = posY;
	}

	public void drawPorte(Graphics g, int TX, int TY) {
		g.fillRect(X, Y, TX, TY);
	}

}
