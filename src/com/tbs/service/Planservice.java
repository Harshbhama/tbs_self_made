package com.tbs.service;

import java.util.List;

import com.tbs.dao.PlanDAO;
import com.tbs.model.Adminvo;
import com.tbs.model.Planvo;

public class Planservice {

	
	PlanDAO plandao;
	Planservice Planservice;
	public Planservice()
	{
		
		plandao = new PlanDAO();
		
	}
	


	public List<Planvo> planEmpservice()
	{
		
		return plandao.addplan();
	}
	

	public Planvo plancostEmpservice(int code)
	{
		
		return plandao.plancost(code);
	}
	
	
}
