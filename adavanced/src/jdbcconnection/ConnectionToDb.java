package jdbcconnection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionToDb {
	static Connection con=null;
	private ConnectionToDb()
	{
		
	}
 public static Connection getConnection() throws FileNotFoundException,IOException
{	InputStream is=new FileInputStream("E:\\congif.properties");
	 Properties p=new Properties();
	 p.load(is);
	String dbuser= p.getProperty("dbuser");
	
	String dbpass= p.getProperty("dbpass");
	 
	 
	try {
		Class.forName("com.mysql.jdbc.Driver");
		 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test",dbuser,dbpass);
	}catch(Exception e)
	{	e.printStackTrace();
		System.out.println("connection fails");
	}
		return con;
}
	
}

 