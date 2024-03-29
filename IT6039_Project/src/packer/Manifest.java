package packer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author 91031150
 */
public class Manifest {
    
    // This tracks the quantity if each product in the manifest
    private Map<Product, Integer> quantities;
    // This keeps a list of all products ordered by weight
    private Set<Product> byWeight;
    // This tracks the products that cannot be added to the manifest
    private Map<Product, Integer> cannotSet;

    /**
     * Constructor to initialize useful product lists
     */
    public Manifest() {
        quantities = new HashMap<>();
        byWeight = new TreeSet<>(new ProductWeightComparator());
        cannotSet = new HashMap<>();
    }
    
    /**
     * Adds a product to the manifest with a quantity of 1
     * 
     * @param p The product that is added to the manifest
     */
    public void addProduct(Product p) {
        addProduct(p,1);
    } 

    /**
     * Adds a product to the manifest with a set quantity.
     * Also adds the product to the an ordered byWeight set, if applicable. 
     * Otherwise, it is added to the cannotSet map.
     * 
     * @param p The product that is added to the manifest
     * @param quantity The quantity of product to be added to the manifest
     */
    public void addProduct(Product p, int quantity) {
        if (quantities.containsKey(p)) {
            quantities.put(p,quantities.get(p)+quantity); // LOGICAL ERROR: Changed to '+' from '*'
        }
        else {
            quantities.put(p,quantity);
            if(!byWeight.add(p)) {
                cannotSet.put(p,1); 
            }
        }
    }
    
    /**
     * Removes a product from the manifest by a quantity of 1.
     * Also, removes product from the byWeight set if the quantity is reduced to 0. 
     * 
     * @param p The product that is to be removed from the manifest
     */
    public void removeProduct(Product p) {
        if (quantities.containsKey(p) && quantities.get(p) > 0) {
            quantities.put(p,quantities.get(p)-1);
        }
        else if (quantities.get(p) == 0) { 
            // ^ LOGICAL ERROR: Changed to ELSE IF incase quantities set to 0 in previous statement
            quantities.remove(p); 
        }
        if (quantities.containsKey(p) && quantities.get(p) == 0 ) {  
            // ^ LOGICAL ERROR: Added 'quantities.get(p) = 0' condition when removing fom byWeight
            byWeight.remove(p);
        }
    }
    
    /**
     * Get the total weight of all products in the Quantities map (i.e. Current total weight of box)
     * 
     * @return The total weight of all products currently in box
     */
    public double getTotalWeight() { 
        // LOGICAL ERROR: Function was returning TOTAL weight of the quantities of only one product 
        double weight;
        double total_weight = 0;  // ADDED
        for (Product p : quantities.keySet()) {
            weight = quantities.get(p) * p.getWeight(); 
            total_weight = total_weight + weight; // ADDED
        }
        return total_weight; // CHANGED to total_weight
    }

    /**
     * Gets the heaviest product in the manifest under the given weight
     * 
     * @param weight The maximum weight limit of the heaviest product 
     * @return The heaviest product remaining in the manifest, null if not processed
     */
    public Product getHeaviestUnder(double weight) {
        for (Product p : byWeight) {
            if (p.getWeight() <= weight) {
                return p;
            }
        }
        return null;
    }

    /**
     * @return Validity of the ByWeight set being empty. This also means the manifest is empty.
     */
    public boolean isEmpty() {
        return byWeight.isEmpty();
    }

    /**
     * @param p The product to check if it exists in the Quantities map.
     * @return Validity of a product existing in the Quantities map.
     */    
    public boolean containsProduct(Product p) {
        return quantities.containsKey(p) && quantities.get(p) > 0;
    }
    
    /**
     * Overrides the toString() from the Java Standard Library to return a string containing the 
     * quantities of products in the Quantities map 
     * 
     * @return The string listing all the quantities of the products in the Quantities map
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Product p : quantities.keySet()) {
            result.append(p.getName());
            result.append(" x ");
            result.append(quantities.get(p));
            result.append("\n");
        }
        return result.substring(0, result.length()-1);
    }

    /**
     * @return Validity if the Quantities map contains a fragile product
     */       
    public boolean hasFragileItems() {
        for (Product p : quantities.keySet()) {
            if (p.isFragile()) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * @return Validity if the Quantities map contains a hazardous product
     */        
    public boolean hasHazardousItems() { // ADDED: To detect if any hazardous items in manifest
        for (Product p : quantities.keySet()) {
            if (p.isHazardous()) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Generates a string for all items that cannot be set into the manifest.
     * 
     * @return The string listing all products that cannot be set, null is none exists
     */        
    public String cannotSetProduct() { 
        // ^ ADDED: Created during refactoring of AddProduct Function to detect products that cannot be set.
        if (cannotSet.isEmpty()) {
            return null;
        }
        else {
            return String.format(
                    "Couldn't add '%s' to Set", 
                    cannotSet.keySet().toString().replace("[", "").replace("]", ""));
        }
    }
    
} // SYNTAX ERROR: '}' bracket to close class
