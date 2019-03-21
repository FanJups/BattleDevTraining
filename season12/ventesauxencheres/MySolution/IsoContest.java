/*******
 * Read input from System.in
 * Use: System.out.println to ouput your result to STDOUT.
 * Use: System.err.println to ouput debugging information to STDERR.
 * ***/

// NOT OK
package com.isograd.exercise;
import java.util.*;
import java.util.Map;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.function.Predicate;

public class IsoContest {
public static void main( String[] argv ) throws Exception {
		String  line;
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		int prixBase= Integer.parseInt(sc.nextLine());

		List<EnchereEncherisseur> list = new ArrayList<>();
		
		while(sc.hasNextLine()) {
			line = sc.nextLine();
			EnchereEncherisseur elt = new EnchereEncherisseur(Integer.parseInt(line.split(" ")[0]) , line.split(" ")[1] );
			list.add(elt);
		}
	/* Vous pouvez aussi effectuer votre traitement une fois que vous avez lu toutes les données.*/

	// predicate 
		Predicate<EnchereEncherisseur> enchereCorrect = e -> e.getEnchere() > prixBase ;
		try {

			// also good, parallel is just to get the result quickly

			//System.out.println(list.stream().filter(enchereCorrect).max(Comparator.comparing(EnchereEncherisseur::getEnchere)).get().getEncherisseur());

			System.out.println(list.stream().parallel().filter(enchereCorrect).max(Comparator.comparing(EnchereEncherisseur::getEnchere)).get().getEncherisseur());

		} catch (NoSuchElementException e) {

			System.out.println("KO");

		}
	}
	
	 static class EnchereEncherisseur
	{
	    private int enchere;
	    private String encherisseur;
	    
	    public EnchereEncherisseur(int enchere,String encherisseur)
	    {
	        this.enchere = enchere;
	        this.encherisseur = encherisseur;
	        
	    }
	    
	    public int getEnchere()
	    {
	        return enchere;
	    }
	    
	    
	    public String getEncherisseur()
	    {
	        return encherisseur;
	    }
	    
	}
	
}

