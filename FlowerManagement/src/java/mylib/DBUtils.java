
package mylib;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtils {
    public static Connection makeConnetion() throws Exception{
        Connection cn = null;
        String IP="localhost";
        String instanceName="DAIQUYEN";
        String port="1433";
        String uid="sa";
        String pwd="12345";
        String db="FlowerManagement";
        String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url="jdbc:sqlserver://" +IP+"\\"+ instanceName+":"+port
                 +";databasename="+db+";user="+uid+";password="+pwd;
        Class.forName(driver);
        cn=DriverManager.getConnection(url);
        return cn;
    }
}