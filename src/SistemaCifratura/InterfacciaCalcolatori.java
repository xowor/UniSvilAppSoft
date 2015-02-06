package SistemaCifratura;

public interface InterfacciaCalcolatori {
    public InterfacciaCalcolatori create(String met);
    public Mappatura calcola(String chiave);
}
