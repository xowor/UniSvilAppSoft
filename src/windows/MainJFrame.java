package windows;
import Elementi.Alfabeto;
import Elementi.Studente;
import Elementi.messaggi.Messaggio;
import MainSystem.DBManager;
import MainSystem.AlberoIpotesi;
import MainSystem.AlberoIpotesi.NodoIpotesi;
import MainSystem.Ipotesi;
import MainSystem.Sessione;
import MainSystem.Sostituzione;
import java.awt.event.ItemEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author luca
 */
public class MainJFrame extends javax.swing.JFrame {
    
    private DBManager dbManager;
    private Studente studente;
    private Sessione sessione;
    private ArrayList<Studente> studenti;
//    private AlberoIpotesi alberoIpotesi;
//    private Ipotesi ipotesiCorrente;
//    private Messaggio messaggioCorrente;
//    private Alfabeto alfabetoCorrente;

    /**
     * Creates new form MainJFrame
     */
    public MainJFrame() {
        initComponents();
        setContentEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainJPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        studentiJComboBox = new javax.swing.JComboBox();
        gestioneMessaggi = new javax.swing.JButton();
        creaDatiJButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        contentJSplitPane = new javax.swing.JSplitPane();
        IpotesiJPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        aggiungiIpotesiJButton = new javax.swing.JButton();
        rimuoviIpotesiJButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ipotesiJTree = new javax.swing.JTree();
        RightJPanel = new javax.swing.JPanel();
        jSplitPane2 = new javax.swing.JSplitPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        testoCifratoJTextPane = new javax.swing.JTextPane();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        ipotesiJTextPane = new javax.swing.JTextPane();
        mostraAlfabetoJButton = new javax.swing.JButton();
        soluzioneJButton = new javax.swing.JButton();
        soluzioneJLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CryptoHelper");
        setResizable(false);

        jLabel1.setText("Studente");

        studentiJComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                studentiJComboBoxItemStateChanged(evt);
            }
        });
        studentiJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentiJComboBoxActionPerformed(evt);
            }
        });

        gestioneMessaggi.setText("Gestione messaggi");
        gestioneMessaggi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gestioneMessaggiActionPerformed(evt);
            }
        });

        creaDatiJButton.setText("Crea dati di esempio");
        creaDatiJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creaDatiJButtonActionPerformed(evt);
            }
        });

        jButton1.setText("Sistemi di cifratura");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(studentiJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gestioneMessaggi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(creaDatiJButton))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1)
                .addComponent(studentiJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(gestioneMessaggi)
                .addComponent(creaDatiJButton)
                .addComponent(jButton1))
        );

        jLabel2.setText("Ipotesi");

        aggiungiIpotesiJButton.setText("+");
        aggiungiIpotesiJButton.setToolTipText("Aggiungi");
        aggiungiIpotesiJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aggiungiIpotesiJButtonActionPerformed(evt);
            }
        });

        rimuoviIpotesiJButton.setText("-");
        rimuoviIpotesiJButton.setToolTipText("Annulla");
        rimuoviIpotesiJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rimuoviIpotesiJButtonActionPerformed(evt);
            }
        });

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        ipotesiJTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        ipotesiJTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                ipotesiJTreeValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(ipotesiJTree);

        javax.swing.GroupLayout IpotesiJPanelLayout = new javax.swing.GroupLayout(IpotesiJPanel);
        IpotesiJPanel.setLayout(IpotesiJPanelLayout);
        IpotesiJPanelLayout.setHorizontalGroup(
            IpotesiJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(IpotesiJPanelLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aggiungiIpotesiJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rimuoviIpotesiJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, IpotesiJPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        IpotesiJPanelLayout.setVerticalGroup(
            IpotesiJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(IpotesiJPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(IpotesiJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(aggiungiIpotesiJButton)
                    .addComponent(rimuoviIpotesiJButton)))
        );

        contentJSplitPane.setLeftComponent(IpotesiJPanel);

        jSplitPane2.setDividerLocation(220);
        jSplitPane2.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Testo cifrato"));

        testoCifratoJTextPane.setText("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?");
        jScrollPane2.setViewportView(testoCifratoJTextPane);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 769, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
        );

        jSplitPane2.setTopComponent(jPanel4);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Ipotesi corrente"));

        ipotesiJTextPane.setText("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?");
        jScrollPane4.setViewportView(ipotesiJTextPane);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 769, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
        );

        jSplitPane2.setRightComponent(jPanel6);

        mostraAlfabetoJButton.setText("Alfabeto");
        mostraAlfabetoJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostraAlfabetoJButtonActionPerformed(evt);
            }
        });

        soluzioneJButton.setText("Soluzione");
        soluzioneJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                soluzioneJButtonActionPerformed(evt);
            }
        });

        soluzioneJLabel.setText(" ");

        javax.swing.GroupLayout RightJPanelLayout = new javax.swing.GroupLayout(RightJPanel);
        RightJPanel.setLayout(RightJPanelLayout);
        RightJPanelLayout.setHorizontalGroup(
            RightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane2)
            .addGroup(RightJPanelLayout.createSequentialGroup()
                .addComponent(mostraAlfabetoJButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(soluzioneJButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(soluzioneJLabel)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        RightJPanelLayout.setVerticalGroup(
            RightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightJPanelLayout.createSequentialGroup()
                .addComponent(jSplitPane2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(RightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mostraAlfabetoJButton)
                    .addComponent(soluzioneJButton)
                    .addComponent(soluzioneJLabel)))
        );

        contentJSplitPane.setRightComponent(RightJPanel);

        javax.swing.GroupLayout mainJPanelLayout = new javax.swing.GroupLayout(mainJPanel);
        mainJPanel.setLayout(mainJPanelLayout);
        mainJPanelLayout.setHorizontalGroup(
            mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentJSplitPane)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        mainJPanelLayout.setVerticalGroup(
            mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainJPanelLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contentJSplitPane))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mainJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void studentiJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentiJComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentiJComboBoxActionPerformed

    private void aggiungiIpotesi(Sostituzione i){
        if (i != null){
            // # DSD #
            String nuovoTesto = this.sessione.sostituisci(this.sessione.getIpotesiCorrente().getTestoParzialmenteDecifrato(), i.getSostituisci(), i.getSostituisciCon());
            this.sessione.getIpotesiCorrente().aggiungiIpotesiAdAlbero(nuovoTesto, i.getSostituisci() + " -> " + i.getSostituisciCon());
            //AlberoIpotesi.NodoIpotesi nodoIpotesi = (AlberoIpotesi.NodoIpotesi) this.ipotesiJTree.getLastSelectedPathComponent();
            //nodoIpotesi.aggiungiIpotesi(nuovoTesto, i.getSostituisci() + " -> " + i.getSostituisciCon());

            DefaultTreeModel model = (DefaultTreeModel)ipotesiJTree.getModel();
            model.reload();
        }
    }
    
    private void aggiungiIpotesiJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aggiungiIpotesiJButtonActionPerformed
        Sostituzione sostituzione = new Sostituzione(this.sessione.getIpotesiCorrente().getTestoParzialmenteDecifrato());
        windows.AggiungiIpotesiJFrame frame = new windows.AggiungiIpotesiJFrame(this.sessione, sostituzione, this.dbManager);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                aggiungiIpotesi(frame.getSostituzione());
            }
        });
        frame.setVisible(true);
        
    }//GEN-LAST:event_aggiungiIpotesiJButtonActionPerformed

    private void rimuoviIpotesiJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rimuoviIpotesiJButtonActionPerformed
        AlberoIpotesi.NodoIpotesi nodoIpotesi = (AlberoIpotesi.NodoIpotesi) this.ipotesiJTree.getLastSelectedPathComponent();
        NodoIpotesi parent = ((AlberoIpotesi.NodoIpotesi) nodoIpotesi.getParent());
        parent.eliminaIpotesi(nodoIpotesi);
        
        DefaultTreeModel model = (DefaultTreeModel)ipotesiJTree.getModel();
        model.reload(); 
    }//GEN-LAST:event_rimuoviIpotesiJButtonActionPerformed

    private void mostraAlfabetoJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostraAlfabetoJButtonActionPerformed
        // TEMP
        //String[] chars = new String[]{"a", "b","c","d","e","f","g","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        //Alfabeto alfabeto = new Alfabeto("EN_us", chars);
        //\TEMP
        
        windows.AlfabetoJFrame frame = new windows.AlfabetoJFrame(this.sessione.getAlfabeto());
        frame.setVisible(true);
    }//GEN-LAST:event_mostraAlfabetoJButtonActionPerformed

    private void studentiJComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_studentiJComboBoxItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            this.studente = (Studente) studentiJComboBox.getSelectedItem();
            
            this.sessione = Sessione.getOrInsertSessione(this.studente);
            
            //int idAlberoTmp = DBManager.getIdAlbero(this.sessione.getId());
            //this.sessione.setAlberoIpotesi(new AlberoIpotesi(this.sessione.getId(), idAlberoTmp, messaggio.getTestoCifrato(), messaggio.getTitolo());
            this.sessione.setAlberoIpotesi( DBManager.getAlberoIpotesi(sessione.getId()) );
            this.sessione.setMessaggio( DBManager.getMessaggio(sessione.getId()) );
            if (this.sessione.getMessaggio() != null){
                this.sessione.setAlfabeto( new Alfabeto(this.sessione.getMessaggio().getLocale()) );
                this.testoCifratoJTextPane.setText(this.sessione.getMessaggio().getTestoCifrato());
                DefaultTreeModel a;
                AlberoIpotesi tmp;
                if(this.sessione.getAlberoIpotesi() == null){
                    this.sessione.setAlberoIpotesi( new AlberoIpotesi(this.sessione.getId(), this.sessione.getMessaggio().getTestoCifrato(), this.sessione.getMessaggio().getTestoCifrato()) );
                }                
                a = new DefaultTreeModel(this.sessione.getAlberoIpotesi().getRoot());
                this.ipotesiJTree.setModel(a);
                this.ipotesiJTree.setSelectionPath(new TreePath(this.sessione.getAlberoIpotesi().getRoot().getPath()));
                setContentEnabled(true);
            }
            
            //System.out.println(this.sessione.getId());
        }
    }//GEN-LAST:event_studentiJComboBoxItemStateChanged

    private void creaDatiJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creaDatiJButtonActionPerformed
       this.dbManager.creaTabelle();
       this.dbManager.creaDati();
    }//GEN-LAST:event_creaDatiJButtonActionPerformed

    private void gestioneMessaggiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestioneMessaggiActionPerformed
        Messaggio messaggioRicevuto = new Messaggio();
        windows.GestioneMessaggiJFrame frame = new windows.GestioneMessaggiJFrame(this.studente, this.dbManager, messaggioRicevuto);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                mostraMessaggio(frame.getMessaggioIntercettato());
            }
        });
        frame.setVisible(true);
    }//GEN-LAST:event_gestioneMessaggiActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        windows.SistemiCifraturaJFrame frame = new windows.SistemiCifraturaJFrame(this.studente, this.dbManager);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                //aggiungiIpotesi(frame.getSostituzione());
            }
        });
        frame.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ipotesiJTreeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_ipotesiJTreeValueChanged
        AlberoIpotesi.NodoIpotesi nodoIpotesi = (AlberoIpotesi.NodoIpotesi) this.ipotesiJTree.getLastSelectedPathComponent();
        if (nodoIpotesi != null){
            ipotesiJTextPane.setText(nodoIpotesi.getIpotesi().getTestoParzialmenteDecifrato());
            this.sessione.setIpotesiCorrente( nodoIpotesi.getIpotesi() );
            setContentEnabled(true);   
        }
    }//GEN-LAST:event_ipotesiJTreeValueChanged

    private void soluzioneJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_soluzioneJButtonActionPerformed
        if (this.sessione.getMessaggio().getTesto().equals(this.sessione.getIpotesiCorrente().getTestoParzialmenteDecifrato())){
            this.soluzioneJLabel.setText("Soluzione corretta");
        } else {
            this.soluzioneJLabel.setText("Soluzione errata");
        }
    }//GEN-LAST:event_soluzioneJButtonActionPerformed
    
    public void inizializza(){
        this.dbManager = new DBManager();
        if (this.dbManager.inizializza() == null){
            JOptionPane.showMessageDialog(null, "Errore durante la connessione al database");
            this.dispose();
        }
        
    }
    
    public void mostraStudenti(){
        this.studenti = Studente.getStudenti();
        if (studenti.size() > 0){
            for (Studente studente : this.getStudenti()){
                this.studentiJComboBox.addItem(studente);
            }
        }      
    }
    
    public void mostraMessaggio(Messaggio messaggio){
        if (messaggio != null && messaggio.getTesto() != null){
            this.sessione.setMessaggio( messaggio );
            this.sessione.setAlfabeto( new Alfabeto(this.sessione.getMessaggio().getLocale()) );
            this.testoCifratoJTextPane.setText(messaggio.getTestoCifrato());
            //int idAlberoTmp = DBManager.getIdAlbero(this.sessione.getId());
            //this.sessione.setAlberoIpotesi(new AlberoIpotesi(this.sessione.getId(), idAlberoTmp, messaggio.getTestoCifrato(), messaggio.getTitolo());
            this.sessione.setAlberoIpotesi( DBManager.getAlberoIpotesi(this.sessione.getId()) );
            DefaultTreeModel a;
            AlberoIpotesi tmp;
            if(this.sessione.getAlberoIpotesi() == null){
                this.sessione.setAlberoIpotesi( new AlberoIpotesi(this.sessione.getId(), messaggio.getTestoCifrato(), messaggio.getTestoCifrato()) );
            }                
            a = new DefaultTreeModel(this.sessione.getAlberoIpotesi().getRoot());
            this.ipotesiJTree.setModel(a);
            this.ipotesiJTree.setSelectionPath(new TreePath(this.sessione.getAlberoIpotesi().getRoot().getPath()));
            setContentEnabled(true);
            //System.out.println(messaggio.getTesto());   
        }
    }
    
    private ArrayList<Studente> getStudenti() {
        return this.studenti;
    }
    
    public void setContentEnabled(boolean enabled){
        this.ipotesiJTree.setEnabled(enabled);
        this.testoCifratoJTextPane.setEnabled(enabled);
        this.ipotesiJTextPane.setEnabled(enabled);
        this.aggiungiIpotesiJButton.setEnabled(enabled);
        this.rimuoviIpotesiJButton.setEnabled(enabled);
        this.mostraAlfabetoJButton.setEnabled(enabled);
        this.soluzioneJButton.setEnabled(enabled);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainJFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(MainJFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(MainJFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(MainJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
//        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainJFrame frame = new MainJFrame();
                frame.setVisible(true);
                
                frame.inizializza();
                frame.mostraStudenti();
                
                
                // TEMP
                //Studente studente = new Studente("mario", "rossi");
                //studente.setNome("Mario");
                // \TEMP
                
                //frame.studentiJComboBox.addItem(studente);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel IpotesiJPanel;
    private javax.swing.JPanel RightJPanel;
    private javax.swing.JButton aggiungiIpotesiJButton;
    private javax.swing.JSplitPane contentJSplitPane;
    private javax.swing.JButton creaDatiJButton;
    private javax.swing.JButton gestioneMessaggi;
    private javax.swing.JTextPane ipotesiJTextPane;
    private javax.swing.JTree ipotesiJTree;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JPanel mainJPanel;
    private javax.swing.JButton mostraAlfabetoJButton;
    private javax.swing.JButton rimuoviIpotesiJButton;
    private javax.swing.JButton soluzioneJButton;
    private javax.swing.JLabel soluzioneJLabel;
    private javax.swing.JComboBox studentiJComboBox;
    private javax.swing.JTextPane testoCifratoJTextPane;
    // End of variables declaration//GEN-END:variables

}
