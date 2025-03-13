import java.sql.Connection;

public class SecureBruteForceLoginController {

    public boolean login(String username, String password) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int counter = 0;
        try {
            conn = DatabaseConnection.getConnection();
            String query = "SELECT password FROM users WHERE username = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, username);
            rs = pstmt.executeQuery();
            
            if (rs.next()) {
                String storedPassword = rs.getString("password");
                if (storedPassword.equals(password)) {
                    // Login avvenuto con successo
                    return true;
                } else {
                    // Password errata
                    counter++;
                    System.out.println("Login failed for user: " + username);
                    return false;
                }
            } else {
                // Utente non trovato
                System.out.println("User not found: " + username);
                return false;
            } if (counter>=5){
                System.out.println("attempt limit reached, try again later" );
                conn.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            closeResources(conn, pstmt, rs);
        }
    }

    private void closeResources(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        // Chiusura di connessioni, statement e result set
    }
}