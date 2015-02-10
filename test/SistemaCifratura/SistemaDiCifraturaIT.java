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
    private static int idStudente;
    private static int idSistema;
    private static Studente studente;
    private static UserInfo userTest2;
    
    @BeforeClass
    public static void setUpClass() {
        try {
            dbManager = new DBManager();
            dbManager.inizializza();
            
            esegui("INSERT INTO sistemaDiCifratura (idStudente, chiave, metodo) VALUES(10, 'chiave', 'cesare')", st);
            
            esegui("INSERT INTO studente (nome, cognome, login, password) VALUES('nome', 'cognome', 'login', 'password')", st);
            
            // recupero l'id dello studente
            ResultSet rs0 = st.executeQuery("SELECT id FROM studente WHERE login='login' ");
            idStudente = -1;
            if(rs0.next())
                idStudente = rs0.getInt("id");
            
            studente = new Studente(idStudente, "login", "password", "nome", "cognome");
            userTest2 = new UserInfo(idStudente, "nome", "cognome");
        
            // aggiungo il sistema di cifratura allo studente
            esegui("INSERT INTO sistemaDiCifratura (idStudente, chiave, metodo) VALUES("+idStudente+", 'chiave', 'cesare')", st);

            // recupera l'id del sistema di cifratura associato allo studente
            rs0 = st.executeQuery("SELECT id FROM sistemaDiCifratura WHERE idStudente="+idStudente+""
                    + " AND chiave='chiave' AND metodo='cesare'");
            idSistema = -1;
            if(rs0.next())
                idSistema = rs0.getInt("id");
            
        } catch (SQLException ex) {
            Logger.getLogger(SistemaDiCifraturaIT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @AfterClass
    public static void tearDownClass() {
        esegui("DELETE FROM sistemaDiCifratura WHERE idStudente=10 AND chiave='chiave' AND metodo='cesare'", st);
        esegui("DELETE FROM studente WHERE nome='nome' AND cognome='cognome' AND login='login' AND password='password'", st);
        esegui("DELETE FROM sistemadicifratura WHERE idStudente=60 AND chiave='key' AND metodo='cesar'", st);
        
    }

    /**
     * Test of caricaSistemiCifratura method, of class SistemaDiCifratura. TODO manca nel db
     */
    @Test
    public void testCaricaSistemiCifratura() {
            System.out.println("caricaSistemiCifratura");

            // crea l'expResult con il SistemaDiCifratura appena costruito
            ArrayList<SistemaDiCifratura> expResult = new ArrayList<>();
            expResult.add( new SistemaDiCifratura(idSistema,  "chiave", "cesare", userTest2) );
      
            // costruisco il risultato da testare
            ArrayList<SistemaDiCifratura> result = SistemaDiCifratura.caricaSistemiCifratura(studente);
            
            assertEquals(expResult.get(0).getChiave(), result.get(0).getChiave()); 
            assertEquals(expResult.get(0).getId(), result.get(0).getId());
            assertEquals(expResult.get(0).getMetodo(), result.get(0).getMetodo());
            assertEquals(expResult.get(0).toString(), result.get(0).toString());

    }

    /**
     * Test of load method, of class SistemaDiCifratura.
     */
    @Test
    public void testLoad() {
        
            System.out.println("load");
            int id = 500;
            SistemaDiCifratura result = SistemaDiCifratura.load(id);
            System.out.println(result);
            assertNull(result);
                       
            SistemaDiCifratura expResult2 = new SistemaDiCifratura(idSistema, "chiave", "cesare", userTest2);
            SistemaDiCifratura result2 = SistemaDiCifratura.load(idSistema);
            
            assertEquals(expResult2.getChiave(), result2.getChiave());
            assertEquals(expResult2.getId(), result2.getId());
            assertEquals(expResult2.getMetodo(), result2.getMetodo());
            assertEquals(expResult2.toString(), result2.toString());

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
        try {
            System.out.println("salva");
            esegui("INSERT INTO sistemadicifratura (idStudente, chiave, metodo) VALUES (60, 'key', 'cesar')", st);
            ResultSet rs = st.executeQuery("SELECT id FROM sistemaDiCifratura WHERE idStudente="+idStudente+""
                    + " AND chiave='chiave' AND metodo='cesare'");
            int id = -1;
            if(rs.next())
                id = rs.getInt("id");
            UserInfo stud = new UserInfo(89, "stud", "stud");
            SistemaDiCifratura instance2 = new SistemaDiCifratura(id, "key", "cesar", stud);
            instance2.salva();
        } catch (SQLException ex) {
            Logger.getLogger(SistemaDiCifraturaIT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of elimina method, of class SistemaDiCifratura.
     */
    @Test
    public void testElimina() {
        try {
            System.out.println("elimina");
            esegui("INSERT INTO sistemaDiCifratura (idStudente, chiave, metodo) VALUES(89, 'key', 'cesar')", st);
            ResultSet rs = st.executeQuery("SELECT id FROM sistemaDiCifratura WHERE idStudente="+idStudente+""
                    + " AND chiave='chiave' AND metodo='cesare'");
            int id = -1;
            if(rs.next())
                id = rs.getInt("id");
            esegui("DELETE FROM sistemadicifratura WHERE chiave='" + id + "' AND metodo='cesare' AND chiave='key'", st);
            UserInfo stud = new UserInfo(89, "stud", "stud");
            SistemaDiCifratura instance2 = new SistemaDiCifratura(id, "key", "cesar", stud);
            instance2.elimina();
        } catch (SQLException ex) {
            Logger.getLogger(SistemaDiCifraturaIT.class.getName()).log(Level.SEVERE, null, ex);
        }
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
