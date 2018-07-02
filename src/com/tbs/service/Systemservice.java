package com.tbs.service;

import com.tbs.dao.SystemDAO;
import com.tbs.model.Systemvo;

public class Systemservice {

	SystemDAO systemdao;
	Systemvo systemvo;
	public Systemservice()
	{
		
		systemdao = new SystemDAO();
		
	}
	public Systemvo systemvalSystemservice(long n4)
	{
		
		return systemdao.systemval(n4);
	}
	
	
	
	
	
}
