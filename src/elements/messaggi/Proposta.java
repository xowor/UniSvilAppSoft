package elements.messaggi;
import SistemaCifratura.*;
import elements.utenti.UserInfo;
import java.sql.ResultSet;

public class Proposta {
    private int id;
    private String stato;
    private boolean notificata;
    
//    public SistemaDiCifratura sistema;
//    public int idp;
//    public String testoCifrato;
    
    public Proposta (ResultSet info){
        
    }

    public Proposta(UserInfo prop, UserInfo par, SistemaDiCifratura sdc){
        
    }

    public void setId(int idp){
        id = idp;
    }
    
    public void accetta(){
        this.stato = "approvata";
    }

    public void rifiuta(){
        this.stato = "rifiutata";
    }
}
