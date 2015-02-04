import javax.management.Query;
import java.sql.*;


public class DBManager {


	  public DBManager(){

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
	                "lingua         VARCHAR(24)     NOT NULL," +
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
    }

  public Query execute(Query q){
      return null;
  }
}
