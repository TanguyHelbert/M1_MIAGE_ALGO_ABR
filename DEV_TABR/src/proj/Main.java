package proj;

import java.util.ArrayList;

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
		System.out.println("Creation du TABR par fichier :");
		System.out.println(listeABR.fichierVersTABR("txt/test.txt"));
		System.out.println("Lecture suffixe premier ABR :");
		System.out.println(listeABR.getTabr().get(0).getAbr().parcoursSuffixe());
		System.out.println(listeABR.ABRversFichier("txt/testSauv.txt"));
		System.out.println("Affichage :");
		System.out.println(listeABR.affichage());
		System.out.println("Insertion dans TABR (hors interv) :");
		System.out.println(listeABR.insertTABR(7));
		System.out.println("Insertion dans TABR (existe) :");
		System.out.println(listeABR.insertTABR(3));
		System.out.println("Insertion dans TABR (vrai) :");
		System.out.println(listeABR.insertTABR(79));
		System.out.println("Affichage :");
		System.out.println(listeABR.affichage());
		System.out.println("Suppresion dans TABR (hors interv) :");
		System.out.println(listeABR.supprTABR(7));
		System.out.println("Suppression dans TABR (existe pas) :");
		System.out.println(listeABR.supprTABR(66));
		System.out.println("Suppression dans TABR (vrai) :");
		System.out.println(listeABR.supprTABR(14));
		System.out.println("Affichage :");
		System.out.println(listeABR.affichage());
		System.out.println("Fusion de deux cases (hors interv)");
		System.out.println(listeABR.fusionCase(6));
		System.out.println("Fusion de deux cases (max)");
		System.out.println(listeABR.fusionCase(3));
		System.out.println("Fusion de deux cases (vrai)");
		System.out.println(listeABR.fusionCase(1));
		System.out.println("Affichage :");
		System.out.println(listeABR.affichage());
		System.out.println("Equilibre correct");
		System.out.println(listeABR.estEquilibreProf(2));
		System.out.println("Equilibre incorrect");
		System.out.println(listeABR.estEquilibreProf(1));
		ArbreBinaireRecherche abr = new ArbreBinaireRecherche(13);
		abr.insere(16);abr.insere(10);abr.insere(5);abr.insere(24);abr.insere(20);		
		ArrayList<Integer> bornesB = new ArrayList<Integer>(){{add(1);add(17);add(9);add(15);add(-1);add(40);}};
		listeABR = new TabABR();
		System.out.println("Creation d'un TABR via un ABR");
		System.out.println(listeABR.ABRversTABR(abr,bornesB));
		System.out.println("Creation d'un ABR regroupant tout le TABR");
		System.out.println(listeABR.TABRversABR());
		System.out.println("");
		System.out.println(listeABR.generateRandomTABR(10,80));
		System.out.println(listeABR.affichage());
	}
	
}
