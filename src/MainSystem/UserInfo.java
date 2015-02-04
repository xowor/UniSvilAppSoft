package MainSystem;

public class UserInfo {
    private final int id;
    private final String nome;
    private final String cognome;
    
    public UserInfo(int i, String n, String c){
        this.id = i;
        this.nome = n;
        this.cognome = c;
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
}
