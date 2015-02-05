package SistemaCifratura;
public class Mappatura {
    char[] mappa;
    char[] mappaInversa;
    
    public Mappatura(char[] mapp){
       mappa = mapp;
       mappaInversa = creaMappaInversa(mapp);
    }
    
      public static char[] creaMappaInversa(char[] mapp){
       char[] mappaIP = new char[26];
       char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','y','x','z'};
       char c;
       for(int i=0; i < 26; i++){
           c = mapp[i];
               mappaIP[c-97] = alphabet[i];
       }
       return mappaIP;
   }
}
