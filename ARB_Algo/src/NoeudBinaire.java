public class NoeudBinaire {

	public Object valeur;
	protected ArbreBinaireRecherche sag, sad;

	public NoeudBinaire(Object e, ArbreBinaireRecherche g, ArbreBinaireRecherche d) {
		valeur=e;
		sag=g;
		sad=d;
	}

	public NoeudBinaire(Object e) {
		valeur=e;
		sag=sad=ArbreBinaireRecherche.arbreVide;
	}

	public Object valeur() {
		return valeur;
	}

	public void setValeur(Object valeur) {
		this.valeur = valeur;
	}

	public void changerValeur(Object e) {
		valeur=e;
	}

}
