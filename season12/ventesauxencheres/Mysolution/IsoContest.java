/*******
 * Read input from System.in
 * Use: System.out.println to ouput your result to STDOUT.
 * Use: System.err.println to ouput debugging information to STDERR.
 * ***/
package com.isograd.exercise;
import java.util.*;
import java.util.Map;

public class IsoContest {
public static void main( String[] argv ) throws Exception {
		String  line;
		String N="";
		String prixRes="";
		int i =0;
		int prixResInt=0;
		int prixEnch =0;
		IsoContest xU = new IsoContest();
		EnchereEncherisseur elt =null;
		Map<String, Integer> encheresMap = new HashMap<>();
		LinkedHashMap<String, Integer> sortedEncheresMap = new LinkedHashMap<>();
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()) {
			line = sc.nextLine();
			/* Lisez les données et effectuez votre traitement */
			i++;
			
			if(i==1)
			{
			    N=line;
			}
			if(i==2)
			{
			    prixRes=line;
			}
			if(i>2)
			{
			     elt = xU.convertToEnchereEncherisseur (line);
			     
			     prixResInt=Integer.parseInt(prixRes);
		prixEnch = elt.getEnchere();
			    
			    if(prixEnch > prixResInt )
			    {
			        encheresMap.put(elt.getEncherisseur(),prixEnch);
			        
			    }
			    
			}
		}
	/* Vous pouvez aussi effectuer votre traitement une fois que vous avez lu toutes les données.*/
	
	
	if(encheresMap.size() >0)
	{
	    /*De la plus grande enchère à la plus petite */
				
	encheresMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEachOrdered(x -> sortedEncheresMap.put(x.getKey(), x.getValue()));
	
	Object maxEntry = Collections.max(sortedEncheresMap.entrySet(), Map.Entry.comparingByValue()).getKey(); 
	
	System.out.println(maxEntry);
	    
	}else{ // Aucune enchère adéquate
	
	System.out.println("KO");
	    
	}
	
	
	
	
    
    
    
	
	}
	
	/*
	
	static int stringToInt(String a)
	{
	    return Integer.parseInt(a);
	} */
	
	public  EnchereEncherisseur convertToEnchereEncherisseur (String pe)
	{
	    
        String[] parts = pe.split(" ");
        String enchere = parts[0];
        String encherisseur = parts[1];
        
        int enchereInt = Integer.parseInt(enchere);
        
        return new EnchereEncherisseur(enchereInt,encherisseur);
	}
	
	// class EnchereEncherisseur
	
	 class EnchereEncherisseur
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

