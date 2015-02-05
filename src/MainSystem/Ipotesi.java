package MainSystem;

import Elements.Messaggio;
import java.util.ArrayList;

public class Ipotesi {
    
    private int id;
    private String testoParzialmenteDecifrato;
    private int idPadre;
    private ArrayList<Integer> figli;
    
    public Ipotesi(int id, String testo, int padre, ArrayList<Integer> listaFigli){
        this.id = id;
        this.testoParzialmenteDecifrato = testo;
        this.idPadre = padre;
        this.figli = listaFigli;
    }

}