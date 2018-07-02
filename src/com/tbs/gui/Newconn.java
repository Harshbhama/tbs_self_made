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

import com.tbs.model.Payvo;
import com.tbs.model.Vouchervo;
import com.tbs.service.Billservice;
import com.tbs.service.Customerservice;
import com.tbs.service.Payservice;
import com.tbs.service.Voucherservice;

public class Newconn implements ActionListener {

	
	
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
	
	JTextField t1,t2,t3,t4,t5,t6,t7;
	JPasswordField p1,p2;
	
	JButton b1,b2,b3;
	JFrame f;
	JPanel p;
	
	public Newconn()
	{
		
		
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
		f.requestFocus();
		f.setFocusable(true);
		f.setVisible(true);
		
		p.setBackground(Color.LIGHT_GRAY);
		f.getContentPane().add(p);
		f.setTitle("New Connection");

			
			
			l1 = new JLabel("Name");
			l2 = new JLabel("Address");
			l3 = new JLabel("Phone no");
			l4 = new JLabel("Country");
			l5 = new JLabel("State");
			l6 = new JLabel("customer no");
			l7 = new JLabel("Enter respective plan code");
			l8 = new JLabel("Enter the password");
			l9 = new JLabel("Confirm password");
			
			l1.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
			l2.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
			l3.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
			l4.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
			l5.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
			l6.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
			l7.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
			l8.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
			l9.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
		
			b1 = new JButton("SUBMIT");
			b2 = new JButton("Check plans");
			b3 = new JButton("Home");
			
			b1.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
			b2.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
			b3.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
			
			l1.setForeground(Color.WHITE);
			l2.setForeground(Color.WHITE);
			l3.setForeground(Color.WHITE);
			l4.setForeground(Color.WHITE);
			l5.setForeground(Color.WHITE);
			l6.setForeground(Color.WHITE);
			l7.setForeground(Color.WHITE);
			l8.setForeground(Color.WHITE);
			l9.setForeground(Color.WHITE);
			
			
			t1 = new JTextField();
			t2= new JTextField();
			t3 = new JTextField();
			t4 = new JTextField();
			t5 = new JTextField();
			t6 = new JTextField();
			t7 = new JTextField();
			
			p1 = new JPasswordField();
			p2 = new JPasswordField();
			
			l1.setBounds(150,30,200,30);
			l2.setBounds(150,80,200,30);
			l3.setBounds(150,130,200,30);
			l4.setBounds(150,180,200,30);
			l5.setBounds(150,230,200,30);
			l6.setBounds(150,280,200,30);
			l7.setBounds(150,330,200,30);
			l8.setBounds(150,380,200,30);
			l9.setBounds(150,430,200,30);
			
			
			t1.setBounds(400,30,200,30);
			t2.setBounds(400,80,200,30);
			t3.setBounds(400,130,200,30);
			t4.setBounds(400,180,200,30);
			t5.setBounds(400,230,200,30);
			t6.setBounds(400,280,200,30);
			t7.setBounds(400,330,200,30);
			
			
			p1.setBounds(400, 380, 200, 30);
			p2.setBounds(400, 430,200, 30);
			
			b1.setBounds(400,650,90,30);
			b2.setBounds(350,500,200,30);
			b3.setBounds(250,650,110,30);
			p.add(l1);
			p.add(l2);
			p.add(l3);
			p.add(l4);
			p.add(l5);
			p.add(l6);
			p.add(l7);
			
			p.add(l8);
			p.add(l9);
			
			p.add(t1);
			p.add(t2);
			p.add(t3);
			p.add(t4);
			p.add(t5);
			p.add(t6);
			p.add(t7);
			p.add(p1);
			p.add(p2);
			
			p.add(b1);
			p.add(b2);
			p.add(b3);
			
			b1.addActionListener(this);
			b2.addActionListener(this);
			b3.addActionListener(this);
			
			p.add(label);
			p.setLayout(null);
			
			Billvo ev = new Billvo();
			Billservice es1 = new Billservice();
			
			ev = es1.updateempBillservice();
			int n=ev.getcustomerno();
			if(n==0)
			{
				t6.setText(String.valueOf(1));
			}
			t6.setText(String.valueOf((++n)));
			//System.out.println(ev.getcustomerno());
			
}
		
	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1)
		{
			
		Customervo e1 = new Customervo();
		Payvo e2= new Payvo();
		e1.setcustomername(t1.getText());
		e1.setcustomeradd(t2.getText());
		e1.setcustomermob(Long.parseLong(t3.getText()));
		e1.setCountry(t4.getText());
		e1.setState(t5.getText());
		e1.setcustomerno(Integer.parseInt(t6.getText()));
		e1.setPlancode(Integer.parseInt(t7.getText()));
		e1.setcustomerpassword(String.valueOf(p1.getPassword()));
		e2.setcustomerno(Integer.parseInt(t6.getText()));
		e2.setcustomermob(Long.parseLong(t3.getText()));
		if(String.valueOf(p1.getPassword()).equals(String.valueOf(p2.getPassword())))
		{
		Customerservice es =  new Customerservice();
		es.addCustomerservice(e1);
		System.out.println("DONE");
		
		Payservice es1 = new Payservice();
		int randomNum = 11111 + (int)(Math.random() * 1111111);
		e2.setTranspassword(String.valueOf(randomNum));
		es1.paydetail(e2);
		
		Voucherservice es2 = new Voucherservice();
		Vouchervo e3 = new Vouchervo();
		e3.setcustomermob(Long.parseLong(t3.getText()));
		e3.setVouchercode("basic100");
		
		es2.voucherempEmperservice(e3);
		
		Voucherservice es3 = new Voucherservice();
		Vouchervo e4 = new Vouchervo();
		e4.setcustomermob(Long.parseLong(t3.getText()));
		e4.setVouchercode("mega500");
		
		es3.voucherempEmperservice(e4);
		
	
		JOptionPane.showMessageDialog(b1,"Transanction pass sent to your mobile");
		}
		else{
			JOptionPane.showMessageDialog(b1, "Password doesnot match");
		}
		
		
		
	}
		if(e.getSource()==b2)
		{
			Newplan n = new Newplan();
			
		}
		if(e.getSource()==b3)
		{
			f.setVisible(false);
			Homegui h = new Homegui();
		}

	
	
}
	
	public static void main(String[] args)
	{
		
		new Newconn();
	}
	
}
