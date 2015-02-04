package Elements;

public class Studente {
  public String nome;
  public String cognome;
  public int id;
  public String login;
  public String pwd;

  public Studente(int id, String login, String pwd, String nome, String cognome){
    this.login = login;
    this.pwd = pwd;
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
  public void setId(int id){
    this.id = id;
  }
  public void setLogin(String login){
    this.login = login;
  }
  public void setPwd(String pwd){
    this.pwd = pwd;
  }
  
  @Override
  public String toString(){
      return this.nome;
  }
}
