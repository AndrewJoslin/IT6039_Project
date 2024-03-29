/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packer;


import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author bunta
 */
public class CoordinatesTest {
    
    /** Sets the acceptable difference the results can be, due to results calculated using Double */
    public static final double DELTA = 0.001; // Results can be off by up to 1m
    
    // Test data
    Coordinates testCoordinates1 = new Coordinates(0,0);
    Coordinates testCoordinates2 = new Coordinates(30,40);
    Coordinates testCoordinates3 = new Coordinates(1000, 2000);
    
    /**
     * Console output indicating start of CoordinatesTest class.
     */
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing Coordinates class...");
    }
    
    /**
     * Test of getX method, of class Coordinates.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        assertEquals(0.0,testCoordinates1.getX(),DELTA);
        assertEquals(30.0,testCoordinates2.getX(),DELTA);
        assertEquals(1000.0,testCoordinates3.getX(),DELTA);
    }

    /**
     * Test of getY method, of class Coordinates.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        assertEquals(0.0,testCoordinates1.getY(),DELTA);
        assertEquals(40.0,testCoordinates2.getY(),DELTA);
        assertEquals(2000.0,testCoordinates3.getY(),DELTA);
    }

    /**
     * Test of euclideanDistanceTo method, of class Coordinates.
     */
    @Test
    public void testEuclideanDistanceTo() {
        System.out.println("euclideanDistanceTo");
        assertEquals(50.0, testCoordinates1.euclideanDistanceTo(testCoordinates2), DELTA);
        assertEquals(2236.0679, testCoordinates1.euclideanDistanceTo(testCoordinates3), DELTA);
        assertEquals(2186.8927, testCoordinates2.euclideanDistanceTo(testCoordinates3), DELTA);      
    }

    /**
     * Test of manhattanDistanceTo method, of class Coordinates.
     */
    @Test
    public void testManhattanDistanceTo() {
        System.out.println("manhattanDistanceTo");
        assertEquals(70.0, testCoordinates1.manhattanDistanceTo(testCoordinates2), DELTA);
        assertEquals(3000.0, testCoordinates1.manhattanDistanceTo(testCoordinates3), DELTA);
        assertEquals(2930.0, testCoordinates2.manhattanDistanceTo(testCoordinates3), DELTA); 
    }

    /**
     * Test of companyDistanceTo method, of class Coordinates.
     */
    @Test
    public void testCompanyDistanceTo() { // ERROR FIX: All assertEquals were 1km too much
        System.out.println("companyDistanceTo");
        assertEquals(61.0, testCoordinates1.companyDistanceTo(testCoordinates2), DELTA);  
        // ^ WAS AN ERROR (50.0+70.0)/2 = 60.0 NOT 61.0
        assertEquals(2619.0340, testCoordinates1.companyDistanceTo(testCoordinates3), DELTA); 
        // ^ WAS AN ERROR (2236.0679+3000)/2 = 2618.0340 NOT 2619.0340
        assertEquals(2559.4464, testCoordinates2.companyDistanceTo(testCoordinates3), DELTA); 
        // ^ WAS AN ERROR (2186.8928+2910)/2 = 2558.4464 NOT 2559.4464
    }

    /**
     * Separates console output between test classes.
     */    
    @AfterClass
    public static void closeClass() {
        System.out.println("");
    }

}

