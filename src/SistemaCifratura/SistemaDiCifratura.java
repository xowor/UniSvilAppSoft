package SistemaCifratura;

import elements.Studente;
import MainSystem.DBManager;
import elements.utenti.UserInfo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


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
//        DBManager.aggiungiSistemaCifratura(studente,key,met);
    }
    
    public SistemaDiCifratura(int id, String key, String met){
        this.id = id;
        this.chiave = key;
        this.metodo = met;
//        this.calcola = CalcolatoreMappe.create(met);
//        calcolaMappatura();
    }
    
    public static ArrayList<SistemaDiCifratura> caricaSistemaCifratura(Studente studente){
        ArrayList<SistemaDiCifratura> lista = new ArrayList<SistemaDiCifratura>();
        int idStudente = studente.getId();
        try {
            ResultSet rs = DBManager.execute("SELECT * FROM sistemaDiCifratura WHERE idStudente="+idStudente+"");
            while(rs.next()){
                lista.add( new SistemaDiCifratura(rs.getString("chiave"), rs.getString("metodo")) );
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
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
