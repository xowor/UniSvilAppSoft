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
}
