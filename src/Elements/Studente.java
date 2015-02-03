package Elements;



public class Studente {
  public String nome;
  public String cognome;
  public String id;
  public String login;
  public String pwd;

  public Studente(String login, String pwd){
    this.login = login;
    this.pwd = pwd;
    // id++;
  }


  public String getNome(){
    return this.nome;
  }
  public String getCognome(){
    return this.cognome;
  }
  public String getId(){
    return this.id;
  }
  public String getLogin(){
    return this.login;
  }
  public String getPwd(){
    return this.pwd;
  }

  public void setNome(String nome){
    this.nome = nome;
  }
  public void setCognome(String cognome){
    this.cognome =cognome ;
  }
  public void setId(String id){
    this.id = id;
  }
  public void setLogin(String login){
    this.login = login;
  }
  public void setPwd(String pwd){
    this.pwd = pwd;
  }
  
  public String toString(){
      return this.nome;
  }
}
