package proj;

import java.io.*;
import java.util.ArrayList;

public class TABR_FAKE {

	private String fi;
	private ArrayList<int[]> allInter;
	private int[] intervalle;
	private ArbreBinaireRecherche abr;

	public TABR_FAKE(String fi) {
		this.allInter = new ArrayList<>();
		this.fi = fi;
		analyseFichier();
	}
	
	private void analyseFichier(){
		this.intervalle = new int[2];
		this.abr = new ArbreBinaireRecherche();
		String ligne = "";
		String[] interArbre;
		String inter = "";
		String[] valInter;
		String arbre = "";
		String[] valArbre;
		int maxBorne = 0;
		int indexInterv = 0;
		
		try{
			// Parcours pour les intervalles
			InputStream ips=new FileInputStream(this.fi); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
						
			while ((ligne=br.readLine())!=null){
				interArbre = ligne.split(";");	// Récupération de la ligne de texte splitté
				inter = interArbre[0];			// Récupération de la partie intervalle
				valInter = inter.split(":");	// Splitt de la liste d'intervalle par :
				this.intervalle = new int[2];	// Ré-initialisation de l'intervalle
				this.intervalle[0] = Integer.parseInt(valInter[0]);
				this.intervalle[1] = Integer.parseInt(valInter[1]);
				// Vérification de l'ordonnement croissant
				if(this.intervalle[0] > this.intervalle[1]){
					this.intervalle[0] = Integer.parseInt(valInter[1]);
					this.intervalle[1] = Integer.parseInt(valInter[0]);
					System.out.println("La première de l'intervalle était trop grande elle a échangée de place avec la deuxième");
				}
				// Ajout dans tous les intervalles
				if(this.allInter.size()==0){
					this.allInter.add(this.intervalle);
				} else {
					System.out.println("derniere val : " + this.allInter.get(this.allInter.size()-1)[1]);
					// Vérification de l'ordonnement croissant sur l'intervalle précédent
					if(this.allInter.get(this.allInter.size()-1)[1] > this.intervalle[0]) {
						this.intervalle[0] = this.allInter.get(this.allInter.size()-1)[1] + 1;
						if(this.intervalle[0] > this.intervalle[1])
							this.intervalle[1]++;
					}
					this.allInter.add(this.intervalle);
				}
				for(int i = 0 ; i < this.allInter.size() ; i++){
					System.out.println("intervalles : " + this.allInter.get(i)[0] + " ; " + this.allInter.get(i)[1]);
				}
			}
			br.close(); 
			
			// Parcours pour les arbres
			ips=new FileInputStream(this.fi); 
			ipsr=new InputStreamReader(ips);
			br=new BufferedReader(ipsr);
			
			indexInterv = 0;
			while ((ligne=br.readLine())!=null){
				interArbre = ligne.split(";");
				arbre = interArbre[1];
				valArbre = arbre.split(":");
				maxBorne = valArbre.length -1;
				for (int i = maxBorne ; i >= 0; i--){
					if(i == maxBorne)
						this.abr = new ArbreBinaireRecherche();
					if(Integer.parseInt(valArbre[i]) >= this.allInter.get(indexInterv)[0] && Integer.parseInt(valArbre[i]) <= this.allInter.get(indexInterv)[1])
						this.abr.insere(Integer.parseInt(valArbre[i]));
					else
						System.out.println("Nombre " + valArbre[i] + " n'appartient pas à l'intervalle : [" + this.intervalle[0] + " ; " + this.intervalle[1] + "]");
				} 
				System.out.println(this.abr.getRacine().toString());
				indexInterv++;
			}
			br.close();
		} catch (Exception e){
			System.out.println(e.toString());
		}
	}	
}