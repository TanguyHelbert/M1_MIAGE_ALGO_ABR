package proj;

public class Case {
	private int min;
	private int max;
	private ArbreBinaireRecherche abr;
	
	public Case(int min, int max) {
		// Vérification de l'ordonnement croissant
		if(min > max){
			this.min = max;
			this.max = min;
			System.out.println("La première de l'intervalle était trop grande elle a échangée de place avec la deuxième");
		} else {
			this.min = min;
			this.max = max;
		}
		this.abr = new ArbreBinaireRecherche();
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
		if(this.min > this.max)
			this.max++;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public ArbreBinaireRecherche getAbr() {
		return abr;
	}

	public void setAbr(ArbreBinaireRecherche abr) {
		this.abr = abr;
	}
}