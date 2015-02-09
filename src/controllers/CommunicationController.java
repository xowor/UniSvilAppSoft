package controllers;


import MainSystem.DBManager;
import static MainSystem.DBManager.esegui;
import static MainSystem.DBManager.st;
import SistemaCifratura.SistemaDiCifratura;
import elements.Studente;
import elements.messaggi.Messaggio;
import elements.messaggi.Proposta;
import elements.utenti.UserInfo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CommunicationController {
    
    public static void send(Messaggio messaggio){
        esegui("INSERT INTO messaggio (testo, testoCifrato, lingua, titolo, idMittente, idDestinatario, "
                + "bozza, letto) VALUES ('"+messaggio.getTesto() + "', '" + messaggio.getTestoCifrato()
                +"', '"+ messaggio.getLingua() + "', '"+ messaggio.getTitolo()+"', "+messaggio.getMittente().getId()+", "
                + ""+messaggio.getDestinatario().getId()+",'false', 'false')", st);
    }
    
    public static Messaggio apriMessaggioBozza(Messaggio messaggio){
        Messaggio mess = null;
        try {
            ResultSet rs = st.executeQuery("SELECT * FROM messaggio WHERE id="+messaggio.getId()+" "
                    + "AND bozza='true'");
            if(rs.next()){
                UserInfo mittente = UserInfo.getUserInfo(rs.getInt("idMittente"));
                UserInfo destinatario = UserInfo.getUserInfo(rs.getInt("idDestinatario"));
                mess = new Messaggio(rs.getString("titolo"), rs.getString("testo"), rs.getString("testoCifrato"),
                        mittente, destinatario, rs.getString("lingua"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mess;
    }
        
    public static ArrayList<Messaggio> elencaMessaggiBozza(int idStudente){
        ArrayList<Messaggio> bozze  = new ArrayList<Messaggio>();
        try {
            ResultSet rs = st.executeQuery("SELECT * FROM messaggio WHERE idMittente="+idStudente+" "
                    + "AND bozza='true'");
            while(rs.next()){
                UserInfo mittente = UserInfo.getUserInfo(rs.getInt("idMittente"));
                UserInfo destinatario = UserInfo.getUserInfo(rs.getInt("idDestinatario"));
                Messaggio tmp = new Messaggio(rs.getString("titolo"), rs.getString("testo"), rs.getString("testoCifrato"),
                        mittente, destinatario, rs.getString("lingua"));
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
                UserInfo mittente = UserInfo.getUserInfo(idMittente);
                UserInfo destinatario = UserInfo.getUserInfo(rs.getInt("idDestinatario"));
                Messaggio tmp = new Messaggio(rs.getString("titolo"), rs.getString("testo"), rs.getString("testoCifrato"),
                        mittente, destinatario, rs.getString("lingua"));
                inviati.add(tmp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return inviati;
    }
    
    public static ArrayList<Messaggio> elencaMessaggiRicevuti(Studente studente){
        ArrayList<Messaggio> messaggi = new ArrayList<Messaggio>();
        try {
            ResultSet rs = st.executeQuery("SELECT * FROM messaggio WHERE idDestinatario="+studente.getId()+" "
                    + "AND bozza='false'");
            while(rs.next()){
                UserInfo mittente = UserInfo.getUserInfo(rs.getInt("idMittente"));
                UserInfo destinatario = UserInfo.getUserInfo(studente.getId());
                Messaggio tmp = new Messaggio(rs.getString("titolo"), rs.getString("testo"), rs.getString("testoCifrato"),
                        mittente, destinatario, rs.getString("lingua"));
                messaggi.add(tmp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return messaggi;
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
    
    public static ArrayList<Messaggio> elencaMessaggiRicevuti(int idDestinatario){
        ArrayList<Messaggio> messaggi = new ArrayList();
        try {           
            ResultSet rs = st.executeQuery("SELECT * FROM messaggio WHERE idDestinatario = " + idDestinatario + ""
                    + "AND bozza='false'");
            while(rs.next()){
                UserInfo mittente = UserInfo.getUserInfo(rs.getInt("idMittente"));
                UserInfo destinatario = UserInfo.getUserInfo(rs.getInt("idDestinatario"));
                Messaggio messaggio = new Messaggio(rs.getString("titolo"), rs.getString("testo"), rs.getString("testoCifrato"),
                        mittente, destinatario, rs.getString("lingua"));  
                messaggi.add(messaggio);
            }   
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return messaggi;
    }
    
    public static Messaggio visualizzaMessaggioInviato(int idMessaggio){
        Messaggio messaggio = null;
        try {            
            ResultSet rs = st.executeQuery("SELECT * FROM messaggio WHERE id = "+idMessaggio+" AND bozza='false'");
            if(rs.next()){
            
            UserInfo mittente = UserInfo.getUserInfo(rs.getInt("idMittente"));
            UserInfo destinatario = UserInfo.getUserInfo(rs.getInt("idDestinatario"));
            messaggio = new Messaggio(rs.getString("titolo"), rs.getString("testo"), rs.getString("testoCifrato"),
                        mittente, destinatario, rs.getString("lingua"));            
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return messaggio;
    }

    
    public static void salvaMessaggioBozza(Messaggio messaggio){
        esegui("INSERT INTO messaggio (testo, testoCifrato, lingua, titolo, idMittente, idDestinatario, "
                + "bozza, letto) VALUES ('"+messaggio.getTesto() + "', '" + messaggio.getTestoCifrato()
                +"', '"+ messaggio.getLingua() + "', '"+ messaggio.getTitolo()+"', "+messaggio.getMittente().getId()+", "
                + ""+messaggio.getDestinatario().getId()+",'true', 'false')", st);
    }
    
    public static void setAccettaProposta(int id){
        DBManager.execute("UPDATE proposta SET stato='Accettata' WHERE id=" + id);
    }
    
    public static void inviaProposta(SistemaDiCifratura sistema, Studente mittente, Studente destinatario){
        DBManager.execute("DELETE FROM proposta where idMittente=" + mittente.getId() + " AND idDestinatario=" + destinatario.getId());
        DBManager.execute("INSERT INTO proposta (sistemaDiCifratura, stato, notificata, idMittente, idDestinatario) "
                + "VALUES (" + sistema.getId() + ", 'In attesa', 'false', " + mittente.getId() + ", " + destinatario.getId() + ")");
    }
    
    public static ArrayList<Proposta> getProposte(Studente destinatario){
        ArrayList<Proposta> proposte = new ArrayList();
        try {           
            ResultSet rs = st.executeQuery("SELECT * FROM proposta WHERE idDestinatario = " + destinatario.getId() + " "
                    + "AND stato = 'In attesa'");
            while(rs.next()){
                proposte.add(new Proposta(rs));
            }   
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return proposte;
    }
    
    public static ArrayList<Proposta> getProposteAccettate(Studente mittente, Studente destinatario){
        ArrayList<Proposta> proposte = new ArrayList();
        try {           
            ResultSet rs = st.executeQuery("SELECT * FROM proposta WHERE idDestinatario = " + destinatario.getId() + " "
                    + "AND idMittente = " + mittente.getId() + " AND stato = 'Accettata'");
            while(rs.next()){
                proposte.add(new Proposta(rs));
            }   
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return proposte;
    }
    
    public static void setRifiutaProposta(int idMittente, int idDestinatario, String key, String metodo){
        esegui("UPDATE sistemadicifratura SET accettazione='rifiutato'"
                + " WHERE idStudente="+idMittente+" AND idDestinatario="+idDestinatario+""
                + " AND chiave='"+key+"' AND metodo='"+metodo+"'", st);
    }

    public static ArrayList<Messaggio> getMessaggi() {
        ArrayList<Messaggio> messaggi = new ArrayList();
        try {           
            ResultSet rs = st.executeQuery("SELECT * FROM messaggio WHERE bozza='false'");
            while(rs.next()){
                Messaggio messaggio = new Messaggio(rs);  
                messaggi.add(messaggio);
            }   
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return messaggi;
    }

    public static Proposta getProposta(Studente mittente, Studente destinatario) {
        Proposta proposta = null;
        try {           
            ResultSet rs = st.executeQuery("SELECT * FROM proposta WHERE idDestinatario = " + destinatario.getId() + " AND idMittente ="  + mittente.getId() + "");
            if(rs.next()){
                proposta = new Proposta(rs);
            }   
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return proposta;
    }
    
}
