package com.tbs.service;

import java.util.List;

import com.tbs.dao.PayDAO;
import com.tbs.model.Customervo;
import com.tbs.model.Payvo;

public class Payservice {
	
	
	PayDAO paydao;
	Payvo payvo;
	public Payservice()
	{
		
		paydao = new PayDAO();
		
	}
	
	public int deletepayEmpservice(Payvo e)
	{
		
		return paydao.deletepay(e);
	}
	
	
	public int paydetail(Payvo e)
	{
		return paydao.paydetail(e);
		
	}

	public Payvo transpassEmpservce(long n5)
	{
		return paydao.transpass(n5);
	}
}