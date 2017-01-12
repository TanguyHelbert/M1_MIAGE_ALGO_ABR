package proj;

public class NoeudBinaire {

	private int valeur;

    private NoeudBinaire nd, ng;

    public NoeudBinaire(int valeur, NoeudBinaire nbd, NoeudBinaire nbg) {
      this.valeur = valeur;
      this.nd = nbd;
      this.ng = nbg;
    }

    public NoeudBinaire(int valeur) {
      this.valeur = valeur;
      this.nd = null;
      this.ng = null;
    }
    
    public NoeudBinaire() {
        this(-1, null, null);
    }
    
    public boolean estVide() {
    	return this.valeur == -1;
    }

    public int getValeur() {
      return valeur;
    }

    public NoeudBinaire getNd() {
      return nd;
    }

    public NoeudBinaire getNg() {
      return ng;
    }

    public void supprNoeudBinaire() {
        if(this.ng != null || this.nd != null){
        	System.out.println("Vous ne pouvez pas supprimer ce noeud, il possede des fils");
        } else {
        	this.valeur = -1;
        }
        	
    }
    
    public void setNd(NoeudBinaire nbd) {
      this.nd = nbd;
    }

    public void setNg(NoeudBinaire nbg) {
      this.ng = nbg;
    }
	
    @Override
    public String toString() {
    	String result = "";
    	if (ng != null && nd != null){
    		result = "[Noeud : " + valeur +" ; fils gauche : " + ng + " ; fils droit : " + nd + "]";
    	} else if (ng != null && nd == null){
    		result = "[Noeud : " + valeur +" ; fils gauche : " + ng + "]";
    	} else if (ng == null && nd != null){
    		result = "[Noeud : " + valeur +" ; fils droit : " + nd + "]";
    	} else {
    		result = "[Noeud : " + valeur +"]";
    	}
      return result;
    }
    
    /**
	 * Fonction permettant de recuperer la profondeur du fils gauche ou droit du noeud
	 * @param nb noeud a regarder
	 * @param sag indique si on regarde le fils gauche ou le droit
	 * @return renvoit la profond du sous arbre
	 */
	public int profondeur(boolean sag){
		int prof = 0;
		
		if (this.valeur == -1){
			prof = -1;
		} else {
			prof = (sag) ? profondeurRecursif(this.ng)-1 : profondeurRecursif(this.nd)-1;
		}
		
		//prof = (nb == null) ? -1 : (profondeurRecursif(nb.getNg())-1) - (profondeurRecursif(nb.getNd())-1);
		
		return prof;
	}
	
	private int profondeurRecursif(NoeudBinaire nb) {
		if (nb == null)
		    return 0;
		else
			return (1 + profondeurRecursif(nb.getNg()) + profondeurRecursif(nb.getNd()));
	}
}
