package Elements;

public class Alfabeto {
    private final String locale;
    private String[] elements;
    
    public Alfabeto(String alphabet, String[] letters){
        this.locale = alphabet;
        this.elements = letters;        
    }
    
    public String[] getCodice(){
        return this.elements;
    }
}
