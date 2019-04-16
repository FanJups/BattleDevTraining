
package com.isograd.exercise;
import java.util.*;

// masse max admise  monte charge <= 100


public class IsoContest {
public static void main( String[] argv ) throws Exception {
		String  line;
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		
		Map<Integer,Integer> cartonsSol = new HashMap<>();
		Map<Integer,Integer> cartonsMonteCharge = new HashMap<>();
		Map<Integer,Integer> cartonsEtage = new HashMap<>();

		int i=0;
		while(sc.hasNextLine()) {
			line = sc.nextLine();
			/* Lisez les données et effectuez votre traitement */ 

			cartonsSol.put(i,Integer.parseInt(line));

			i++;

		}

		

		

		
	/* Vous pouvez aussi effectuer votre traitement une fois que vous avez lu toutes les données.*/
	}

}