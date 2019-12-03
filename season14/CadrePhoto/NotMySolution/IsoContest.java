
/****************************************************************
/***/
/***/
/** SOLUTION BY egaetan*/
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
        
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        
        int max = Math.min(a, Math.min(b, Math.min(c, d)));
        System.out.println(a+b+c+d - max*4);
        
    /* Vous pouvez aussi effectuer votre traitement une fois que vous avez lu toutes les données.*/
    }
}

