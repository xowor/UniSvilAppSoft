package elements.messaggi;

import SistemaCifratura.SistemaDiCifratura;
import elements.Studente;
import elements.utenti.UserInfo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Messaggio implements MessaggioMittente, MessaggioDestinatario{
    private int id;
    private String testo;
    private String testoCifrato;
    private String lingua;
    private String titolo;
    private boolean bozza;
    //private String oggetto;
    private boolean letto;
    private SistemaDiCifratura sistemaDiCifratura;
    private UserInfo mittente;
    private UserInfo destinatario;
//    private String descMitt;
//    public String descDest;


    public Messaggio(ResultSet rs){
        try {
            this.titolo = rs.getString("titolo");
            this.testo = rs.getString("testo");
            this.testoCifrato = rs.getString("testoCifrato");
            this.mittente = UserInfo.getUserInfo(rs.getInt("idMittente"));
            this.destinatario = UserInfo.getUserInfo(rs.getInt("idDestinatario"));
            this.lingua = rs.getString("lingua");
            this.bozza = rs.getBoolean("bozza");
            this.letto = rs.getBoolean("letto");
            this.id = rs.getInt("id");
        } catch (SQLException ex) {
            Logger.getLogger(Messaggio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Messaggio(String titolo, String testo, String testoCifrato, UserInfo mitt, UserInfo dest, String lingua){
        this.titolo = titolo;
        this.testo = testo;
        this.mittente = mitt;
        this.destinatario = dest;
        this.lingua = lingua;
        this.testoCifrato = testoCifrato;
        this.sistemaDiCifratura = null;
    }
    
    public Messaggio(){
    }
    

    public String getTesto(){
        return this.testo;
    }
    
    public int getId(){
        return this.id;
    }

    public String getTestoCifrato(){
        return this.testoCifrato;
    }

    public void setTesto(String testo){
        this.testo = testo;
    }

    public void setTestoCifrato(String testoCifrato){
        this.testoCifrato = testoCifrato ;
    }
    
    public void setLetto(boolean letto){
        this.letto = letto ;
    }

    public static Messaggio load(String id){
        return null;
    }

    public static List<Messaggio> caricaBozze(Studente stud){

        return null;
    }

    public  static List<Messaggio> caricaInviati(Studente stud){

        return null;
    }

    public static List<Messaggio> caricaRicevuti(Studente stud){

        return null;
    }

    public boolean elimina(){

        return false;
    }


    public boolean salva(){
        return false;
    }


    public void cifra(){

    }
    
    public String getLocale(){
        return this.lingua;
    }
    
    @Override
    public String toString(){
        return this.mittente.getNome() + ": " + this.titolo;
    }

    @Override
    public boolean isBozza() {
        return this.bozza;
    }

    @Override
    public String getLingua() {
        return this.lingua;
    }

    @Override
    public String getTitolo() {
        return this.titolo;
    }

    @Override
    public boolean isLetto() {
        return this.letto;
    }
    
    public UserInfo getMittente(){
        return this.mittente;
    }
    
    public UserInfo getDestinatario(){
        return this.destinatario;
    }

}
