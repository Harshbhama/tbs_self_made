package com.tbs.service;

import java.util.List;

import com.tbs.dao.VoucherDAO;
import com.tbs.model.Customervo;
import com.tbs.model.Payvo;
import com.tbs.model.Vouchervo;

public class Voucherservice {
	
	
	VoucherDAO voucherdao;
	Payvo payvo;
	public Voucherservice()
	{
		
		voucherdao = new VoucherDAO();
		
	}
	
	public int voucherempEmperservice(Vouchervo e)
	{
		return voucherdao.vouceremp(e);
	}
}