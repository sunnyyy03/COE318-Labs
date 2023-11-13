package coe318.lab7;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class CircuitTest {
    
    public CircuitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getInstance method, of class Circuit.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        Circuit expResult = Circuit.getInstance();
        Circuit result = Circuit.getInstance();
        assertEquals(expResult, result);
    }
}
