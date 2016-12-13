package proj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class TabABR {
	private ArrayList<Case> tabr;
	
	public TabABR() {
		this.tabr = new ArrayList<>();
	}
	
	public void fichierABR(String file){
		Case c;
		int precMax;
		String ligne = "";
		String[] interArbre;
		String inter = "";
		String[] valInter;
		String arbre = "";
		String[] valArbre;
		int maxBorne = 0;
		int indexCase = 0;
		
		try{
			// Parcours pour les intervalles
			InputStream ips=new FileInputStream(file); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
						
			while ((ligne=br.readLine())!=null){
				interArbre = ligne.split(";");	// Récupération de la ligne de texte splitté
				inter = interArbre[0];			// Récupération de la partie intervalle
				valInter = inter.split(":");	// Splitt de la liste d'intervalle par :
				c = new Case(Integer.parseInt(valInter[0]),Integer.parseInt(valInter[1]));
				if(this.tabr.size()==0){
					this.tabr.add(c);
				} else {
					precMax = this.tabr.get(this.tabr.size()-1).getMax();
					System.out.println("derniere val : " + precMax);
					// Vérification de l'ordonnement croissant sur l'intervalle précédent
					if(precMax > c.getMin())
						c.setMin(++precMax);
					this.tabr.add(c);
				}
				for(int i = 0 ; i < this.tabr.size() ; i++){
					System.out.println("intervalles : " + this.tabr.get(i).getMin() + " ; " + this.tabr.get(i).getMax());
				}
			}
			br.close(); 
			
			// Parcours pour les arbres
			ips=new FileInputStream(file); 
			ipsr=new InputStreamReader(ips);
			br=new BufferedReader(ipsr);
			
			indexCase = 0;
			while ((ligne=br.readLine())!=null){
				c = this.tabr.get(indexCase);
				interArbre = ligne.split(";");
				arbre = interArbre[1];
				valArbre = arbre.split(":");
				maxBorne = valArbre.length -1;
				for (int i = maxBorne ; i >= 0; i--){
					if(Integer.parseInt(valArbre[i]) >= c.getMin() && Integer.parseInt(valArbre[i]) <= c.getMax())
						c.getAbr().insere(Integer.parseInt(valArbre[i]));
					else
						System.out.println("Nombre " + valArbre[i] + " n'appartient pas à l'intervalle : [" + c.getMin() + " ; " + c.getMax() + "]");
				} 
				System.out.println(c.getAbr().getRacine().toString());
				indexCase++;
			}
			br.close();
			
		} catch (Exception e){
			System.out.println(e.toString());
		}
	}
	
	public void abrFichier(String file){
		try{
			OutputStream ops=new FileOutputStream(file); 
			OutputStreamWriter opsw=new OutputStreamWriter(ops);
			String ligne = "";
			
			for(int i = 0 ; i < this.tabr.size() ; i++) {
				
				ligne = String.format(ligneFichier(i) + "%s",System.getProperty("line.separator"));
				opsw.write(ligne);
				opsw.flush();
			}
		} catch (Exception e){
			System.out.println(e.toString());
		}
	}
	
	public void affichage(){
		for(int i = 0 ; i < this.tabr.size() ; i++) {
			System.out.println(ligneFichier(i));
		}
	}
	
	public String ligneFichier(int i){
		String intervalle = "";
		String abr = "";
		
		intervalle = this.tabr.get(i).getMin() + ":" + this.tabr.get(i).getMax();
		abr = this.tabr.get(i).getAbr().parcoursSuffixe();
		
		return intervalle + ";" + abr;
	}

	public ArrayList<Case> getTabr() {
		return tabr;
	}

	public void setTabr(ArrayList<Case> tabr) {
		this.tabr = tabr;
	}
}