/*******
 * Read input from System.in
 * Use: System.out.println to ouput your result to STDOUT.
 * Use: System.err.println to ouput debugging information to STDERR.
 * ***/
package com.isograd.exercise;
import java.util.*;

public class IsoContest {
public static void main( String[] argv ) throws Exception {
		String  line;
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		int numberMagicWordsDifferents =0;
		//ArrayList<String> magicWordsDifferentsList  = new ArrayList<String>();
		
		Set<String> magicWordsDifferentsList = new HashSet<String>();
		IsoContest instance = new IsoContest();
		int dommage=0;
		while(sc.hasNextLine()) {
			line = sc.nextLine();
			/* Lisez les données et effectuez votre traitement */
			
			System.err.println("sais pas--->"+line.trim());
			
			if(instance.ifMagic(line.trim()) == true)
			{
			    
			    magicWordsDifferentsList.add(line.trim());
			    
			    System.err.println("ok-->"+line.trim());
			}else{
			    dommage++;
			    
			    System.err.println("dommage-->"+line.trim());
			    
			    
			}
		}
	/* Vous pouvez aussi effectuer votre traitement une fois que vous avez lu toutes les données.*/
	
	
		
		numberMagicWordsDifferents = magicWordsDifferentsList.size();

		 //numberMagicWordsDifferents =  instance.removeDuplicates(magicWordsDifferentsList).size();
		 
		 System.err.println("dommageNumber-->"+dommage);
		 
		 System.err.println("magicNumber-->"+numberMagicWordsDifferents);
	
	
	    System.out.println(numberMagicWordsDifferents);
	}
	
	public boolean ifMagic(String mot)
	{
	    boolean test = false; 

	    char[] voyelles = {'a','e','i','o','u','y'};

	    char[] data = new char[26];
		String[] alphabet = new String[26]; // a- z
		for (int i = 0; i < 26; i++) {
			data[i] = (char) (65 + (i / 26) * 6 + i);

			alphabet[i] = data[i] + "";

			alphabet[i] = alphabet[i].toLowerCase();
			
		}

	    if(mot.trim().length()>=5 && mot.trim().length()<=7)
	    {

	    	char mot0 = mot.charAt(0);

	    	char mot1 = mot.charAt(1);

	    	char derniereLettre = mot.charAt(mot.trim().length()-1);

	    	if (Arrays.binarySearch(alphabet, Character.toString(mot0) ) >= 0) {

	    		if (Arrays.binarySearch(alphabet, Character.toString(mot1) ) >= 0) {

	    			//Les 2 premières lettres sont des lettres alphabétiques

	    			if(Character.toLowerCase(mot0) == Character.toLowerCase(mot1) -1)
	    			{
	    				//les deux lettres se suivent

	    				if (Arrays.binarySearch(voyelles, derniereLettre) >= 0)
	    				{
	    					test = true;
	    				}

	    			}

			
		    	} 
			
		    } 

	    }
	    
	    return test;
	}

	// Function to remove duplicates from an ArrayList 
    public  <T> ArrayList<T> removeDuplicates(ArrayList<T> list) 
    { 
  
        // Create a new LinkedHashSet 
        Set<T> set = new LinkedHashSet<>(); 
  
        // Add the elements to set 
        set.addAll(list); 
  
        // Clear the list 
        list.clear(); 
  
        // add the elements of set 
        // with no duplicates to the list 
        list.addAll(set); 
  
        // return the list 
        return list; 
    } 
}