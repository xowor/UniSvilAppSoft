package SistemaSupporto;

import Elements.Alfabeto;
import Elements.Frequenze;
import Elements.Messaggio;
import java.util.HashMap;

public class AnalisiFrequenze extends Supporto{
    
    public static Frequenze calcolaFrequenze(String testo, Alfabeto alfabeto){
        HashMap<String,Integer> map = new HashMap();
        
        // chiave hashmap -> lettera alfabeto
        for (int i = 0; i < alfabeto.getLettere().size(); i++){
            map.put(alfabeto.getLettere().get(i), 0);
        }
        
        // integer hash incrementato in corrispondenza dell'occorrenza della lettera
        for (int i = 0; i < testo.length(); i++){
            char c = testo.charAt(i);
            int val = map.get(String.valueOf(c)); 
            System.out.println(c);
            System.out.println(val);    
            map.replace(String.valueOf(c),  val + 1 );   
            System.out.println(c);
            System.out.println(val);    
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
