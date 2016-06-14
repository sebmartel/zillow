/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interview.Zillow;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Seb
 */
public class Generator {

    int current = 0;
    int[] missing = null;
    int idx = 0;
    int max;

    public Generator(int max, int missing) {
        this.max = max;
        if (missing > 0) {
            this.missing = new int[missing];

            Random r = new Random();
            for (int i = 0; i < this.missing.length; ++i) {
                this.missing[i] = r.nextInt(max);
            }
            Arrays.sort(this.missing);
        }
    }

    boolean hasNext() {
        if (missing != null && idx < missing.length) {
            if (current == missing[idx]) {
                ++idx;
                ++current;
            }
        }
        return current < max;
    }

    int next() {
        hasNext();
        return current++;
    }
}