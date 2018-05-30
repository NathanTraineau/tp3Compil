import java.io.*;
import java.util.*;

public class AlgorithmeAutomate{



	private boolean estPrefixe(String test, String motif){
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
	private int positionLettre(char l, char langage[]){
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

	private boolean dansLangage(char l, char langage[]){
		boolean result = false;
		int i=0;
		while(!result && i<langage.length){
			if(l==langage[i]){
				result=true;
			}
			i+=1;
		}
		return result;
	}
	private int [][] transitionTable(char langage [], String motif){
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