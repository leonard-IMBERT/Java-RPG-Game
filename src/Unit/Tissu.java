package Unit;

public class Tissu implements Armure {

	
	// Une armure avec une valeur de reduction 20%
	public float redArmor(float dommage) {
		float armure = 10;
		float dmg = dommage * (50 - armure) / 50;
		return dmg;
	}

}
