package packer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 91031150
 */
public class Customer {
    
    private String name;
    private List<Address> addresses;

    /**
     * Adding customer's address to the array name addresses
     * @param name
     * @param address 
     */
    public Customer(String name, Address address) {
        addresses = new ArrayList<>();
        this.name = name;
        this.addresses.add(address);
    }
    
    /**
     * @param address Adding an address to the customer
     */
    public void addAddress(Address address) {
        this.addresses.add(address);
    }
    
   /**
     * @return The name of the customer
     */
    public String getName() {
        return name;
    /*
changed

        public String getName() {
        return address;
    }
to
        public String getName() {
        return name;
    }

    */
        
    }
    /**
     * calculating the closest address to the depot
     * @param d
     * @return 
     */

    public Address getClosestAddressTo(Depot d) {
        double bestDistance = Double.MAX_VALUE;
        Address bestAddress = null;
        for (Address a : addresses) {
            double distance = a.getCoordinates().companyDistanceTo(d.getCoordinates());
            if (distance < bestDistance) {
                bestAddress = a;
                bestDistance = distance;
            }
        }
        return bestAddress;
    }
/**
     * Overrides the toString() from the Java Standard Library to just return the customer name
     * 
     * @return The name of the customer
     */
    @Override
    public String toString() {
        return this.getName();
    }
}
