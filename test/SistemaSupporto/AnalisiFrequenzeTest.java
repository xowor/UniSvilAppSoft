/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaSupporto;

import elements.Alfabeto;
import elements.Frequenze;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author luca
 */
public class AnalisiFrequenzeTest {
    
    public AnalisiFrequenzeTest() {
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
     * Test of calcolaFrequenze method, of class AnalisiFrequenze.
     */
    @Test
    public void testCalcolaFrequenze() {
        System.out.println("calcolaFrequenze");
        String testo = "";
        Alfabeto alfabeto = null;
        Frequenze expResult = null;
        Frequenze result = AnalisiFrequenze.calcolaFrequenze(testo, alfabeto);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
