
package connectDB;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionDB {
    String DB_USERNAME="db.jdbcUsername";
    String DB_PASSWORD="db.jdbcPassword";
    String DB_URL ="db.jdbcURL";

    public void ConnectDB() {
    }
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Properties properties = new Properties();
            InputStream inStream = new FileInputStream(new File("src\\main\\resources\\" +
                    "db.properties"));
            properties.load(inStream);
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(properties.getProperty(DB_URL),
                    properties.getProperty(DB_USERNAME), properties.getProperty(DB_PASSWORD));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
