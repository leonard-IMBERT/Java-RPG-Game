package Unit;

public class Epee implements Combat {

	// Une arme de 35 dmg (avant reduction due à l'armure)
	public void combat(Unit victim, Unit Attack) {
		float dmg = 35;
		victim.takeDamage(dmg);
		dmg = victim.armure.redArmor(dmg);
		System.out.println("L'unitée " + Attack.name + " a infligée " + dmg
				+ " points de dégats à " + victim.name);
	}

}
