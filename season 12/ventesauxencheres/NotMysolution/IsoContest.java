/*************************************
Solution by MaelG
****************************************/
package com.isograd.exercise;
import java.util.*;

public class IsoContest {
    public static void main( String[] argv ) throws Exception {
    	String  line;
    	Scanner sc = new Scanner(System.in);
    	Integer offers = Integer.parseInt(sc.nextLine());
    	Integer bestPrice = Integer.parseInt(sc.nextLine());
    	String buyer = new String("KO");
    	
    	while(sc.hasNextLine()) {
    		line = sc.nextLine();
    		Integer price = Integer.parseInt(line.split(" ")[0]);
    		if (price > bestPrice) {
    		    bestPrice = price;
    		    buyer = line.split(" ")[1];
    		}
    	}
    	System.out.println(buyer);
    }
}
