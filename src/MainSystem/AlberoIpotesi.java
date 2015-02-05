
package MainSystem;


import Elements.*;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.swing.JTree;
import javax.swing.tree.TreeNode;

public class AlberoIpotesi extends JTree{
    
    public int idSessione;
    public int idAlbero;
    private final Ipotesi root;
    public int idCounter = 0;           // numero di nodi dell'albero
                                    // utile per capire quale id assegnare al nodo successivo
    
      
    public AlberoIpotesi(int idSes, int idAlb, String cifrato){
        this.idSessione = idSes;
        this.idAlbero = idAlb;
        this.root = new Ipotesi(this.idSessione, this.idAlbero, 0, cifrato, 0, new ArrayList<>());
        
    }
    
    
    /* Classe interna */
    private class NodoIpotesi implements TreeNode{
        
        private final int id;
        private final int parent;
        private Ipotesi ipotesi;
        private ArrayList<Integer> listaFigli;
        
        /* ****************************************************************** */
        /* Costruttori */
        
        // root
        private NodoIpotesi(int idSes, int idAlb, String testo){
            this.id = 0;
            this.parent = 0;
            this.listaFigli = new ArrayList<>();
            this.ipotesi = new Ipotesi(idSes, idAlb, idCounter, testo, this.parent, this.listaFigli);
            idCounter++;
        }
        
        // nuovo nodo ipotesi
        private NodoIpotesi(int idSes, int idAlb, String testo, int padre, int id){
            this.id = id;
            this.parent = padre;
            this.listaFigli = new ArrayList<>();
            this.ipotesi = new Ipotesi(idSes, idAlb, idCounter, testo, this.parent, this.listaFigli);
        }
        
        /* ****************************************************************** */
        /* Metodi interni */
        
        /* Aggiunge un nuovo figlio */
        
        
        public void aggiungiIpotesi(String testo){
            idCounter++;
            this.listaFigli.add(idCounter);
            new NodoIpotesi(idSessione, idAlbero, testo, this.id, idCounter);
        }
        
        public String getPath(){
            String path = "";
            NodoIpotesi tmp = this;
            while(tmp.getPadre()!= 0){
                path+= this.parent;
                tmp = getNodo(this.parent);
            }
            return path;
        }
        
        /* Aggiungere query che costruisca nodo */
        public NodoIpotesi getNodo(int id){
            return null;
        }
        
        /* Torna al padre ed elimina il figlio */
        
        public int annullaIpotesi(){
            
            return -1;
        }
        
        public int getPadre(){
            return this.parent;
        }
        
        /* Ritorna l'id del nodo */
        
        public int getId() {
            return this.id;
        }
        
        /* ****************************************************************** */
        
        /* Metodi in Override */
        
        @Override
        public TreeNode getChildAt(int childIndex) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public int getChildCount() {
            return this.listaFigli.size();
        }

        @Override
        public TreeNode getParent() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public int getIndex(TreeNode node) {
            return this.id;
        }

        @Override
        public boolean getAllowsChildren() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean isLeaf() {
            return this.listaFigli.isEmpty();
        }

        @Override
        public Enumeration children() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
        
        /* ****************************************************************** */
    }

    public Alfabeto getAlfabeto(){
        return this.alfabeto;
    }
 /*   public AlberoIpotesi getAlberoIpotesi(){
        return ;
    }*/
}

