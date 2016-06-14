/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interview.Zillow;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Seb
 */
public class NumberScannerTest {
    
    public NumberScannerTest() {
    }
    /**
     * Test of findMissing method, of class NumberScanner.
     */
    @Test
    public void testFindMissing() {
        Generator r = new Generator(Integer.MAX_VALUE, 4);        
        List<Integer> missing = NumberScanner.findMissing(r);
        for (Integer i: missing) {
            System.out.println(i);
        }
        List<Integer> expected = new ArrayList<Integer>();
        for (int i : r.missing) {
            expected.add(i);
        }
        assertEquals(expected, missing);
    }
}
