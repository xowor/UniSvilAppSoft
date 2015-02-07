package elements;

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
  
  @Override
  public String toString(){
      return this.nickname;
  }
}
