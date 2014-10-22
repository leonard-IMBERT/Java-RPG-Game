import inputManager.KeyManager;
import inputManager.MouseManager;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Unit.Hero;

public class Salle extends JPanel {
	/**
	 * TX : Taille X de la fenêtre TY : Taille Y de la fenêtre serialVersionUID
	 * : version des packages
	 * 
	 */
	public int TX = 200;
	public int TY = 400;
	private static final long serialVersionUID = 1L;
	private Image listMur[] = new Image[5];
	private Image oldListMur[] = new Image[5];
	private Porte p1 = new Porte(10, 50, 1);
	private Porte p2 = new Porte(10 + TX + 10, 50, 2);
	private Porte p3 = new Porte(10 + 2 * TX + 2 * 10, 50, 3);
	private Porte p4 = new Porte(10 + 3 * TX + 3 * 10, 50, 4);
	private int state = 0;
	private Fenetre fenetre;
	private int porteCilquee;
	private Hero hero = new Hero("src\\Sprites\\Face-Stand-1.png",
			"src\\Sprites\\Fireball.png", 10, 300);
	private Point pointer;
	private KeyManager key = new KeyManager();
	private JTextField monField = new JTextField();
	private boolean fBall = false;
	private MouseManager mouse = new MouseManager();

	// Constructeur de base
	public Salle(Fenetre f) {
		System.out.println("C'est bon!");
		this.fenetre = f;
		fenetre.addMouseListener(mouse);
		this.add(monField);
		monField.addKeyListener(key);
	}

	public void genererSalle() {
		try {
			Image img0 = ImageIO.read(new File(
					"src\\Sprites\\Salle\\Part 1.png"));
			Image img1 = ImageIO.read(new File(
					"src\\Sprites\\Salle\\Part 2.png"));
			Image img2 = ImageIO.read(new File(
					"src\\Sprites\\Salle\\Part 3.png"));
			Image img3 = ImageIO.read(new File(
					"src\\Sprites\\Salle\\Part 4.png"));
			Image img4 = ImageIO.read(new File(
					"src\\Sprites\\Salle\\Part 5.png"));
			Image img5 = ImageIO.read(new File(
					"src\\Sprites\\Salle\\Part 6.png"));
			Image img6 = ImageIO.read(new File(
					"src\\Sprites\\Salle\\Part 7.png"));
			Image img7 = ImageIO.read(new File(
					"src\\Sprites\\Salle\\Part 8.png"));
			Image img8 = ImageIO.read(new File(
					"src\\Sprites\\Salle\\Part 9.png"));
			Image img9 = ImageIO.read(new File(
					"src\\Sprites\\Salle\\Part 10.png"));
			Image img11 = ImageIO.read(new File(
					"src\\Sprites\\Salle\\Part 12.png"));
			Image img10 = ImageIO.read(new File(
					"src\\Sprites\\Salle\\Part 11.png"));

			this.generer(img0, img1, img2, img3, img4, img5, img6, img7, img8,
					img9, img11, img10);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Une salle c'est 5 mur chacun 11 possibilitée
	private void generer(Image img0, Image img1, Image img2, Image img3,
			Image img4, Image img5, Image img6, Image img7, Image img8,
			Image img9, Image img10, Image img11) {
		Random rnd = new Random();
		this.setBackground(Color.blue);
		for (int i = 0; i <= 4; i++) {
			// une image par nombre aléatoire
			int r = rnd.nextInt(11);
			switch (r) {
			case 0:
				listMur[i] = img0;
				break;
			case 1:
				listMur[i] = img1;
				break;
			case 2:
				listMur[i] = img2;
				break;
			case 3:
				listMur[i] = img3;
				break;
			case 4:
				listMur[i] = img4;
				break;
			case 5:
				listMur[i] = img5;
				break;
			case 6:
				listMur[i] = img6;
				break;
			case 7:
				listMur[i] = img7;
				break;
			case 8:
				listMur[i] = img8;
				break;
			case 9:
				listMur[i] = img9;
				break;
			case 10:
				listMur[i] = img10;
				break;
			case 11:
				listMur[i] = img11;
				break;
			default:
				listMur[i] = img0;
				break;
			}
			System.out.println("Case " + i + " remplie avec la valeur " + r);
		}
		System.out.println("Salle générée");
	}

	public void afficher(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, TX, TY);
		if (state == 1) {
			for (int i = 0; i <= 4; i++) {
				g.drawImage(listMur[i], i * 75 * 4, 10, 75 * 4, 400, this);
			}
			g.drawImage(hero.getSprite(), hero.getX(), hero.getY(), this);
			// on affiche le mur
			if (fBall == true) {
				hero.moveFBall(g, this);
			}
		}
		if (state == 0) {
			this.setBackground(Color.black);
			g.setColor(Color.ORANGE);
			p1.drawPorte(g, TX, TY);
			p2.drawPorte(g, TX, TY);
			p3.drawPorte(g, TX, TY);
			p4.drawPorte(g, TX, TY);
		}
	}

	private void changeStateTo1() {
		for (int i = 0; i <= 4; i++) {
			oldListMur[i] = listMur[i];
		}
		state = 1;
		System.out.println(state);
	}

	/*
	 * private void changeStateTo0() { state = 0; }
	 */

	public boolean inSalle() {
		boolean b = false;
		if (state == 1) {
			b = true;
		} else if (state == 0) {
			b = false;
		}
		return b;
	}

	public void move() {

		int KEY = key.getKeyPre();
		if (KEY == 39) {
			hero.move(3, 0);
		} else if (KEY == 37) {
			hero.move(-3, 0);
		}
		key.resetAllKey();
		KEY = 0;
	}

	public void mouseClicked() {
		// TODO Auto-generated method stub
		if (mouse.getClick()) {
			mouse.setClickFalse();
			if (state == 0) {
				if (mouse.getPoint().getX() >= 10
						&& mouse.getPoint().getX() <= 10 + TX) {
					porteCilquee = 1;
					changeStateTo1();
				} else if (mouse.getPoint().getX() >= 2 * 10
						&& mouse.getPoint().getX() <= 2 * (10 + TX)) {
					porteCilquee = 2;
					changeStateTo1();
				} else if (mouse.getPoint().getX() >= 3 * 10
						&& mouse.getPoint().getX() <= 3 * (10 + TX)) {
					porteCilquee = 3;
					changeStateTo1();
				} else if (mouse.getPoint().getX() >= 4 * 10
						&& mouse.getPoint().getX() <= 4 * (10 + TX)) {
					porteCilquee = 4;
					changeStateTo1();
				}
				System.out.println("J'ai cliquer sur la porte " + porteCilquee
						+ " " + mouse.getPoint());

			} else if (state == 1) {
				pointer = mouse.getPoint();
				System.out.println(pointer);
				hero.setDestMagic(pointer);
				fBall = true;
			}
		}
	}
}
