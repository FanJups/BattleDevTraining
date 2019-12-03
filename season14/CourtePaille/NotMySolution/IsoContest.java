
/****************************************************************
/***/
/***/
/** SOLUTION BY SimonD*/
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
        int nbPeople = Integer.parseInt(sc.nextLine());
        String res="";
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nbPeople; i++) {
            String[] line = sc.nextLine().split(" ");
            String name = line[0];
            int size = Integer.parseInt(line[1]);
            if (size < min) {
                res = name;
                min = size;
            }
        }
        System.out.println(res);
    }
}

