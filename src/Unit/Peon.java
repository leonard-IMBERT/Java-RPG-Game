package Unit;

public class Peon extends Unit {

	// Ici MainNue veut dire aucune attaque ==> MainNue
	public Peon() {
		super();
		this.name = "Peon";
		this.combat = new MainNue();
		this.pv = 100;
	}

}
