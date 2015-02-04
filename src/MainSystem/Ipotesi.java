package MainSystem;

import Elements.Messaggio;

public class Ipotesi {
    
    int id;
    Messaggio messaggio;
    
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
}
