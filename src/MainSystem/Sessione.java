package MainSystem;

import static MainSystem.DBManager.esegui;
import static MainSystem.DBManager.st;
import elements.Studente;
import elements.messaggi.Messaggio;
import SistemaSupporto.Supporto;
import SistemaCifratura.SistemaDiCifratura;
import controllers.CommunicationController;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sessione {
    
    private Studente studente;
    private final int idSessione;
    private int idAlbero;
    private int idIpotesiCorrente;
    private Messaggio messaggioOriginaleCifrato;
    private AlberoIpotesi alberoIpotesi;
    private ArrayList<Supporto> strumentoSupporto;
//    private ArrayList<SistemaDiCifratura> sistemaCifratura;
    
    // Sessione iniziale senza aver ancora deciso cosa decifrare
    public Sessione(Studente studente, int idSes){
        this.studente = studente;
        this.idSessione = idSes;
    }
    
    // Sessione recuperata dal db
    public Sessione(int idSes, Studente studente, int idAlb, int idMessaggioCifrato){
        this.studente = studente;
        this.idSessione = idSes;
        this.idAlbero = idAlb;    
        this.alberoIpotesi = DBManager.getAlberoIpotesi(idSes);
        //this.messaggioOriginaleCifrato = CommunicationController.visualizzaMessaggioInviato(idMessaggioCifrato);
    }
    
    // pre: cosa sostituire
    // post: con cosa sostituire
    public String sostituisci(String testo, String pre, String post){
        return testo.replace(pre, post);
    }
    
    public void setSupporto(){
        this.strumentoSupporto = null;
    }
    
    public void setAlberoIpotesi(String testo){
        //this.alberoIpotesi = new AlberoIpotesi(this.idSessione, this.idAlbero, messaggioOriginaleCifrato.testoCifrato);
    }
    
    public static boolean verificaSoluzione(Messaggio messaggio, String soluzioneSpia){
        if(messaggio.getTesto().equals(soluzioneSpia))
            return true;
        return false;
    }
    
//    public void setSistemaCifratura(Studente id){
//        this.sistemaCifratura = DBManager.elencaSistemiCifratura(id);
//    }
    
    public Studente getStudente(){
        return this.studente;
    }

    public int getId() {
        return this.idSessione;
    }
    
    
    
    public static boolean getIfSessioneTerminate(Studente studente){
        try {
            ResultSet rs = DBManager.execute("SELECT COUNT(idIpotesi) FROM sessione WHERE idStudente = "
                    + "" + studente.getId() + " AND terminata = 'false'");
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
        esegui("UPDATE sessione SET terminata='true' WHERE idStudente='"+studente.getId()+"' AND terminata='true'", st);
    }
    
    public static Sessione getOrInsertSessione(Studente studente){
        Sessione sessione = null;
        // esiste una sessione iniziata?
        // no
        if(getIfSessioneTerminate(studente)){
            // conteggio delle vecchie sessioni dello studente
            int countVecchie = countVecchieSessioni( studente);
            // inizializzare una sessione
            esegui("INSERT INTO sessione (idStudente, idAlbero, terminata) VALUES (" + studente.getId() + ", "
                    + ""+(countVecchie+1)+", 'false')", st);
            // creare l'oggetto Sessione
            sessione = new Sessione(studente, getIdSessioneCorrente(studente));
        }else{  
            try {
                // si
                // recuperare la sessione con la decifratura già iniziata (terminata = false)
                ResultSet rs = st.executeQuery("SELECT * FROM sessione WHERE idStudente = " + studente.getId() + "");
                rs.next();
                sessione = new Sessione(rs.getInt("id"), studente, rs.getInt("idAlbero"), rs.getInt("idMessaggioOriginaleCifrato"));
            } catch (SQLException ex) {
                Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return sessione;
    }
}
