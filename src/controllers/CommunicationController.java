package controllers;


import MainSystem.DBManager;
import static MainSystem.DBManager.esegui;
import static MainSystem.DBManager.st;
import elements.messaggi.Messaggio;
import elements.utenti.UserInfo;
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
                UserInfo mittente = getUserInfo(rs.getInt("idMittente"));
                UserInfo destinatario = getUserInfo(rs.getInt("idDestinatario"));
                mess = new Messaggio(rs.getString("titolo"), rs.getString("testo"), 
                                    rs.getString("testoCifrato"), mittente,
                                    destinatario, rs.getString("lingua"), messaggio.getId());
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
                UserInfo mittente = getUserInfo(rs.getInt("idMittente"));
                UserInfo destinatario = getUserInfo(rs.getInt("idDestinatario"));
                Messaggio tmp = new Messaggio(rs.getString("titolo"), rs.getString("testo"), 
                                    rs.getString("testoCifrato"), mittente,
                                    destinatario, rs.getString("lingua"), rs.getInt("id"));
                bozze.add(tmp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bozze;
    }
    
    public static ArrayList<Messaggio> elencaMessaggiInviati(int idMittente){
        ArrayList<Messaggio> inviati = null;
        try {
            ResultSet rs = st.executeQuery("SELECT * FROM messaggio WHERE idMittente="+idMittente+" "
                    + "AND bozza='false'");
            while(rs.next()){
                UserInfo mittente = getUserInfo(idMittente);
                UserInfo destinatario = getUserInfo(rs.getInt("idDestinatario"));
                Messaggio tmp = new Messaggio(rs.getString("titolo"), rs.getString("testo"), 
                                    rs.getString("testoCifrato"), mittente,
                                    destinatario, rs.getString("lingua"), rs.getInt("id"));
                inviati.add(tmp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return inviati;
    }
    
    public static void eliminaMessaggioBozza(Messaggio messaggio){
        esegui("DELETE FROM messaggio WHERE id="+messaggio.getId()+")", st);
    }
    
    public static void eliminaMessaggioInviato(Messaggio messaggio){
        esegui("DELETE FROM messaggio WHERE id="+messaggio.getId()+")", st);
    }
    
    public static void eliminaMessaggioRicevuto(Messaggio messaggio){
        esegui("DELETE FROM messaggio WHERE id="+messaggio.getId()+")", st);
    }
    
    // new name: elencaMessaggiRicevuti
    public static ArrayList<Messaggio> getMessaggi(int idDestinatario){
        ArrayList<Messaggio> messaggi = new ArrayList();
        try {           
            ResultSet rs = st.executeQuery("SELECT * FROM messaggio WHERE idDestinatario = " + idDestinatario + "");
            rs.next();
            while(rs.next()){
                UserInfo mittente = getUserInfo(rs.getInt("idMittente"));
                UserInfo destinatario = getUserInfo(rs.getInt("idDestinatario"));
                Messaggio messaggio = new Messaggio(rs.getString("titolo"), rs.getString("testo"), rs.getString("testoCifrato"), mittente, 
                    destinatario, rs.getString("lingua"), rs.getInt("id"));  
                messaggi.add(messaggio);
            }   
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return messaggi;
    }
    
    // new name:visualizzaMessaggioInviato
    public static Messaggio getMessaggio(int idMessaggio){
        Messaggio messaggio = null;
        try {            
            ResultSet rs = st.executeQuery("SELECT * FROM messaggio WHERE id = "+idMessaggio+" AND bozza='false'");
            rs.next();
            UserInfo mittente = getUserInfo(rs.getInt("idMittene"));
            UserInfo destinatario = getUserInfo(rs.getInt("idDestinatario"));
            messaggio = new Messaggio(rs.getString("titolo"), rs.getString("testo"), rs.getString("testoCifrato"), mittente, 
                    destinatario, rs.getString("lingua"), rs.getInt("id"));            
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return messaggio;
    }
    
    public static UserInfo getUserInfo(int id){
         UserInfo ui = null;
         try {   
            ResultSet rs = st.executeQuery("SELECT * FROM userInfo WHERE id="+id+"");
            if(rs.next()){
                ui = new UserInfo(id, rs.getString("nome"), rs.getString("cognome"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommunicationController.class.getName()).log(Level.SEVERE, null, ex);
        }
         return ui;
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
