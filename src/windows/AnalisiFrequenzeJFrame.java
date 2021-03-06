/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package windows;

import Elementi.Alfabeto;
import Elementi.Frequenze;
import Elementi.messaggi.Messaggio;
import MainSystem.DBManager;
import SistemaSupporto.AnalisiFrequenze;
import SistemaSupporto.Supporto;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luca
 */
public class AnalisiFrequenzeJFrame extends javax.swing.JFrame {

    DBManager dbManager;
    
    /**
     * Creates new form AnalisiFrequenzeJFrame
     */
    public AnalisiFrequenzeJFrame(Supporto supporto, String messaggio, Alfabeto alfabeto, DBManager dbManager) {
        this.dbManager = dbManager;
        initComponents();
        
        DefaultTableModel model = (DefaultTableModel) this.frequenzeJTable.getModel();
        
        /* #UC */
        Frequenze frequenze = Frequenze.getFrequenze(alfabeto);
        AnalisiFrequenze analisiFrequenze = (AnalisiFrequenze) supporto;
        //frequenze.setFrequenze( dbManager.getFrequenzeAlfabeto(alfabeto.getLocale()) );
        /* #UC */
        Frequenze frequenzeTesto = analisiFrequenze.getFrequenzeTesto(messaggio , alfabeto);

        for (String parola : frequenze.getFrequenze().keySet()) {
            int frequenza = frequenze.getFrequenze().get(parola);
            Object[] row = new Object[]{parola, String.valueOf(frequenza) + "%", String.valueOf(frequenzeTesto.getFrequenze().get(parola)) + "%"};
            model.addRow(row);
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        frequenzeJTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Analisi frequenze");

        frequenzeJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Lettera", "Frequenze lingua", "Frequenze testo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(frequenzeJTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 707, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(AnalisiFrequenzeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(AnalisiFrequenzeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(AnalisiFrequenzeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(AnalisiFrequenzeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new AnalisiFrequenzeJFrame().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable frequenzeJTable;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
