package elements.messaggi;
import SistemaCifratura.*;
import elements.Studente;
import elements.utenti.UserInfo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Proposta {
    private int id;
    private String stato;
    private boolean notificata;
    private int idMittente;
    private int idDestinatario;
    private int sistemaDiCifratura;
    
//    public SistemaDiCifratura sistema;
//    public int idp;
//    public String testoCifrato;
    
    public Proposta (ResultSet rs){
        try {
            this.id = rs.getInt("id");
            this.stato = rs.getString("stato");
            this.notificata = rs.getBoolean("notificata");
            this.idMittente = rs.getInt("idMittente");
            this.idDestinatario = rs.getInt("idDestinatario");
            this.sistemaDiCifratura = rs.getInt("sistemaDiCifratura");
        } catch (SQLException ex) {
            Logger.getLogger(Proposta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Proposta(UserInfo prop, UserInfo par, SistemaDiCifratura sdc){
        
    }
    
    @Override
    public String toString(){
        String name = Studente.getStudente(idMittente).getNickname();
        SistemaDiCifratura s = SistemaDiCifratura.load(this.sistemaDiCifratura);
        return name + ": " + s.getMetodo();
    }

//    public void setId(int idp){
//        id = idp;
//    }
//    
//    public void accetta(){
//        this.stato = "approvata";
//    }
//
//    public void rifiuta(){
//        this.stato = "rifiutata";
//    }
}
