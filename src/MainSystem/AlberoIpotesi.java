
package MainSystem;


import Elements.*;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.swing.JTree;
import javax.swing.tree.TreeNode;

public class AlberoIpotesi extends JTree{
    
    private final NodoIpotesi root;
    private int idAlbero = 0;
    private Alfabeto alfabeto;
    public int idCounter;           // numero di nodi dell'albero
                                    // utile per capire quale id assegnare al nodo successivo
    
    public AlberoIpotesi(int id, Messaggio cifrato, String lingua){
        this.idAlbero = id;
        this.root = new NodoIpotesi(cifrato);
        this.alfabeto = new Alfabeto(lingua); 
        this.idCounter = 0;
    }
    
    /* Classe interna */
    private class NodoIpotesi implements TreeNode{
        
        private final int id;
        private final int parent;
        private ArrayList<Integer> listaFigli;
        
        /* ****************************************************************** */
        /* Costruttori */
        
        private NodoIpotesi(Messaggio mex){
            this.id = 0;
            this.parent = 0;
            Ipotesi tmp = new Ipotesi(mex, this.id);
            this.listaFigli = new ArrayList<>();
        }
        
        private NodoIpotesi(Messaggio mex, int padre, int id){
            this.id = id;
            this.parent = padre;
            Ipotesi tmp = new Ipotesi(mex, this.id);
            this.listaFigli = new ArrayList<>();
        }
        
        /* ****************************************************************** */
        /* Metodi interni */
        
        /* Aggiunge un nuovo figlio */
        
        public void aggiungiIpotesi(Messaggio mex){
            idCounter++;
            Ipotesi tmp = new Ipotesi(mex, idCounter);
            this.listaFigli.add(idCounter);        
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

