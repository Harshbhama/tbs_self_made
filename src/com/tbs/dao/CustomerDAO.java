package com.tbs.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tbs.dbfactory.Dbfactory;
import com.tbs.model.Customervo;

public class CustomerDAO {
	public static PreparedStatement ps;
	Connection con;
	Customervo costumervo;
	int result;
	ResultSet rs;
	
	public CustomerDAO()
	{
		Dbfactory db = new Dbfactory();
		con = db.setconnection();
		
	}
	
	public int addcustomer(Customervo e)
	{
		try {
			ps =con.prepareStatement("insert into emp values(?,?,?,?,?,?,?,?)");
			
			ps.setString(1, e.getcustomername());
			ps.setString(2, e.getcustomeradd());
			ps.setLong(3, e.getcustomermob());
			ps.setString(4, e.getCountry());
			ps.setString(5,e.getState());
			ps.setInt(6, e.getcustomerno());
			ps.setInt(7, e.getPlancode());
			ps.setString(8, e.getcustomerpassword());
			//ps.setString(9,"Due");
			
			result = ps.executeUpdate();
			if(result>0)
			{
				
				con.commit();
			}
			con.close();
			
		} catch (SQLException e1) {
			// TODO Auto-generatcustomerdao catch block
			e1.printStackTrace();
		}
		
		return result;
		
		
	}
	
	
	
	public int modifyadd(Customervo e)
	{
		try {
			ps=con.prepareStatement("update emp set emp_add = ? where emp_no1 = ?");

			ps.setString(1,e.getcustomeradd());
			ps.setInt(2, e.getcustomerno());
			
			result = ps.executeUpdate();
			if(result>0)
			{
				con.commit();
				
			}
			con.close();
		} catch (SQLException e1) {
			// TODO Auto-generatcustomerdao catch block
			e1.printStackTrace();
		}
				
				
				return result;
		}
	public int modifyno(Customervo e)
	{
		try {
			ps=con.prepareStatement("update emp set emp_no=? where emp_no1 = ?");
			
			ps.setLong(1, e.getcustomermob());
			ps.setInt(2, e.getcustomerno());
			
			result = ps.executeUpdate();
			if(result>0)
			{
				
				con.commit();
			}
			con.close();
			
		} catch (SQLException e1) {
			// TODO Auto-generatcustomerdao catch block
			e1.printStackTrace();
		}
		return result;
	}
		
		public int modifycon(Customervo e)
		{
			try {
				ps=con.prepareStatement("update emp set emp_country = ? where emp_no1 = ?");
				
				ps.setString(1, e.getCountry());
				ps.setInt(2, e.getcustomerno());
				
				result = ps.executeUpdate();
				if(result>0)
				{
					
					con.commit();
				}
				con.close();
				
			} catch (SQLException e1) {
				// TODO Auto-generatcustomerdao catch block
				e1.printStackTrace();
			}
			return result;
		}
			
			public int modifyste(Customervo e)
			{
				try {
					ps=con.prepareStatement("update emp set emp_state=? where emp_no1 = ?");
					
					ps.setString(1, e.getState());
					ps.setInt(2, e.getcustomerno());
					
					result = ps.executeUpdate();
					if(result>0)
					{
						
						con.commit();
					}
					con.close();
					
				} catch (SQLException e1) {
					// TODO Auto-generatcustomerdao catch block
					e1.printStackTrace();
				}
				
							
		
		
		return result;
		}
			public int modifyname(Customervo e)
			{
				try {
					ps=con.prepareStatement("update emp set emp_name=? where emp_no1 = ?");
					
					ps.setString(1, e.getcustomername());
					ps.setInt(2, e.getcustomerno());
					
					result = ps.executeUpdate();
					if(result>0)
					{
						
						con.commit();
					}
					con.close();
					
				} catch (SQLException e1) {
					// TODO Auto-generatcustomerdao catch block
					e1.printStackTrace();
				}
				return result;
			}
			
