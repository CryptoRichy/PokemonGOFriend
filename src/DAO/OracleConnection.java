package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
public class OracleConnection {
    public Connection getConnection() throws ClassNotFoundException,
            IOException, SQLException {
        final Properties prop = new Properties();
        //System.out.println("happened prop");
        //final InputStream inputStream = OracleConnection.class.getClassLoader()
        //		.getResourceAsStream(
        //				"CoreJavaJDBC_Assessment\\CoreJavaJDBC_Assessment\\src\\CoreJava\\Resources\\db.properties");
        //prop.load(inputStream);
        //System.out.println(inputStream);
        //Class.forName(prop.getProperty("driver"));
        Class.forName("oracle.jdbc.driver.OracleDriver");
//		final Connection connection = DriverManager.getConnection(prop.getProperty("jdbc:oracle:thin:@raidapp.cx6xdnjwmpez.us-east-2.rds.amazonaws.com:1521:ORCL"),
//			prop.getProperty("fichaelnd"), prop.getProperty("michael123"));


        String url = "jdbc:oracle:thin:@raid.cx6xdnjwmpez.us-east-2.rds.amazonaws.com:1521:ORCL";
        String username = "fichaelnd";
        String password = "michael123";

        final Connection connection = DriverManager.getConnection(url, username, password);
        return connection;

    }
}