package ManagedBeans;
import java.sql.*;
import java.util.HashMap;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DatabaseConnectivity 
{
	private static DatabaseConnectivity instance;
	private DataSource dataSource;
	private String dependencyInjection = "java:comp/env/jdbc/project";
	
	public static DatabaseConnectivity getInstance() throws NamingException
	{
		if(instance == null) {
			instance = new DatabaseConnectivity(); 
		}
		return instance;
	}
	
	private DatabaseConnectivity() throws NamingException
	{
		dataSource = getDataSource();
	}
	
	private DataSource getDataSource() throws NamingException
	{
		Context context = new InitialContext();
		DataSource dataSource = (DataSource) context.lookup(dependencyInjection);
		return dataSource;
	}
	
	private Connection getConnection() throws SQLException
	{
		Connection con = dataSource.getConnection();
		return con;
	}
	
	public HashMap<String,String> getLogins(String table) throws SQLException
	{
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		HashMap<String,String> Logins = new HashMap<String,String>();
		String IdType;
		
		con = getConnection();
		if(table.equals("Vendor"))
		{
			IdType = "VID";
		}
		else
		{
			IdType = "PID";
		}
		String query = "SELECT P." + IdType + ", CAST(AES_DECRYPT(P.Username, '27y64m22k') AS CHAR(100) CHARACTER SET utf8) AS Username, "
				+ "CAST(AES_DECRYPT(P.Password, '27y64m22k') AS CHAR(100) CHARACTER SET utf8) AS Password\n"
				+ "FROM " + table + " AS P";
		stmt = con.createStatement();
		rs = stmt.executeQuery(query);
		while(rs.next())
		{
			String userName = rs.getString("userName");
			String passWord = rs.getString("passWord");
			Logins.put(userName, passWord);
		}
		return Logins;
	}
	
	public ResultSet executeQuery(String Query) throws SQLException {
		Connection con = getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(Query);
		return rs;
	}
	public void executeUpdate(String Update) throws SQLException {
		Connection con = getConnection();
		Statement stmt = con.createStatement();
		stmt.executeUpdate(Update);
	}
}
