package connectivity;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionClass {
public Connection connection;	
	public Connection getConnection() {
		
	//	String dbName="Project";
	//	String userName="hr";
	//	String password="**";
		
	try {	
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		connection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/ARUNIMA","hr","**");
		
	} catch(Exception e)
	{
		e.printStackTrace();
	}
		return connection;
	}

}
