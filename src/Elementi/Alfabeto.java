package Elementi;

import MainSystem.DBManager;
import java.util.ArrayList;

public class Alfabeto {
    
    private final String locale;
    private ArrayList<String> lettere;
    
    public Alfabeto(String lingua){
        this.locale = lingua;
        this.lettere = DBManager.getAlfabeto(lingua);
    }
    
    public String getLocale(){
        return this.locale;
    }
    
    public ArrayList<String> getLettere(){
        return this.lettere;
    }
}
