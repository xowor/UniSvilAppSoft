
package MainSystem;


import Elements.*;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.swing.JTree;
import javax.swing.tree.TreeNode;

public final class AlberoIpotesi extends JTree{
    
    public int idSessione;
    public int idAlbero;
    private final NodoIpotesi root;
    public int idCounter;           // numero di nodi dell'albero
                                    // utile per capire quale id assegnare al nodo successivo
    
      
    public AlberoIpotesi(int idSes, int idAlb, String cifrato){
        this.idSessione = idSes;
        this.idAlbero = idAlb;
        this.root = new NodoIpotesi(this.idSessione, this.idAlbero, cifrato);
        idCounter = 0;
        
    }
    
    public AlberoIpotesi(Ipotesi root){
        this.idSessione = root.getSessione();
        this.idAlbero = root.getAlbero();
        this.root = new NodoIpotesi(root);
        idCounter = contaNodi(this.root);
        
    }
    
    public int contaNodi(NodoIpotesi nodo){
            int nodi = 1;
            if(!nodo.getFigli().isEmpty()){
                for(NodoIpotesi tmp: nodo.getFigli()){
                    nodi += contaNodi(tmp);
                }
            }
            return  nodi;
        }
    
    /* Classe interna */
    private class NodoIpotesi implements TreeNode{
        
        private final int parent;
        private final Ipotesi ipotesi;
        private ArrayList<NodoIpotesi> listaFigli;
        
        /* ****************************************************************** */
        /* Costruttori */
        
        // root
        private NodoIpotesi(int idSes, int idAlb, String testo){
            this.parent = 0;
            this.ipotesi = new Ipotesi(idSes, idAlb, 0, testo, 0, new ArrayList<>());
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
        
        
        public void aggiungiIpotesi(NodoIpotesi nodo, String testo){
            Ipotesi tmp = new Ipotesi(nodo.ipotesi.getSessione(), nodo.ipotesi.getAlbero(), idCounter, testo, nodo.ipotesi.getId(), new ArrayList<Integer>());
            idCounter++;
            this.listaFigli.add(new NodoIpotesi(tmp));
        }
        
        
        
        public int getPadre(){
            return this.parent;
        }
        
        public ArrayList<NodoIpotesi> getFigli(){
            return this.listaFigli;
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

