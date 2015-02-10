package MainSystem;

import Elementi.Alfabeto;
import static MainSystem.DBManager.esegui;
import static MainSystem.DBManager.st;
import Elementi.Studente;
import Elementi.messaggi.Messaggio;
import SistemaSupporto.Supporto;
import SistemaSupporto.AnalisiFrequenze;
import SistemaSupporto.Dizionario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sessione {
    
    private int idSessione;
    private Studente studente;
    private AlberoIpotesi alberoIpotesi;
    private Ipotesi ipotesiCorrente;
    private Messaggio messaggio;
    private Alfabeto alfabeto;
    
    // Sessione iniziale senza aver ancora deciso cosa decifrare
    public Sessione(Studente studente, int idSes){
        this.studente = studente;
        this.idSessione = idSes;
    }
    
    // Sessione recuperata dal db
    public Sessione(int idSes, Studente studente, int idAlb, int idMessaggioCifrato){
        this.studente = studente;
        this.idSessione = idSes;
    }
    
    // pre: cosa sostituire
    // post: con cosa sostituire
    public String sostituisci(String testo, String pre, String post){
        return testo.replace(pre, post);
    }
    
    public static boolean verificaSoluzione(Messaggio messaggio, String soluzioneSpia){
        if(messaggio.getTesto().equals(soluzioneSpia))
            return true;
        return false;
    }
    
    public Studente getStudente(){
        return this.studente;
    }

    public int getId() {
        return this.getIdSessione();
    }
    
    
    
    public static boolean getIfSessioneTerminate(Studente studente){
        try {
            ResultSet rs = DBManager.execute("SELECT COUNT(id) FROM sessione WHERE idStudente = "
                    + studente.getId() + " AND terminata = 'false'");
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
    
    public static int countVecchieSessioni(Studente studente){
        int count = -1;
        try {
            ResultSet rs = DBManager.execute("SELECT COUNT(id) FROM sessione WHERE idStudente = " + studente.getId() + "");
            rs.next();
            count = rs.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }
    
    public static int getIdSessioneCorrente(Studente studente){
        int id = -1;
        try {
            ResultSet rs = DBManager.execute("SELECT id FROM sessione WHERE idStudente = " + studente.getId() + " "
                    + "AND terminata = 'false'");
            rs.next();
            id = rs.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    
    public static void terminaSessione(Studente studente){
        esegui("UPDATE sessione SET terminata='true' WHERE idStudente="+studente.getId()+" AND terminata='false'", st);
    }
    
    public static Sessione getOrInsertSessione(Studente studente){
        Sessione sessione = null;
        // esiste una sessione iniziata?
        // no
        if(getIfSessioneTerminate(studente)){
            System.out.println("NUOVA SESSIONE");
            // inizializzare una sessione
            esegui("INSERT INTO sessione (idStudente, terminata) VALUES (" + studente.getId() + ", 'false')", st);
            // creare l'oggetto Sessione
            sessione = new Sessione(studente, getIdSessioneCorrente(studente));
        }else{  
            try {
                
                System.out.println("VECCHIA SESSIONE");
                // si
                // recuperare la sessione con la decifratura già iniziata (terminata = false)
                ResultSet rs = st.executeQuery("SELECT * FROM sessione WHERE idStudente = " + studente.getId() + " AND terminata = false");
                if(rs.next()){
                sessione = new Sessione(rs.getInt("id"), studente, rs.getInt("idAlbero"), rs.getInt("idMessaggioOriginaleCifrato"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return sessione;
    }
    
    
    public Supporto getSupporto(String nome){
        if (nome.equals("Dizionario")) return new Dizionario();
        if (nome.equals("AnalisiFrequenze")) return new AnalisiFrequenze();
        return null;
    }
    

    /**
     * @return the idSessione
     */
    public int getIdSessione() {
        return idSessione;
    }

    /**
     * @param idSessione the idSessione to set
     */
    public void setIdSessione(int idSessione) {
        this.idSessione = idSessione;
    }

    /**
     * @param studente the studente to set
     */
    public void setStudente(Studente studente) {
        this.studente = studente;
    }

    /**
     * @return the alberoIpotesi
     */
    public AlberoIpotesi getAlberoIpotesi() {
        return alberoIpotesi;
    }

    /**
     * @param alberoIpotesi the alberoIpotesi to set
     */
    public void setAlberoIpotesi(AlberoIpotesi alberoIpotesi) {
        this.alberoIpotesi = alberoIpotesi;
    }

    /**
     * @return the ipotesiCorrente
     */
    public Ipotesi getIpotesiCorrente() {
        return ipotesiCorrente;
    }

    /**
     * @param ipotesiCorrente the ipotesiCorrente to set
     */
    public void setIpotesiCorrente(Ipotesi ipotesiCorrente) {
        this.ipotesiCorrente = ipotesiCorrente;
    }

    /**
     * @return the messaggio
     */
    public Messaggio getMessaggio() {
        return messaggio;
    }

    /**
     * @param messaggio the messaggio to set
     */
    public void setMessaggio(Messaggio messaggio) {
        this.messaggio = messaggio;
    }

    /**
     * @return the alfabeto
     */
    public Alfabeto getAlfabeto() {
        return alfabeto;
    }

    /**
     * @param alfabeto the alfabeto to set
     */
    public void setAlfabeto(Alfabeto alfabeto) {
        this.alfabeto = alfabeto;
    }
}
