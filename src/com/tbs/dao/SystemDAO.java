package com.tbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tbs.dbfactory.Dbfactory;
import com.tbs.model.Systemvo;

public class SystemDAO {
	
	


	public static PreparedStatement ps;
	Connection con;
	Systemvo systemvo;
	int result;
	ResultSet rs;
	
	public SystemDAO()
	{
		Dbfactory db = new Dbfactory();
		con = db.setconnection();
		
	}

	public Systemvo systemval(long n4)
	{
		
		Systemvo systemvo = null;
		
		try {
			ps = con.prepareStatement("select sys_pass from system_table where sys_phoneno = ?");
			
			ps.setLong(1, n4);
			rs = ps.executeQuery();
			
			if(rs.next())
			{
				systemvo = new Systemvo();
				systemvo.setSystempassword((rs.getString(1)));	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return systemvo;
		
	}
	
}
