package MainSystem;
import Elements.Frequenze;
import Elements.Messaggio;
import Elements.Studente;
import javax.management.Query;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBManager {
    
    public static Statement st;
    private static Connection conn;
    public DBManager(){}
    
    public void inizializza() {
        this.conn = openConnection();

        this.st=openStatement(conn);
        //creaTabelle();
        //creaDati();
        //closeStatement(st);
        //closeConnection(conn);
    }
    /**
    * crea uno Statement con il database;
    *
    * @param conn indica una connessione disponibile per creare uno Statement;
    * @return uno Statement aperto;
    */
    public Statement openStatement(Connection conn) {
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
    public void closeStatement(Statement st){
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
    public Connection openConnection() {
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
    * @return il resultSet della query eseguIT_it;
    */
    public ResultSet query(String sql, Statement st) {
        try{
         return st.executeQuery(sql);
        }catch(SQLException e){return null;}
    }
    
    /**
    * Chiude la Connection precedentemente creata;
    *
    * @param conn indica la Connessione da chiudere;
    */
    public void closeConnection(Connection conn) {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void creaTabelle(){
        try {
            st.execute( "CREATE TABLE studente(" +
            "id INT NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1)," +
            "nome VARCHAR(24) NOT NULL," +
            "cognome VARCHAR(24) NOT NULL," +
            "login VARCHAR(24) NOT NULL UNIQUE," +
            "password VARCHAR(24) NOT NULL," +
            "PRIMARY KEY(id))");
           
            st.execute( "CREATE TABLE sessione(" +
            "id INT NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1)," +
            "idStudente INT NOT NULL," +
            "idAlbero INT NOT NULL," +
                    // idIpotesi == idIpotesi dell'ipotesi raggiunta nell'alberoIpotesi
            "idIpotesi INT," +
            "idMessaggioOriginaleCifrato INT," +
            "terminata BOOLEAN NOT NULL," +     // false = sessione corrente; true = chiusa
            "PRIMARY KEY(id))");
            
            st.execute( "CREATE TABLE messaggio(" +
            "id INT NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1)," +
            "testo LONG VARCHAR NOT NULL," +
            "testoCifrato LONG VARCHAR NOT NULL," +
            "lingua VARCHAR(12) NOT NULL," +
            "titolo VARCHAR(24) NOT NULL," +
            "idMittente INT NOT NULL," +
            "idDestinatario INT NOT NULL," +
            "bozza LONG VARCHAR NOT NULL," +
            "letto BOOLEAN NOT NULL," +
            "PRIMARY KEY(id))");
            
            st.execute( "CREATE TABLE alberoIpotesi(" +
            "idAlbero INT NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1)," +
            "idSessione INT NOT NULL," +
            "idIpotesiRoot INT NOT NULL," +
            "PRIMARY KEY(idAlbero))");
            
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
            "idSessione INT NOT NULL," +
            "idAlbero INT NOT NULL," +
            "idPadre INT NOT NULL," +
            "figli LONG VARCHAR NOT NULL," +
            "testoParzialmenteDecifrato LONG VARCHAR NOT NULL," +
            "PRIMARY KEY(id, idSessione, idAlbero))");
            
            st.execute( "CREATE TABLE frequenzaLingua(" +
            "lettera VARCHAR(1) NOT NULL," +
            "lingua VARCHAR(12) NOT NULL," +
            "frequenza INT NOT NULL," +
            "PRIMARY KEY(lettera, lingua))");
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void creaDati(){
        aggiungiFrequenza("a", "IT_it", 12, st);
        aggiungiFrequenza("b", "IT_it", 1, st);
        aggiungiFrequenza("c", "IT_it", 4, st);
        aggiungiFrequenza("d", "IT_it", 3, st);
        aggiungiFrequenza("e", "IT_it", 12, st);
        aggiungiFrequenza("f", "IT_it", 1, st);
        aggiungiFrequenza("g", "IT_it", 2, st);
        aggiungiFrequenza("h", "IT_it", 2, st);
        aggiungiFrequenza("i", "IT_it", 11, st);
        aggiungiFrequenza("l", "IT_it", 6, st);
        aggiungiFrequenza("m", "IT_it", 3, st);
        aggiungiFrequenza("n", "IT_it", 7, st);
        aggiungiFrequenza("o", "IT_it", 10, st);
        aggiungiFrequenza("p", "IT_it", 3, st);
        aggiungiFrequenza("q", "IT_it", 1, st);
        aggiungiFrequenza("r", "IT_it", 6, st);
        aggiungiFrequenza("s", "IT_it", 5, st);
        aggiungiFrequenza("t", "IT_it", 5, st);
        aggiungiFrequenza("u", "IT_it", 3, st);
        aggiungiFrequenza("v", "IT_it", 2, st);
        aggiungiFrequenza("z", "IT_it", 1, st);

        aggiungiFrequenza("a", "EN_us", 8, st);
        aggiungiFrequenza("b", "EN_us", 2, st);
        aggiungiFrequenza("c", "EN_us", 3, st);
        aggiungiFrequenza("d", "EN_us", 4, st);
        aggiungiFrequenza("e", "EN_us", 13, st);
        aggiungiFrequenza("f", "EN_us", 2, st);
        aggiungiFrequenza("g", "EN_us", 2, st);
        aggiungiFrequenza("h", "EN_us", 2, st);
        aggiungiFrequenza("i", "EN_us", 7, st);
        aggiungiFrequenza("j", "EN_us", 2, st);
        aggiungiFrequenza("k", "EN_us", 2, st);
        aggiungiFrequenza("l", "EN_us", 4, st);
        aggiungiFrequenza("m", "EN_us", 2, st);
        aggiungiFrequenza("n", "EN_us", 7, st);
        aggiungiFrequenza("o", "EN_us", 8, st);
        aggiungiFrequenza("p", "EN_us", 2, st);
        aggiungiFrequenza("q", "EN_us", 1, st);
        aggiungiFrequenza("r", "EN_us", 6, st);
        aggiungiFrequenza("s", "EN_us", 6, st);
        aggiungiFrequenza("t", "EN_us", 9, st);
        aggiungiFrequenza("u", "EN_us", 3, st);
        aggiungiFrequenza("v", "EN_us", 1, st);
        aggiungiFrequenza("w", "EN_us", 2, st);
        aggiungiFrequenza("x", "EN_us", 2, st);
        aggiungiFrequenza("y", "EN_us", 2, st);
        aggiungiFrequenza("z", "EN_us", 1, st);           

        aggiungiStudente("eva", "spia", "spia", "spia", st);
        aggiungiStudente("bob", "scrittore", "bob", "bob", st);
        aggiungiStudente("rob", "lettore", "rob", "rob", st);
        aggiungiStudente("admin", "admin", "admin", "admin", st);   
    }
    
    public void aggiungiMessaggio(String testo, String lingua, String titolo, String bozza, Boolean letto, int idMitt, int idDest){
        esegui("INSERT INTO messaggio (testo, lingua, titolo, idMittente, idDestinatario, bozza, letto) VALUES ('"+testo
                +"', '"+lingua+"', '"+titolo+"', '"+idMitt+"', '"+idDest+"','"+bozza+"', '"+letto+"')", st);
    }
    
    public void aggiungiFrequenza(String lettera, String lingua, int frequenza, Statement st){
        esegui("INSERT INTO frequenzaLingua (lettera, lingua, frequenza) VALUES ('"+lettera+"', '"+lingua+"', "+frequenza+")", st);
    }
    
    public static void aggiungiIpotesi(int idSessione, int idAlbero, int idIpotesi, String testo, int idPadre, String figli){
        esegui("INSERT INTO ipotesi (idSessione, idAlbero, testoParzialmenteDecifrato, idPadre, figli) VALUES ("+idSessione+", "+idAlbero+", '"+testo+"', "+idPadre+", '"+figli+"')", st);
    }
    
    public static Ipotesi getIpotesi(int idIpotesi, int idSessione, int idAlbero){
        Ipotesi ip = null;
        try {
            ResultSet rs = st.executeQuery("SELECT * FROM ipotesi WHERE idIpotesi="+idIpotesi+", idSessione="+idSessione+", idAlbero="+idAlbero+"");
            rs.next();
            ArrayList<Integer> figli = getArrayFigli(rs.getString("figli"));
            ip = new Ipotesi(idIpotesi, idSessione, idAlbero, rs.getString("testoParzialmenteDecifrato"), 
                    rs.getInt("idPadre"), figli);
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ip;
    }
    
    public static ArrayList<Integer> getArrayFigli(String figli){
        ArrayList<Integer> arrayFigli = new ArrayList<>();
        String[] str = figli.split(",");
        for(int i = 0; i < str.length; i++){
            int val = Integer.parseInt(str[i]);
            arrayFigli.add(val);
        }
        return arrayFigli;
    }
        
    public HashMap<Integer, String> recuperaMessaggiCifrati(){                  // per la spia
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        try {
            ResultSet rs = st.executeQuery("SELECT id, testoCifrato FROM messaggio");
            while(rs.next()){
                map.put(rs.getInt("id"), rs.getString("testoCifrato"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return map;
    }
    
    public static ArrayList<String> getAlfabeto(String lingua){
        ArrayList<String> al = null;
        try {
            ResultSet rs = st.executeQuery("SELECT lettera FROM frequenzaLingua WHERE lingua = '"+lingua+"'");
            al = new ArrayList();
            while(rs.next()){
                al.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return al;
    }
   
    public static HashMap<String, Integer> getFrequenzeAlfabeto(String lingua){
        HashMap<String, Integer> map = new HashMap();        
        try {
            ResultSet rs = st.executeQuery("SELECT lettera, frequenza FROM frequenzaLingua WHERE lingua = '"+lingua+"'");
            map = new HashMap();
            while(rs.next()){
                map.put(rs.getString("lettera"), rs.getInt("frequenza"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return map;
    }
     
    public void aggiungiStudente(String nome, String cognome, String login, String password, Statement st){
        esegui("INSERT INTO studente (nome, cognome, login, password) VALUES ('"+nome+"', '"+cognome+"', '"+login+"', '"+password+"')", st);
    }
    
    public static Studente getStudente(int id){
        Studente studente = null;
        try {
            ResultSet rs = st.executeQuery("SELECT * FROM studente WHERE id = id");
            if (rs.next()){
                studente = new Studente(id, rs.getString("login"), rs.getString("password"), rs.getString("nome"), rs.getString("cognome"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return studente;
    }
    
    public Studente getStudenteDaNome(String nome){
        Studente studente = null;
        try {
            ResultSet rs = st.executeQuery("SELECT * FROM studente WHERE nome = '" + nome + "'");
            if (rs.next()){
                studente = new Studente(rs.getInt("id"), rs.getString("login"), rs.getString("password"), nome, rs.getString("cognome"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return studente;
    }
    
    public Studente getStudente(String login, String password){
        Studente studente = null;
        try {
            ResultSet rs = st.executeQuery("SELECT * FROM studente WHERE login = '"+login+"' AND password = '"+password+"'");
            if (rs.next()){
                studente = new Studente(rs.getInt("id"), login, password, rs.getString("nome"), rs.getString("cognome"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return studente;
    }
   
    public ArrayList<Studente> getStudenti(){
        
        ArrayList<Studente> al = new ArrayList();
        try {           
            PreparedStatement ps = conn.prepareStatement("SELECT id, login, nome, cognome  FROM studente");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Studente stud = new Studente(rs.getInt("id"), rs.getString("login"), "", rs.getString("nome"), rs.getString("cognome"));
                al.add(stud);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return al;
    }
    
    public boolean getIfSessioneTerminate(int idStudente){
        try {
            ResultSet rs = st.executeQuery("SELECT COUNT(idIpotesi) FROM sessione WHERE idStudente = "+idStudente+" AND terminata = 'false'");
            rs.next();
            // se le sessioni non terminate (-> aperte) == 0
            if(rs.getInt(1) == 0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public int countVecchieSessioni(int idStudente){
        int count = -1;
        try {
            ResultSet rs = st.executeQuery("SELECT COUNT(id) FROM sessione WHERE idStudente = "+idStudente+"");
            rs.next();
            count = rs.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }
    
    public int getIdSessioneCorrente(int idStudente){
        int id = -1;
        try {
            ResultSet rs = st.executeQuery("SELECT id FROM sessione WHERE idStudente = "+idStudente+" AND terminata = 'false'");
            rs.next();
            id = rs.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    
    public Sessione getOrInsertSessione(int idStudente){
        Sessione sessione = null;
        // esiste una sessione iniziata?
        // no
        if(getIfSessioneTerminate(idStudente)){
            // conteggio delle vecchie sessioni dello studente
            int countVecchie = countVecchieSessioni(idStudente);
            // inizializzare una sessione
            esegui("INSERT INTO sessione (idStudente, idAlbero, terminata) VALUES ("+idStudente+", "+(countVecchie+1)+", 'false')", st);
            // creare l'oggetto Sessione
            sessione = new Sessione(getIdSessioneCorrente(idStudente), idStudente);
        }else{  
            try {
                // si
                // recuperare la sessione con la decifratura già iniziata (terminata = false)
                ResultSet rs = st.executeQuery("SELECT * FROM sessione WHERE idStudente = "+idStudente+"");
                rs.next();
                sessione = new Sessione(rs.getInt("id"), idStudente, rs.getInt("idAlbero"), rs.getInt("idMessaggioOriginaleCifrato"));
            } catch (SQLException ex) {
                Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return sessione;
    }
    
    public static Messaggio getMessaggio(int idMessaggio){
        Messaggio messaggio = null;
        try {            
            ResultSet rs = st.executeQuery("SELECT * FROM messaggio WHERE id = "+idMessaggio+"");
            rs.next();
            messaggio = new Messaggio(rs.getString("titolo"), rs.getString("testo"), rs.getInt("mittente"), 
                    rs.getInt("destinatario"), rs.getString("lingua"));            
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return messaggio;
    }
    
    public static ArrayList<Messaggio> getMessaggi(int idDestinatario){
        ArrayList<Messaggio> messaggi = new ArrayList();
        try {           
            ResultSet rs = st.executeQuery("SELECT * FROM messaggio WHERE idDestinatario = " + idDestinatario + "");
            rs.next();
            while(rs.next()){
                Messaggio messaggio = new Messaggio(rs.getString("titolo"), rs.getString("testo"), rs.getInt("mittente"), 
                    rs.getInt("mittente"), rs.getString("lingua"));  
                messaggi.add(messaggio);
            }   
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return messaggi;
    }
    
    public static AlberoIpotesi getAlberoIpotesi(int idSessione, int idAlbero){
        AlberoIpotesi albero = null;
        if(idAlbero != -1){
            Ipotesi ip = getIpotesi(0, idSessione, idAlbero);
            albero = new AlberoIpotesi(ip);
        }
        return albero;
    }
    
    public static int getPadre(int idIpotesi,  int idAlbero, int idSessione){
        int id = -1;
        try {            
            ResultSet rs = st.executeQuery("SELECT idPadre FROM ipotesi WHERE id = "+idIpotesi+"AND "
                    + "idAlbero="+idAlbero+" AND idSessione="+idSessione+"");
            rs.next();
            id = rs.getInt("idPadre");            
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    
    public static String getFigli(int id, int idAlbero, int idSessione){
        String figli = "";
        try {            
            ResultSet rs = st.executeQuery("SELECT figli FROM ipotesi WHERE id = "+id+""
                    + " AND idAlbero="+idAlbero+" AND idSessione="+idSessione+"");
            rs.next();
            figli = rs.getString("figli");            
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return figli;
    }
    
    public static String getTestoFromIpotesi(int id, int idAlbero, int idSessione){
        String testo = "";
        try {            
            ResultSet rs = st.executeQuery("SELECT testoParzialmenteDecifrato FROM ipotesi WHERE id = "+id+" AND "
                    + "idAlbero="+idAlbero+" AND idSessione="+idSessione+"");
            rs.next();
            testo = rs.getString("figli");            
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return testo;
    }
    
    public static String getStringFromArray(ArrayList<Integer> array){
        String stringa = "";
        for(int i = 0; i < array.size(); i++){
            stringa = stringa + array.get(i)+",";
        }
        return stringa;
    }
    
    public static void aggiornaFigli(int id, int idAlbero, int idSessione, String figli){  
        esegui("UPDATE ipotesi SET figli = '"+figli+"' WHERE id = "+id+" AND "
                + "idAlbero="+idAlbero+" AND idSessione="+idSessione+"", st);
    }
    
    public static void rimuoviIpotesi(int idSessione, int idAlbero, int id){
        // trovare il padre della tripletta
        int idPadre = getPadre(id, idAlbero, idSessione);
        // prendere i figli del padre
        String strFigli = getFigli(idPadre, idAlbero, idSessione);
        ArrayList<Integer> figli = getArrayFigli(strFigli);
        // creare un nuovo array list senza l'id da parametro
        ArrayList<Integer> newFigli = new ArrayList<>();
        for(int i = 0; i < figli.size(); i++){
            if(figli.get(i) != id)
                newFigli.add(figli.get(i));
        }
        // convertire l'arrayList in String
        String figliFinali = getStringFromArray(newFigli);
        // sostituire la lista di figli nel padre
        aggiornaFigli(idPadre, idAlbero, idSessione, figliFinali);

    }
}
