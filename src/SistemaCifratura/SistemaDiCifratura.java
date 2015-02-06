package SistemaCifratura;


public class SistemaDiCifratura {
    public String id;
    public String chiave;
    public String metodo;


    public SistemaDiCifratura(String key, String met){
        this.chiave = key;
        this.metodo = met;
    }


    public Mappatura calcolaMappatura(String chiave, String metodo){
        if(this.metodo.equals("cesare")){
            return CalcolatoreCesare.cifraCesare(chiave);
        } else if (this.metodo.equals("monoalfabetica")){
            return null;
        } else return null;
    }

}
