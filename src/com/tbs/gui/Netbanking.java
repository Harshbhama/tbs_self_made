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
import com.tbs.service.Billservice;
import com.tbs.service.Payservice;

public class Netbanking implements ActionListener {
JFrame f;
JPanel p;

JLabel l1,l2,l3,l4,l;
JTextField t1,t2,t3,t4,t;
JButton b1;
JPasswordField p1,p2;

public Netbanking(long n)
{
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
	
	l1 = new JLabel("Enter email address");
	l2 = new JLabel("Enter your password");
//	l3 = new JLabel("Enter Card name");
	l4 = new JLabel("Enter your provided trans password");
	
	l1.setForeground(Color.white);
	l2.setForeground(Color.WHITE);
	//l3.setForeground(Color.white);
	l4.setForeground(Color.white);
	b1 = new JButton("Submit");
	
	t1 = new JTextField();
	//t2 = new JTextField();
	//t3 = new JTextField();
	p2 = new JPasswordField();
	p1 = new JPasswordField();
	l1.setBounds(150,30,200,30);
	l2.setBounds(150,80,200,30);
	//l3.setBounds(150,130,200,30);
	l4.setBounds(150,130,200,30);
	
	l1.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
	l2.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
	l4.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
	
	t1.setBounds(400, 30, 200, 30);
	//t2.setBounds(400, 80, 200, 30);
	//t3.setBounds(400, 130, 200, 30);
	p1.setBounds(400,130,200,30);
	p2.setBounds(400,80,200,30);
	b1.setBounds(300,230,200,30);
	
	l = new JLabel("Loged in user with phone no");
	l.setBounds(150,600,200,30);

	l.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
	l.setForeground(Color.white);

	t = new JTextField();
	t.setBounds(400, 600, 200, 30);

	t.setText(String.valueOf(n));
	
	
	p.add(l1);
	p.add(l2);
//	p.add(l3);
	p.add(l4);
	
	p.add(t1);
	p.add(p2);
//	p.add(t3);
	p.add(p1);
	p.add(b1);
	p.add(l);
	p.add(t);
	p.add(label);
	p.setLayout(null);
	
	
	b1.addActionListener(this);
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
			
			
			System.out.println("Done");
			JOptionPane.showMessageDialog(b1,"Submitted sucessfully");
		}
		else
		{
			JOptionPane.showMessageDialog(b1,"Incorrect details");
		}
		
	}

}

}
