package jUnit;

import labex3.BridgeGui;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kyle Jolicoeur
 */
public class BridgeTest 
{
    public BridgeTest() 
    {
        
    }
    
    @BeforeClass
    public static void setUpClass() 
    {
        
    }
    
    @AfterClass
    public static void tearDownClass() 
    {
        
    }
    
    @Before
    public void setUp() 
    {
        
    }
    
    @After
    public void tearDown() 
    {
        
    }
    @Test
    public void testVariables()
    {
        BridgeGui testBridge = new BridgeGui();
        
        System.out.println(testBridge.cWhoLeads.getFaceValue());
        System.out.println(testBridge.cWhoLeads.getSuit());
        assertTrue("initialize the who leads variable",testBridge.sWhoLeads.equals("North"));
    }
}