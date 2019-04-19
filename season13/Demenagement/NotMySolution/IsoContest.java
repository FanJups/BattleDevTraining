
/****************************************************************
/***/
/***/
/** SOLUTION BY NicolasGdj*/
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
		String  line;
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		int aller = 1;
		int poids = 0;
		while(sc.hasNextLine()) {
			int p = Integer.parseInt(sc.nextLine());
			if(poids+p > 100){
			    aller++;
			    poids = 0;
			}
			poids+=p;
		}
		System.out.println(aller);
        
	}
}

