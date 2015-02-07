package elements;

import MainSystem.DBManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Studente {
  public int id;
  public String nickname;
  public String password;
  public String nome;
  public String cognome;

  public Studente(int id, String login, String pwd, String nome, String cognome){
    this.nickname = login;
    this.password = pwd;
    this.nome = nome;
    this.cognome = cognome;
    this.id = id;
  }


  public String getNome(){
    return this.nome;
  }
  public String getCognome(){
    return this.cognome;
  }
  public int getId(){
    return this.id;
  }
  public String getNickname(){
    return this.nickname;
  }
  public String getPwd(){
    return this.password;
  }

  public void setNome(String nome){
    this.nome = nome;
  }
  public void setCognome(String cognome){
    this.cognome =cognome ;
  }
  public void setId(int id){
    this.id = id;
  }
  public void setNickname(String nickname){
    this.nickname = nickname;
  }
  public void setPwd(String pwd){
    this.password = pwd;
  }
  
    public static Studente getStudente(int idStudente){
        Studente studente = null;
        try {
            ResultSet rs = DBManager.execute("SELECT * FROM studente WHERE id = '" + idStudente + "'");
            if (rs.next()){
                studente = new Studente(idStudente, rs.getString("login"), rs.getString("password"), rs.getString("nome"), rs.getString("cognome"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return studente;
    }
  
    public static ArrayList<Studente> getStudenti(){
        ArrayList<Studente> studenti = new ArrayList<Studente>();
        try {
            ResultSet rs = DBManager.execute("SELECT * FROM studente");
            while (rs.next()){
                studenti.add( new Studente(rs.getInt("id"), rs.getString("login"), rs.getString("password"), rs.getString("nome"), rs.getString("cognome")) );
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return studenti;
    }
  
  
  
  @Override
  public String toString(){
      return this.nickname;
  }
}
