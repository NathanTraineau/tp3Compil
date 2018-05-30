import java.io.*;
import java.util.*;

public class AlgorithmeAutomate{

	public List<Integer> positions(String txt, String motif, char langage []){		//renvoie une liste d'integer avec les positions où sont le motif dans le texte selon un langage		int tab [][] = new int[langage.length][motif.length()+1];		tab = this.transitionTable(langage, motif);		int etat=0;		List<Integer> res = new ArrayList<Integer>();		// res est la liste des différentes positions du motif dans txt		for(int i=0; i<txt.length(); i++){			if(this.dansLangage(txt.charAt(i),langage)){				int pos = this.positionLettre(txt.charAt(i),langage);				etat=tab[pos][etat];				if(etat==motif.length()){					res.add(i-motif.length()+2);				}			}			else{				etat=0;			}		}		return res;	}

	private boolean estPrefixe(String test, String motif){		//renvoie true si la chaine string test est préfixe du motif
		boolean prefixe = true;
		int i=0;
		if(test.length()>motif.length()){
			prefixe=false;
		}
		else{
			while(i<test.length() && prefixe){
				if(test.charAt(i)!=motif.charAt(i)){
					prefixe=false;
				}
				i+=1;
			}
		}
		return prefixe;
	}	
	private int positionLettre(char l, char langage[]){		// positionLettre( lettre recherché , le langage où l'on cherche la lettre  )		//Renvoie la position de la lettre dans le langage
		boolean trouve=false;
		int i=0;
		while(!trouve && i<langage.length){
			if(l==langage[i]){
			trouve=true;
			}
			i+=1;
		}
		return i-1;
	}

	private boolean dansLangage(char l, char langage[]){		//renvoie true si la lettre result au langage
		boolean result = false;
		int i=0;
		while(!result && i<langage.length){
			if(l==langage[i]){
				result=true;
			}
			i+=1;
		}
		return result;
	}////////////////////////////// Table de transition //////////////////////////////
	private int [][] transitionTable(char langage [], String motif){		int tab [][] = new int[langage.length][motif.length()+1]; //		for(int i=0; i<langage.length; i++){			for(int j=0; j<motif.length()+1; j++){				String test ="";					for(int k=0; k<j; k++){					test=test+motif.charAt(k);				}				test=test+langage[i];				boolean estPrefixe = false;				int p = j+1;				while(test.length()!=0 && !estPrefixe){					if(estPrefixe(test,motif)){						tab[i][j]=p;						estPrefixe=true;					}					test=test.substring(1);					p-=1;				}		}		}		return tab;	}	//////////////////////////////Main //////////////////////////////
	public static void main (String[] args){
		motif2automate automate = new motif2automate();
		char langage [] = {'A','C','G','T'};
		try{
					BufferedReader chr = new BufferedReader(new FileReader("chr22.fa"));
					String txt = "";
					String tmp= "";
			while((tmp=chr.readLine())!=null){
						txt+=tmp;
			}
			chr.close();
			txt=txt.toUpperCase();
			txt=txt.replaceAll("\n","");
			txt=txt.substring(6);
			Writer gen = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("genome.txt"), "utf-8"));
			gen.write(txt);
			String motif="";
			BufferedReader bufferMotif = new BufferedReader(new FileReader("tags.txt"));
			String res = "";
			while((motif = bufferMotif.readLine()) !=null){
							motif=motif.toUpperCase();
							List<Integer> tab = new ArrayList<Integer>();
							tab= automate.positions(txt, motif, langage);
							res+=motif;
							res+=": ";
							System.out.print(motif+" ");
							for(int i=0; i<tab.size(); i++){
										System.out.print(tab.get(i)+" ");
										res+=String.valueOf(tab.get(i));
										res+="  ";
							}
							res+="\n";
							System.out.println();
			}
			bufferMotif.close();
			try {
							FileWriter file = new FileWriter("resultat.txt");
							file.append(res);
							file.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		} catch(FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
	}
}
