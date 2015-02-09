package MainSystem;
import Elementi.Frequenze;
import Elementi.messaggi.Messaggio;
import Elementi.Studente;
import SistemaCifratura.SistemaDiCifratura;
import Elementi.utenti.UserInfo;
import javax.management.Query;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBManager {
    
    public static Statement st;
    private static Connection conn;
    
    public DBManager(){}
    
    public Connection inizializza() {
        this.conn = openConnection();
        this.st = openStatement(conn);
        return conn;

        
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
    * Esegue una execute SQL ritornando un booleano;
    *
    * @param sql indica il testo di una execute SQL;
    * @param st indica lo Statement creato per l'interazione con il database;
    * @return "true" se la execute ha avuto successo;
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
    * Esegue una execute SQL ritornando un ResultSet;
    *
    * @param sql indica il testo di una execute SQL;
    * @param st indica lo Statement creato per l'interazione con il database;
    * @return il resultSet della execute eseguIT_it;
    */
    public static ResultSet execute(String sql) {
        try{
            Statement statement = openStatement(conn);
            if (sql.contains("INSERT") || sql.contains("UPDATE") || sql.contains("DELETE")){
                statement.executeUpdate(sql);
                return null;
            } else {
                ResultSet rs = statement.executeQuery(sql);
                return rs;
            }
          }catch(SQLException ex){
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
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
            "idAlbero INT," +
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
            "bozza BOOLEAN NOT NULL," +
            "letto BOOLEAN NOT NULL," +
            "PRIMARY KEY(id))");
            
            st.execute( "CREATE TABLE alberoIpotesi(" +
            "idAlbero INT NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1)," +
            "idSessione INT NOT NULL," +
            "idIpotesiRoot INT NOT NULL," +
            "PRIMARY KEY(idAlbero, idSessione))");
            
            st.execute( "CREATE TABLE userInfo(" +
            "id INT NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1)," +
            "nome VARCHAR(24) NOT NULL," +
            "cognome VARCHAR(24) NOT NULL," +
            "PRIMARY KEY(id))");
            
            st.execute( "CREATE TABLE proposta(" +
            "id INT NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1)," +
            "sistemaDiCifratura INT NOT NULL," +
            "stato VARCHAR(24) NOT NULL," +
            "notificata BOOLEAN NOT NULL," +
            "idMittente INT NOT NULL," +
            "idDestinatario INT NOT NULL," +
            "PRIMARY KEY(id))");
            
            st.execute( "CREATE TABLE sistemaDiCifratura(" +
            "id INT NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1)," +
            "idStudente INT NOT NULL," +            // idMittente
            //"idDestinatario INT NOT NULL," +
            "chiave VARCHAR(24) NOT NULL," +
            "metodo VARCHAR(24) NOT NULL," +
            //"accettazione VARCHAR(24) NOT NULL," +  // valore "proposta" --> il mittente ha inviato la proposta al destinatario
                                                    // valore "accettato" --> destinatario ha accettato
                                                    // valore "rifiutato" --> destinatario ha rifiutato
            "PRIMARY KEY(id))");
            
            st.execute( "CREATE TABLE ipotesi(" +
            "id INT NOT NULL," +
            "idSessione INT NOT NULL," +
            "idAlbero INT NOT NULL," +
            "idPadre INT NOT NULL," +
            "figli LONG VARCHAR NOT NULL," +
            "testoParzialmenteDecifrato LONG VARCHAR NOT NULL," +
            "delta LONG VARCHAR NOT NULL," +
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
        aggiungiFrequenza("j", "IT_it", 0, st);
        aggiungiFrequenza("k", "IT_it", 0, st);
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
        aggiungiFrequenza("w", "IT_it", 0, st);
        aggiungiFrequenza("x", "IT_it", 0, st);
        aggiungiFrequenza("y", "IT_it", 0, st);
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
    
    
    public static void salvaSistemaCifratura(Studente studente, String key, String metodo){
        esegui("INSERT INTO sistemadicifratura (idStudente, chiave, metodo) VALUES ("+ studente.getId() +", '"+key + "', '"+metodo+"')", st);
    }
    
    public static void eliminaSistemaCifratura(String key, String metodo){
        esegui("DELETE FROM sistemadicifratura WHERE chiave='"+key+"' AND metodo='"+metodo+"')", st);
    }
        
    public void aggiungiFrequenza(String lettera, String lingua, int frequenza, Statement st){
        esegui("INSERT INTO frequenzaLingua (lettera, lingua, frequenza) VALUES ('"+lettera+"', '"+lingua+"', "+frequenza+")", st);
    }
    
    public static Studente getStudente(int idSessione){
        Studente stud = null;
        try {
            ResultSet rs = st.executeQuery("SELECT idStudente FROM sessione WHERE id="+idSessione);
            if(rs.next()){
                int id = rs.getInt("idStudente");
                stud = Studente.getStudente(id);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return stud;
    }
    
    public static Messaggio getMessaggio(int idSessione){
        Messaggio mex = null;
        try {
            ResultSet rs = st.executeQuery("SELECT idMessaggioOriginaleCifrato FROM sessione WHERE id="+idSessione);
            if(rs.next()){
                int idMex = rs.getInt(1);
                rs = st.executeQuery("SELECT * FROM messaggio WHERE id="+idMex);
                rs.next();
                mex = new Messaggio(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mex;
    }
    
    public static void aggiungiIpotesi(int idSessione,  int idIpotesi, String testo, int idPadre, String figli, String delta){
        
        if(getIdAlbero(idSessione)<0){
            creaAlberoIpotesi(idSessione);
            HashMap<Integer, String> mappa = recuperaMessaggiCifrati(getStudente(idSessione));
            int idMex = -1;
            Set<Integer> keys = mappa.keySet();
            for(Integer i: keys){
                if(mappa.get(i).equals(testo)){
                    idMex = i;
                    break;
                }
            }
            esegui("UPDATE sessione SET idMessaggioOriginaleCifrato = " + idMex + " WHERE id =" + idSessione, st);
        }
        esegui("INSERT INTO ipotesi (id, idSessione, idAlbero, testoParzialmenteDecifrato, idPadre, figli, delta) VALUES "
                + "("+idIpotesi+", "+idSessione+", "+ getIdAlbero(idSessione)+", '"+testo+"', "+idPadre+", '"+figli+"', '"+delta+"')", st);
        ArrayList<Integer> newFigli = getArrayFigli(figli);
        if(idIpotesi != 0){
            String strFigli = getFigli(idPadre, idSessione);
            newFigli = new ArrayList<>();
            // figli vecchi
            ArrayList<Integer> figliTmp = getArrayFigli(strFigli);            
            for(int i = 0; i < figliTmp.size(); i++)
                newFigli.add(figliTmp.get(i));
            // figli nuovi
            newFigli.add(idIpotesi);
        }
        String figliFinali = getStringFromArray(newFigli);
        aggiornaFigli(idPadre, idSessione, figliFinali);
    }   
    
    
    public static Ipotesi getIpotesi(int idIpotesi, int idSessione){
        Ipotesi ip = null;
        try {
            if(getIdAlbero(idSessione)>0){
                ResultSet rs = st.executeQuery("SELECT * FROM ipotesi WHERE id="+idIpotesi+" AND idSessione="+idSessione+" "
                        + "AND idAlbero="+getIdAlbero(idSessione)+"");
                if(rs.next()){
                    String stringaFigli = rs.getString("figli");
                    String stringaTesto = rs.getString("testoParzialmenteDecifrato");
                    int padre = rs.getInt("idPadre");
                    String stringaDelta = rs.getString("delta");
                    
                    ArrayList<Integer> figli = getArrayFigli(stringaFigli);
                    ip = new Ipotesi(idIpotesi, idSessione, getIdAlbero(idSessione), stringaTesto, 
                        padre, figli, stringaDelta);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ip;
    }
    
    public static SistemaDiCifratura visualizzaSistemaCifratura(int id){
        SistemaDiCifratura sdc = null;
        try {
            ResultSet rs = st.executeQuery("SELECT * FROM sistemadicifratura WHERE id="+id+"");
            if(rs.next()){
                sdc = new SistemaDiCifratura(rs.getString("chiave"), rs.getString("metodo"), UserInfo.getUserInfo(rs.getInt("idStudente")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sdc;
    }
    
    public static ArrayList<SistemaDiCifratura> elencaSistemiCifratura(Studente studente){
        ArrayList<SistemaDiCifratura> lista = new ArrayList<SistemaDiCifratura>();
        int idStudente = studente.getId();
        try {
            ResultSet rs = st.executeQuery("SELECT * FROM sistemaDiCifratura WHERE idStudente="+idStudente+"");
            while(rs.next()){
                SistemaDiCifratura tmp = new SistemaDiCifratura(rs.getString("chiave"), rs.getString("metodo"), UserInfo.getUserInfo(rs.getInt("idStudente")));
                lista.add(tmp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    public static ArrayList<Integer> getArrayFigli(String figli){
         ArrayList<Integer> arrayFigli = new ArrayList<>();
        if(!figli.equals("[]")){
            String tmp = figli.substring(1, figli.length()-1);    
            if(figli.contains(",")){
                String[] str = tmp.split(",");
                for(int i = 0; i < str.length; i++){
                    String stringa = str[i];
                    int val = Integer.parseInt(stringa);
                    arrayFigli.add(val);
                }    
            }else{
                int val = Integer.parseInt(tmp);
                arrayFigli.add(val);
            }
            
        }
        return arrayFigli;
    }
        
    public static HashMap<Integer, String> recuperaMessaggiCifrati(Studente studente){                  // per la spia
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        try {
            ResultSet rs = st.executeQuery("SELECT id, testoCifrato FROM messaggio WHERE idDestinatario<>"+studente.getId()+""
                    + " AND idMittente<>"+studente.getId()+" AND bozza='false'");
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
        esegui("INSERT INTO studente (nome, cognome, login, password) VALUES ('"+nome+"', '"+cognome+"', '"+login+"', "
                + "'"+password+"')", st);
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
    

    
    public static int getIdAlbero(int idSessione){
        int id = -1;
        try {
            ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM alberoIpotesi WHERE idSessione = "+idSessione);
            rs.next();
            int tmp = rs.getInt(1);
            if (tmp>0){
                rs = st.executeQuery("SELECT idAlbero FROM sessione WHERE id = "+idSessione);
                rs.next();
                    id = rs.getInt("idAlbero");
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    
    public static AlberoIpotesi getAlberoIpotesi(int idSessione){
        AlberoIpotesi albero = null;
        Ipotesi ip = getIpotesi(0, idSessione);
        if(ip != null)
            albero = new AlberoIpotesi(ip);
        return albero;
    }

    
    public static void creaAlberoIpotesi(int idSessione){
        if(getIdAlbero(idSessione)<0){
            esegui("INSERT INTO alberoIpotesi(idSessione, idIpotesiRoot) VALUES("+idSessione+", "+0+")", st);
            int id = -1;
            try {
                ResultSet rs = st.executeQuery("SELECT idAlbero FROM alberoIpotesi WHERE idSessione = "+idSessione);
                if (rs.next()){
                    id = rs.getInt(1);   
                }         
            } catch (SQLException ex) {
                Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
            }
            esegui("UPDATE sessione SET idAlbero = "+id+", idIpotesi = " + 0 +" WHERE id = "+ idSessione, st);
        }
    }

    
    public static int getPadre(int idIpotesi, int idSessione){
        int id = -1;
        try {            
            ResultSet rs = st.executeQuery("SELECT idPadre FROM ipotesi WHERE id = "+idIpotesi+" AND "
                    + "idAlbero="+getIdAlbero(idSessione)+" AND idSessione="+idSessione+"");
            rs.next();
            id = rs.getInt("idPadre");            
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    
    public static String getFigli(int id, int idSessione){
        String figli = "";
        try {            
            ResultSet rs = st.executeQuery("SELECT figli FROM ipotesi WHERE id = "+id+""
                    + " AND idAlbero="+getIdAlbero(idSessione)+" AND idSessione="+idSessione+"");
            rs.next();
            figli = rs.getString("figli");            
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return figli;
    }
    
    public static String getTestoFromIpotesi(int id, int idSessione){
        String testo = "";
        try {            
            ResultSet rs = st.executeQuery("SELECT testoParzialmenteDecifrato FROM ipotesi WHERE id = "+id+" AND "
                    + "idAlbero="+getIdAlbero(idSessione)+" AND idSessione="+idSessione+"");
            rs.next();
            testo = rs.getString("figli");            
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return testo;
    }
    
    public static String getStringFromArray(ArrayList<Integer> array){
        String stringa = "";
        if(array.size() == 0){
            stringa = "[]";
        }else if(array.size() == 1){
            stringa = "["+array.get(0)+"]";
        }else{
            stringa+="[";
            for(int i = 0; i < array.size(); i++){
                stringa = stringa + array.get(i);
                if(i != array.size()-1)
                    stringa+=",";
            }
            stringa+="]";
        }
        return stringa;
    }
    
    public static void aggiornaFigli(int id, int idSessione, String figli){  
        esegui("UPDATE ipotesi SET figli = '"+figli+"' WHERE id = "+id+" AND "
                + "idAlbero="+getIdAlbero(idSessione)+" AND idSessione="+idSessione+"", st);
    }
    
    
    
    public static void rimuoviIpotesi(int idSessione, int id){
        // trovare il padre della tripletta
        int idPadre = getPadre(id, idSessione);
        // prendere i figli del padre
        String strFigli = getFigli(idPadre, idSessione);
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
        aggiornaFigli(idPadre, idSessione, figliFinali);

    }
}
