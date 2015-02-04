
package MainSystem;

import Elements.Messaggio;

public class Ipotesi {
    
    int id;
    Messaggio messaggio;
    
    private String sostituisci;
    private String sostituisciCon;
    
    public Ipotesi(Messaggio m, int id){
        this.id = id;
        this.messaggio = m;
    }
    
    public Messaggio getMessaggio(){
        return this.messaggio;
    }
    
    public void setTesto(String testo){
        this.messaggio.setTesto(testo);
    }
    
    public void setSostituisci(String sostituisci){
        this.sostituisci = sostituisci;
    }   
    
    public void setSostituisciCon(String sostituisciCon){
        this.sostituisciCon = sostituisciCon;
    }
    
    public String getSostituisci(){
        return this.sostituisci;
    }   
    
    public String getSostituisciCon(){
        return this.sostituisciCon;
    }
}

