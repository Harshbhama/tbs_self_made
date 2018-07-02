
package com.tbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tbs.dbfactory.Dbfactory;
import com.tbs.model.Planvo;

public class PlanDAO {
	public static PreparedStatement ps;
	Connection con;
	Planvo planvo;
	int result;
	ResultSet rs;
	
	public PlanDAO()
	{
		Dbfactory db = new Dbfactory();
		con = db.setconnection();
		
	}


	public List<Planvo> addplan()
	{
		List<Planvo> l = new ArrayList<Planvo>();
		try {
			
			
			ps = con.prepareStatement("select * from plan_table");
			
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				planvo = new Planvo();
				planvo.setPlanname(rs.getString(1));
				planvo.setPlancode(rs.getInt(2));
				planvo.setPlanval(rs.getInt(3));
				planvo.setPlancost(rs.getInt(4));
				planvo.setCostmin(rs.getFloat(5));
				planvo.setCostmb(rs.getFloat(6));
				
				l.add(planvo);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		return l;
		
		
	}
	
	public Planvo plancost(int code)
	{
		planvo = null;
		try {
			
			ps = con.prepareStatement("select plan_cost from plan_table where plan_code = ?");
			ps.setInt(1, code);
			rs = ps.executeQuery();
			if(rs.next())
			{
				planvo = new Planvo();
				planvo.setPlancost(rs.getInt(1));
				
			}
			
			con.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		return planvo;
		
	}
	}
	
	
	
	
	