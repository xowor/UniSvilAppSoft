package MainSystem;

import elements.Studente;
import elements.messaggi.Messaggio;
import SistemaSupporto.Supporto;
import SistemaCifratura.SistemaDiCifratura;
import java.util.ArrayList;

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
    public Sessione(int idStud, int idSes){
        this.studente = DBManager.getStudente(idStud);
        this.idSessione = idSes;
    }
    
    // Sessione recuperata dal db
    public Sessione(int idSes, int idStud, int idAlb, int idMessaggioCifrato){
        this.studente = DBManager.getStudente(idStud);
        this.idSessione = idSes;
        this.idAlbero = idAlb;    
        this.alberoIpotesi = DBManager.getAlberoIpotesi(idSes);
        this.messaggioOriginaleCifrato = CommunicationController.visualizzaMessaggioInviato(idMessaggioCifrato);
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
        this.alberoIpotesi = new AlberoIpotesi(this.idSessione, this.idAlbero, this.messaggioOriginaleCifrato.getTestoCifrato()); 
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
    
}
