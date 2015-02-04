package Elements;

public class Alfabeto {
    private final String locale;
    private String[] lettere;
    
    public Alfabeto(String alphabet, String[] letters){
        this.locale = alphabet;
        this.lettere = letters;        
    }
    
    public String getCodice(){
        return this.locale;
    }
    
    public String[] getLettere(){
        return this.lettere;
    }
}
