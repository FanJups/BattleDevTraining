

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
    static class Etu {
        int c1, c2;
        Etu(int c1, int c2) {
            this.c1 = c1;
            this.c2 = c2;
        }
    }
    
    public static void reserve(boolean[] b, int i) {
        for (int a = 0; a < 60; a++) {
            b[i + a] = true;
        }
    }
    
    public static void dereserve(boolean[] b, int i) {
        for (int a = 0; a < 60; a++) {
            b[i + a] = false;
        }
    }
    
    public static boolean dispo (boolean[] b, int i) {
        for (int a = 0; a < 60; a++) {
            if (b[i + a]) {
                return false;
            }
        }
        return true;
    }
    
    public static int compute(boolean[] b, List<Etu> l, int i) {
        if (i == l.size()) {
            return 0;
        }
        
        Etu e = l.get(i);
        int t1 = 0;
        int t2 = 0;
        int t3 = compute(b, l, i + 1);
        if (dispo(b, e.c1)) {
            reserve(b, e.c1);
            t1 = 1 + compute(b, l, i+1);
            dereserve(b, e.c1);
        }
        if (dispo(b, e.c2)) {
            reserve(b, e.c2);
            t2 = 1 + compute(b, l, i+1);
            dereserve(b, e.c2);
        }
        
        return Math.max(t1, Math.max(t2, t3));
    }
    
public static void main( String[] argv ) throws Exception {
		String  line;
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Etu> l = new ArrayList<>(n);
		for (int i = 0; i < n; i++) {
		    l.add(new Etu(sc.nextInt(), sc.nextInt()));
		}
		
		System.out.println(compute(new boolean[2000], l, 0));
	}
}

