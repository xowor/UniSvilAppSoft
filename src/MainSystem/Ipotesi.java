package MainSystem;

import Elements.Messaggio;

public class Ipotesi {
    
    int id;
    Messaggio messaggio;
    
    public Ipotesi(Messaggio m, int id){
        this.id = id;
        this.messaggio = m;
    }
    
    public Messaggio getTesto(){
        return messaggio;
    }
    
    public void setTesto(String testo){
        messaggio.setTesto(testo);
    }
}
