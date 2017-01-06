package proj;

public class Case {
	private int debut;
	private int fin;
	private ArbreBinaireRecherche abr;
	
	public Case(int debut, int fin) {
		// Vérification de l'ordonnement croissant
		if(debut > fin){
			this.debut = fin;
			this.fin = debut;
			System.out.println("La premiere de l'intervalle etait trop grande elle a echange de place avec la deuxieme");
		} else {
			this.debut = debut;
			this.fin = fin;
		}
		this.abr = new ArbreBinaireRecherche();
	}

	public int getDebut() {
		return this.debut;
	}

	public void setDebut(int debut) {
		this.debut = debut;
		if(this.debut > this.fin)
			this.fin++;
	}

	public int getFin() {
		return this.fin;
	}

	public void setFin(int fin) {
		this.fin = fin;
	}

	public ArbreBinaireRecherche getAbr() {
		return abr;
	}

	public void setAbr(ArbreBinaireRecherche abr) {
		this.abr = abr;
	}
}
