/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interview.Zillow;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Seb
 */
public class NumberScanner {
    
    public static List<Integer> findMissing(Generator g) {
        int[] bits = new int[g.max / 32 + 1];
        while (g.hasNext()) {
            int n = g.next();
            int index = n / 32;
            int pos = 1 << n % 32;
            bits[index] = bits[index] | pos;                        
        }
        
        ArrayList<Integer> missing = new ArrayList<Integer>();
        for (int p=0; p<bits.length; ++p) {
            int c = bits[p];
            int hit = c ^ (Integer.MAX_VALUE |  -1);
            if (hit > 0) {
                for (int j = 0, mask = 1; j < 32; mask = mask << 1, ++j) {
                    if ( (mask & hit) > 0) {
                        int m  = 32*p + j;
                        if (m < g.max && m >= 0) {
                            missing.add(m);
                        }
                    }
                }
            }
        }
        return missing;
    }
}
