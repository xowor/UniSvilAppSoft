package SistemaCifratura;
import MainSystem.*;

public class CalcolatorePseudoCasuale implements InterfacciaCalcolatori {
    
    
    @Override
    public InterfacciaCalcolatori create(String met) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Mappatura calcola(String chiave) {
        char[] c = chiave.toCharArray();
        return new Mappatura(c);
    }

    /* ********************************************************************** */
    // Metodi di cifratura/decifratura

  
    
}
