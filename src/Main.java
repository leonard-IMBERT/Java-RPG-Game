public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// J'instancie la fenêtre
		Fenetre fenetre = new Fenetre(900, 400);
		boolean click = false; // est-ce que l'on a clicker sur une porte
		boolean finish = false;
		int nbSalles = 0; // Objectifs: finir 12 salles :p
		int etat = 0; // 0=choix de la salle 1=Dans la salle
		int FPS = 60;
		long targetTime = 1000 / FPS;

		// La salle n°0 correspond au menu

		while (nbSalles != 12) {
			long start;
			long elapsed;
			long wait;
			if (etat == 0) {
				fenetre.salle.genererSalle();

				while (click != true) {
					fenetre.salle.afficher(fenetre.getGraphics());
					click = fenetre.salle.inSalle();
					fenetre.salle.mouseClicked();
				}
				System.out.println(click);
				click = true;
				etat = 1;
			}
			if (etat == 1) {
				start = System.nanoTime();
				
				click = fenetre.salle.inSalle();
				fenetre.salle.mouseClicked();
				fenetre.salle.move();
				fenetre.salle.afficher(fenetre.getGraphics());
				
				elapsed = System.nanoTime() - start;
				
				wait = targetTime - elapsed / 1000000;
				if(wait < 0) wait = 5;
				
				try {
					Thread.sleep(wait);
				}
				catch(Exception e) {
					e.printStackTrace();
				}	
				
			}
		}
	}
}
