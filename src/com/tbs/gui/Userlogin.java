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

import com.tbs.model.Billvo;
import com.tbs.model.Customervo;
import com.tbs.service.Billservice;
import com.tbs.service.Customerservice;


public class Userlogin implements ActionListener {

	JFrame f;
	JPanel p;
	
	JLabel l1,l2;
	JTextField t1;
	JPasswordField p1;
	JButton b1;
	
	
	public Userlogin()
	{
		
		f = new JFrame();
		p = new JPanel();
	
		
		ImageIcon background = new ImageIcon("E://new2.jpg");
		JLabel label = new JLabel();
		label.setBounds(0, 0, 700, 700);
		label.setIcon(background);
		p.setPreferredSize(new Dimension(700,700));
		
		f.add(p);
		f.pack();
		f.requestFocus();
		f.setFocusable(true);
		f.setVisible(true);
		
		p.setBackground(Color.LIGHT_GRAY);
		f.getContentPane().add(p);
		

		l1 = new JLabel("Enter phone number");
		l2 = new JLabel("Enter password");
		
		l1.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
		l2.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
		
		l1.setForeground(Color.WHITE);
		l2.setForeground(Color.WHITE);
		
		t1 = new JTextField();
		
		p1 = new JPasswordField();
		
		b1 = new JButton("submit");
		
		l1.setBounds(150,30,200,30);
		l2.setBounds(150,80,200,30);
		
		b1.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
		
		t1.setBounds(400,30, 200, 30);
		p1.setBounds(400,80,200,30);
		p1.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
		
		
		
		b1.setBounds(200, 130, 90, 60);
		b1.addActionListener(this);
		
		p.add(l1);
		p.add(l2);
		p.add(t1);
		p.add(p1);
		p.add(b1);
		p.add(label);
		p.setLayout(null);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==b1)
		
		{

			Customervo ev = new Customervo();
			Customerservice es = new Customerservice();
			
			ev = es.uservalCustomerservice(Long.parseLong(t1.getText()));

			if(String.valueOf(p1.getPassword()).equals(ev.getcustomerpassword()))
					{
				
			//	JOptionPane.showMessageDialog(b1,"done");
				
				Billvo ev1 = new Billvo();
				Billservice es1 = new Billservice();
				ev1 = es1.usagecomplainBillservice(Long.parseLong(t1.getText()));
				System.out.println(ev1.getCustomercomplain());
				if(ev1.getCustomercomplain().equals("Done"))
				{
					JOptionPane.showMessageDialog(b1, "WARNING----Payment complain from admin received--Kindly pay for continuation");
				}
				
				long n =Long.parseLong(t1.getText());
				Usergui u = new Usergui(n);
				f.setVisible(false);
				
					}
			else 
			{
				JOptionPane.showMessageDialog(b1, "Invalid details");
				
			}
		
	}
		
}
}
