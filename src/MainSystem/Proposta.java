package MainSystem;
import SistemaCifratura.*;

public class Proposta {
    int id;
    String destinatario = "";
    String accettata;
    
    public SistemaDiCifratura sistema;
    public int idp;
    public String testoCifrato;

    public Proposta(SistemaDiCifratura sisC){
        sistema = sisC;
    }

    public void setId(int idp){
        id = idp;
    }
    public void accetta(){
        accettata = "approvata";
    }

    public void rifiuta(){
        accettata = "rifiutata";
    }

    public void setDest(String nome){
        this.destinatario = nome;
    }
}
