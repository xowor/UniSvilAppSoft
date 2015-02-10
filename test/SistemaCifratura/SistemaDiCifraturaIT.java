/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaCifratura;

import Elementi.Studente;
import Elementi.utenti.UserInfo;
import MainSystem.DBManager;
import static MainSystem.DBManager.esegui;
import static MainSystem.DBManager.st;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    private UserInfo userTest = new UserInfo(10, "nome", "cognome");                                // id, nome, cognome
    private SistemaDiCifratura instance = new SistemaDiCifratura(50, "chiave", "cesare", userTest); // id, chiave, metodo, creatore
    private static DBManager dbManager;
    private static Connection conn;
    
    @BeforeClass
    public static void setUpClass() {
        dbManager = new DBManager();
        conn = dbManager.inizializza();
        if(conn != null)
            esegui("INSERT INTO sistemaDiCifratura (idStudente, chiave, metodo) VALUES(10, 'chiave', 'cesare')", st);
    }
    
    @AfterClass
    public static void tearDownClass() {
        //esegui("DELETE FROM sistemaDiCifratura WHERE idStudente=10 AND chiave='chiave' AND metodo='cesare'", st);
    }

    /**
     * Test of caricaSistemiCifratura method, of class SistemaDiCifratura. TODO manca nel db
     */
/*    @Test
    public void testCaricaSistemiCifratura() {
        System.out.println("caricaSistemiCifratura");
        Studente studente = new Studente(10, "login", "password", "nome", "cognome");
        ArrayList<SistemaDiCifratura> expResult = null;
        expResult.add(instance);
        ArrayList<SistemaDiCifratura> result = SistemaDiCifratura.caricaSistemiCifratura(studente);
        assertEquals(expResult, result);
    }
*/
    /**
     * Test of load method, of class SistemaDiCifratura. TODO manca nel db
     */
/*    @Test
    public void testLoad() {
        System.out.println("load");
        int id = 1;
        SistemaDiCifratura expResult = null;
        SistemaDiCifratura result = SistemaDiCifratura.load(id);
        assertEquals(expResult, result);
    }
*/
    /**
     * Test of calcolaMappatura method, of class SistemaDiCifratura. TODO
     */
/*    @Test
    public void testCalcolaMappatura() {
        System.out.println("calcolaMappatura");
        instance.calcolaMappatura();
        fail("testCalcolaMappatura has got a problem.");
    }
*/
    /**
     * Test of salva method, of class SistemaDiCifratura. TODO
     */
/*    @Test
    public void testSalva() {
        System.out.println("salva");
        instance.salva();
        fail("testSalva has got a problem.");
    }
*/
    /**
     * Test of elimina method, of class SistemaDiCifratura. TODO
     */
/*    @Test
    public void testElimina() {
        System.out.println("elimina");
        instance.elimina();
        fail("testElimina has got a problem.");
    }
*/
    /**
     * Test of getChiave method, of class SistemaDiCifratura.
     */
    @Test
    public void testGetChiave() {
        System.out.println("getChiave");
        String expResult = "chiave";
        String result = instance.getChiave();
        assertEquals(expResult, result);
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
    }

    /**
     * Test of toString method, of class SistemaDiCifratura.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "cesare / chiave";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getId method, of class SistemaDiCifratura.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        int result = instance.getId();
        int expResult = 50;
        assertEquals(expResult, result);
    }
    
}
