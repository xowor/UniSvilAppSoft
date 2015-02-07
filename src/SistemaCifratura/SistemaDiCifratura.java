package SistemaCifratura;

import Elements.Studente;
import MainSystem.DBManager;
import java.util.ArrayList;


public class SistemaDiCifratura {
    public int id;
    public String chiave;
    public String metodo;
    CalcolatoreMappe calcola;
    Mappatura mappatura;


    public SistemaDiCifratura(String key, String met){
        this.chiave = key;
        this.metodo = met;
        this.calcola = CalcolatoreMappe.create(met);
        calcolaMappatura();
        DBManager.aggiungiSistemaCifratura(key,met);
    }
    
    public SistemaDiCifratura(int id, String key, String met){
        this.id = id;
        this.chiave = key;
        this.metodo = met;
        this.calcola = CalcolatoreMappe.create(met);
        calcolaMappatura();
    }
    
    public ArrayList<SistemaDiCifratura> caricaSistemaCifratura(Studente s){
        return DBManager.getSistemiDiCifratura(s);
    }

    public SistemaDiCifratura caricaSistemaCifratura(int id){
        return DBManager.getSistemaDiCifratura(id);
    }
    
    public void calcolaMappatura(){
        if (this.calcola != null)
            this.mappatura = calcola.calcola(this.chiave);
    }
    
    
    public void elimina(){
        DBManager.eliminaSistemaCifratura(this.chiave, this.metodo);
    }
    
    @Override
    public String toString(){
        return metodo + " / " + chiave;
    }
}
