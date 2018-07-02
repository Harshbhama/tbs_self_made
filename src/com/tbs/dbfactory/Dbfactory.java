package com.tbs.dbfactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbfactory {

	Connection myconn ;
	
	public Connection setconnection()
	{
		com.mysql.jdbc.Driver d;
		try {
			d = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(d);
			
			myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","harsh19971997");
			myconn.setAutoCommit(false);
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		return myconn;
		
		
	}
	
}
