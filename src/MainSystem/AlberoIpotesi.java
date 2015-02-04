package MainSystem;


import Elements.*;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.swing.JTree;
import javax.swing.tree.TreeNode;

public class AlberoIpotesi {
    
    private final JTree alberoIpotesi;
    public int idCounter;
    
    public AlberoIpotesi(Messaggio cifrato){
        NodoIpotesi tmp = new NodoIpotesi(cifrato);
        alberoIpotesi = new JTree(tmp);
        this.idCounter = 0;
    }
    
    /* Classe interna */
    private class NodoIpotesi implements TreeNode{
        
        private final int id;
        private final int parent;
        private final Ipotesi ip;
        private ArrayList<NodoIpotesi> listaFigli = new ArrayList<>();
        
        private NodoIpotesi(Messaggio tmp){
            this.id = 0;
            this.parent = 0;
            this.ip = new Ipotesi(tmp, this.id);
        }
        
        private NodoIpotesi(Messaggio tmp, int padre, int id){
            this.id = id;
            this.parent = padre;
            this.ip = new Ipotesi(tmp, this.id);
        }
        
        /* Aggiunge un nuovo figlio */
        
        public void addChild(Messaggio mex){
            idCounter++;
            this.listaFigli.add(new NodoIpotesi(mex, this.id, idCounter));        
        }
        
        /* Ritorna l'id del padre */
        
        public int getIdParent() {
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
            return this.id;
        }

        @Override
        public boolean getAllowsChildren() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean isLeaf() {
            if(this.listaFigli.size() == 0)
                return true;
            else
                return false;
        }

        @Override
        public Enumeration children() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
        
        /* ****************************************************************** */
    }
}
