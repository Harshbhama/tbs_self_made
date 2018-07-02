package com.tbs.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.tbs.dao.BillDAO;
import com.tbs.model.Billvo;
import com.tbs.model.Customervo;
import com.tbs.model.Planvo;
import com.tbs.service.Billservice;
import com.tbs.service.Customerservice;
import com.tbs.service.Planservice;

public class Usage1 implements ActionListener {
	
	JLabel l1,l2,l3,l4;
	JTextField t1,t2,t3,t4;
	JFrame f;
	JPanel p;
	JButton b1,b2;

	public Usage1()
	{

	f = new JFrame();
	p = new JPanel();
	
	ImageIcon background = new ImageIcon("E://new2.jpg");
	JLabel label = new JLabel();
	label.setBounds(0, 0, 700, 700);
	label.setIcon(background);
	
	f.getContentPane().add(p);
	
	p.setPreferredSize(new Dimension(700,700));
	p.setLayout(new BorderLayout());
	
	f.add(p);
	f.pack();
	f.requestFocus();
	f.setFocusable(true);
	f.setVisible(true);
	
	//p.setBackground(Color.LIGHT_GRAY);

	
	l1 = new JLabel("Enter the duration in minutes");
	l2 = new JLabel("Enter the data usage in mbs");
	l3 = new JLabel("Enter customerloyee number");
	l4 = new JLabel("Enter the respective plan code");
	
	l1.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
	l2.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
	l3.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
	l4.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
	
	l1.setForeground(Color.WHITE);
	l2.setForeground(Color.WHITE);
	l3.setForeground(Color.WHITE);
	l4.setForeground(Color.WHITE);
	
	
	t1 = new JTextField();
	t2 = new JTextField();
	t3 = new JTextField();
	t4 = new JTextField();
	
	b1 = new JButton("Submit");
	b2 = new JButton("Back");
	
	l1.setBounds(150,30,200,30);
	l2.setBounds(150,80,200,30);
	l3.setBounds(150,130,200,30);
	l4.setBounds(150,180,200,30);
	
	t1.setBounds(400,30,200,30);
	t2.setBounds(400,80,200,30);
	t3.setBounds(400,130,200,30);
	t4.setBounds(400, 180, 200, 30);
	
	b1.setBounds(200,230,90,30);
	b2.setBounds(250,500,110,30);
	b1.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
	b2.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
	p.add(l1);
	p.add(l2);
	p.add(t1);
	p.add(t2);
	p.add(b1);
	p.add(l3);
	p.add(t3);
	p.add(b2);
	//p.add(l4);
	//p.add(t4);

	
	b1.addActionListener(this);
	b2.addActionListener(this);
	p.add(label);
	p.setLayout(null);
	
	
}

	@Override
	public void actionPerformed(ActionEvent e1) {
		if(e1.getSource()==b1)
		{
			int n7 = Integer.parseInt(t3.getText());
			Customervo e11 = new Customervo();
			Customerservice es1 = new Customerservice();
			e11 = es1.usageempCustomerservice(n7);
		//	System.out.println(e11.getPlancode());
			
			Customervo e22 = new Customervo();
			Customerservice es2 = new Customerservice();
			e22 = es2.usagephoneCustomerservice(n7);
			//System.out.println(e22.getcustomermob());
			Long n = e22.getcustomermob();
			System.out.println(n);
	/*		Customervo e33 = new Customervo();
			Customerservice es3 = new Customerservice();
			e33 = es3.usagephone1Customerservice(n, n7);
		*/	
			Planvo e = new Planvo();
		
			Planservice e2 = new Planservice();
			
			
			e = e2.plancostEmpservice(e11.getPlancode());
			Billvo e111 = new Billvo();
			e111.setCustomercomplain("Nill");
			int f4= e.getPlancost();
			if(f4==200)
			{
	
				
	
			int f1 = e111.setcustomerdur(Integer.parseInt(t1.getText()));
			int f2 = e111.setcustomernet(Integer.parseInt(t2.getText()));
			
			float f5 = f1*1;
			float f6 = f2/3;
			float f3 = f5+f6+f4;
			System.out.println("Done");
			e111.setcustomerno(Integer.parseInt(t3.getText()));
			
			e111.setcustomercost(f3);
			int randomNum = 11111 + (int)(Math.random() * 1111111);
			e111.setcustomerinv(randomNum);
			System.out.println("setting invoice");
			e111.setBillstatus("due");
			System.out.println(n);
			e111.setcustomermob(n);
			Billservice e3 = new Billservice();
		
			e3.usageBillservice(e111);
			
			JOptionPane.showMessageDialog(b1, "Submitted succesfully");
			
			}
			else if (f4==400)
			{
				int f1 = e111.setcustomerdur(Integer.parseInt(t1.getText()));
				int f2 = e111.setcustomernet(Integer.parseInt(t2.getText()));
				
				float f5 = f1/2;
				float f6 = f2/4;
				float f3 = f5+f6+f4;
				System.out.println("Done");
				e111.setcustomerno(Integer.parseInt(t3.getText()));
				
				e111.setcustomercost(f3);
				int randomNum = 11111 + (int)(Math.random() * 1111111);
				e111.setcustomerinv(randomNum);
				System.out.println("setting invoice");
				e111.setBillstatus("due");
				e111.setcustomermob(n);
				Billservice e3 = new Billservice();
				e3.usageBillservice(e111);
				JOptionPane.showMessageDialog(b1, "Submitted succesfully");
				
			}
			else if(f4==600)
			{
				
				int f1 = e111.setcustomerdur(Integer.parseInt(t1.getText()));
				int f2 = e111.setcustomernet(Integer.parseInt(t2.getText()));
				
				float f5 = f1/10;
				float f6 = f2/10;
				float f3 = f5+f6+f4;
				System.out.println("Done");
				e111.setcustomerno(Integer.parseInt(t3.getText()));
				e111.setBillstatus("due");
				e111.setcustomercost(f3);
				int randomNum = 11111 + (int)(Math.random() * 1111111);
				e111.setcustomerinv(randomNum);
				System.out.println("setting invoice");
				e111.setcustomermob(n);
				Billservice e3 = new Billservice();
				e3.usageBillservice(e111);
				JOptionPane.showMessageDialog(b1, "Submitted succesfully");
			}
			
			
		}
		
		if(e1.getSource()==b2)
		{
			f.setVisible(false);
			Admingui u = new Admingui();
		}
		
		
		
	}

}