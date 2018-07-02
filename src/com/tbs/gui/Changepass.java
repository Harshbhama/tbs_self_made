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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.tbs.model.Customervo;
import com.tbs.service.Customerservice;

public class Changepass implements ActionListener {

	JFrame f;
	JPanel p;
	JLabel l1,l2,l;
	JPasswordField p1,p2;
	JButton b1,b2;
	JTextField t;
	long n;
	public Changepass(Long n)
	{
		this.n = n;
	
		f = new JFrame();
		p = new JPanel();
		
		
		ImageIcon background = new ImageIcon("E://new2.jpg");
		JLabel label = new JLabel();
		label.setBounds(0, 0, 700, 700);
		label.setIcon(background);
		p.setPreferredSize(new Dimension(700,700));
		
		
		p.setPreferredSize(new Dimension(700,700));
		p.setLayout(new BorderLayout());
		f.add(p);
		f.pack();
		f.requestFocus();
		f.setFocusable(true);
		f.setVisible(true);
		
		p.setBackground(Color.LIGHT_GRAY);
		f.getContentPane().add(p);
		
		l1 = new JLabel("Enter your old password");
		l2 = new JLabel("Enter the new password");
		
		l1.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
		l1.setForeground(Color.white);
		
		l2.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
		l2.setForeground(Color.white);
		p1 = new JPasswordField();
		p2 = new JPasswordField();
		b2 = new JButton("Back");
		b1 = new JButton("Submit");
		
		l1.setBounds(150,30,200,30);
		l2.setBounds(150,80,200,30);
		
		b1.setBounds(250,130,110,30);
		b2.setBounds(250,500,110,30);
		
		p1.setBounds(400,30,200,30);
		p2.setBounds(400,80,200,30);
		
		l = new JLabel("Loged in user with phone no");
		l.setBounds(150,600,200,30);

		l.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
		l.setForeground(Color.white);

		t = new JTextField();
		t.setBounds(400, 600, 200, 30);

		t.setText(String.valueOf(n));
		b1.addActionListener(this);
		b2.addActionListener(this);
		b1.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
		b2.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
		p.add(l1);
		p.add(l2);
		p.add(t);
		p.add(l);
		p.add(p1);
		p.add(p2);
		p.add(b1);
		p.add(b2);
		p.add(label);
		p.setLayout(null);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==b1)
		{
			Long n = Long.parseLong(t.getText());
			Customervo ev = new Customervo();
			Customerservice es = new Customerservice();
			
			ev = es.changepassCustomerservice(n);
			System.out.println(ev.getcustomerpassword());
			if(String.valueOf(p1.getPassword()).equals(ev.getcustomerpassword()))
			{ 
				Long n1 = Long.parseLong(t.getText());
				Customervo ev1 = new Customervo();
			//	System.out.println("hello");
				
				Long n2 = Long.parseLong(String.valueOf((p2.getPassword())));
				System.out.println(n2);
				ev1.setcustomermob(n1);
				ev1.setcustomerpassword(String.valueOf(n2));
				
				Customerservice es1 = new Customerservice();
				es1.changeemppassCustomerservice(ev1);
				System.out.println("done");
				JOptionPane.showMessageDialog(b1, "Password changed sucessfully");
			}
			
		}
		if(e.getSource()==b2)
		{
		f.setVisible(false);
			Usergui u = new Usergui(n);
		}
		
	}
	

}