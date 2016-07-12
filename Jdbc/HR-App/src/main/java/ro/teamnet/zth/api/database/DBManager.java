package ro.teamnet.zth.api.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by user on 7/8/2016.
 */
public class DBManager {

    private DBManager (){
        throw new UnsupportedOperationException();
    }

    private static final String CONNECTION_STRING = "jdbc:oracle:thin:@" + DBProperties.IP + ":" + DBProperties.PORT;

    private static void registerDriver(){
        try {
            Class.forName(DBProperties.DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnection()  {
        registerDriver();
        try {
            return DriverManager.getConnection(
                    CONNECTION_STRING, DBProperties.USER, DBProperties.PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
      return null;
    }

    public static boolean checkConnection(Connection connection){
        try (Statement stmt = connection.createStatement())
        {
           return stmt.execute("select 1 from dual");
        }
        catch (SQLException e) {
        }
       return false;
    }
}
