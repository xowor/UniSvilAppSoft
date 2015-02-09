package MainSystem;

import java.util.ArrayList;

public class Ipotesi {
    
    private int idSessione;
    private int idAlbero;
    private int idIpotesi;
    private String testoParzialmenteDecifrato;
    private int idPadre;
    private ArrayList<Integer> figli;
    private String delta;
    
    public Ipotesi(int idSes, int idAlb, int idIp, String testo, int padre, ArrayList<Integer> listaFigli, String delta){
        this.idSessione = idSes;
        this.idAlbero = idAlb;
        this.idIpotesi = idIp;
        this.testoParzialmenteDecifrato = testo;
        this.idPadre = padre;
        this.figli = listaFigli;
        this.delta = delta;
    }
    
    public void aggiungiIpotesi(){
        String figli = this.figli.toString();
        DBManager.aggiungiIpotesi(this.idSessione, this.idIpotesi, this.testoParzialmenteDecifrato, 
                this.idPadre, figli, this.delta);
    }
    
    public void rimuoviIpotesi(){
        DBManager.rimuoviIpotesi(this.idSessione, this.idAlbero, this.idIpotesi);
    }
    
    public void addFiglio(int figlio){
        this.figli.add(figlio);
        
    }
    
    public int getSessione(){
        return this.idSessione;
    }
    
    public int getAlbero(){
        return this.idAlbero;
    }
    
    public int getId(){
        return this.idIpotesi;
    }
    
    public int getParent(){
        return this.idPadre;
    }
    
    public ArrayList<Integer> getFigli(){
        return this.figli;
    }

    public String getTestoParzialmenteDecifrato(){
        return this.testoParzialmenteDecifrato;
    }

    String getDelta() {
        return this.delta;
    }
}