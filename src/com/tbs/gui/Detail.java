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

import com.tbs.service.Billservice;


public class Detail implements ActionListener {

	
	JFrame f;
	JPanel p;
	JLabel l1,l2,l3,l4,l;
	JButton b1,b2,b3,b;
	JTextField t,t1;
	
	public Detail(long n)
	{
		
		f = new JFrame();
		p = new JPanel();
		
		ImageIcon background = new ImageIcon("E://new2.jpg");
		JLabel label = new JLabel();
		label.setBounds(0, 0, 700, 700);
		label.setIcon(background);
		p.setPreferredSize(new Dimension(700,700));
		
		p.setLayout(new BorderLayout());
		f.getContentPane().add(p);
		f.add(p);
		f.pack();
		f.requestFocus();
		f.setFocusable(true);
		f.setVisible(true);
		
		b1 = new JButton("Credit card");
		b2 = new JButton("Net Banking");
		b3 = new JButton("Debit card");
		b = new JButton("Back");
		
		
		b1.setBounds(200,80,200,30);
		b2.setBounds(200,130,200,30);
		b3.setBounds(200,180,200,30);
		b.setBounds(200,300,200,30);
		
		b1.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
		b2.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
		b3.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
		b.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
		
		l4 = new JLabel("Payment status");
		l4.setBounds(150,30,200,30);
		
		l = new JLabel("Logged in user with phone no");
		l.setBounds(150,600,200,30);

		l.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
		l.setForeground(Color.white);

		l4.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
		l4.setForeground(Color.white);

		
		
		t = new JTextField();
		t.setBounds(400, 600, 200, 30);

		t1 = new JTextField();
		t1.setBounds(400,30,200,30);
		t.setText(String.valueOf(n));
		
		
		p.add(b1);
		p.add(b2);
		p.add(b3);
		p.add(l);
		p.add(t);
		p.add(b);
		p.add(t1);
		p.add(l4);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b.addActionListener(this);

		p.add(label);
		p.setLayout(null);
		
		Billvo ev = new Billvo();
		Billservice es = new Billservice();
		
		ev = es.sltbillstatusBillservice(n);
		t1.setText(ev.getBillstatus());
		
		
		
	}
	
	
	
	
	
	
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource()==b1)
		{
			
			Long n = Long.parseLong(t.getText());
			//f.setVisible(false);
			Credit c = new Credit(n);
			
		}
		else if(e.getSource()==b3)
		{
			Long n = Long.parseLong(t.getText());
			//f.setVisible(false);
			Debit d = new Debit(n);
			
		}
		if(e.getSource()==b2)
		{
			Long n = Long.parseLong(t.getText());
			Netbanking net = new Netbanking(n);
			
		}
		if(e.getSource()==b)
		{
			Long n = Long.parseLong(t.getText());
			Pay p = new Pay(n);
		}
		
	}

	
	
}
