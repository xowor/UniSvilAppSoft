package MainSystem;

import Elements.*;

public class Sessione {
    private final int idStudente;
    private final int idSessione;
    private Alfabeto alfabeto;
    private AlberoIpotesi alberoIpotesi;
    private Supporto strumentoSupporto;
    
    public Sessione(int idStud, int idSes){
        this.idStudente = idStud;
        this.idSessione = idSes;
    }
    
    public void setAlfabeto(){
        this.alfabeto = null;
    }
    
    public void setAlberoIpotesi(){
        this.alberoIpotesi = null;
    }
    
    public void setSupporto(){
        this.strumentoSupporto = null;
    }
}
