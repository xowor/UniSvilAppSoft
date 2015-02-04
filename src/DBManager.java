import javax.management.Query;
import java.sql.*;


public class DBManager {


	  public DBManager(){

	  }

		public static void inizializza() throws SQLException{
			Connection conn=openConnection();
			Statement st=openStatement(conn);
			try{
				creaTabelle(st);
			}catch(SQLException e){}
			try{
				creaDati(st);
			}catch(SQLException e){}
			closeStatement(st);
			closeConnection(conn);
		}

		/**
		 * crea uno Statement con il database;
		 *
		 * @param conn indica una connessione disponibile per creare uno Statement;
		 * @return uno Statement aperto;
		 * @throws java.sql.SQLException in caso di malfunzionamento del database;
		 */
		public static Statement openStatement(Connection conn) throws SQLException{
			Statement st = conn.createStatement();
			return st;
    	}

		/**
		 * Chiude uno Statement precedentemente creato;
		 *
		 * @param st indica lo Statement da chiudere;
		 * @throws java.sql.SQLException in caso di malfunzionamento del database;
		 */
		public static void closeStatement(Statement st) throws SQLException{
			st.close();
		}

		/**
		 * Apre una connessione con il database;
		 *
		 * @return una Connessione aperta;
		 * @throws java.sql.SQLException in caso di malfunzionamento del database;
     	*/
		public static Connection openConnection() throws SQLException{
			String ur = "jdbc:derby://localhost:1527/CryptoHelperDB";
			String us = "studente";
			String p = "studente";
			Connection conn = DriverManager.getConnection(ur, us, p);
			return conn;
    	}

		/**
		 * Chiude la Connection precedentemente creata;
		 *
		 * @param conn indica la Connessione da chiudere;
		 * @throws java.sql.SQLException in caso di malfunzionamento del database;
		 */

		public static void closeConnection(Connection conn) throws SQLException{
			conn.close();
    	}

	    public static void creaTabelle(Statement st) throws SQLException{
	        st.execute(   "CREATE TABLE studente(" +
	                "id         	INT         NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1)," +
	                "nome			VARCHAR(24) NOT NULL," +
	                "cognome		VARCHAR(24) NOT NULL," +
	                "login			VARCHAR(24) NOT NULL UNIQUE," +
	                "password       VARCHAR(24) NOT NULL," +
	                "PRIMARY KEY(id))");

	        st.execute(   "CREATE TABLE messaggio(" +
	                "id        		INT         	NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1)," +
	                "testo          LONG VARCHAR 	NOT NULL," +
	                "testoCifrato   LONG VARCHAR 	NOT NULL," +
	                "lingua         VARCHAR(12)     NOT NULL," +
	                "titolo         VARCHAR(24)     NOT NULL," +
	                "bozza          LONG VARCHAR    NOT NULL," +
	                "letto          BOOLEAN			NOT NULL," +
	                "PRIMARY KEY(id))");

	        st.execute(   "CREATE TABLE userInfo(" +
	                "id				INT         NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1)," +
	                "nome			VARCHAR(24) NOT NULL," +
	                "cognome		VARCHAR(24) NOT NULL," +
	                "PRIMARY KEY(id))");

	        st.execute(   "CREATE TABLE proposta(" +
					"id				INT         NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1)," +
					"stato			VARCHAR(24) NOT NULL," +
					"notificata		BOOLEAN		NOT NULL," +
	                "PRIMARY KEY(id))");

			st.execute(   "CREATE TABLE sistemaDiCifratura(" +
					"id				INT         NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1)," +
					"chiave			VARCHAR(24) NOT NULL," +
					"metodo			VARCHAR(24)	NOT NULL," +
					"PRIMARY KEY(id))");

			st.execute(   "CREATE TABLE ipotesi(" +
					"id				INT         	NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1)," +
					"messaggio		LONG VARCHAR 	NOT NULL," +
					"PRIMARY KEY(id))");

			st.execute(   "CREATE TABLE frequenzaLingua(" +
					"lettera		CHAR         	NOT NULL," +
					"lingua			VARCHAR(12)     NOT NULL," +
					"frequenza		INTEGER 		NOT NULL," +
					"PRIMARY KEY(lettera, lingua))");
    }

	public static void creaDati(Statement st) throws SQLException{
		aggiungiFrequenza('a', "ita", 12, st);
		aggiungiFrequenza('b', "ita", 1, st);
		aggiungiFrequenza('c', "ita", 4, st);
		aggiungiFrequenza('d', "ita", 3, st);
		aggiungiFrequenza('e', "ita", 12, st);
		aggiungiFrequenza('f', "ita", 1, st);
		aggiungiFrequenza('g', "ita", 2, st);
		aggiungiFrequenza('h', "ita", 2, st);
		aggiungiFrequenza('i', "ita", 11, st);
		aggiungiFrequenza('l', "ita", 6, st);
		aggiungiFrequenza('m', "ita", 3, st);
		aggiungiFrequenza('n', "ita", 7, st);
		aggiungiFrequenza('o', "ita", 10, st);
		aggiungiFrequenza('p', "ita", 3, st);
		aggiungiFrequenza('q', "ita", 1, st);
		aggiungiFrequenza('r', "ita", 6, st);
		aggiungiFrequenza('s', "ita", 5, st);
		aggiungiFrequenza('t', "ita", 5, st);
		aggiungiFrequenza('u', "ita", 3, st);
		aggiungiFrequenza('v', "ita", 2, st);
		aggiungiFrequenza('z', "ita", 1, st);

		aggiungiFrequenza('a', "eng", 8, st);
		aggiungiFrequenza('b', "eng", 2, st);
		aggiungiFrequenza('c', "eng", 3, st);
		aggiungiFrequenza('d', "eng", 4, st);
		aggiungiFrequenza('e', "eng", 13, st);
		aggiungiFrequenza('f', "eng", 2, st);
		aggiungiFrequenza('g', "eng", 2, st);
		aggiungiFrequenza('h', "eng", 2, st);
		aggiungiFrequenza('i', "eng", 7, st);
		aggiungiFrequenza('j', "eng", 2, st);
		aggiungiFrequenza('k', "eng", 2, st);
		aggiungiFrequenza('l', "eng", 4, st);
		aggiungiFrequenza('m', "eng", 2, st);
		aggiungiFrequenza('n', "eng", 7, st);
		aggiungiFrequenza('o', "eng", 8, st);
		aggiungiFrequenza('p', "eng", 2, st);
		aggiungiFrequenza('q', "eng", 1, st);
		aggiungiFrequenza('r', "eng", 6, st);
		aggiungiFrequenza('s', "eng", 6, st);
		aggiungiFrequenza('t', "eng", 9, st);
		aggiungiFrequenza('u', "eng", 3, st);
		aggiungiFrequenza('v', "eng", 1, st);
		aggiungiFrequenza('w', "eng", 2, st);
		aggiungiFrequenza('x', "eng", 2, st);
		aggiungiFrequenza('y', "eng", 2, st);
		aggiungiFrequenza('z', "eng", 1, st);
    }

	public static int aggiungiFrequenza(Char lettera, String lingua, int frequenza ruolo, Statement st) throws SQLException{
		int id;
		esegui("INSERT INTO frequenzaLingua (lettera, lingua, frequenza) VALUES ('"+lettera+"', '"+lingua+"', '"+frequenza+"')", st);
		ResultSet rs = st.executeQuery("SELECT IDUSER FROM UTENTI WHERE USERNAME='"+nome+"'");
		rs.next();
		id = rs.getInt("IDUSER");
		return id;
    }

  public Query execute(Query q){
      return null;
  }
}
