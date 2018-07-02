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
import com.tbs.model.Payvo;
import com.tbs.service.Billservice;
import com.tbs.service.Payservice;

public class Debit implements ActionListener {
JFrame f;
JPanel p;

JLabel l1,l2,l3,l4,l5,l6,l;
JTextField t1,t2,t3,t4,t5,t;
JButton b1,b2;
JPasswordField p1;
long n;
int onclick;

public Debit(long n)
{
	this.onclick=0;
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
	
	l1 = new JLabel("Enter card number");
	l2 = new JLabel("Enter CVV number");
	l3 = new JLabel("Enter Card name");
	l4 = new JLabel("Enter your provided trans password");
	l5 = new JLabel("Enter Discount Voucher");
	l6 = new JLabel("Discounted cost");
	
	l1.setForeground(Color.white);
	l2.setForeground(Color.WHITE);
	l3.setForeground(Color.white);
	l4.setForeground(Color.white);
	b1 = new JButton("Submit");
	b2 = new JButton("Check");
	
	t1 = new JTextField();
	t2 = new JTextField();
	t3 = new JTextField();
	t4 = new JTextField();
	t5 = new JTextField();
	p1 = new JPasswordField();
	l1.setBounds(150,30,200,30);
	l2.setBounds(150,80,200,30);
	l3.setBounds(150,130,200,30);
	l4.setBounds(150,400,200,30);
	l5.setBounds(150,180,200,30);
	l6.setBounds(150,230,200,30);
	
	t1.setBounds(400, 30, 200, 30);
	t2.setBounds(400, 80, 200, 30);
	t3.setBounds(400, 130, 200, 30);
	t4.setBounds(400, 180, 80, 30);
	t5.setBounds(400, 230, 200, 30);
	p1.setBounds(400,400,200,30);
	
	b2.setBounds(500,180,80,30);
	b1.setBounds(300,450,200,30);
	b1.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
	b2.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
	l = new JLabel("Logged in user with phone no");
	l.setBounds(150,600,200,30);

	l.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
	l.setForeground(Color.white);

	l5.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
	l5.setForeground(Color.white);

	l6.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
	l6.setForeground(Color.white);
	t = new JTextField();
	t.setBounds(400, 600, 200, 30);

	t.setText(String.valueOf(n));
	
	p.add(b2);
	p.add(l1);
	p.add(l2);
	p.add(l3);
	p.add(l4);
	p.add(l6);
	p.add(t5);
	p.add(t1);
	p.add(t2);
	p.add(t3);
	p.add(p1);
	p.add(b1);
	p.add(l);
	p.add(t);
	p.add(l5);
	p.add(t4);
	p.add(label);
	p.setLayout(null);
	
	
	b1.addActionListener(this);
	b2.addActionListener(this);
}

@Override
public void actionPerformed(ActionEvent e) {
	
	
	if(e.getSource()==b1)
	{
		Long n = Long.parseLong(t.getText());
		
		Payvo ev = new Payvo();
		Payservice es = new Payservice();
		ev = es.transpassEmpservce(n);
		
		
		
		
	//	System.out.println(ev.getTranspassword());
		
		if(String.valueOf(p1.getPassword()).equals(ev.getTranspassword()))
		{
			Billvo ev1 = new Billvo();
			Billservice es1 = new Billservice();
			ev1.setcustomermob(n);
			ev1.setBillstatus("Paid");
			es1.billstatuspaidBillservice(ev1);
			
			Billvo ev2 = new Billvo();
			Billservice es2 = new Billservice();
			ev2.setcustomermob(n);
			ev2.setCustomercomplain("Nill");
			es2.addcomplainBillservice1(ev2);
			
			
			
			
			System.out.println("Done");
			JOptionPane.showMessageDialog(b1,"Submitted sucessfully");
			f.setVisible(false);
			Usergui u = new Usergui(n);
			
		}
		else
		{
			JOptionPane.showMessageDialog(b1,"Incorrect details");
		}
		
	}
	if(e.getSource()==b2)
	{
		
		
		if(t4.getText().equals("basic100"))
		{
			if(onclick==0)
			{
			JOptionPane.showMessageDialog(b2, "BINGO-Code applied");
			
			Billvo ev = new Billvo();
			Billservice es = new Billservice();
			ev.setcustomermob(n);
			es.updatecostBillservice(ev);

			Billvo ev1 = new Billvo();
			Billservice es1 = new Billservice();
			
			ev1 = es1.sltempcostBillservice(n);
			System.out.println(ev1.getcustomercost());
			t5.setText(String.valueOf(ev1.getcustomercost()));
			onclick++;
			}
			else
			{
				JOptionPane.showMessageDialog(b2, "Code already applied");
				
			}
		}
		
		else if(t4.getText().equals("mega500"))
		{
			if(onclick==0)
			{
			JOptionPane.showMessageDialog(b2, "BINGO-Code applied");
			
			Billvo ev = new Billvo();
			Billservice es = new Billservice();
			ev.setcustomermob(n);
			es.updatecost1Billservice(ev);

			Billvo ev1 = new Billvo();
			Billservice es1 = new Billservice();
			
			ev1 = es1.sltempcostBillservice(n);
			System.out.println(ev1.getcustomercost());
			t5.setText(String.valueOf(ev1.getcustomercost()));
			
			onclick++;
			}
			else
			{
				JOptionPane.showMessageDialog(b2, "Code already applied");
				
			}
		}
		
		else
		{
			JOptionPane.showMessageDialog(b2, "Sorry not a valid code");
		}
	}

}

}
