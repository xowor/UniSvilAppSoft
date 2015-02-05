/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package windows;

import Elements.Alfabeto;
import Elements.Messaggio;
import MainSystem.DBManager;
import MainSystem.Sostituzione;
import java.util.Set;

/**
 *
 * @author luca
 */
public class AggiungiIpotesiJFrame extends javax.swing.JDialog {
    
    private Sostituzione sostituzione;
    private final DBManager dbManager;
    private final Messaggio messaggio;
    private final Alfabeto alfabeto;

    /**
     * Creates new form AggiungiIpotesiJFrame
     */
    public AggiungiIpotesiJFrame(Messaggio messaggio, Alfabeto alfabeto, Sostituzione sostituzione, DBManager dbManager) {
        this.sostituzione = sostituzione;
        this.messaggio = messaggio;
        this.alfabeto = alfabeto;
        this.dbManager = dbManager;
        initComponents();
        this.messaggioJTextArea.setText(sostituzione.getMessaggio().getTesto());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        messaggioJTextArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        sostituisciJTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        sostituisciConJTextField = new javax.swing.JTextField();
        annullaJButton = new javax.swing.JButton();
        confermaJButton = new javax.swing.JButton();
        mostraAnalisiFrequenzeJButton = new javax.swing.JButton();
        mostraDizionarioJButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Aggiungi ipotesi");

        messaggioJTextArea.setColumns(20);
        messaggioJTextArea.setLineWrap(true);
        messaggioJTextArea.setRows(5);
        messaggioJTextArea.setText("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?\n");
        jScrollPane2.setViewportView(messaggioJTextArea);

        jLabel1.setText("Testo");

        jLabel2.setText("Sostituisci");

        sostituisciJTextField.setMinimumSize(new java.awt.Dimension(50, 29));
        sostituisciJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sostituisciJTextFieldActionPerformed(evt);
            }
        });

        jLabel3.setText("con");

        sostituisciConJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sostituisciConJTextFieldActionPerformed(evt);
            }
        });

        annullaJButton.setText("Annulla");
        annullaJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                annullaJButtonActionPerformed(evt);
            }
        });

        confermaJButton.setText("Conferma");
        confermaJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confermaJButtonActionPerformed(evt);
            }
        });

        mostraAnalisiFrequenzeJButton.setText("Analisi delle frequenze");
        mostraAnalisiFrequenzeJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostraAnalisiFrequenzeJButtonActionPerformed(evt);
            }
        });

        mostraDizionarioJButton1.setText("Dizionario");
        mostraDizionarioJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostraDizionarioJButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sostituisciJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sostituisciConJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 256, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(mostraDizionarioJButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mostraAnalisiFrequenzeJButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(confermaJButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(annullaJButton)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(sostituisciJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(sostituisciConJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(annullaJButton)
                    .addComponent(confermaJButton)
                    .addComponent(mostraAnalisiFrequenzeJButton)
                    .addComponent(mostraDizionarioJButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sostituisciConJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sostituisciConJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sostituisciConJTextFieldActionPerformed

    private void sostituisciJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sostituisciJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sostituisciJTextFieldActionPerformed

    private void annullaJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_annullaJButtonActionPerformed
        this.sostituzione = null;
        this.dispose();
    }//GEN-LAST:event_annullaJButtonActionPerformed

    private void confermaJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confermaJButtonActionPerformed
        this.sostituzione.getMessaggio().setTesto(messaggioJTextArea.getText());
        this.sostituzione.setSostituisci(sostituisciJTextField.getText());
        this.sostituzione.setSostituisciCon(sostituisciConJTextField.getText());
        this.dispose();
    }//GEN-LAST:event_confermaJButtonActionPerformed

    private void mostraAnalisiFrequenzeJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostraAnalisiFrequenzeJButtonActionPerformed
        // TODO add your handling code here:
        AnalisiFrequenzeJFrame frame = new AnalisiFrequenzeJFrame(this.messaggio, this.alfabeto, this.dbManager);
        frame.setVisible(true);
    }//GEN-LAST:event_mostraAnalisiFrequenzeJButtonActionPerformed

    private void mostraDizionarioJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostraDizionarioJButton1ActionPerformed
        // TODO add your handling code here:
        DizionarioJFrame frame = new DizionarioJFrame(this.dbManager);
        frame.setVisible(true);
    }//GEN-LAST:event_mostraDizionarioJButton1ActionPerformed

    public Sostituzione getSostituzione(){
        return this.sostituzione;
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
//            java.util.logging.Logger.getLogger(AggiungiIpotesiJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(AggiungiIpotesiJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(AggiungiIpotesiJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(AggiungiIpotesiJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new AggiungiIpotesiJFrame().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton annullaJButton;
    private javax.swing.JButton confermaJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea messaggioJTextArea;
    private javax.swing.JButton mostraAnalisiFrequenzeJButton;
    private javax.swing.JButton mostraDizionarioJButton1;
    private javax.swing.JTextField sostituisciConJTextField;
    private javax.swing.JTextField sostituisciJTextField;
    // End of variables declaration//GEN-END:variables
}
