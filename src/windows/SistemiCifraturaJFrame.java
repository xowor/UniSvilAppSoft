/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package windows;

import elements.Studente;
import MainSystem.DBManager;
import SistemaCifratura.SistemaDiCifratura;
import elements.utenti.UserInfo;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 *
 * @author luca
 */
public class SistemiCifraturaJFrame extends javax.swing.JFrame {
    private final DBManager dbManager;
    private final Studente studente;

    /**
     * Creates new form SistemiCifraturaJFrame
     */
    public SistemiCifraturaJFrame(Studente studente, DBManager dbManager) {
        this.dbManager = dbManager;
        initComponents();
        this.studente = studente; 
        this.chiaveJTextField.setVisible(false);
        this.caricaSistemi();
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
        jList1 = new javax.swing.JList();
        eliminaJButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        metodoJComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        chiaveJTextField = new javax.swing.JTextField();
        aggiungiSistemaButton = new javax.swing.JButton();
        chiaveJSpinner = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sistemi di cifratura");

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        eliminaJButton.setText("Elimina sistema");
        eliminaJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminaJButtonActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Nuovo sistema"));

        metodoJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cesare", "Monoalfabetico" }));
        metodoJComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                metodoJComboBoxItemStateChanged(evt);
            }
        });
        metodoJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                metodoJComboBoxActionPerformed(evt);
            }
        });

        jLabel1.setText("Metodo:");

        jLabel2.setText("Chiave:");

        chiaveJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chiaveJTextFieldActionPerformed(evt);
            }
        });

        aggiungiSistemaButton.setText("Aggiungi sistema");
        aggiungiSistemaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aggiungiSistemaButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(metodoJComboBox, 0, 325, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(chiaveJSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chiaveJTextField))))
            .addComponent(aggiungiSistemaButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(metodoJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(chiaveJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chiaveJSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(aggiungiSistemaButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(eliminaJButton, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eliminaJButton)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aggiungiSistemaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aggiungiSistemaButtonActionPerformed
        aggiungiSistema();
    }//GEN-LAST:event_aggiungiSistemaButtonActionPerformed

    private void metodoJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_metodoJComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_metodoJComboBoxActionPerformed

    private void chiaveJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chiaveJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chiaveJTextFieldActionPerformed

    private void metodoJComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_metodoJComboBoxItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            if (metodoJComboBox.getSelectedItem().toString() == "Cesare"){
                this.chiaveJSpinner.setVisible(true);
                this.chiaveJTextField.setVisible(false);
            } else {
                this.chiaveJSpinner.setVisible(false);
                this.chiaveJTextField.setVisible(true);
            }
        }
    }//GEN-LAST:event_metodoJComboBoxItemStateChanged

    private void eliminaJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminaJButtonActionPerformed
        this.eliminaSistema();
    }//GEN-LAST:event_eliminaJButtonActionPerformed

    private void caricaSistemi() {
        ArrayList<SistemaDiCifratura> sistemi = this.dbManager.elencaSistemiCifratura(this.studente);
        DefaultListModel m = new DefaultListModel();
        for (SistemaDiCifratura sistema: sistemi){
            m.addElement(sistema);
        }
        this.jList1.setModel(m);
    }
    
    
    private void eliminaSistema() {
        SistemaDiCifratura sistema = (SistemaDiCifratura) this.jList1.getSelectedValue();
        if (sistema != null){
            sistema.elimina();
        }
    }
    
    private void aggiungiSistema() {
        String chiave;
            if (metodoJComboBox.getSelectedItem().toString() == "Cesare"){
                chiave = String.valueOf(this.chiaveJSpinner.getValue());
            } else {
                chiave = this.chiaveJTextField.getText();
            }
        SistemaDiCifratura sistema = new SistemaDiCifratura(chiave, this.metodoJComboBox.getSelectedItem().toString(), UserInfo.getUserInfo(this.studente.getId()));
        sistema.salva();
        //this.dbManager.salvaSistemaCifratura(this.studente, chiave , this.metodoJComboBox.getSelectedItem().toString());
        caricaSistemi();
    }
    
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
//            java.util.logging.Logger.getLogger(SistemiCifraturaJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(SistemiCifraturaJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(SistemiCifraturaJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(SistemiCifraturaJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new SistemiCifraturaJFrame().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aggiungiSistemaButton;
    private javax.swing.JSpinner chiaveJSpinner;
    private javax.swing.JTextField chiaveJTextField;
    private javax.swing.JButton eliminaJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox metodoJComboBox;
    // End of variables declaration//GEN-END:variables

}
