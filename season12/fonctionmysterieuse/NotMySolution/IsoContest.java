
/****************************************************************
/***/
/***/
/** SOLUTION BY RomainGWA*/
/***/
/***/
/********************************************************************/
package com.isograd.exercise;
import java.util.*;

public class IsoContest {
    
public static void main( String[] argv ) throws Exception {
		String  line;
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		double nSur2 = ((double) n) / 2;
		int cpt = 0;
		int previous= sc.nextInt();
		for (int i = 0; i < n; i++) {
		    int next = sc.nextInt();
		    if (previous == next & next == nSur2) {
		        System.out.println("INF");
		        return;
		    }
		    if (previous == nSur2) {
		        cpt++;
		    }
		    if (previous < nSur2 & nSur2 < next) {
		        cpt++;
		    }
		    if (next < nSur2 & nSur2 < previous) {
		        cpt++;
		    }
		    previous = next;
		}
		if (previous == nSur2) {
		    cpt++;
		}
		System.out.println(cpt);
	}
}

