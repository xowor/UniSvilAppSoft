/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainSystem;

import Elements.Messaggio;

/**
 *
 * @author luca
 */
public class Sostituzione {
    
    int id;
    private String testo;
    
    private String sostituisci;
    private String sostituisciCon;
    
    public Sostituzione(String m){
        this.testo = m;
    }
    
    public String getTesto(){
        return this.testo;
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

    public void setTesto(String testo) {
        this.testo = testo;
    }
}
