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
    Messaggio messaggio;
    
    private String sostituisci;
    private String sostituisciCon;
    
    public Sostituzione(Messaggio m){
        this.messaggio = m;
    }
    
    public Messaggio getMessaggio(){
        return this.messaggio;
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
