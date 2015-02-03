package Elements;

import Elements.Studente;
import Studente;

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


  public Messaggio(QueryResult info){

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
    this.testoCifrato =testoCifrato ;
  }



  public Messaggio load(String id){

  }

  public List<Messaggio> caricaBozze(Studente stud){

  }

  public List<Messaggio> caricaInviati(Studente stud){

  }

  public List<Messaggio> caricaRicevuti(Studente stud){

  }

  public boolean elimina(){

  }


  public boolean salva(){

  }


  public void cifra(){

  }


}
