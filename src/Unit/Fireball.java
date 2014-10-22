package Unit;

import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Fireball extends Unit {
	private double X;
	private double Y;
	private double vectX = 1;
	private double vectY;
	private double D;

	public Fireball(String path, int posX1, int posY1, int posX2, int posY2) {
		try {
			this.sprite = ImageIO.read(new File(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		X = posX1;
		Y = posY1;
		D = java.lang.Math.sqrt((double) ((posX2 - posX1) ^ 2)
				+ (double) ((posY2 - posY1) ^ 2));
		System.out.println(D);
		vectX = ((double) posX2 - (double) posX1) / (D);
		vectY = ((double) posY2 - (double) posY1) / (D);
		System.out.println("Vecteur Y = " + vectY);

	}

	public void move() {
		X = X + vectX;
		Y = Y + vectY;
	}

	public void Draw(Graphics g, JPanel fen) {
		g.drawImage(sprite, (int) X, (int) Y, fen);
	}

}
