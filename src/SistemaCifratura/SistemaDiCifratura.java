package SistemaCifratura;

import Elementi.Studente;
import MainSystem.DBManager;
import Elementi.utenti.UserInfo;
import static MainSystem.DBManager.st;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SistemaDiCifratura {
    private int id;
    private String chiave;
    private String metodo;
    private UserInfo creatore;
    CalcolatoreMappe calcola;
    Mappatura mappatura;


    public SistemaDiCifratura(String key, String met, UserInfo creatore){
        this.chiave = key;
        this.metodo = met;
        this.creatore = creatore;
//        this.calcola = CalcolatoreMappe.create(met);
//        calcolaMappatura();
//        DBManager.salvaSistemaCifratura(studente,key,met);
    }
    
    public SistemaDiCifratura(ResultSet rs){
        try {
            this.id = rs.getInt("id");
            this.chiave = rs.getString("chiave");
            this.metodo = rs.getString("metodo");
            this.creatore = UserInfo.getUserInfo(rs.getInt("idStudente"));
        } catch (SQLException ex) {
            Logger.getLogger(SistemaDiCifratura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public SistemaDiCifratura(int id, String key, String met, UserInfo creatore){
            this.id = id;
            this.chiave = key;
            this.metodo = met;
            this.creatore = creatore;
    }
    
    /**
     * Scarica dal db tutti i Sistemi di Cifratura di un dato Studente.
     * @param studente
     * @return ArrayList<SistemaDiCifratura> 
     */
    public static ArrayList<SistemaDiCifratura> caricaSistemiCifratura(Studente studente){
        ArrayList<SistemaDiCifratura> lista = new ArrayList<SistemaDiCifratura>();
        ResultSet rs = DBManager.execute("SELECT * FROM sistemaDiCifratura WHERE idStudente="+studente.getId()+"");
        try {
            while(rs.next()){
                lista.add( new SistemaDiCifratura(rs) );
            }
        } catch (SQLException ex) {
            Logger.getLogger(SistemaDiCifratura.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    /**
     * Carica dal db il SistemaDiCifratura tramite l'id.
     * @param id del SistemaDiCifratura
     * @return SistemaDiCifratura
     */
    public static SistemaDiCifratura load(int id){
        SistemaDiCifratura sistema = null;
        try {
            ResultSet rs = st.executeQuery("SELECT * FROM sistemaDiCifratura WHERE id="+id);
            if(rs.next()){
                sistema = new SistemaDiCifratura(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SistemaDiCifratura.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sistema;
    }
    
    public void calcolaMappatura(){
        if (this.calcola != null)
            this.mappatura = calcola.calcola(this.chiave);
    }
    
    
    public void salva(){
        DBManager.execute("INSERT INTO sistemadicifratura (idStudente, chiave, metodo) VALUES (" + this.creatore.getId() + ", '" + this.chiave + "', '" + this.metodo + "')");
    }
    
    public void elimina(){
        DBManager.execute("DELETE FROM sistemadicifratura WHERE chiave='" + this.chiave + "' AND metodo='" + this.metodo + "'");
    }
    
//    public ArrayList<SistemaDiCifratura> ottieniMetodiCifratura(){
//        // TODO
//    }
    
    public String getChiave(){
        return this.chiave;
    }
    
    public String getMetodo(){
        return this.metodo;
    }
    
    @Override
    public String toString(){
        return metodo + " / " + chiave;
    }

    public int getId() {
        return this.id;
    }
}
