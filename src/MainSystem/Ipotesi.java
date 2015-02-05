package MainSystem;

import java.util.ArrayList;

public class Ipotesi {
    
    private int idSessione;
    private int idAlbero;
    private String testoParzialmenteDecifrato;
    private int idPadre;
    private ArrayList<Integer> figli;
    
    public Ipotesi(int idSes, int idAlb, String testo, int padre, ArrayList<Integer> listaFigli){
        this.idSessione = idSes;
        this.idAlbero = idAlb;
        this.testoParzialmenteDecifrato = testo;
        this.idPadre = padre;
        this.figli = listaFigli;
    }

}