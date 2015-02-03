package Elements;

import java.util.List;
import javax.management.Query;

public class Messaggio {
  public String id;
  public String testo;
  public String testoCifrato;
  public String lingua;
  public String titolo;
  public boolean bozza;
  public boolean letto;
  public String idmitt;
  public String iddest;
  public String descmitt;
  public String descdest;


  public Messaggio(Query info){

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
