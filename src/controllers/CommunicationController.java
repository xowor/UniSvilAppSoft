/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import MainSystem.Proposta;
import MainSystem.UserInfo;
import SistemaCifratura.SistemaDiCifratura;
import elements.Studente;
import elements.messaggi.Messaggio;
import java.util.List;

/**
 *
 * @author luca
 */
public class CommunicationController {
    
    public void send(Messaggio messaggio){
        
    }
    
    public List<UserInfo> getDestinatari(Studente studente){
        return null;
    }

    public void inviaProposta(Studente studente, UserInfo partner, SistemaDiCifratura sistemaDiCIfratura){
        
    }
    
    public List<Proposta> getAccettazioneProposte(Studente studente){
        return null;
    }
    
    public List<Proposta> getProposte(Studente studente){
        return null;
    }
    
    public void inviaDecisione(Proposta proposta, String dec){
        
    }
    
    public Messaggio apriMessaggioRicevuto(String id){
        return null;
    }
}
