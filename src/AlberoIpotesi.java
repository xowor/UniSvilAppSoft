
import Elements.*;
import javax.swing.JTree;
import javax.swing.tree.TreeNode;

public class AlberoIpotesi {
    
    private final JTree alberoIpotesi;
    
    public AlberoIpotesi(Messaggio cifrato){
        TreeNode root = new Ipotesi(cifrato);
        alberoIpotesi = new JTree(tmp);
    }
}
