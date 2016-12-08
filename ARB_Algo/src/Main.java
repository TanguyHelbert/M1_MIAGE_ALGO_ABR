public class Main {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		ArbreBinaireRecherche arbre1 = new ArbreBinaireRecherche(8, null, null);
		ArbreBinaireRecherche arbre2 = new ArbreBinaireRecherche(9, null, null);
		ArbreBinaireRecherche arbre3 = new ArbreBinaireRecherche(4, arbre1, arbre2);
		ArbreBinaireRecherche arbre4 = new ArbreBinaireRecherche(5, null, null);
		ArbreBinaireRecherche arbre5 = new ArbreBinaireRecherche(2, arbre3, arbre4);
		ArbreBinaireRecherche arbre6 = new ArbreBinaireRecherche(6, null, null);
		ArbreBinaireRecherche arbre7 = new ArbreBinaireRecherche(7, null, null);
		ArbreBinaireRecherche arbre8 = new ArbreBinaireRecherche(3, arbre6, arbre7);
		ArbreBinaireRecherche arbre9 = new ArbreBinaireRecherche(1, arbre5, arbre8);
		
		// Les trois parcours différents de l'arbre

		System.out.println("Le parcours préfixe donne :");
		ParcoursPrefixe(arbre9);
		System.out.println("");
		System.out.println("Le parcours infixe donne :");
		ParcoursInfixe(arbre9);
		System.out.println("");
		System.out.println("Le parcours postfixe donne :");
		ParcoursPostfixe(arbre9);

		// Nombre de noeuds de l'arbre

		System.out.println("");
		System.out.println("Le nombre de noeud(s) de l'arbre choisi est de : " + NbNoeud(arbre9));

		// Nombre de feuilles de l'arbre

		System.out.println("Le nombre de feuille(s) de l'arbre choisi est de : " + NbFeuilles(arbre9));

		// Si l'arbre est dégénéré ou non

		System.out.println("L'arbre choisi est il dégénéré ? : " + ArbreDegenere(arbre9));

		// Rechercher un élément dans l'arbre

		System.out.println("Recherche de \"2\" : " + Rechercher(arbre9, 2));

		// Si les deux arbres sont miroirs ou non - CETTE FONCTION NE SEMBLE PAS MARCHER...

		// System.out.println("Les deux arbres sont ils \"miroirs\" ? " + Miroir(arbre8, arbre9));
		
		// Rechercher la valeur max dans l'arbre

		System.out.println("La valeur max trouvée dans l'arbre est " + ValMax(arbre9));
		
		// Modifier la valeur du noeud d'un arbre donn�
		
		System.out.println("Modification de la valeur 6 par 4 - AVANT MODIFICATION");
		ParcoursPostfixe(arbre9);
		System.out.println("");
		ModifValeurNoeudArbre(arbre9, 6, 4);
		System.out.println("Modification de la valeur 6 par 4 - APRES MODIFICATION");
		ParcoursPostfixe(arbre9);
		System.out.println("");

	}
	


	public static void ParcoursPrefixe(ArbreBinaireRecherche a) {

		System.out.print(" " + a.racine().valeur);

		if (a.sag() != null) {
			ParcoursPrefixe(a.sag());
		}
		if (a.sad() != null) {
			ParcoursPrefixe(a.sad());
		}

	} 

	public static void ParcoursInfixe(ArbreBinaireRecherche a) {

		if (a.sag() != null){
			ParcoursInfixe(a.sag());
		}

		System.out.print(" " + a.racine().valeur);

		if (a.sad() != null){
			ParcoursInfixe(a.sad());
		}

	}

	public static void ParcoursPostfixe(ArbreBinaireRecherche a) {		

		if (a.sag() != null) {
			ParcoursPostfixe(a.sag());
		}
		if (a.sad() != null) {
			ParcoursPostfixe(a.sad());
		}

		System.out.print(" " + a.racine().valeur);

	}

	public static int NbNoeud(ArbreBinaireRecherche a ) {

		if(a == null) {
			return 0;
		}
		else {
			return 1 + NbNoeud(a.sag()) + NbNoeud(a.sad());
		}
	}

	public static int NbFeuilles(ArbreBinaireRecherche a) {

		if(a.sag() == null && a.sad() == null) {
			return 1;
		}
		else{
			return NbFeuilles(a.sag()) + NbFeuilles(a.sad());
		}
	}

	public int HauteurPlusUn(ArbreBinaireRecherche a) {

		if(a.estVide()) {
			return 0;
		}
		else{
			return 1 + Math.max(HauteurPlusUn(a.sag()),HauteurPlusUn(a.sad()) );
		}
	}

	public int hauteur(ArbreBinaireRecherche a ) {
		return (HauteurPlusUn(a)-1);
	}

	public static boolean ArbreDegenere(ArbreBinaireRecherche a) throws ArbreVideException {

		if(a.estVide()) {
			return false;
		}
		else if(a.sag()!=null ^ a.sad() != null) {
			return true;
		}
		else if(a.sag() == null) {
			return (ArbreDegenere(a.sad()));
		}
		else if(a.sad() == null) {
			return (ArbreDegenere(a.sag()));
		}
		return false; 
	}

	public static boolean Rechercher(ArbreBinaireRecherche a, Object e) throws ArbreVideException {

		if(a.estVide()) {
			return false;
		}
		if(a.racine().valeur().equals(e)) {
			return true;
		}
		else if(a.racine().valeur() != e) {
			return Rechercher(a.sag(), e);
		}
		else {
			return Rechercher(a.sad(), e);
		}
	}

	public static int ValMax(ArbreBinaireRecherche a) {
		
		if(a!=null && a.racine().valeur() != null) {
			
			int valeurNoeud= (Integer) a.racine().valeur();
			
			int maxG=0, maxD=0;
			
			if(a.sag() !=null)
				maxG = ValMax(a.sag());
			if(a.sad() !=null)
				maxD = ValMax(a.sad());
			return Math.max(valeurNoeud, Math.max(maxD,maxG));
		}
		return 0;
	}
	
	public static void ModifValeurNoeudArbre(ArbreBinaireRecherche a, Object ancienneVal, Object nouvelleVal) {
		
		if(a.racine().valeur().equals(ancienneVal)) {
			a.racine().setValeur(nouvelleVal);
		}
		else if(a.sag() != null) {
			ModifValeurNoeudArbre(a.sag(), ancienneVal, nouvelleVal);
		}
		if(a.sad() != null) {
			ModifValeurNoeudArbre(a.sad(), ancienneVal, nouvelleVal);
		}
	}

}
