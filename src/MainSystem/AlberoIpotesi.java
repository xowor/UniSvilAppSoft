
package MainSystem;


import Elements.*;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.swing.JTree;
import javax.swing.tree.TreeNode;

public class AlberoIpotesi extends JTree{
    
    public int idSessione;
    public int idAlbero;
    private final NodoIpotesi root;
    public int idCounter = 0;           // numero di nodi dell'albero
                                    // utile per capire quale id assegnare al nodo successivo
    
      
    public AlberoIpotesi(int idSes, int idAlb, String cifrato){
        this.idSessione = idSes;
        this.idAlbero = idAlb;
        this.root = new NodoIpotesi(this.idSessione, this.idAlbero, cifrato);
        
    }
    
    
    /* Classe interna */
    private class NodoIpotesi implements TreeNode{
        
        private int parent;
        private Ipotesi ipotesi;
        private ArrayList<NodoIpotesi> listaFigli;
        
        /* ****************************************************************** */
        /* Costruttori */
        
        // root
        private NodoIpotesi(int idSes, int idAlb, String testo){
            this.parent = 0;
            this.ipotesi = new Ipotesi(idSes, idAlb, idCounter, testo, 0, new ArrayList<>());
            idCounter++;
            listaFigli = new ArrayList<>();
        }
        
        // nuovo nodo ipotesi
        private NodoIpotesi(Ipotesi ip){
            this.parent = ip.getParent();
            this.ipotesi = ip;
            ArrayList<Integer> tmp = ip.getFigli();
            int ses = ip.getSessione();
            int alb = ip.getAlbero();
            if(!tmp.isEmpty()){
                for(Integer idNewIp : tmp){
                    Ipotesi temp = DBManager.getIpotesi(ses, alb, idNewIp);
                    this.listaFigli.add(new NodoIpotesi(temp));
                }
            }
            
        }
        
        /* ****************************************************************** */
        /* Metodi interni */
        
        /* Aggiunge un nuovo figlio */
        
        
        public void aggiungiIpotesi(String testo){
            Ipotesi tmp = new Ipotesi(this.ipotesi.getSessione(), this.ipotesi.getAlbero(), idCounter, testo, this.ipotesi.getId(), new ArrayList<Integer>());
            idCounter++;
            this.listaFigli.add(new NodoIpotesi(tmp));
        }
 
        public int getPadre(){
            return this.parent;
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
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

}

