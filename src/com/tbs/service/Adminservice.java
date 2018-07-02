package com.tbs.service;

import com.tbs.dao.AdminDAO;
import com.tbs.model.Adminvo;


public class Adminservice {

	
	AdminDAO admindao;
	Adminservice adminservice;
	public Adminservice()
	{
		
		admindao = new AdminDAO();
		
	}
	
	
	public Adminvo adminvalEmpservice(long n3)
	{
		return admindao.adminval(n3);
		
	}
}
