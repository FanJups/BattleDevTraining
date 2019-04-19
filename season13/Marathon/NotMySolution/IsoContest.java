
/****************************************************************
/***/
/***/
/** SOLUTION BY Vince_17*/
/***/
/***/
/********************************************************************/
/*******
 * Read input from System.in
 * Use: System.out.println to ouput your result to STDOUT.
 * Use: System.err.println to ouput debugging information to STDERR.
 * ***/
package com.isograd.exercise;
import java.util.*;

public class IsoContest {
public static void main( String[] argv ) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		int n=42;
		int pos=sc.nextInt();
		
		for (int i=0;i<n;i++){
		    int x=sc.nextInt();
		    int y=sc.nextInt();
		    pos+=x;
		    pos-=y;
		}
		String ans="KO";
		if (pos<=10000) {
		    ans="100";
		    if (pos<=100)
		        ans="1000";
		    
		   
		    
		}
		System.out.println(ans);
		
	/* Vous pouvez aussi effectuer votre traitement une fois que vous avez lu toutes les données.*/
	}
}

