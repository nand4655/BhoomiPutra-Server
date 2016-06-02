package dao;
import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnection
{
	static Connection con;
	public static Connection connect()
	{
		try
		{
			if(con==null || con.isClosed())
			{
				Class.forName("oracle.jdbc.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","wimc","omsai123$");
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return con;
	}

}
