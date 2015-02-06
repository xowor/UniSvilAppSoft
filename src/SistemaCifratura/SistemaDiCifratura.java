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
        salva();
    }
    
    public SistemaDiCifratura(int id, String key, String met){
        this.id = id;
        this.chiave = key;
        this.metodo = met;
        this.calcola = CalcolatoreMappe.create(met);
    }
    
    public ArrayList<SistemiDiCifratura> caricaSistemaCifratura(Studente s){
        return DBManager.getSistemaDiCifratura(s);
    }

    public SistemiDiCifratura caricaSistemaCifratura(int id){
        return DBManager.getSistemaDiCifratura(id);
    }
    
    public void calcolaMappatura(){
        this.mappatura = calcola.calcola(this.chiave);
    }
    
    public boolean salva(){
        return DBManager.salvaSistemaCifratura(this);
    }
    
    public boolean elimina(){
        return DBManager.eliminaSistemaCifratura(this.id);
    }
}
