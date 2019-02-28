
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class JavaDbConnect {
    
    

    private static Connection connection = null;

    /**
     *
     * @return
     * @throws SQLException
     */
    public static Connection dbConnect() throws SQLException {
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String userid = "system";
        
       
       
        String passwd= "system";
        
        
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(url, userid, passwd);
            return connection;

        } catch (ClassNotFoundException e) {
            
            JOptionPane.showMessageDialog(null, e);
            return null;

        }
        
    }
}
