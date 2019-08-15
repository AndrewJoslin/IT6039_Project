package packer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 91031150
 * 
 */
public class Packer {
    /**
     * Packing product 
     * @param c customer
     * @param d depot
     * @param m manifest
     * @return 
     */

    public static List<Box> packProducts(Customer c, Depot d, Manifest m) {
        List<Box> packedBoxes = new ArrayList<>();
        Box b = null;
        while (!m.isEmpty()) { // repeat until all items are packed
            if (b == null) {
                b = new Box(c,d);
            }
            
            Product prodToAdd = m.getHeaviestUnder(b.remainingCapacity());

            if (prodToAdd == null) {
                packedBoxes.add(b);
                b = null;
            }
            else {
                b.addProduct(prodToAdd);
                m.removeProduct(prodToAdd);
            }
        }

        if (b != null) {
            packedBoxes.add(b); // LOGICAL ERROR: There was a duplicate line adding an extra box
        }
        return packedBoxes;  
    }
    
}
