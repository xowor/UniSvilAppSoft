package MainSystem;

import static MainSystem.DBManager.esegui;
import static MainSystem.DBManager.st;
import elements.messaggi.Messaggio;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CommunicationController {
    
    public void aggiungiMessaggio(String testo, String testoCifrato, String lingua, String titolo, Boolean bozza, Boolean letto, int idMitt, int idDest){
        esegui("INSERT INTO messaggio (testo, testoCifrato, lingua, titolo, idMittente, idDestinatario, bozza, letto) VALUES ('"+testo + "', '" + testoCifrato
                +"', '"+lingua+"', '"+titolo+"', "+idMitt+", "+idDest+",'"+bozza+"', '"+letto+"')", st);
    }
    
    public static Messaggio apriMessaggioBozza(Messaggio messaggio){
        Messaggio mess = null;
        try {
            ResultSet rs = st.executeQuery("SELECT * FROM messaggio WHERE id="+messaggio.getId()+" "
                    + "AND bozza='true'");
            if(rs.next()){
                mess = new Messaggio(rs.getString("titolo"), rs.getString("testo"), 
                                    rs.getString("testoCifrato"), rs.getInt("idMittente"),
                                    rs.getInt("idDestinatario"), rs.getString("lingua"), messaggio.getId());
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mess;
    }
        
    public static ArrayList<Messaggio> elencaMessaggiBozza(int idStudente){
        ArrayList<Messaggio> bozze  = null;
        try {
            ResultSet rs = st.executeQuery("SELECT * FROM messaggio WHERE idMittente="+idStudente+" "
                    + "AND bozza='true'");
            while(rs.next()){
                Messaggio tmp = new Messaggio(rs.getString("titolo"), rs.getString("testo"), 
                                    rs.getString("testoCifrato"), rs.getInt("idMittente"),
                                    rs.getInt("idDestinatario"), rs.getString("lingua"), rs.getInt("id"));
                bozze.add(tmp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bozze;
    }
    
    public static void eliminaMessaggioBozza(Messaggio messaggio){
        esegui("DELETE FROM messaggio WHERE id="+messaggio.getId()+")", st);
    }
    
    public static ArrayList<Messaggio> getMessaggi(int idDestinatario){
        ArrayList<Messaggio> messaggi = new ArrayList();
        try {           
            ResultSet rs = st.executeQuery("SELECT * FROM messaggio WHERE idDestinatario = " + idDestinatario + "");
            rs.next();
            while(rs.next()){
                Messaggio messaggio = new Messaggio(rs.getString("titolo"), rs.getString("testo"), rs.getString("testoCifrato"), rs.getInt("idMittente"), 
                    rs.getInt("idDestinatario"), rs.getString("lingua"), rs.getInt("id"));  
                messaggi.add(messaggio);
            }   
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return messaggi;
    }
    
    public static Messaggio getMessaggio(int idMessaggio){
        Messaggio messaggio = null;
        try {            
            ResultSet rs = st.executeQuery("SELECT * FROM messaggio WHERE id = "+idMessaggio+"");
            rs.next();
            messaggio = new Messaggio(rs.getString("titolo"), rs.getString("testo"), rs.getString("testoCifrato"), rs.getInt("mittente"), 
                    rs.getInt("destinatario"), rs.getString("lingua"), rs.getInt("id"));            
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return messaggio;
    }
    
    public static void salvaMessaggioBozza(int idMessaggio, String messaggioModificato){
        esegui("UPDATE sistemadicifratura SET testo='"+messaggioModificato+"' AND bozza='true'"
                + " WHERE id="+idMessaggio+"", st);
    }
    
    public static void setAccettaProposta(int idMittente, int idDestinatario, String key, String metodo){
        esegui("UPDATE sistemadicifratura SET accettazione='accettato'"
                + " WHERE idStudente="+idMittente+" AND idDestinatario="+idDestinatario+""
                + " AND chiave='"+key+"' AND metodo='"+metodo+"'", st);
    }
    
    public static void setProposta(int idMittente, int idDestinatario, String key, String metodo){
        esegui("INSERT INTO sistemadicifratura (idStudente, idDestinatario, chiave, metodo, accettazione) "
                + "VALUES ("+idMittente+", "+idDestinatario+", '"+key+"', '"+metodo+"', 'proposta')", st);
    }
    
    public static void setRifiutaProposta(int idMittente, int idDestinatario, String key, String metodo){
        esegui("UPDATE sistemadicifratura SET accettazione='rifiutato'"
                + " WHERE idStudente="+idMittente+" AND idDestinatario="+idDestinatario+""
                + " AND chiave='"+key+"' AND metodo='"+metodo+"'", st);
    }
}
