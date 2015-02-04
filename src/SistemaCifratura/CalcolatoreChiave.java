package SistemaCifratura;
import MainSystem.*;

public class CalcolatoreChiave implements CalcolatoreMappe {

    @Override
    public CalcolatoreMappe create(String met) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public Mappatura calcola(String chiave) {
        
      char[] map ={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','y','x','z'};
      int[] esiste = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
      char c;
      int j=0;
      for(int i=0; i< chiave.length();i++){
        while(esiste[j]==1){j++;}
        
        if( esiste[(chiave.charAt(i))-'a']==0){
          
            esiste[(chiave.charAt(i))-'a']=1;
            esiste[j]=1;
            c=map[j];
            map[(chiave.charAt(i))-'a']=c;
            map[j]=chiave.charAt(i);
            j++;
          }
      }
       
      return new Mappatura(String.valueOf(map));
  }    
}
