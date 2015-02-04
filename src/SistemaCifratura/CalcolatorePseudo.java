package SistemaCifratura;
import MainSystem.*;

public class CalcolatorePseudo implements CalcolatoreMappe {
    
    
    @Override
    public CalcolatoreMappe create(String met) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Mappatura calcola(String chiave) {
        return new Mappatura(chiave);
    }

    

  
    
}
