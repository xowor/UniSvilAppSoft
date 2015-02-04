package MainSystem;
import Elements.Studente;
import javax.management.Query;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBManager {
    public DBManager(){}
    
    public static void inizializza() {
        Connection conn=openConnection();
        Statement st=openStatement(conn);
        creaTabelle(st);
        creaDati(st);
        closeStatement(st);
        closeConnection(conn);
    }
    /**
    * crea uno Statement con il database;
    *
    * @param conn indica una connessione disponibile per creare uno Statement;
    * @return uno Statement aperto;
    */
    public static Statement openStatement(Connection conn) {
        Statement st = null;
        try {
            st = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return st;
    }
    
    /**
    * Chiude uno Statement precedentemente creato;
    *
    * @param st indica lo Statement da chiudere;
    */
    public static void closeStatement(Statement st){
        try {
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
    * Apre una connessione con il database;
    *
    * @return una Connessione aperta;
    */
    public static Connection openConnection() {
        Connection conn = null;
        try {
            String ur = "jdbc:derby://localhost:1527/CryptoHelperDB";
            String us = "studente";
            String p = "studente";
            conn = DriverManager.getConnection(ur, us, p);
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    
    /**
    * Esegue una query SQL ritornando un booleano;
    *
    * @param sql indica il testo di una query SQL;
    * @param st indica lo Statement creato per l'interazione con il database;
    * @return "true" se la query ha avuto successo;
    */
    public static boolean esegui(String sql, Statement st) {
        boolean tmp = false;
        try {
            tmp = st.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tmp;
    }
    
    /**
    * Esegue una query SQL ritornando un ResultSet;
    *
    * @param sql indica il testo di una query SQL;
    * @param st indica lo Statement creato per l'interazione con il database;
    * @return il resultSet della query eseguita;
    */
    public static ResultSet query(String sql, Statement st) {
        try{
         return st.executeQuery(sql);
        }catch(SQLException e){return null;}
    }
    
    /**
    * Chiude la Connection precedentemente creata;
    *
    * @param conn indica la Connessione da chiudere;
    */
    public static void closeConnection(Connection conn) {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void creaTabelle(Statement st){
        try {
            st.execute( "CREATE TABLE studente(" +
            "id INT NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1)," +
            "nome VARCHAR(24) NOT NULL," +
            "cognome VARCHAR(24) NOT NULL," +
            "login VARCHAR(24) NOT NULL UNIQUE," +
            "password VARCHAR(24) NOT NULL," +
            "PRIMARY KEY(id))");
            
            st.execute( "CREATE TABLE messaggio(" +
            "id INT NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1)," +
            "testo LONG VARCHAR NOT NULL," +
            "testoCifrato LONG VARCHAR NOT NULL," +
            "lingua VARCHAR(12) NOT NULL," +
            "titolo VARCHAR(24) NOT NULL," +
            "bozza LONG VARCHAR NOT NULL," +
            "letto BOOLEAN NOT NULL," +
            "PRIMARY KEY(id))");
            
            st.execute( "CREATE TABLE userInfo(" +
            "id INT NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1)," +
            "nome VARCHAR(24) NOT NULL," +
            "cognome VARCHAR(24) NOT NULL," +
            "PRIMARY KEY(id))");
            
            st.execute( "CREATE TABLE proposta(" +
            "id INT NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1)," +
            "stato VARCHAR(24) NOT NULL," +
            "notificata BOOLEAN NOT NULL," +
            "PRIMARY KEY(id))");
            
            st.execute( "CREATE TABLE sistemaDiCifratura(" +
            "id INT NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1)," +
            "chiave VARCHAR(24) NOT NULL," +
            "metodo VARCHAR(24) NOT NULL," +
            "PRIMARY KEY(id))");
            
            st.execute( "CREATE TABLE ipotesi(" +
            "id INT NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1)," +
            "messaggio LONG VARCHAR NOT NULL," +
            "PRIMARY KEY(id))");
            
            st.execute( "CREATE TABLE frequenzaLingua(" +
            "lettera CHAR NOT NULL," +
            "lingua VARCHAR(12) NOT NULL," +
            "frequenza INTEGER NOT NULL," +
            "PRIMARY KEY(lettera, lingua))");
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void creaDati(Statement st){
    aggiungiFrequenza('a', "ita", 12, st);
    aggiungiFrequenza('b', "ita", 1, st);
    aggiungiFrequenza('c', "ita", 4, st);
    aggiungiFrequenza('d', "ita", 3, st);
    aggiungiFrequenza('e', "ita", 12, st);
    aggiungiFrequenza('f', "ita", 1, st);
    aggiungiFrequenza('g', "ita", 2, st);
    aggiungiFrequenza('h', "ita", 2, st);
    aggiungiFrequenza('i', "ita", 11, st);
    aggiungiFrequenza('l', "ita", 6, st);
    aggiungiFrequenza('m', "ita", 3, st);
    aggiungiFrequenza('n', "ita", 7, st);
    aggiungiFrequenza('o', "ita", 10, st);
    aggiungiFrequenza('p', "ita", 3, st);
    aggiungiFrequenza('q', "ita", 1, st);
    aggiungiFrequenza('r', "ita", 6, st);
    aggiungiFrequenza('s', "ita", 5, st);
    aggiungiFrequenza('t', "ita", 5, st);
    aggiungiFrequenza('u', "ita", 3, st);
    aggiungiFrequenza('v', "ita", 2, st);
    aggiungiFrequenza('z', "ita", 1, st);
    
    aggiungiFrequenza('a', "eng", 8, st);
    aggiungiFrequenza('b', "eng", 2, st);
    aggiungiFrequenza('c', "eng", 3, st);
    aggiungiFrequenza('d', "eng", 4, st);
    aggiungiFrequenza('e', "eng", 13, st);
    aggiungiFrequenza('f', "eng", 2, st);
    aggiungiFrequenza('g', "eng", 2, st);
    aggiungiFrequenza('h', "eng", 2, st);
    aggiungiFrequenza('i', "eng", 7, st);
    aggiungiFrequenza('j', "eng", 2, st);
    aggiungiFrequenza('k', "eng", 2, st);
    aggiungiFrequenza('l', "eng", 4, st);
    aggiungiFrequenza('m', "eng", 2, st);
    aggiungiFrequenza('n', "eng", 7, st);
    aggiungiFrequenza('o', "eng", 8, st);
    aggiungiFrequenza('p', "eng", 2, st);
    aggiungiFrequenza('q', "eng", 1, st);
    aggiungiFrequenza('r', "eng", 6, st);
    aggiungiFrequenza('s', "eng", 6, st);
    aggiungiFrequenza('t', "eng", 9, st);
    aggiungiFrequenza('u', "eng", 3, st);
    aggiungiFrequenza('v', "eng", 1, st);
    aggiungiFrequenza('w', "eng", 2, st);
    aggiungiFrequenza('x', "eng", 2, st);
    aggiungiFrequenza('y', "eng", 2, st);
    aggiungiFrequenza('z', "eng", 1, st);
    
    aggiungiStudente("eva", "spia", "spia", "spia", st);
    aggiungiStudente("bob", "scrittore", "bob", "bob", st);
    aggiungiStudente("rob", "lettore", "rob", "rob", st);
    aggiungiStudente("admin", "admin", "admin", "admin", st);
    }
    
    public static void aggiungiFrequenza(char lettera, String lingua, int frequenza, Statement st){
        esegui("INSERT INTO frequenzaLingua (lettera, lingua, frequenza) VALUES ('"+lettera+"', '"+lingua+"', "+frequenza+");", st);
    }
    
    public static ArrayList getAlfabeto(String lingua, Statement st){
        ArrayList al = null;
        try {
            ResultSet rs = st.executeQuery("SELECT lettera FROM frequenzaLingua WHERE lingua = '"+lingua+"';");
            al = new ArrayList();
            while(rs.next()){
                al.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return al;
    }
    
    public static HashMap getFrequenzeAlfabeto(String lingua, Statement st){
        HashMap<String, Integer> map = null;
        try {
            ResultSet rs = st.executeQuery("SELECT lettera, frequenza FROM frequenzaLingua WHERE lingua = '"+lingua+"';");
            map = new HashMap();
            while(rs.next()){
                map.put(rs.getString("lettera"), rs.getInt("frequenza"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return map;
    }
    
    public static void aggiungiStudente(String nome, String cognome, String login, String password, Statement st){
        esegui("INSERT INTO studente (nome, cognome, login, password) VALUES ('"+nome+"', '"+cognome+"', '"+login+"', '"+password+"');", st);
    }
    
    public static Studente getStudente(String login, String password, Statement st){
        Studente studente = null;
        try {
            ResultSet rs = st.executeQuery("SELECT id, nome, cognome FROM studente WHERE login = '"+login+"' AND password = '"+password+"';");
            studente = new Studente(rs.getInt("id"), login, password, rs.getString("nome"), rs.getString("cognome"));
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return studente;
    }
    
    public static ArrayList<Studente> getStudenti(Statement st){
        ArrayList<Studente> al = new ArrayList();
        try {           
            ResultSet rs = st.executeQuery("SELECT id, login, nome, cognome  FROM studente;");
            while(rs.next()){
                Studente stud = new Studente(rs.getInt("id"), rs.getString("login"), "", rs.getString("nome"), rs.getString("cognome"));
                al.add(stud);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return al;
    }
}