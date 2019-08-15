package packer;

/**
 *
 * @author 91031150
 */
public class Address {
    private String street;
    private String suburb;
    private String city;
    private String postcode;
    private Coordinates coordinates;
    /**
     * 
     * This gets the following input from the text file
     * @param street
     * @param suburb
     * @param city
     * @param postcode
     * @param coordinates 
     */
    public Address(String street, String suburb, String city, String postcode, Coordinates coordinates) {
        this.street = street;
        this.suburb = suburb;
        this.city = city;
        this.postcode = postcode;
        this.coordinates = coordinates;
    }
/**
 * 
 * 
 * @return converting to string in output
 */
    @Override
    public String toString() {
        return 
                street + "\n" +
                suburb + "\n" +
                city + "\n" +
                postcode;
    }
    /**
     * @return the coordinates
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }
    
}
