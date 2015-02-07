package elements;

import MainSystem.DBManager;
import java.util.HashMap;

public class Frequenze {
    private HashMap<String,Integer> frequenze;
    
    public Frequenze(String lingua){
        this.frequenze = DBManager.getFrequenzeAlfabeto(lingua);
    }
    
    public HashMap<String,Integer> getFrequenze(){
        return this.frequenze;
    }
    
    public void setFrequenze(HashMap<String,Integer> frequenze){
        this.frequenze = frequenze;
    }
}
