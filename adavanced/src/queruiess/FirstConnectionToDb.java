package queruiess;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class FirstConnectionToDb {

	public static void main(String[] args) throws SQLException, FileNotFoundException, IOException
	{
		
	Connection con=	jdbcconnection.ConnectionToDb.getConnection();
	
	try {
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from stud ");
		
		while(rs.next())
		{
			System.out.println(rs.getString(1)+" "+rs.getString(2));
		}
	
	}catch(Exception e)
	{	e.printStackTrace();
		System.out.println(e);
	}
	con.close();
	
}
}