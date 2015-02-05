package Elements;

import java.util.List;

public class Messaggio {
    public int id;
    public String testo;
    public String testoCifrato;
    public String lingua;
    public String oggetto;
    public boolean bozza;
    public boolean letto;
    public int idMitt;
    public int idDest;
    public String descMitt;
    public String descDest;


    public Messaggio(String testo){
        this.testo = testo;
    }
    
    public Messaggio(String titolo, String testo, int mitt, int dest, String lingua){
        this.oggetto = titolo;
        this.testo = testo;
        this.idMitt = mitt;
        this.idDest = dest;
        this.lingua = lingua;
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
    
    public void setLetto(boolean b){
        this.letto = b ;
    }

    public Messaggio load(String id){
        return null;
    }

    public List<Messaggio> caricaBozze(Studente stud){

        return null;
    }

    public List<Messaggio> caricaInviati(Studente stud){

        return null;
    }

    public List<Messaggio> caricaRicevuti(Studente stud){

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


}
