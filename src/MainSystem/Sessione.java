package MainSystem;

import Elements.Alfabeto;
import SistemaSupporto.Supporto;
import Elements.*;
import java.util.ArrayList;

public class Sessione {
    private final int idStudente;
    private final int idSessione;
    private Messaggio messaggioCifrato;
    private AlberoIpotesi alberoIpotesi;
    private ArrayList<Supporto> strumentoSupporto;
    
    // Sessione iniziale senza aver ancora deciso cosa decifrare
    public Sessione(int idSes, int idStud){
        this.idStudente = idStud;
        this.idSessione = idSes;
    }
    
    // Sessione recuperata dal db
    public Sessione(int idSes, int idStud, int idAlbero, int idMessaggioCifrato){
        this.idStudente = idStud;
        this.idSessione = idSes;               
        this.alberoIpotesi = DBManager.getAlberoIpotesi(idAlbero);
        this.strumentoSupporto = null;
        this.messaggioCifrato = DBManager.getMessaggio(idMessaggioCifrato);
    }
    

    
    public void getAlberoIpotesi(){
        return this.alberoIpotesi;
    }
    
    public Supporto getSupporto(){
        return this.strumentoSupporto;
    }
     
    // TODO
    public void setSupporto(){
        this.strumentoSupporto = null;
    }
    
}
