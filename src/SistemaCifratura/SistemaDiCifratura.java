package SistemaCifratura;

import javax.management.Query;

public class SistemaDiCifratura {
    public String id;
    public String chiave;
    public String metodo;


    public SistemaDiCifratura(String key, String met){
        this.chiave = key;
        this.metodo = met;
    }

    public SistemaDiCifratura(Query info){
        // da completare
    }

//  public List<SistemaDiCifratura> caricaSistemiCifratura(Studente stud){
//
//  }

//  public SistemaDiCifratura load(String id){
//      
//  }

    public void calcolaMappatura(){

    }

    public void prova(){

    }

    public boolean elimina(){
        return false;
    }

    public boolean salva(){
        return false;
    }
}
