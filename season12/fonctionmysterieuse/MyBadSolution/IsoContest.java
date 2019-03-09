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
		int N = Integer.parseInt(sc.nextLine()); // ligne 1
		line = sc.nextLine(); // ligne 2
		
		Set<Integer> setValeurs = new HashSet<Integer>();
		
		
		int nbreEntrees =0;
		String result = "INF"; //Initialisation du résultat
		boolean inf =false; // Supposons qu'il n y a pas d'infinités
		double Nsur2 = ((double)N)/2;
		System.err.println("N = "+ N);
		System.err.println("N/2 = "+ Nsur2);
		
		for(int i=0; i<=N-1;i++)
		{
		    
		    double fi = Double.parseDouble(line.split(" ")[i]) ; 
		    double fiplusun = Double.parseDouble(line.split(" ")[i+1]) ;
		    
		    System.err.println("f("+i+") = "+fi+" **** "+"f("+(i+1)+") = "+fiplusun);
		    
		    if( ( fi <= Nsur2 && Nsur2 <= fiplusun ) || ( fiplusun <= Nsur2 && Nsur2 <= fi ) )
		    
		    {
		        if( fi == fiplusun  )
		        {
		            
		            //System.err.println("INF");
		            
		            inf = true;
		            
		            break; // INF
		            
		            
		        }else{
		            
		            
		            
		            /*
		            
		                Imaginons N = 6 et f(1) = 3,
		                je vais compter l'indice "1" 2 fois
		                i=0 -> 0&1 * i=1 -> 1&2
		                donc en plus je vérifie si fi =n/2 ou fiplusun
		                je ne mets pas ou dans la condition car je veux savoir exactement si i ou i+1 
		                correspondent à N/2
		                Je crée un set pour ne pas accepter de doublons
		                Le nombre d entrees final sera nbreEntree+set.size() : enlève les doublons de nbreEntrees
		            
		            */
		            
		            if(fi == Nsur2 )
		            {
		                
		                setValeurs.add(i);
		                
		            }
		            
		            if(fiplusun == Nsur2)
		            {
		                setValeurs.add(i+1);
		                
		            }

		            //This is the problem
		            
		            if(fiplusun != Nsur2 && fiplusun != Nsur2)
		            {
		                nbreEntrees++; 
		                
		            }
		            
		        }
		        
		        
		    }
		    
		    
		}
	
	/* Vous pouvez aussi effectuer votre traitement une fois que vous avez lu toutes les données.*/
	
	if(inf)
	{
	    
	}else{
	    
	    
	    
	    System.err.println("nbreEntrees diff = "+ nbreEntrees);
	    
	    System.err.println("setValeurs.size() = "+ setValeurs.size());
	    
	    nbreEntrees = nbreEntrees + setValeurs.size();
	    
	    System.err.println("nbreEntrees final = "+ nbreEntrees);
	    
	    result = nbreEntrees+"";
	}
	
	System.out.println(result);
	
	
	}
}