/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaCifratura;

import elements.Studente;
import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Federica
 */
public class SistemaDiCifraturaIT {
    
    public SistemaDiCifraturaIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of caricaSistemiCifratura method, of class SistemaDiCifratura.
     */
    @Test
    public void testCaricaSistemiCifratura() {
        System.out.println("caricaSistemiCifratura");
        Studente studente = null;
        ArrayList<SistemaDiCifratura> expResult = null;
        ArrayList<SistemaDiCifratura> result = SistemaDiCifratura.caricaSistemiCifratura(studente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of load method, of class SistemaDiCifratura.
     */
    @Test
    public void testLoad() {
        System.out.println("load");
        int id = 0;
        SistemaDiCifratura expResult = null;
        SistemaDiCifratura result = SistemaDiCifratura.load(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calcolaMappatura method, of class SistemaDiCifratura.
     */
    @Test
    public void testCalcolaMappatura() {
        System.out.println("calcolaMappatura");
        SistemaDiCifratura instance = null;
        instance.calcolaMappatura();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of salva method, of class SistemaDiCifratura.
     */
    @Test
    public void testSalva() {
        System.out.println("salva");
        SistemaDiCifratura instance = null;
        instance.salva();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of elimina method, of class SistemaDiCifratura.
     */
    @Test
    public void testElimina() {
        System.out.println("elimina");
        SistemaDiCifratura instance = null;
        instance.elimina();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getChiave method, of class SistemaDiCifratura.
     */
    @Test
    public void testGetChiave() {
        System.out.println("getChiave");
        SistemaDiCifratura instance = null;
        String expResult = "";
        String result = instance.getChiave();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMetodo method, of class SistemaDiCifratura.
     */
    @Test
    public void testGetMetodo() {
        System.out.println("getMetodo");
        SistemaDiCifratura instance = null;
        String expResult = "";
        String result = instance.getMetodo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class SistemaDiCifratura.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        SistemaDiCifratura instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class SistemaDiCifratura.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        SistemaDiCifratura instance = null;
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
