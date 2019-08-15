/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packer;


import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.AfterClass;
import org.hamcrest.CoreMatchers;
import static org.junit.Assert.assertThat;

/**
 *
 * @author 91031150
 */
    
    public class ManifestTest {

    // Test data
    Manifest manifest = new Manifest();
    Product product = new Product("Hammer", 3, false, false);
    Product product2 = new Product("Danger Hammer", 1, true, true);
    Product dup_product = new Product("Hammer", 3, false, false);
    
    /**
     * Console output indicating start of ManifestTest class.
     */
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing Manifest class...");
    }
    
    /**
     * Test of addProduct(args[0]) method, of class Manifest.
     */
    @Test
    public void testAddProduct() {
        System.out.println("addProduct");
        Product p = new Product("Screws", 3, true, true);
        Manifest instance = new Manifest();
        instance.addProduct(p, 12);
    }
    
    /**
     * Test of removeProduct method, of class Manifest.
     */
    @Test
    public void testRemoveProduct() {
        System.out.println("removeProduct");
        manifest.addProduct(product);
        manifest.removeProduct(product);
        assertEquals(true, manifest.isEmpty());
        
        manifest.addProduct(product2);
        assertEquals(false, manifest.isEmpty());
    }
    
    /**
     * Test of removeProduct method, of class Manifest.
     */
    @Test
    public void testGetTotalWeight() {
        System.out.println("getTotalWeight");
        manifest.addProduct(product);
        assertEquals(3.0, manifest.getTotalWeight(), 0.0001);
    }
    
    /**
     * Test of getHeaviestUnder method, of class Manifest.
     */
    @Test
    public void testGetHeaviestUnder() {
        System.out.println("getHeaviestUnder");      
        manifest.addProduct(product);
        manifest.addProduct(product2);

        assertEquals(product, manifest.getHeaviestUnder(10));
        assertEquals(product2, manifest.getHeaviestUnder(2));
    }
    
    /**
     * Test of isEmpty method, of class Manifest.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        assertEquals(true, manifest.isEmpty());
        
        manifest.addProduct(product);
        assertEquals(false, manifest.isEmpty());
    }
    
    /**
     * Test of containsProduct method, of class Manifest.
     */
    @Test
    public void testContainsProduct() {
        System.out.println("containsProduct");
        manifest.addProduct(product);
        assertEquals(true, manifest.containsProduct(product));
        assertEquals(false, manifest.containsProduct(product2));
    }
    
    /**
     * Test of toString method, of class Manifest.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        
        manifest.addProduct(product, 1);
        assertEquals("Hammer x 1", manifest.toString());
        
        manifest.addProduct(product2, 5);
        assertThat(manifest.toString(),
                CoreMatchers.either(
                        CoreMatchers.is("Hammer x 1\nDanger Hammer x 5"))
                        .or(CoreMatchers.is("Danger Hammer x 5\nHammer x 1")));
    }

    /**
     * Test of hasFragileItems method, of class Manifest.
     */
    @Test
    public void testHasFragileItems() {
        System.out.println("hasFragileItems");
        manifest.addProduct(product);
        assertEquals(false, manifest.hasFragileItems());
        
        manifest.addProduct(product2);
        assertEquals(true, manifest.hasFragileItems());
    }
    
    /**
     * Test of hasHazardousItems method, of class Manifest.
     */
    @Test
    public void testHasHazardousItems() {
        System.out.println("hasHazardousItems");
        manifest.addProduct(product);
        assertEquals(false, manifest.hasHazardousItems());
        
        manifest.addProduct(product2);
        assertEquals(true, manifest.hasHazardousItems());
    }
    
    /**
     * Test of hasHazardousItems method, of class Manifest.
     */
    @Test
    public void testCannotSetProduct() {
        System.out.println("cannotSetProduct");
        
        manifest.addProduct(product);
        assertEquals(null, manifest.cannotSetProduct());
        
    }
    
    /**
     * Separates console output between test classes.
     */
    @AfterClass
    public static void closeClass() {
        System.out.println("");
    }
    
}
