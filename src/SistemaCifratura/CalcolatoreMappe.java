package SistemaCifratura;

public abstract class CalcolatoreMappe {
    
    public static CalcolatoreMappe create(String metodo){
        if(metodo.equals("cesare"))
            return  new CalcolatoreCesare();
        if(metodo.equals("parola chiave"))
            return new CalcolatoreChiave();
        if(metodo.equals("random"))
            return new CalcolatorePseudo();
        return null;
    }
    
    abstract Mappatura calcola(String chiave);
}
