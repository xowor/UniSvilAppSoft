package SistemaSupporto;

import Elementi.Alfabeto;
import Elementi.Frequenze;
import Elementi.messaggi.Messaggio;
import java.util.HashMap;

public class AnalisiFrequenze implements Supporto{
    
    public static Frequenze calcolaFrequenze(String testo, Alfabeto alfabeto){
        HashMap<String,Integer> map = new HashMap();
        
        // chiave hashmap -> lettera alfabeto
        for (int i = 0; i < alfabeto.getLettere().size(); i++){
            map.put(alfabeto.getLettere().get(i), 0);
        }
        
        // integer hash incrementato in corrispondenza dell'occorrenza della lettera
        for (int i = 0; i < testo.length(); i++){
            char c = testo.charAt(i);
            if(c != ' '){
                int val = map.get(String.valueOf(c));   
                map.replace(String.valueOf(c),  val + 1 );
            }
        }
                
        
        for (String lett: map.keySet()){
            int val = map.get(lett);
            map.replace(lett,  (val * 100) / testo.length() );
        }
          
        Frequenze freq = new Frequenze(alfabeto.getLocale());
        freq.setFrequenze(map);
        return freq;
    }
}
