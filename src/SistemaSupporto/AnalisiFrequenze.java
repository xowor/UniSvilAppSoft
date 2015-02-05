package SistemaSupporto;

import Elements.Alfabeto;
import Elements.Frequenze;
import Elements.Messaggio;
import java.util.HashMap;

public class AnalisiFrequenze extends Supporto{
    
    public static Frequenze calcolaFrequenze(Messaggio messaggio, Alfabeto alfabeto){
        HashMap<String,Integer> map = new HashMap();
        String testo = messaggio.getTesto();
        
        // chiave hashmap -> lettera alfabeto
        for (int i = 0; i < testo.length(); i++){
            map.put(alfabeto.getLettere().get(i), 0);
        }
        
        // integer hash incrementato in corrispondenza dell'occorrenza della lettera
        for (int i = 0; i < testo.length(); i++){
            char c = testo.charAt(i);            
            map.replace(String.valueOf(c),  (map.get(c)) + 1 );
        }
        
        int pc = 100 / testo.length();
        
        
        for (int i = 0; i < testo.length(); i++){
            char c = testo.charAt(i);            
            map.replace(String.valueOf(c),  (map.get(c)) * pc );
        }
          
        Frequenze freq = new Frequenze(alfabeto.getLocale());
        freq.setFrequenze(map);
        return freq;
    }
}
