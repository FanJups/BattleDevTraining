
package com.isograd.exercise;
import java.util.*;

// masse max admise  monte charge <= 100


public class IsoContest {
public static void main( String[] argv ) throws Exception {
		String  line;
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		
		Map<Integer,Integer> cartonsSol = new HashMap<>();
		
		Map<Integer,Integer> cartonsEtage = new HashMap<>();

		// LinkedHashMap preserve the ordering of elements in which they are inserted
		LinkedHashMap<Integer, Integer> sortedCartonsSol = new LinkedHashMap<>();

		int masse =0; // Maase monte charge

		int ar=0; // nbre aller retour

		int i=0;
		while(sc.hasNextLine()) {
			line = sc.nextLine();
			/* Lisez les données et effectuez votre traitement */ 

			cartonsSol.put(i,Integer.parseInt(line));

			i++;

		}

		// cartons au sol par ordre de masse croissante

		cartonsSol.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEachOrdered(x -> sortedCartonsSol.put(x.getKey(), x.getValue()));


		for(int j=0;j<sortedCartonsSol.size();j++)
		{
			

				masse = masse + sortedCartonsSol.get(j); // je mets le carton sur le monte charge

				if(masse>100)
				{
					// alarme sonne

					masse = masse - sortedCartonsSol.get(j); // j'enlève le carton du monte charge

					ar++; // aller retour

					masse=0; // je vide le monde charge

					masse = masse + sortedCartonsSol.get(j); // je mets le carton laissé précédemment sur le monte charge

					cartonsEtage.put(j,sortedCartonsSol.get(j)); // le carton est sur le monte charge pour aller à l'étage

					/*

						Si il reste un seul carton , je le fais monter
					*/

					if(j== sortedCartonsSol.size()-1) 
						ar++;


				}else{

					cartonsEtage.put(j,sortedCartonsSol.get(j));

					/*

						Si il reste un seul carton , je le fais monter
					*/

					if(j== sortedCartonsSol.size()-1)
						ar++;

					
				}

		}


		System.err.println("Etage : "+cartonsEtage.size());

		System.err.println("N: "+N);

		if(cartonsEtage.size()==N)
			System.out.println(ar);
		else
			System.err.println("ERROR");



	/* Vous pouvez aussi effectuer votre traitement une fois que vous avez lu toutes les données.*/
	}
		

}