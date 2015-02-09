/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementi.utenti;

import MainSystem.DBManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luca
 */
public class UserInfo {
    private final int id;
    private final String nome;
    private final String cognome;
    
    public UserInfo(int id, String nome, String cognome){
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
    }
    
    public int getId(){
        return this.id;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public String getCognome(){
        return this.cognome;
    }
    
    public static UserInfo getUserInfo(int idStudente){
        UserInfo info = null;
        try {
           ResultSet rs = DBManager.execute("SELECT * FROM studente WHERE id = " + idStudente);
           if (rs.next()){
              info = new UserInfo(idStudente, rs.getString("nome"), rs.getString("cognome"));
           }
        } catch (SQLException ex) {
           Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return info;
    }
}