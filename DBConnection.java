package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
   
public static Connection createConnection() throws ClassNotFoundException, SQLException {
	Class. forName ( "com.ibm.db2.jcc.DB2Driver"  );
        Connection  connection =
                DriverManager.getConnection("jdbc:db2://172.16.12.92:50000/MITS","db2admin","mits123$");
 
        System. out .println( "From DAO, connection obtained "  +connection);
      return connection;

	
    }
}
