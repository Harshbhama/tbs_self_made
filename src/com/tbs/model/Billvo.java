package com.tbs.model;

public class Billvo {

	
	public int getcustomerdur() {
		return customerdur;
	}
	public int setcustomerdur(int customerdur) {
		return this.customerdur = customerdur;
	}
	public int getcustomernet() {
		return customernet;
	}
	public int setcustomernet(int customernet) {
		return this.customernet = customernet;
	}
	public float getcustomercost() {
		return customercost;
	}
	public void setcustomercost(float customercost) {
		this.customercost = customercost;
	}
	public int getcustomerinv() {
		return customerinv;
	}
	public void setcustomerinv(int customerinv) {
		this.customerinv = customerinv;
	}
	public long getcustomermob() {
		return customermob;
	}
	public void setcustomermob(long customermob) {
		this.customermob = customermob;
	}
	public int getcustomerno() {
		return customerno;
	}
	public void setcustomerno(int customerno) {
		this.customerno = customerno;
	}
	public String getBillstatus() {
		return billstatus;
	}
	public void setBillstatus(String billstatus) {
		this.billstatus = billstatus;
	}
	int customerdur;
	int customernet;
	float customercost;
	int customerinv;
	long customermob;
	int customerno;
	String billstatus;
	String customercomplain;
	public String getCustomercomplain() {
		return customercomplain;
	}
	public void setCustomercomplain(String customercomplain) {
		this.customercomplain = customercomplain;
	}
}
