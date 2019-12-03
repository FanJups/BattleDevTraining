
package com.isograd.exercise;
import java.util.*;  


public class IsoContest {
public static void main( String[] argv ) throws Exception {
		String  line;
		String  line2NPlus1;
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine()); 
		line2NPlus1=sc.nextLine();
		String prenom = line2NPlus1.split(" ")[0]; 
		int min = Integer.parseInt(line2NPlus1.split(" ")[1]); 
		
		while(sc.hasNextLine()) {
			line = sc.nextLine();
			int taille = Integer.parseInt(line.split(" ")[1]);
			
			if(min>taille)
			{
				min =taille;
				prenom = line.split(" ")[0];
			}
			
		}

		System.out.println(prenom);
		
		}
	/* Vous pouvez aussi effectuer votre traitement une fois que vous avez lu toutes les données.*/
	}
