package SistemaCifratura;

public class CalcolatoreParolaChiave implements InterfacciaCalcolatori {

    @Override
    public InterfacciaCalcolatori create(String met) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Mappatura calcola(String chiave) {
        char[] key = chiave.toCharArray();
        char[] map ={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','y','x','z'};
        int[] esiste = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        char c;
        int j=0;
        for(int i=0; i < key.length; i++){
            while(esiste[j] == 1){
                j++;
            }
                if( esiste[(key[i])-'a']==0){
                    esiste[(key[i])-'a']=1;
                    esiste[j]=1;
                    c = map[j];
                    map[(key[i])-'a']=c;
                    map[j]=key[i];
                    j++;
                }
            }
        return new Mappatura(map);
    }
    /* ********************************************************************** */
    // Metodi di cifratura/decifratura
    
}
