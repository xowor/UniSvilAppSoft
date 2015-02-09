/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaCifratura;

import Elementi.Studente;
import Elementi.utenti.UserInfo;
import static MainSystem.DBManager.esegui;
import static MainSystem.DBManager.st;
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
    
    UserInfo userTest = new UserInfo(10, "nome", "cognome");
    SistemaDiCifratura instance = new SistemaDiCifratura(50, "chiave", "cesare", userTest);
    
    @BeforeClass
    public static void setUpClass() {
        esegui("INSERT INTO sistemaDiCifratura (idStudente, chiave, metodo) VALUES(10, 'chiave', 'cesare')", st);
    }
    
    @AfterClass
    public static void tearDownClass() {
        esegui("DELETE FROM sistemaDiCifratura WHERE idStudente=10 AND chiave='chiave' AND metodo='cesare'", st);
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
        fail("testLoad has got a problem.");
    }

    /**
     * Test of calcolaMappatura method, of class SistemaDiCifratura. TODO
     */
    @Test
    public void testCalcolaMappatura() {
        System.out.println("calcolaMappatura");
        instance.calcolaMappatura();
        fail("testCalcolaMappatura has got a problem.");
    }

    /**
     * Test of salva method, of class SistemaDiCifratura. TODO
     */
    @Test
    public void testSalva() {
        System.out.println("salva");
        instance.salva();
        fail("testSalva has got a problem.");
    }

    /**
     * Test of elimina method, of class SistemaDiCifratura. TODO
     */
    @Test
    public void testElimina() {
        System.out.println("elimina");
        instance.elimina();
        fail("testElimina has got a problem.");
    }

    /**
     * Test of getChiave method, of class SistemaDiCifratura.
     */
    @Test
    public void testGetChiave() {
        System.out.println("getChiave");
        String expResult = "chiave";
        String result = instance.getChiave();
        assertEquals(expResult, result);
        fail("testGetChiave has got a problem.");
    }

    /**
     * Test of getMetodo method, of class SistemaDiCifratura.
     */
    @Test
    public void testGetMetodo() {
        System.out.println("getMetodo");
        String expResult = "cesare";
        String result = instance.getMetodo();
        assertEquals(expResult, result);
        fail("testGetMetodo has got a problem.");
    }

    /**
     * Test of toString method, of class SistemaDiCifratura.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "cesare/chiave";
        String result = instance.toString();
        assertEquals(expResult, result);
        fail("testToString has got a problem.");
    }

    /**
     * Test of getId method, of class SistemaDiCifratura.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        int result = instance.getId();
        int expResult = 3;
        assertEquals(expResult, result);
        fail("testGetId has got a problem.");
    }
    
}
