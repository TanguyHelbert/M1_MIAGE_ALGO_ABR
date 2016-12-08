package proj;

import java.io.*;

public class TABR {

	private String fi;
	private int[] intervalle;
	private ArbreBinaireRecherche abr;

	public TABR(String fi) {
		this.fi = fi;
		analyseFichier();
	}
	
	private void analyseFichier(){
		String ligne = "";
		String chaine = "";
		String[] interArbre;
		String inter = "";
		String arbre = "";
		
		try{
			InputStream ips=new FileInputStream(this.fi); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			
			while ((ligne=br.readLine())!=null){
				interArbre = ligne.split(";");
				inter = interArbre[0];
				arbre = interArbre[1];
								
				System.out.println(inter);
				System.out.println(arbre);
				chaine+=ligne+"\n";
			}
			br.close(); 
		} catch (Exception e){
			System.out.println(e.toString());
		}
	}	
}
