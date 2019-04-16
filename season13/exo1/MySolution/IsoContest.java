
package com.isograd.exercise;
import java.util.*;


public class IsoContest {
public static void main( String[] argv ) throws Exception {
		String  line;
		Scanner sc = new Scanner(System.in);
		int rank = Integer.parseInt(sc.nextLine());
		String montant="KO";
		while(sc.hasNextLine()) {
			line = sc.nextLine();
			int avant = Integer.parseInt(line.split(" ")[0]); 
			int derr = Integer.parseInt(line.split(" ")[1]); 
			/* Lisez les données et effectuez votre traitement */

			rank = rank + avant - derr;
		}

		if(rank<=100)
			montant="1000";
			
		else
			if(rank<=10000)
				montant="100";
			

		System.err.println(rank);


		System.out.println(montant);
	/* Vous pouvez aussi effectuer votre traitement une fois que vous avez lu toutes les données.*/
	}
}