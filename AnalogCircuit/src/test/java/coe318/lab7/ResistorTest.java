package coe318.lab7;

import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ResistorTest
{    
    public ResistorTest() {}
    
    @BeforeClass
    public static void setUpClass() {}
    
    @AfterClass
    public static void tearDownClass() {}
    
    @Before
    public void setUp() {}
    
    @After
    public void tearDown() {}

    @Test
    public void testGetNodes()
    {
        System.out.println("getNodes");
        Node node0 = new Node();
        Node node1 = new Node();
        Resistor instance = new Resistor(15.0, node0, node1);
        Node[] expResult = {node0, node1};
        Node[] result = instance.getNodes();
        assertArrayEquals(expResult, result);
    }
}