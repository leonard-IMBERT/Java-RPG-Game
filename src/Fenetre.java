import javax.swing.JFrame;

public class Fenetre extends JFrame {

	private static final long serialVersionUID = 1L;

	public Salle salle = new Salle(this);

	// Constructeur de base
	public Fenetre() {
		this.setTitle("Ducon, t'a mal déclaré :p");
		this.setSize(888, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);

	}

	// Constructeur avec les propriétées taille X et Y
	public Fenetre(int X, int Y) {
		this.setTitle("Rogue Like Clément - Programme par Léonard");
		this.setSize(X, Y);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		this.setContentPane(salle);
	}

	public void refresh(Salle pan) {
		salle = pan;
		salle.repaint();
	}
}
