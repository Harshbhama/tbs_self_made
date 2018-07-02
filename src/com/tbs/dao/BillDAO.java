package com.tbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tbs.dbfactory.Dbfactory;
import com.tbs.model.Billvo;

public class BillDAO {
	public static PreparedStatement ps;
	Connection con;
	Billvo ev;
	int result;
	ResultSet rs;
	
	public BillDAO()
	{
		Dbfactory db = new Dbfactory();
		con = db.setconnection();
		
	}
	
	public int usage(Billvo e)
	{
		
		try {
			ps = con.prepareStatement("insert into emp1 values(?,?,?,?,?,?,?,?)");
			
			ps.setInt(1, e.getcustomerdur());
			ps.setInt(2, e.getcustomernet());
			ps.setFloat(3, e.getcustomercost());
			ps.setInt(4, e.getcustomerno());
			ps.setInt(5, e.getcustomerinv());
			ps.setString(6, e.getBillstatus());
			ps.setLong(7, e.getcustomermob());
			ps.setString(8, e.getCustomercomplain());
			result = ps.executeUpdate();
			if (result>0)
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
	

	public List<Billvo> view()
	{
		List<Billvo> l = new ArrayList<Billvo>();
		try {
			ps = con.prepareStatement("select emp_dur,emp_net,emp_cost,emp_inv,emp_no1,bill_status from emp1 ");
			
			rs= ps.executeQuery();
			
			
			
			while(rs.next())
			{
				ev = new Billvo();
				ev.setcustomerdur(rs.getInt(1));
				ev.setcustomernet(rs.getInt(2));
				ev.setcustomercost(rs.getFloat(3));
				ev.setcustomerinv(rs.getInt(4));
				ev.setcustomerno(rs.getInt(5));
				ev.setBillstatus(rs.getString(6));
				
				
				l.add(ev);
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return l;
	
	}

	public Billvo paycost(long n)
	{
		Billvo ev = null;
		try {
			
			ps = con.prepareStatement("select emp_cost from emp1  where emp_no = ?");
			ps.setLong(1,n);
			rs=ps.executeQuery();
			if(rs.next())
			{
				ev = new Billvo();
				ev.setcustomercost(rs.getFloat(1));
				
			}
			
		}
		 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return ev;
		
		
	}
	public Billvo vdetails(long n)
	{
		Billvo ev = null;
		try{
		
		ps = con.prepareStatement("select emp_dur,emp_net,emp_cost,emp_inv from emp1 where emp_no = ?");
				ps.setLong(1, n);
		rs = ps.executeQuery();
		if(rs.next())
		{
			
			ev = new Billvo();
			ev.setcustomerdur(rs.getInt(1));
			ev.setcustomernet(rs.getInt(2));
			ev.setcustomercost(rs.getFloat(3));
			ev.setcustomerinv(rs.getInt(4));
			 }
		}
		 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		
		
		return ev;
			
		
	}
	
	public int deleteemp1(Billvo e)
	{
		try {
			ps = con.prepareStatement("delete from emp1 where emp_no1 = ?");
			ps.setInt(1, e.getcustomerno());
			
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
	
	public Billvo usagephone1(Long n1,int n)
	{
		try {
			ps = con.prepareStatement("update emp1 set emp_no = ? where emp_no1 = ?");
			
			ps.setLong(1, n1);
			ps.setInt(2, n);
			result = ps.executeUpdate();
			if(result>0)
			{
				con.commit();
			}
			
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ev;
		
		
	}
	public int billstatuspaid(Billvo e)
	{
		try {
			ps = con.prepareStatement("update emp1 set bill_status = ? where emp_no = ?");
			ps.setString(1, e.getBillstatus());
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
	
	public List<Billvo> view1(Billvo ev)
	{
		List<Billvo> l = new ArrayList<Billvo>();
		try {
			ps = con.prepareStatement("select emp_dur,emp_net,emp_cost,emp_inv,emp_no1,bill_status from emp1 where bill_status = ? ");
			ps.setString(1, ev.getBillstatus());
			rs= ps.executeQuery();
			
			
			
			while(rs.next())
			{
				ev = new Billvo();
				ev.setcustomerdur(rs.getInt(1));
				ev.setcustomernet(rs.getInt(2));
				ev.setcustomercost(rs.getFloat(3));
				ev.setcustomerinv(rs.getInt(4));
				ev.setcustomerno(rs.getInt(5));
				ev.setBillstatus(rs.getString(6));
				
				
				l.add(ev);
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return l;
	}
	public Billvo updateemp()
	{
		Billvo ev = null;
		try {
			ps = con.prepareStatement("select max(emp_no1) from emp1 ");
			
			rs = ps.executeQuery();
			if(rs.next())
			{
				ev = new Billvo();
				ev.setcustomerno(rs.getInt(1));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		return ev;
		
	}
	public int updatecost(Billvo e)
	{
		try {
			ps = con.prepareStatement("update emp1 set emp_cost = emp_cost-100 where emp_no = ?");
			ps.setLong(1, e.getcustomermob());
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
	
	public Billvo sltempcost(long n)
	{
		Billvo ev = null;
		try {
			ps = con.prepareStatement("select emp_cost from emp1 where emp_no = ?");
			ps.setLong(1, n);
			rs = ps.executeQuery();
			if(rs.next())
			{
				ev = new Billvo();
				ev.setcustomercost(rs.getInt(1));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ev;
	}
	public Billvo sltbillstatus(long n)
	{
		Billvo ev = null;
		try {
			ps = con.prepareStatement("select bill_status from emp1 where emp_no = ?");
			ps.setLong(1, n);
			rs= ps.executeQuery();
			if(rs.next())
			{
				ev = new Billvo();
				ev.setBillstatus(rs.getString(1));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ev;

	}
	
	public int updatecost1(Billvo e)
	{
		try {
			ps = con.prepareStatement("update emp1 set emp_cost = emp_cost-500 where emp_no = ?");
			ps.setLong(1, e.getcustomermob());
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
	
	public List<Billvo> view2(Billvo ev)
	{
		List<Billvo> l = new ArrayList<Billvo>();
		try {
			ps = con.prepareStatement("select emp_dur,emp_net,emp_cost,emp_no1,emp_inv,bill_status from emp1 where emp_no1 = ?");
			ps.setInt(1, ev.getcustomerno());
			rs = ps.executeQuery();
			while(rs.next())
			{
				 ev = new Billvo();
				ev.setcustomerdur(rs.getInt(1));
				ev.setcustomernet(rs.getInt(2));
				ev.setcustomercost(rs.getFloat(3));
				ev.setcustomerno(rs.getInt(4));
				ev.setcustomerinv(rs.getInt(5));
				ev.setBillstatus(rs.getString(6));
				
				l.add(ev);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
		
		
	}
	
	public int addcomplain(Billvo ev)
	{
		try {
			ps = con.prepareStatement("update emp1 set emp_complain = ? where emp_no1 = ?");
			ps.setString(1, ev.getCustomercomplain());
			ps.setInt(2, ev.getcustomerno());
			
			result = ps.executeUpdate();
			if(result>0)
			{
				
				con.commit();
			}
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}
	
	public Billvo usagacomplain(long n)
	{
		Billvo ev = null;
		try {
			ps = con.prepareStatement("select emp_complain from emp1 where emp_no = ?");
			ps.setLong(1, n);
			rs = ps.executeQuery();
			if(rs.next())
			{
				ev= new Billvo();
				ev.setCustomercomplain(rs.getString(1));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ev;
		
		
		
		
	}
	
	public int addcomplain1(Billvo ev)
	{
		try {
			ps = con.prepareStatement("update emp1 set emp_complain = ? where emp_no = ?");
			ps.setString(1, ev.getCustomercomplain());
			ps.setLong(2, ev.getcustomermob());
			
			result = ps.executeUpdate();
			if(result>0)
			{
				
				con.commit();
			}
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}
	

	}
	
	
