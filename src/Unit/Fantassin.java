package Unit;

public class Fantassin extends Unit {

	// Un fantassin avec des caractéristique préparées à l'avance
	public Fantassin() {
		super();
		this.name = "Fantassin";
		this.pv = 135;
		this.combat = new Epee();
		this.armure = new Acier();
	}

	// Juste pour le fun ^^
	public Fantassin(float PV, String NAME) {
		super();
		this.name = NAME;
		this.pv = PV;
		this.combat = new Epee();
		this.armure = new Acier();
	}

}
