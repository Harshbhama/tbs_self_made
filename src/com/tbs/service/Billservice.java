package com.tbs.service;

import java.util.List;

import com.tbs.dao.BillDAO;
import com.tbs.model.Billvo;
import com.tbs.model.Customervo;

public class Billservice {
	
	
	BillDAO billdao;
	Billvo ev;
	public Billservice()
	{
		
		billdao = new BillDAO();
		
	}
	
	public List<Billvo> viewBillservice()
	{
		return billdao.view();
	}

	public Billvo paycostBillservice(long n)
	{
		
		return billdao.paycost(n);
	}
	public Billvo vdetailBillservice(long n)
	{
		
		return billdao.vdetails(n);
	}

	public int deleteemp1Billservice(Billvo e)
	{
		
		return billdao.deleteemp1(e);
	}
	public Billvo usagephone1Billservice(Long n1,int n)
	{
		return billdao.usagephone1(n1,n);
	}


	public int billstatuspaidBillservice(Billvo e)
	{
		return billdao.billstatuspaid(e);
	}
	public List<Billvo> viewBillservice1(Billvo e)
	{
		return billdao.view1(e);
	}
	

	public Billvo updateempBillservice()
	{
		return billdao.updateemp();
	}
	public int updatecostBillservice(Billvo e)
	{
		return billdao.updatecost(e);
	}
	public Billvo sltempcostBillservice(long n)
	{
		return billdao.sltempcost(n);
	}
	public Billvo sltbillstatusBillservice(long n)
	{
		
		return billdao.sltbillstatus(n);
	}
	public int updatecost1Billservice(Billvo e)
	{
		return billdao.updatecost1(e);
	}

	public int usageBillservice(Billvo e)
	{
		
		return billdao.usage(e);
	}
	public List<Billvo> view2Billservice(Billvo ev)
	{
		return billdao.view2(ev);
	}
	public int addcomplainBillservice(Billvo e)
	{
		return billdao.addcomplain(e);
	}
	public Billvo usagecomplainBillservice(long n)
	{
		return billdao.usagacomplain(n);
	}
	public int addcomplainBillservice1(Billvo e)
	{
		return billdao.addcomplain1(e);
	}
	
}