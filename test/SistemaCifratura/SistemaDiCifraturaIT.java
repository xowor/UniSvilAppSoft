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
import java.sql.ResultSet;
import java.sql.SQLException;
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
    
    private final UserInfo userTest = new UserInfo(10, "nome", "cognome");                                // id, nome, cognome
    private final SistemaDiCifratura instance = new SistemaDiCifratura(50, "chiave", "cesare", userTest); // id, chiave, metodo, creatore
    private static DBManager dbManager;
    
    @BeforeClass
    public static void setUpClass() {
        dbManager = new DBManager();
        dbManager.inizializza();
        esegui("INSERT INTO sistemaDiCifratura (idStudente, chiave, metodo) VALUES(10, 'chiave', 'cesare')", st);          
    }
    
    @AfterClass
    public static void tearDownClass() {
        esegui("DELETE FROM sistemaDiCifratura WHERE idStudente=10 AND chiave='chiave' AND metodo='cesare'", st);
    }

    /**
     * Test of caricaSistemiCifratura method, of class SistemaDiCifratura. TODO manca nel db
     */
    @Test
    public void testCaricaSistemiCifratura() {
        try {
            System.out.println("caricaSistemiCifratura");
            ResultSet rs0 = st.executeQuery("SELECT id FROM studente WHERE nome='nome' AND cognome='cognome' "
                    + "AND login='login' AND password='password'");
            rs0.next();
            int idStudente = rs0.getInt("id");
            Studente studente = new Studente(idStudente, "login", "password", "nome", "cognome");
            UserInfo userTest2 = new UserInfo(idStudente, "nome", "cognome");
            
            ResultSet rs1 = st.executeQuery("SELECT id FROM sistemaDiCifratura WHERE idStudente="+idStudente+""
                    + " AND chiave='chiave' AND metodo='cesare'");
            rs1.next();
            int idSistema = rs1.getInt("id");
            SistemaDiCifratura sdc = new SistemaDiCifratura(idSistema,  "chiave", "cesare", userTest2);
            
            ArrayList<SistemaDiCifratura> expResult = null;
            expResult.add(sdc);
            
            ArrayList<SistemaDiCifratura> result = SistemaDiCifratura.caricaSistemiCifratura(studente);
            assertEquals(expResult, result); 
        } catch (SQLException ex) {
            Logger.getLogger(SistemaDiCifraturaIT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of load method, of class SistemaDiCifratura.
     */
    @Test
    public void testLoad() {
        try {
            System.out.println("load");
            int id = 1;
            SistemaDiCifratura expResult = null;
            SistemaDiCifratura result = SistemaDiCifratura.load(id);
            assertEquals(expResult, result);
            
            ResultSet rs0 = st.executeQuery("SELECT id FROM studente WHERE nome='nome' AND cognome='cognome' "
                    + "AND login='login' AND password='password'");
            rs0.next();
            int idStudente = rs0.getInt("id");
            UserInfo userTest2 = new UserInfo(idStudente, "nome", "cognome");
            
            ResultSet rs1 = st.executeQuery("SELECT id FROM sistemaDiCifratura WHERE idStudente="+idStudente+""
                    + " AND chiave='chiave' AND metodo='cesare'");
            rs1.next();
            int idSistema = rs1.getInt("id");
            
            SistemaDiCifratura expResult2 = new SistemaDiCifratura(idSistema, "chiave", "cesare", userTest2);
            SistemaDiCifratura result2 = SistemaDiCifratura.load(idSistema);
            assertEquals(expResult2, result2);
        } catch (SQLException ex) {
            Logger.getLogger(SistemaDiCifraturaIT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of calcolaMappatura method, of class SistemaDiCifratura.
     */
    @Test
    public void testCalcolaMappatura() {
        System.out.println("calcolaMappatura");
        instance.calcolaMappatura();
    }

    /**
     * Test of salva method, of class SistemaDiCifratura.
     */
    @Test
    public void testSalva() {
        System.out.println("salva");
        instance.salva();
    }

    /**
     * Test of elimina method, of class SistemaDiCifratura.
     */
    @Test
    public void testElimina() {
        System.out.println("elimina");
        instance.elimina();
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
