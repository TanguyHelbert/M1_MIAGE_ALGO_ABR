package proj;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ArbreBinaireRecherche abr1 = new ArbreBinaireRecherche();
//		
//		System.out.println("avant tostring");
//		
//		System.out.println(abr1.getRacine().toString());
//		
//		System.out.println("apres tostring");
//		
//		abr1.insere(3);
//		abr1.insere(4);
//		abr1.insere(2);
//		abr1.insere(5);
//		
//		System.out.println(abr1.getRacine().toString());
		
		TabABR listeABR = new TabABR();
//		listeABR.fichierABR("/comptes/E134287P/M1_MIAGE/algo_proj/test.txt");
//		System.out.println(listeABR.getTabr().get(0).getAbr().parcoursSuffixe());
//		//listeABR.abrFichier("/comptes/E134287P/M1_MIAGE/algo_proj/testSauv.txt");
//		System.out.println("aff");
//		listeABR.affichage();
		
		listeABR = aleaTABR(10,80);
		listeABR.affichage();
		listeABR = aleaTABR(9,80);
		listeABR.affichage();
	}
	
	public static TabABR aleaTABR(int n, int m){
		TabABR tabalea = new TabABR();	// TABR aléatoire
		Case c;
		int min = 1;					// Intervalle minimal
		int max = 0;					// Intervalle maximal
		int tailleInterv;				// Taille de l'intervalle
		
		tailleInterv = (int) Math.ceil((double)m/(double)n);
		
		System.out.println(m + " " +  n + " taille " + tailleInterv);
		
		for(int i = 0 ; i < n ; i++) {
			max += tailleInterv;
			c = new Case(min,max);
			tabalea.getTabr().add(c);
		}
		
		return tabalea;
	}

}
