package MainSystem;


import Elements.*;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.swing.JTree;
import javax.swing.tree.TreeNode;

public class AlberoIpotesi {
    
    private final JTree alberoIpotesi;
    
    public AlberoIpotesi(Messaggio cifrato){
        NodoIpotesi tmp = new NodoIpotesi(cifrato);
        alberoIpotesi = new JTree(tmp);
    }
    
    /* Classe interna */
    private class NodoIpotesi implements TreeNode{
        
        private final int id;
        private final NodoIpotesi parent;
        private final Ipotesi ip;
        private ArrayList<NodoIpotesi> listaFigli = new ArrayList<>();
        
        private NodoIpotesi(Messaggio tmp){
            this.id = 0;
            this.parent = null;
            this.ip = new Ipotesi(tmp, this.id);
        }
        
        private NodoIpotesi(Messaggio tmp, NodoIpotesi padre, int id){
            this.id = id;
            this.parent = padre;
            this.ip = new Ipotesi(tmp, this.id);
        }
        
        
        @Override
        public TreeNode getChildAt(int childIndex) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public int getChildCount() {
            
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Enumeration children() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
}
