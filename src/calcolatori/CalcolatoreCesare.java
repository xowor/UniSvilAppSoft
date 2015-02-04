package calcolatori;
import MainSystem.*;

public class CalcolatoreCesare implements CalcolatoreMappe {
    
    static char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','y','x','z'};
    
    @Override
    public CalcolatoreMappe create(String met) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Mappatura calcola(String chiave) {
        char[] m = new char[26];
        int key = Integer.parseInt(chiave);
        for(int i=0; i<26; i++){
            m[i]= (char) ('a'+(i+key)%26);
        }
        System.out.println(String.valueOf(m));
        Mappatura out = new Mappatura(String.valueOf(m)); 
        return out;
    }

public static Mappatura cryptCaesar( String chiave){
        int key = Integer.parseInt(chiave);
        String out = "abcdefghijklmnopqrstuvwxyz";
        if(key>27){
            key=key%27;
        }
        if(key>0){
            for(int i =0;i<out.length();i++){
                char tmp = out.charAt(i);
                char sos = ' ';
                for(int j = 0; j< 26;j++){
                    if(tmp==alphabet[j]){
                        if(j-key<0){
                            sos = alphabet[j-key+26];
                        }
                        else{
                            sos = alphabet[j-key];
                        }
                    }
                }
                out = out.substring(0, i) + sos + out.substring(i+1, out.length());
            }
        }

        return new Mappatura(out);
    }       

    public static String decryptCaesar(int key, String message){
        String out = message;
        if(key>27){
            key=key%27;
        }
        if(key>0){
            for(int i =0;i<out.length();i++){
                char tmp = out.charAt(i);
                char sos = ' ';
                for(int j = 0; j< 26;j++){
                    if(tmp==alphabet[j]){
                        if(j-key<0){
                            sos = alphabet[j-key+26];
                        }
                        else{
                            sos = alphabet[j-key];
                        }
                    }
                }
                out = out.substring(0, i) + sos + out.substring(i+1, out.length());
            }
        }
        return out;
    }
}
