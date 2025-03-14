import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SecureLoginController {

    public boolean login(String username, String password) {
        // Connessione al database
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConnection.getConnection();
            pstmt = conn.createStatement();

            // Query SQL costruita in modo insicuro
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            // Imposta i parametri
            pstmt.setString(1, username); // Imposta il primo parametro (username)
            pstmt.setString(2, password); // Imposta il secondo parametro (password)
                
            rs = pstmt.executeQuery(query);

            if (rs.next()) {
                System.out.println("Login avvenuto con successo"); 
                return true;
            } else {
                System.out.println(" Credenziali errate");
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            // Chiusura risorse
            closeResources(conn, pstmt, rs);
        }
    }

    private void closeResources(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        // Chiusura di connessioni e statement
         try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
