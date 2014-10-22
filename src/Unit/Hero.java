package Unit;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Hero extends Unit {

	private Image sprite;
	private Magic combat2;
	private String pathFireball;

	public Hero(String path, String pathFIREBALL, int poX, int poY) {
		super();
		this.name = "Hero";
		this.pv = 100;
		this.combat = new Epee();
		this.armure = new Acier();
		posX = poX;
		posY = poY;
		pathFireball = pathFIREBALL;

		try {
			sprite = ImageIO.read(new File(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.combat2 = new Magic(pathFireball);

	}

	public void move(int x, int y) {
		this.posX = this.posX + x;
		this.posY = this.posY + y;
	}

	public void setDestMagic(Point dest) {
		this.combat2.setDest(dest);
		this.combat2.combat(this, this);
	}

	public void moveFBall(Graphics g, JPanel fen) {
		this.combat2.moveFBall(g, fen);
	}

	public int getX() {
		return this.posX;
	}

	public int getY() {
		return this.posY;
	}

	public Image getSprite() {
		return this.sprite;
	}

}
