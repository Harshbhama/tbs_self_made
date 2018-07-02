package com.tbs.model;

public class Customervo {

	
	public String getcustomername() {
		return customername;
	}
	public void setcustomername(String customername) {
		this.customername = customername;
	}
	public String getcustomeradd() {
		return customeradd;
	}
	public void setcustomeradd(String customeradd) {
		this.customeradd = customeradd;
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
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public int getPlancode() {
		return plancode;
	}
	public void setPlancode(int plancode) {
		this.plancode = plancode;
	}
	public String getcustomerpassword() {
		return customerpassword;
	}
	public void setcustomerpassword(String customerpassword) {
		this.customerpassword = customerpassword;
	}
	String customername;
	String customeradd;
	long customermob;
	int customerno;
	String Country;
	String State;
	int plancode;
	String customerpassword;
	
	float costmin;
	public float getCostmin() {
		return costmin;
	}
	public void setCostmin(float costmin) {
		this.costmin = costmin;
	}
	public float getCostmb() {
		return costmb;
	}
	public void setCostmb(float costmb) {
		this.costmb = costmb;
	}
	public String getPlanname() {
		return Planname;
	}
	public void setPlanname(String planname) {
		Planname = planname;
	}
	float costmb;

	String Planname;
}
