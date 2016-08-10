package connection;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Oracle {
private static Connection cn;
private static String JDBC_DRIVER="com.mysql.jdbc.Driver";
private static String JDBC_USER="onlinestore";
private static String URL ="jdbc:oracle:thin:@localhost:1521:XE";
private static String JDBC_PASSWORD="oracle";
private static Driver driver= null;
//    public static Connection getConnection(String user, String password) throws SQLException {
//        String urlJDBC = "jdbc:mysql://localhost:3306/OnlineStore";
//        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
//        Connection con = DriverManager.getConnection(urlJDBC, user, password);
//        return con;
//    }

    public static Connection getConnection() throws Exception {
//        Context ctx = new InitialContext();
//        DataSource ds = (DataSource) ctx.lookup("jdbc/onlinestoreoracle");
//        Connection cn = ds.getConnection();
//        return cn;
 try {
            Class.forName("oracle.jdbc.OracleDriver");
            cn =DriverManager.getConnection(URL, JDBC_USER, JDBC_PASSWORD);
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch(SQLException e){
        e.printStackTrace();
        }
    return cn;
    }
}
