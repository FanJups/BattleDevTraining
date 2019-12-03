/*******
 * Read input from System.in
 * Use: System.out.println to ouput your result to STDOUT.
 * Use: System.err.println to ouput debugging information to STDERR.
 * ***/
package com.isograd.exercise;
import java.util.*;
import java.util.stream.IntStream;

public class IsoContest {
public static void main( String[] argv ) throws Exception {
		
		int[] planches = new int[4];
		Scanner sc = new Scanner(System.in);

		int planche1 = Integer.parseInt(sc.nextLine());
		planches[0]=planche1;

		int planche2 = Integer.parseInt(sc.nextLine());
		planches[1]=planche2;

		int planche3 = Integer.parseInt(sc.nextLine());
		planches[2]=planche3;

		int planche4 = Integer.parseInt(sc.nextLine());
		planches[3]=planche4; 


		int res= IntStream.of(planches).sum() -4*IntStream.of(planches).min().getAsInt() ;

		System.out.println(res);
		
	/* Vous pouvez aussi effectuer votre traitement une fois que vous avez lu toutes les données.*/
	}
}