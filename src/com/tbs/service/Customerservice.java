package com.tbs.service;

import java.util.List;

import com.tbs.dao.CustomerDAO;
import com.tbs.model.Customervo;

public class Customerservice {
	
	
	CustomerDAO customerdao;
	Customervo customervo;
	public Customerservice()
	{
		
		customerdao = new CustomerDAO();
		
	}
	
	public int addCustomerservice(Customervo e)
	{
		
		return customerdao.addcustomer(e);	
		
	}
	

	public int modifyaddCustomerservice(Customervo e)
	{
		
		return customerdao.modifyadd(e);
	}
	
	public int modifynoCustomerservice(Customervo e)
	{
		
		return customerdao.modifyno(e);
	}
	public int modifyconCustomerservice(Customervo e)
	{
		
		return customerdao.modifycon(e);
	}
	
	public int modifysteCustomerservice(Customervo e)
	{
		
		return customerdao.modifyste(e);
	}

	public int modifynameCustomerservice(Customervo e)
	{
		return customerdao.modifyname(e);
	}
	public Customervo uservalCustomerservice(long n2)
	{
		return customerdao.userval(n2);
		
	}
	
	public int deleteempCustomerservice(Customervo e)
	{
		
		return customerdao.deleteemp(e);
	}
	public Customervo userprofileCustomerservice(long n5)
	{
		
		return customerdao.userprofile(n5);
	}
	
	public Customervo changepassCustomerservice(long n6)
	{
		return customerdao.Changepass(n6);
	}
	public Customervo usageempCustomerservice(int n7)
	{
		return customerdao.usageemp(n7);
	}
	public Customervo usagephoneCustomerservice(int n8)
	{
		return customerdao.usagephone(n8);

	}
	public int changeemppassCustomerservice(Customervo e)
	{
		return customerdao.changeemppass(e);
	}
}