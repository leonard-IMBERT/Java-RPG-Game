import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import javax.swing.JPanel;

public class Mur extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// on charge une image de mur

	public Mur(Image img, Graphics g) throws IOException {
		g.drawImage(img, 0, 0, this);
	}

}
