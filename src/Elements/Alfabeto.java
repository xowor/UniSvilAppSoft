package Elements;

public class Alfabeto {
    private final String locale;
    private String[] lettere;
    private int[] frequenze;
    
    public Alfabeto(String alphabet, String[] letters, int[] frequecies){
        this.locale = alphabet;
        this.lettere = letters;
        this.frequenze = frequecies;
    }
    
    public String getCodice(){
        return this.locale;
    }
    
    public String[] getLettere(){
        return this.lettere;
    }
}
