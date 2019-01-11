package com.wipro.srs.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil
{
	
	public static Connection getDBConnection() throws ClassNotFoundException, SQLException
	{
		//Connection con=null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","srs","srs");
	}
}
