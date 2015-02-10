package Elementi;

import MainSystem.DBManager;
import java.util.HashMap;

public class Frequenze {
    private HashMap<String,Integer> frequenze;
    
    public Frequenze(HashMap<String,Integer> frequenze){
        this.frequenze = frequenze;
    }
    
    public HashMap<String,Integer> getFrequenze(){
        return this.frequenze;
    }
    
    public static Frequenze getFrequenze(Alfabeto alfabeto){
        return new Frequenze(DBManager.getFrequenzeAlfabeto(alfabeto));
    }
    
    public void setFrequenze(HashMap<String,Integer> frequenze){
        this.frequenze = frequenze;
    }
}
