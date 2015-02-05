package MainSystem;

import java.util.ArrayList;

public class Ipotesi {
    
    private int idSessione;
    private int idAlbero;
    private int idIpotesi;
    private String testoParzialmenteDecifrato;
    private int idPadre;
    private ArrayList<Integer> figli;
    
    public Ipotesi(int idSes, int idAlb, int idIp, String testo, int padre, ArrayList<Integer> listaFigli){
        this.idSessione = idSes;
        this.idAlbero = idAlb;
        this.idIpotesi = idIp;
        this.testoParzialmenteDecifrato = testo;
        this.idPadre = padre;
        this.figli = listaFigli;
        String figli = listaFigli.toString();
        DBManager.aggiungiIpotesi(idSes, idAlb, idIp, testo, padre, figli);
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

}