package MainSystem;

import SistemaSupporto.Supporto;
import Elements.*;
import java.util.ArrayList;

public class Sessione {
    
    private Studente studente;
    private final int idSessione;
    private int idAlbero;
    private int idIpotesiCorrente;
    private Messaggio messaggioOriginaleCifrato;
    private AlberoIpotesi alberoIpotesi;
    private ArrayList<Supporto> strumentoSupporto;
    
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
        this.alberoIpotesi = DBManager.getAlberoIpotesi(idSes, idAlbero);
        this.messaggioOriginaleCifrato = DBManager.getMessaggio(idMessaggioCifrato);
    }
    
    // TODO
    public void setSupporto(){
        this.strumentoSupporto = null;
    }
    
    public void setAlberoIpotesi(String testo){
        this.alberoIpotesi = new AlberoIpotesi(this.idSessione, this.idAlbero, messaggioOriginaleCifrato.testoCifrato);
    }
    
}
