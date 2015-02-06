
package MainSystem;


import java.util.ArrayList;
import java.util.Enumeration;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
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
        this.root = new NodoIpotesi(root, null);
        idCounter = contaNodi(this.root);
    }
    
    public NodoIpotesi getRoot(){
        return this.root;
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
    public class NodoIpotesi extends DefaultMutableTreeNode{
        
        private final int parent;
        private final Ipotesi ipotesi;
        private ArrayList<NodoIpotesi> listaFigli;
        private final NodoIpotesi parentNodo;
        
        /* ****************************************************************** */
        /* Costruttori */
        
        // root
        private NodoIpotesi(int idSes, int idAlb, String testo){
            this.parent = 0;
            this.parentNodo = null;
            this.ipotesi = new Ipotesi(idSes, idAlb, 0, testo, 0, new ArrayList<>());
            this.listaFigli = new ArrayList<>();
        }
        
        // nuovo nodo ipotesi
        private NodoIpotesi(Ipotesi ip, NodoIpotesi parent){
            this.parent = ip.getParent();
            this.ipotesi = ip;
            this.parentNodo = parent;
            this.listaFigli = new ArrayList<>();
            ArrayList<Integer> tmp = ip.getFigli();
            int ses = ip.getSessione();
            int alb = ip.getAlbero();
            if(!tmp.isEmpty()){
                for(Integer idNewIp : tmp){
                    Ipotesi temp = DBManager.getIpotesi(ses, alb, idNewIp);
                    this.listaFigli.add(new NodoIpotesi(temp, this));
                }
            }
            
        }
        
        /* ****************************************************************** */
        /* Metodi interni */
        
        /* Aggiunge un nuovo figlio */
        
        
        public void aggiungiIpotesi(String testo){
            Ipotesi tmp = new Ipotesi(this.ipotesi.getSessione(), this.ipotesi.getAlbero(), idCounter, testo, this.ipotesi.getId(), new ArrayList<Integer>());
            tmp.aggiungiIpotesi();
            idCounter++;
            this.listaFigli.add(new NodoIpotesi(tmp, this));
        }
        
        public void eliminaIpotesi(NodoIpotesi nodo){
            Ipotesi tmp = DBManager.getIpotesi(nodo.ipotesi.getParent(), idSessione, idAlbero);
            NodoIpotesi temp = new NodoIpotesi(tmp, this);
            temp.listaFigli.remove(nodo);
            nodo.ipotesi.rimuoviIpotesi();
        }
        
        public Ipotesi getIpotesi(){
            return this.ipotesi;
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
            return this.listaFigli.get(childIndex);
        }

        @Override
        public int getChildCount() {
            return this.listaFigli.size();
        }

        @Override
        public TreeNode getParent() {
            return this.parentNodo;
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
            return this. listaFigli == null || this.listaFigli.isEmpty();
        }

        @Override
        public Enumeration children() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
        @Override
        public String toString(){
            return this.ipotesi.getTestoParzialmenteDecifrato();
        }
        /* ****************************************************************** */
    }

}

