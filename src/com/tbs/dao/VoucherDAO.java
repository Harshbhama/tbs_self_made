package com.tbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tbs.dbfactory.Dbfactory;
import com.tbs.model.Vouchervo;

public class VoucherDAO {
	public static PreparedStatement ps;
	Connection con;
	Vouchervo vouchervo;
	int result;
	ResultSet rs;
	
	public VoucherDAO()
	{
		Dbfactory db = new Dbfactory();
		con = db.setconnection();
		
	}
	
	public int vouceremp(Vouchervo e)
	{
		try {
			ps = con.prepareStatement("insert into voucher_table values(?,?)");
			ps.setLong(1, e.getcustomermob());
			ps.setString(2,e.getVouchercode());
			
			result = ps.executeUpdate();
			if(result>0)
			{
				con.commit();
				
			}
			
			con.close();
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return result;
		
	}
	
}