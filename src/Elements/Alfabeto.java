package Elements;

import MainSystem.DBManager;
import java.util.ArrayList;

public class Alfabeto {
    
    private final String locale;
    private ArrayList<String> lettere;
    private Frequenze frequenze;
    
    public Alfabeto(String lingua){
        this.locale = lingua;
        this.lettere = DBManager.getAlfabeto(lingua);
        this.frequenze = new Frequenze(lingua);
    }
    
    public String getLocale(){
        return this.locale;
    }
    
    public ArrayList<String> getLettere(){
        return this.lettere;
    }
    
    public Frequenze getFrequenze(){
        return this.frequenze;
    }
}
