package com.tbs.gui;

import java.util.Scanner;


import com.tbs.service.Customerservice;


public class Usage {
	public Usage()
	{

	Scanner sc= new Scanner(System.in);
	
	float n1 = (150/1024);

	System.out.println("Enter Duration in minutes");
	
	Customervo e = new Customervo();
	int f=e.setcustomerdur(sc.nextInt());
	
	System.out.println("Enter Net usage in mbs");
	float f1=e.setcustomernet(sc.nextInt());
	
	float f2 = f+f1;
	System.out.println(f2);
	e.setcustomercost(f2);
	
	
	System.out.println("Usage for employee no");
	e.setcustomerno(sc.nextInt());
	
	System.out.println("setting emp invoice");
	e.setcustomerinv(20);
	
	Customerservice es = new Customerservice();
	es.usagecustomerservice(e);

	System.out.println("DONE");
	}
	public static void main(String[] args)
	{
		
		new Usage();
	}
	
}
