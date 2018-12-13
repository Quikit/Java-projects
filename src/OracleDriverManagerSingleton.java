import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleDriverManagerSingleton {

    private static OracleDriverManagerSingleton instance = null;
    private Connection connection = null;

    private OracleDriverManagerSingleton(Connection connection){
        this.connection = connection;
    }

    public static OracleDriverManagerSingleton getInstance() throws ClassNotFoundException, SQLException {
        if (instance == null) {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con  = DriverManager.getConnection("jdbc:oracle:thin:@sql.edu-netcracker.com:1251:xe", "TLT_18", "TLT_18");
            instance = new OracleDriverManagerSingleton(con);
        }
        return instance;
    }
    public Connection getConnection(){
        return connection;
    }

}