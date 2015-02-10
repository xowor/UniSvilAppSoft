
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
    
      
    public AlberoIpotesi(int idSes,String cifrato, String delta){
        this.idSessione = idSes;
        this.root = new NodoIpotesi(this.idSessione, this.idAlbero, cifrato, delta);
        idCounter = 0;
        this.idAlbero = DBManager.getIdAlbero(idSes);
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
        private NodoIpotesi nodoPadre;
        
        /* ****************************************************************** */
        /* Costruttori */
        
        // root
        private NodoIpotesi(int idSes, int idAlb, String testo, String delta){
            this.parent = 0;
            this.ipotesi = new Ipotesi(idSes, idAlb, 0, testo, 0, new ArrayList<>(), delta);
            this.ipotesi.aggiungiIpotesi();
            idCounter++;
            this.listaFigli = new ArrayList<>();
        }
        
        private NodoIpotesi(Ipotesi ip, NodoIpotesi padre){
            this.parent =ip.getParent();
            this.ipotesi = ip;
            idCounter++;
            this.listaFigli = new ArrayList<>();
            this.nodoPadre = padre;
            ArrayList<Integer> tmp = ip.getFigli();
            int ses = ip.getSessione();
            if(!tmp.isEmpty()){
                for(Integer idNewIp : tmp){
                    Ipotesi temp = DBManager.getIpotesi(idNewIp, ses);
                    this.listaFigli.add(new NodoIpotesi(temp, this));
                }
            }
        }
        
        
        /* ****************************************************************** */
        /* Metodi interni */
        
        /* Aggiunge un nuovo figlio */
        public void aggiungiIpotesi(String testo, String delta){
            idCounter++;
            Ipotesi tmp = new Ipotesi(this.ipotesi.getSessione(), this.ipotesi.getAlbero(), idCounter, testo, 
                    this.ipotesi.getId(), new ArrayList<Integer>(), delta);
            tmp.aggiungiIpotesi();            
            this.listaFigli.add(new NodoIpotesi(tmp, this));
            String figli = DBManager.getFigli(this.ipotesi.getId(), idSessione);
            DBManager.aggiornaFigli(this.ipotesi.getId(), idSessione, figli);
        }
        
        public void eliminaIpotesi(NodoIpotesi nodo){
            if(nodo.getPadre() >= 0){
                DBManager.rimuoviIpotesi(this.ipotesi.getSessione(), nodo.ipotesi.getId());
                this.listaFigli.remove(nodo);
            }
        }
        
        public Ipotesi getIpotesi(){
            this.ipotesi.setNodoIpotesi(this);
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
            return this.nodoPadre;
        }

        @Override
        public int getIndex(TreeNode node) {
            for (NodoIpotesi ip: this.listaFigli){
                if (ip.getIpotesi() != null){
                    return ip.getIpotesi().getId();
                }
            }
            return -1;
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
            return this.ipotesi.getDelta();
        }
        /* ****************************************************************** */
    }

}

