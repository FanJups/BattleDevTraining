

/*************************************
Solution by Jean-Michel
****************************************/
package com.isograd.exercise;
import java.util.*;

public class IsoContest {
public static void main( String[] argv ) throws Exception {
		String  line;
		Scanner sc = new Scanner(System.in);
		line = sc.nextLine();
		int nbMots = 0;
		char[] voyelle = {'a', 'e', 'i', 'o', 'u', 'y'};
		Set<String> set = new HashSet<String>();

		while(sc.hasNextLine()) {
			line = sc.nextLine();
			
			if (line.length() >= 5 && line.length() <= 7) {
			    
			    System.err.println(line + "-longueur = "+line.length());
			    if (line.charAt(1)==(char)(line.charAt(0)+1)) {
			    System.err.println(line + "-caractères se suivent");
			        for (int i = 0; i < 6; i++) {
    			        if (line.charAt(line.length()-1) == voyelle[i]) {
    			            set.add(line);
    			            System.err.println(line + "-voyelle");
    			            break;
    			        }
			        }
			    }
			}
			
			/* Lisez les données et effectuez votre traitement */
		}
		
		System.out.println(set.size());
	/* Vous pouvez aussi effectuer votre traitement une fois que vous avez lu toutes les données.*/
	}
}


