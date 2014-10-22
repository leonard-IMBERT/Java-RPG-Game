package Unit;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Magic implements Combat {

	protected String path;
	protected Point dest;
	protected Fireball fireball;
	protected int count = 0;
	protected boolean begining = true;
	protected ArrayList<Fireball> Tab = new ArrayList<Fireball>();

	public Magic(String PATH) {
		path = PATH;
	}

	public void setDest(Point DEST) {
		dest = DEST;
		System.out.println((int) dest.getX());
	}

	public void moveFBall(Graphics g, JPanel fen) {
		for (int i = 0; i < count; i++) {
			fireball = Tab.get(i);
			this.fireball.move();
			this.fireball.Draw(g, fen);
		}
	}

	@Override
	public void combat(Unit victim, Unit Attack) {
		// TODO Auto-generated method stub
		fireball = new Fireball(path, Attack.posX + 30, Attack.posY + 30,
				(int) dest.getX(), (int) dest.getY());
		Tab.add(fireball);
		System.out.println("Coord : " + Attack.posX + Attack.posY);
		count++;
	}

}
