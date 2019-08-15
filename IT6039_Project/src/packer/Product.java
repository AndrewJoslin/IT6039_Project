package packer;

import java.util.Objects;

/**
 *
 * @author 91031150
 */
public class Product {

    private String name;
    private int weight;
    private boolean hazardous;
    private boolean fragile;

    /**
     * @param name Name of the product
     * @param weight Weight of the product
     * @param hazardous Whether or not the product is hazardous
     * @param fragile Whether or not the product is fragile
     */
    public Product(String name, int weight, boolean hazardous, boolean fragile) {
        this.name = name;
        this.weight = weight;
        this.hazardous = hazardous;
        this.fragile = fragile;
    }

    /**
     * @return The weight of the product
     */
    public int getWeight() {
        return weight;
    }

    /**
     * @return The name of the product
     */
    public String getName() {
        return name;
    }

    /**
     * @return Validity of the product being hazardous
     */
    public boolean isHazardous() {
        return hazardous; // LOGICAL ERROR: Was always returning false 
    }

    /**
     * @return Validity of the product being fragile
     */
    public boolean isFragile() {
        return fragile;
    }

    /**
     * Overrides the toString() from the Java Standard Library to return the name of the product
     * 
     * @return The name of the product
     */
    @Override
    public String toString() {
        return this.getName();
    }

    /**
     * Overrides the equals(args) from the Java Standard Library to return the validity of a product
     * name equaling the name of a product.
     * 
     * @param o The product object that is being examined
     * @return Validity of a product name being the name of the product
     */    
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Product)) {
            return false;
        }
        Product p = (Product)o;
        return p.getName().equals(this.getName());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + this.weight;
        hash = 97 * hash + (this.hazardous ? 1 : 0);
        hash = 97 * hash + (this.fragile ? 1 : 0);
        return hash;
    }

}
