package Unit;

public class Acier implements Armure {

	// une armure avec une valeur de reduction de 50%
	public float redArmor(float dommage) {
		float armure = 25;
		float dmg = dommage * (50 - armure) / 50;
		return dmg;
	}

}
