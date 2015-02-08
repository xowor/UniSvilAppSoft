package SistemaCifratura;

public class Cifratore {

    /* Metodo di cifratura */
    public static String cifra(Mappatura map, String testo){
        //genera una stringa modificabile
        StringBuilder msx = new StringBuilder(testo);
        // cicla sul testo
        for(int i = 0; i < testo.length(); i++){
            //la 'a' minuscola corrisponde al carattere ASCII n.97
            int charNumber = 97;
            // gestione punteggiatura
            if(charNumber == ',' || charNumber == ';' || charNumber == '.' || charNumber == ':' || charNumber == '-' || charNumber == '_' || 
                    charNumber == '?' || charNumber == '\'' || charNumber == '=' || charNumber == ')' || charNumber == '(' || 
                    charNumber == '"' || charNumber == '!')
                continue;
            charNumber = testo.charAt(i);
            // caratteri speciali ASCII
            if(charNumber==32 || charNumber==39){
                msx.setCharAt(i, ' ');
            }else{
                // sostituisce al carattere 'i' della stringa il corrispondente char della mappatura
                msx.setCharAt(i, map.mappa[charNumber-97]);
            }
        }
        return msx.toString();
    }
    
    /* Metodo di decifratura */
    public static String decifra(Mappatura map, String testo){
        //genera una stringa modificabile
        StringBuilder msx = new StringBuilder(testo);
        // cicla sul testo
        for(int i = 0; i < testo.length(); i++){
            //la 'a' minuscola corrisponde al carattere ASCII n.97
            int charNumber = 97;
            charNumber = testo.charAt(i);
            // gestione punteggiatura
            if(charNumber == ',' || charNumber == ';' || charNumber == '.' || charNumber == ':' || charNumber == '-' || charNumber == '_' || 
                    charNumber == '?' || charNumber == '\'' || charNumber == '=' || charNumber == ')' || charNumber == '(' || 
                    charNumber == '"' || charNumber == '!')
                continue;
            // caratteri speciali ASCII
            if(charNumber==32 || charNumber==39){
                msx.setCharAt(i, ' ');
            }else{
                // sostituisce al carattere 'i' della stringa il corrispondente char della mappatura inversa
                msx.setCharAt(i, map.mappaInversa[charNumber-97]);
            }
        }
        return msx.toString();
    }
    
    public static String converti(String testo){
        testo.replace('è', 'e');
        testo.replace('é', 'e');
        testo.replace('à', 'a');
        testo.replace('ò', 'o');
        testo.replace('ì', 'i');
        testo.replace('ù', 'u');    
        return testo;
    }
}
