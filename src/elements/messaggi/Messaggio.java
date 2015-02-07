package elements.messaggi;

import SistemaCifratura.SistemaDiCifratura;
import elements.Studente;
import java.util.List;

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
//    private int idMitt;
//    private int idDest;
//    private String descMitt;
//    public String descDest;


    public Messaggio(String testo){
        this.testo = testo;
    }
    
    public Messaggio(String titolo, String testo, String testoCifrato, int mitt, int dest, String lingua){
        this.titolo = titolo;
        this.testo = testo;
//        this.idMitt = mitt;
//        this.idDest = dest;
        this.lingua = lingua;
        this.testoCifrato = testoCifrato;
        this.sistemaDiCifratura = null;
    }
    

    public String getTesto(){
        return this.testo;
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
        return this.testoCifrato;
    }

    @Override
    public boolean isBozza() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getLingua() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getTitolo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isLetto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
