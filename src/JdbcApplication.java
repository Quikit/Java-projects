import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcApplication {

    public static void main(String[] args) {

        try {
            OracleDriverManagerSingleton Manager = OracleDriverManagerSingleton.getInstance();

            // подключаемся к oracle
            Connection con = Manager.getConnection();

            Statement statement = null;
            // создание таблицы
            String createTable = "CREATE TABLE LLL("
                    + "USER_ID NUMBER(5) NOT NULL, "
                    + "USERNAME VARCHAR(20) NOT NULL, "
                    + "CREATED_BY VARCHAR(20) NOT NULL, "
                    + "CREATED_DATE DATE NOT NULL, " + "PRIMARY KEY (USER_ID) "
                    + ")";
            statement = con.createStatement();
            statement.execute(createTable);
            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            if (e instanceof ClassNotFoundException) {
                System.out.println("Where is your MySQL JDBC Driver?");
                e.printStackTrace();
            } else if (e instanceof SQLException) {
                System.out.println("No connection to oracle database...");
                e.printStackTrace();
            }
        }


       /* OracleDriverManager driverManager = new OracleDriverManager();
        Connection connection = driverManager.openPostgresConnection();

        SimpleExample simpleExample = new SimpleExample(connection);
        simpleExample.selectExample();*/
    }
}