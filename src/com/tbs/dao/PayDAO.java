package com.tbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tbs.dbfactory.Dbfactory;
import com.tbs.model.Payvo;

public class PayDAO {
	public static PreparedStatement ps;
	Connection con;
	Payvo payvo;
	int result;
	ResultSet rs;
	
	public PayDAO()
	{
		Dbfactory db = new Dbfactory();
		con = db.setconnection();
		
	}
	
	
	public int deletepay(Payvo e)
	{
		try {
			ps = con.prepareStatement("delete from pay_table where emp_no1 = ?");
			ps.setInt(1, e.getcustomerno());
			
			result = ps.executeUpdate();
			if(result>0)
			{
				
				con.commit();
				//deleteemp1(e);
			}
			con.close();
			
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	return result;
		}
	
	
	
	
	public int paydetail(Payvo e)
	{
		try {
			ps = con.prepareStatement("insert into pay_table values(?,?,?)");
			ps.setInt(1, e.getcustomerno());
			ps.setString(2, e.getTranspassword());
			ps.setLong(3, e.getcustomermob());
			result = ps.executeUpdate();
			if(result>0){
				con.commit();
				
				
			}
			con.close();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		
		return result;
		
		
	}
	public Payvo transpass(long n5)
	{
		Payvo payvo = null;
		try {
			ps = con.prepareStatement("select trans_pass from pay_table where emp_no =?");
			ps.setLong(1, n5);
			rs = ps.executeQuery();
			if(rs.next())
			{
				payvo = new Payvo();
				payvo.setTranspassword(rs.getString(1));
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return payvo;
	}
}
	