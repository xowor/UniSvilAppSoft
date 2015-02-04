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
}
