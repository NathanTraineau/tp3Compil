import java.awt.List;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Recherche {

	public static final String[] lettres = {"a","c","g"};
	public static final String motif = "agagaca";
	
	public static void main(String[] args) {
		
		int[][] resultat = new int[lettres.length][motif.length()+1];
		
		
		for(int i=0;i<motif.length()+1;i++){
			for(int j=0;j<lettres.length;j++){
				String Mi = motif.substring(0, i);				
				String Mil = Mi+lettres[j];
				resultat[j][i]  = prefixpluslong(motif,Mil);		
			}
		}
		
		for (int i = 0; i<lettres.length;i++){
			for (int j = 0;j<motif.length()+1;j++){
				System.out.print(resultat[i][j]);
			}
			System.out.print("\n");
		}
	}
	
	public static int prefixpluslong(String mot, String mil){
		int res =0;
		boolean check = false;
		int i = 0;
			while( i<mot.length() && !check){
				String prefixe = mot.substring(0,mot.length() -i);
				if(isSuffixe(mil,prefixe)){
					res= prefixe.length();
					check = true;
				}
				i++;
			
			}
		return res;
	}
	
	public Hashtable<Integer,String>  transitions(ArrayList<String>enCours,Set<String> lettresUneFois, String lettre){
		// renvoie les transitions possibles
		Hashtable<Integer,String> transitions= new Hashtable<Integer,String>(); 
		// si pas prochaine lettre du motif on regarde 
					//où dans motif peut recommencer avec cette lettre
					java.util.Iterator<String> it = enCours.iterator();
					//ArrayList<String> parcours = new ArrayList<String>();
					for (int j = 0; it.hasNext() ; j ++) {
						String nxt = it.next();
						parcours.add(nxt);
					    //un etat tel que entre cet etat et l'actuel ca fasse entre le début et cet état
						java.util.Iterator<String> it2 = parcours.iterator();
						if ()
		return transitions;
	}
	
	
	public void automate(String motif){
		
		)
		Hashtable<Integer,Hashtable<Integer,String>> tab = new Hashtable<Integer,Hashtable<Integer,String>>();
		String[] lettres = motif.split("");
		Set<String> lettresUneFois;
		ArrayList<String> enCours = new ArrayList<String>();
		int i =0;
		for (String lettre : lettres){
			lettresUneFois.add(lettre);
			i++;
			enCours.add(lettre);
			
			}
			
			tab.put(i++,transitions);
		}
	}

	public static boolean isSuffixe(String mil,String prefixe){
		if (mil.length() < prefixe.length() ){
			return false;
		}
		else {
			return (prefixe.equals(mil.substring(mil.length() - prefixe.length())));
		}
		
	}

}
