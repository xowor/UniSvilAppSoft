package SistemaCifratura;


public interface CalcolatoreMappe {
    public CalcolatoreMappe create(String met);
    public Mappatura calcola(String chiave);
}
