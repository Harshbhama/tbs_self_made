package com.tbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tbs.dbfactory.Dbfactory;
import com.tbs.model.Adminvo;



public class AdminDAO {
	public static PreparedStatement ps;
	Connection con;
	Adminvo ev;
	int result;
	ResultSet rs;
	
	public AdminDAO()
	{
		Dbfactory db = new Dbfactory();
		con = db.setconnection();
		
	}
	

	
	public Adminvo adminval(long n3)
	{
		
		Adminvo adminvo = null;
		
		try {
			ps = con.prepareStatement("select admin_pass from admin_table where admin_phoneno = ?");
			
			ps.setLong(1, n3);
			rs = ps.executeQuery();
			
			if(rs.next())
			{
				adminvo = new Adminvo();
				adminvo.setAdminpassword(rs.getString(1));	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return adminvo;
		
	}
	
	
}
