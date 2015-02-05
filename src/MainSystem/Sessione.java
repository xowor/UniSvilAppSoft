package MainSystem;

import Elements.Alfabeto;
import SistemaSupporto.Supporto;
import Elements.*;
import java.util.ArrayList;

public class Sessione {
    
    private Studente studente;
    private final int idSessione;
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
    public Sessione(int idSes, int idStud, int idAlbero, int idMessaggioCifrato){
        this.studente = DBManager.getStudente(idStud);
        this.idSessione = idSes;               
        this.alberoIpotesi = DBManager.getAlberoIpotesi(idAlbero);
        this.strumentoSupporto = null;
        this.messaggioOriginaleCifrato = DBManager.getMessaggio(idMessaggioCifrato);
    }
    
    // TODO
    public void setSupporto(){
        this.strumentoSupporto = null;
    }
    
    public void setAlberoIpotesi(String testo){
        this.alberoIpotesi = new AlberoIpotesi(this.idSessione, messaggioOriginaleCifrato.testoCifrato);
    }
    
}
