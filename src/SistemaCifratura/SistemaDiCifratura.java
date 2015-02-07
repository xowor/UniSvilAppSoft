package SistemaCifratura;

import elements.Studente;
import MainSystem.DBManager;
import elements.utenti.UserInfo;
import java.util.ArrayList;


public class SistemaDiCifratura {
    private int id;
    private String chiave;
    private String metodo;
    private UserInfo creatore;
    CalcolatoreMappe calcola;
    Mappatura mappatura;


    public SistemaDiCifratura(String key, String met){
        this.chiave = key;
        this.metodo = met;
//        this.calcola = CalcolatoreMappe.create(met);
//        calcolaMappatura();
//        DBManager.salvaSistemaCifratura(studente,key,met);
    }
    
    public SistemaDiCifratura(int id, String key, String met){
        this.id = id;
        this.chiave = key;
        this.metodo = met;
//        this.calcola = CalcolatoreMappe.create(met);
//        calcolaMappatura();
    }
    
    public ArrayList<SistemaDiCifratura> caricaSistemaCifratura(Studente s){
        return DBManager.elencaSistemiCifratura(s);
    }

    public SistemaDiCifratura caricaSistemaCifratura(int id){
        return DBManager.visualizzaSistemaCifratura(id);
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
