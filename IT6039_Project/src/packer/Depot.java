package packer;

/**
 *
 * @author 91031150
 */
public class Depot {
    private String name;
    private Address address;
    /**
     * Getting depot name and address
     * @param name
     * @param address 
     */

    public Depot(String name, Address address) {
        this.name = name;
        this.address = address;
    }
    
    public String getName() {
        return name;
    }
    /**
     * Getting coordinate based on address
     * @return 
     */
    public Coordinates getCoordinates() {
        return this.address.getCoordinates();
    }
    /**
     * Overrides the toString() from the Java Standard Library to just return the depot name
     * 
     * @return The address of the depot
     */
    @Override
    public String toString() {
        return this.getName();
    }
    
}
