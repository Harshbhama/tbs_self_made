package com.tbs.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.tbs.model.Empvo;
import com.tbs.service.Empservice;

public class Gui extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JButton b1,b2,b3,b4,b5,b6,b7;
	
	
	public Gui()
	{
		JLabel background = new JLabel(new ImageIcon("E://new.jpg"));
		add(background);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		
		 setVisible(true);
	        setSize(700, 700);
	        setLayout(null);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setTitle("Telephone billing system");
	  
	      
	        
	        
	        b1 = new JButton("NEW CONNECTION");
	        b2 = new JButton("MODIFY CUSTOMER RECORDS");
	        b3 = new JButton("VIEW CUSTOMER DETAILS");
	        b4 = new JButton("REMOVE CONNECTION");
	        b5 = new JButton("VIEW BILL");
	        b6 = new JButton("Update usage");
	        b7 = new JButton("Pay");
	       
	        
	        b1.setBounds(200,30,200,30);
	        b2.setBounds(200,80,200,30);
	        b3.setBounds(200,130,200,30);
	        b4.setBounds(200,180,200,30);
	        b5.setBounds(200,230,200,30);
	        b6.setBounds(200,280,200,30);
	        b7.setBounds(200,330,200,30);
	        add(b1);
	        add(b2);
	        add(b3);
	        add(b4);
	        add(b5);
	        add(b6);
	        add(b7);
	        
	        
	        b1.addActionListener(this);
	        b2.addActionListener(this);
	        b3.addActionListener(this);
	        b5.addActionListener(this);
	        b6.addActionListener(this);
	       b7.addActionListener(this);


		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==b1)
		{
			
		/*	Empvo ev = new Empvo();
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Emp name");
			
			ev.setEmpname(sc.next());
			
			System.out.println("Enter Emp add");
			
			ev.setEmpadd(sc.next());
			
			System.out.println("Enter Emp mobile no");
			
			ev.setEmpno(sc.nextInt());
			
System.out.println("Enter Emp Country");
			
			ev.setCountry(sc.next());

System.out.println("Enter Emp state");
			
			ev.setState(sc.next());
			
			Empservice es =new Empservice();
			es.addEmpservice(ev);
			
		}*/
			
		Newconn n =new Newconn();
					
		}
		if(e.getSource()==b2)
		{
			
			Modify m = new Modify();
		}
		if(e.getSource()==b5)
		{
			/*Empservice e3 = new Empservice();
			
			List<Empvo> l1 = new ArrayList<Empvo>();
			l1 =e3.viewEmpservice();
			Iterator<Empvo> i =l1.iterator();
			while(i.hasNext())
			{
				Empvo ev=i.next();
				System.out.println("Duration "+ev.getEmpdur()+ " "+"Broadband Usage"+ev.getEmpnet()+" Cost"+ev.getEmpcost()+ " invoice"+ev.getEmpinv()+" "+"EmpName"+ev.getEmpname());
			}*/
			Newbill n1 = new Newbill();
			
			
		}
		if(e.getSource()==b6)
		{
			//Usage u = new Usage();
			Usage1 u = new Usage1();
		}		
				
		if(e.getSource()==b7)
		{
			Pay p = new Pay();
			
		}
		if(e.getSource()==b3)
		{
			Vdetail v = new Vdetail();
			
		}
		
	/*if(e.getSource()==b7)
	{
		
		
	}*/
	}
	
	public static void main(String[] args)
	{
		
		new Gui();
	}


	
}
