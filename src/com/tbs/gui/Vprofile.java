package com.tbs.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.tbs.model.Billvo;
import com.tbs.model.Customervo;

import com.tbs.service.Billservice;
import com.tbs.service.Customerservice;


public class Vprofile implements ActionListener {
JFrame f;
JPanel p;
	
	JLabel l1,l2,l3,l4,l5,l6,l7,l9,l10,l11,l12;
	JTextField t1,t2,t3,t4,t5,t6,t7,t9,t10,t11,t12;
	JButton b1;
	long n;
	public Vprofile(long n)
	{
		this.n = n;
		f = new JFrame();
		p = new JPanel();
		
		ImageIcon background = new ImageIcon("E://new2.jpg");
		JLabel label = new JLabel();
		label.setBounds(0, 0, 700, 700);
		label.setIcon(background);
		p.setPreferredSize(new Dimension(700,700));
		
		p.setLayout(new BorderLayout());
	
		
		f.add(p);
		f.pack();
		f.setVisible(true);
		f.setFocusable(true);
		f.requestFocus();
		
		l1 = new JLabel("customerloyee name");
		l2 = new JLabel("customerloyee address");
		l3 = new JLabel("customerloyee phonenumber");
		l4 = new JLabel("customerloyee Country");
		l5 = new JLabel("customerloyee State");
		l6 = new JLabel("customerloyee name");
		l7 = new JLabel("customerloyee number");
	//	l8 = new JLabel("Plan code");
		l9 = new JLabel("Plan name");
		l10 = new JLabel("Cost per min");
		l11 = new JLabel("Cost per mb");
		
		t1 = new JTextField();
		t2 = new JTextField();
		t3 = new JTextField();
		t4 = new JTextField();
		t5 = new JTextField();
		t6 = new JTextField();
		t7 = new JTextField();
	//	t8 = new JTextField();
		t9 = new JTextField();
		t10 = new JTextField();
		t11 = new JTextField();
		
		b1 = new JButton("Back");
		b1.setBounds(250,500,110,30);
		b1.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
		
		l1.setBounds(150,30,200,30);
		l2.setBounds(150,80,200,30);
		l3.setBounds(150,130,200,30);
		l4.setBounds(150,180,200,30);
		l5.setBounds(150,230,200,30);
		l6.setBounds(150,280,200,30);
		l7.setBounds(150,330,200,30);
		l9.setBounds(150,380,200,30);
		l10.setBounds(150,430,200,30);
		l11.setBounds(150,480,200,30);
		
		l1.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
		l2.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
		l3.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
		l4.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
		l5.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
		l6.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
		l7.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
		l9.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
		l10.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
		l11.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));

		
		l1.setForeground(Color.WHITE);
		l2.setForeground(Color.WHITE);
		l3.setForeground(Color.WHITE);
		l4.setForeground(Color.WHITE);
		l5.setForeground(Color.WHITE);
		l6.setForeground(Color.WHITE);
		l7.setForeground(Color.WHITE);
		l9.setForeground(Color.WHITE);
		l10.setForeground(Color.WHITE);
		l11.setForeground(Color.WHITE);
		
		l12 = new JLabel("Payment status");
		l12.setBounds(150,600,200,30);
		
		
		l12.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
		l12.setForeground(Color.white);
		t12 = new JTextField();
		t12.setBounds(400,600,200,30);
		
		
		

		t1.setBounds(400,30,200,30);
		t2.setBounds(400,80,200,30);
		t3.setBounds(400,130,200,30);
		t4.setBounds(400,180,200,30);
		t5.setBounds(400,230,200,30);
		t6.setBounds(400,280,200,30);
		t7.setBounds(400,330,200,30);
		t9.setBounds(400,380,200,30);
		t10.setBounds(400,430,200,30);
		t11.setBounds(400,480,200,30);
		
		p.add(l1);
		p.add(l2);
		p.add(l3);
		p.add(l4);
		p.add(l5);
		p.add(l6);
		p.add(l7);
	//	p.add(l8);
		p.add(l9);
		p.add(l10);
		p.add(l11);
		p.add(t1);
		p.add(t2);
		p.add(t3);
		p.add(t4);
		p.add(t5);
		p.add(t6);
		p.add(t7);
		//p.add(t8);
		p.add(t9);
		p.add(t10);
		p.add(t11);
		p.add(b1);
		p.add(l12);
		p.add(t12);
		b1.addActionListener(this);
		
		p.add(label);
		p.setLayout(null);
		
		
		Customervo ev = new Customervo();
		Customerservice es = new Customerservice();
		
		ev = es.userprofileCustomerservice(n);
		t1.setText(String.valueOf(ev.getcustomername()));
		t2.setText(String.valueOf(ev.getcustomeradd()));
		t3.setText(String.valueOf(ev.getcustomermob()));
		t4.setText(ev.getCountry());
		t5.setText(ev.getState());
		t6.setText(ev.getcustomername());
		t7.setText(String.valueOf(ev.getcustomerno()));
	//	t8.setText(String.valueOf(ev.getPlancode()));
		t9.setText(ev.getPlanname());
		t10.setText(String.valueOf(ev.getCostmb()));
		t11.setText(String.valueOf(ev.getCostmin()));
		
		
		
		Billvo ev1= new Billvo();
	 Billservice es1 = new Billservice();
		
		ev1 = es1.sltbillstatusBillservice(n);
		t12.setText(ev1.getBillstatus());
		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource()==b1)
		{
			f.setVisible(false);
			Usergui u = new Usergui(n);
		}
		
	}
	
}
