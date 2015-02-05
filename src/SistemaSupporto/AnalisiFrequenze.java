package SistemaSupporto;

import Elements.Alfabeto;
import Elements.Frequenze;
import Elements.Messaggio;
import java.util.HashMap;

public class AnalisiFrequenze {
    public static Frequenze calcolaFrequenze(Messaggio messaggio, Alfabeto alfabeto){
        HashMap<String,Integer> map = new HashMap();
        String testo = messaggio.getTesto();
        
        for (int i = 0; i < testo.length(); i++){
            map.put(alfabeto.getLettere()[0], 0);
        }
        
        for (int i = 0; i < testo.length(); i++){
            char c = testo.charAt(i);
            
            map.replace(String.valueOf(c),  (map.get(c)) + 1 );
        }
        
        int pc = 100 / testo.length();
        
        for (int i = 0; i < testo.length(); i++){
            char c = testo.charAt(i);
            
            map.replace(String.valueOf(c),  (map.get(c)) * pc );
        }
            
        return new Frequenze(map);
    }
}
