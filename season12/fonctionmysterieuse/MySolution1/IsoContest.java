/*******
 * Read input from System.in
 * Use: System.out.println to ouput your result to STDOUT.
 * Use: System.err.println to ouput debugging information to STDERR.
 * ***/

//OK
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
		for(int i=0; i<=N-1;i++)
		{
		    double fi = Double.parseDouble(line.split(" ")[i]) ; 
		    double fiplusun = Double.parseDouble(line.split(" ")[i+1]) ;
		    if( fi == fiplusun && fiplusun == Nsur2 )
		    {
		    	 inf = true;
			     break; // INF
		    }
		    if(  (fi < Nsur2 && Nsur2 < fiplusun) || (fiplusun < Nsur2 && Nsur2 < fi)  )
			{
				nbreEntrees++;
			} 

			if(fi == Nsur2 && fiplusun != Nsur2 )
			{
				setValeurs.add(i);
			}
					            
			if(fiplusun == Nsur2 && fi != Nsur2 )
			{
				setValeurs.add(i+1);
			}
		} //for
	
	/* Vous pouvez aussi effectuer votre traitement une fois que vous avez lu toutes les données.*/
	
	if(inf)
	{
	    
	}else{
	    
	    nbreEntrees = nbreEntrees + setValeurs.size();
	    result = nbreEntrees+"";
	}
	
	System.out.println(result);
	
	
	}
}