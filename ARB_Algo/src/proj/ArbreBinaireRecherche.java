package proj;

public class ArbreBinaireRecherche{
	
	private NoeudBinaire racine;
	
	
	public ArbreBinaireRecherche(int e) {
	    this.racine = new NoeudBinaire(e);
	}

	public ArbreBinaireRecherche() {
	    this.racine = new NoeudBinaire();
	}

	public NoeudBinaire getRacine() {
		return racine;
	}

	public void setRacine(NoeudBinaire racine) {
		this.racine = racine;
	}
	
	public void insere(int elt) {
		if (elt < 0)
			throw new IllegalArgumentException("Un ABR ne contient que des élements positifs");
		    
		if (racine.getValeur() == -1)
			racine = new NoeudBinaire (elt);
		else
			insereRecursif(elt, racine);
	}

	  /**
	   * Insère un élément à partir d'un noeud.
	   * Si l'élément est &lt; à la valeur du noeud, il est inséré dans l'arborescence
	   * du sous-noeud gauche, sinon il est inséré à partir du sous-noeud droit.
	   * Pré-condition : le noeud n'est pas <code>null</code>.
	   * @param elt E l'élément à insérer
	   * @param n Noeud le noeud dans l'arborescence duquel elt sera inséré.
	   */
	  private void insereRecursif(int elt, NoeudBinaire n) {
	    if (n.getValeur() < elt){
	      if (n.getNd() == null)
	        n.setNd(new NoeudBinaire (elt));
	      else
	        insereRecursif(elt, n.getNd());
	    } else {
	      if (n.getNg() == null)
	    	  n.setNg(new NoeudBinaire (elt));
	      else
	    	  insereRecursif(elt, n.getNg());
	    }
	  }

}