package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class CSSQLiteDataHelper {
    private static String CSDBPathConnection = "jdbc:sqlite:Database/examenDataBase.sqlite";
    private static Connection conn = null;
    protected CSSQLiteDataHelper(){}

    protected static synchronized Connection csOpenConnection () throws SQLException{
        try {
            if (conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection(CSDBPathConnection); 
            }
        } catch (SQLException e) {
            throw e;
        }
        return conn;
    }

    protected static void csCloseConnection() throws SQLException {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                conn = null;  // Reset the connection object to null
            }
        } catch (SQLException e) {
            throw e;
        }
    }
}