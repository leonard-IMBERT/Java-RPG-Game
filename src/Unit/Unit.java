package Unit;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

//Abstract car elle n'est pas  destinée à être instancié
public abstract class Unit {

	// les différentes variables et objet appartenant à Unit
	protected float pv;
	protected String name;
	protected Armure armure = new Tissu();
	protected Combat combat = new MainNue();
	protected int posX;
	protected int posY;
	protected Image sprite;

	// Juste pour savoir combien on en à
	public static int pop;
	private static int popBis;

	// Constructeur de base
	public Unit() {
		pop++;
		popBis++;
		System.out.println("Une nouvelle unitée à été crée !");
	}

	// Avoir le nom de l'unitée
	public String getName() {
		return name;
	}

	// Avoir ses PVs
	public float getPv() {
		return pv;
	}

	// Perdre des pv. Fait appel à la fonction redArmor de son armure.
	protected void takeDamage(float dmg) {
		pv = pv - armure.redArmor(dmg);
	}

	// Attaquer, appel la fonction combat de son type de combat
	public void attack(Unit victim) {
		combat.combat(victim, this);
	}

	// Avoir une valeur plus fiable car popBis est private
	public static int getPopBis() {
		return popBis;
	}

	protected void setImage(String path) {
		try {
			sprite = ImageIO.read(new File(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