			public Customervo userval(long n2)
			{
				Customervo costumervo = null;
				try {
					
					ps = con.prepareStatement("select emp_pass from emp where emp_no = ?");
					ps.setLong(1,n2);
					rs=ps.executeQuery();
					if(rs.next())
					{
						costumervo = new Customervo();
						costumervo.setcustomerpassword(rs.getString(1));
						
					}
					
				}
				 catch (SQLException e) {
						// TODO Auto-generatcustomerdao catch block
						e.printStackTrace();
					}
				return costumervo;
				
				
			}
			public int deleteemp(Customervo e)
			{
				try {
					ps = con.prepareStatement("delete from emp where emp_no1 = ?");
					ps.setInt(1, e.getcustomerno());
					
					result = ps.executeUpdate();
					if(result>0)
					{
						
						con.commit();
						//deleteemp1(e);
					}
					con.close();
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generatcustomerdao catch block
					e1.printStackTrace();
				}
			return result;
				}
			
			public Customervo userprofile(long n5)
			{
				
				Customervo costumervo = null;
				
				try {
					ps = con.prepareStatement("select emp_name,emp_add,emp_no,emp_country,emp_state,emp_no1,plan_name,cost_per_min,cost_per_mb from emp inner join plan_table on plan_table.plan_code=emp.plan_code where emp_no = ? ");
					
					ps.setLong(1,n5);
					rs = ps.executeQuery();
					
					if(rs.next())
					{
						costumervo = new Customervo();
						costumervo.setcustomername(rs.getString(1));
						costumervo.setcustomeradd(rs.getString(2));
						costumervo.setcustomermob(rs.getLong(3));
						costumervo.setCountry(rs.getString(4));
						costumervo.setState(rs.getString(5));
						costumervo.setcustomerno(rs.getInt(6));

						costumervo.setPlanname(rs.getString(7));
						costumervo.setCostmin(rs.getFloat(8));
						costumervo.setCostmb(rs.getFloat(9));
						
					}
			
				
				
				} catch (SQLException e1) {
					// TODO Auto-generatcustomerdao catch block
					e1.printStackTrace();
				}
				
				
				return costumervo;
				
				
			}
			
			public Customervo Changepass(long n6)
			{
				Customervo costumervo = null;
				
				try {
					ps = con.prepareStatement("select emp_pass from emp where emp_no = ? ");
					ps.setLong(1, n6);
					rs = ps.executeQuery();
					if(rs.next())
					{
						costumervo = new Customervo();
						costumervo.setcustomerpassword(rs.getString(1));
					}
					
				} catch (SQLException e) {
					// TODO Auto-generatcustomerdao catch block
					e.printStackTrace();
				}
				return costumervo;
				
			}
			public int changeemppass(Customervo e)
			{
				//Customervo ev = null;
				try {
					ps = con.prepareStatement("update emp set emp_pass = ? where emp_no = ?");
					ps.setString(1, e.getcustomerpassword());
					ps.setLong(2, e.getcustomermob());
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
			
			public Customervo usageemp(int n7)
			{
				Customervo costumervo = null;
				try {
					ps = con.prepareStatement("select plan_code from emp where emp_no1 = ?");
					ps.setInt(1, n7);
					rs = ps.executeQuery();
					if(rs.next())
					{
						costumervo = new Customervo();
						costumervo.setPlancode(rs.getInt(1));
						
						
					}
				} catch (SQLException e) {
					// TODO Auto-generatcustomerdao catch block
					e.printStackTrace();
				}
				return costumervo;
				
			}
			public Customervo usagephone(int n8)
			{
				Customervo costumervo = null;
				try {
					ps = con.prepareStatement("select emp_no from emp where emp_no1 = ?");
					ps.setInt(1, n8);
					rs = ps.executeQuery();
					if(rs.next())
					{
						costumervo = new Customervo();
						costumervo.setcustomermob(rs.getLong(1));;
						
						
					}
				} catch (SQLException e) {
					// TODO Auto-generatcustomerdao catch block
					e.printStackTrace();
				}
			
				
				return costumervo;
				
			}
			
			
			
			
			
	
	
}
