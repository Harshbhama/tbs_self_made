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
import com.tbs.model.Payvo;
import com.tbs.service.Billservice;
import com.tbs.service.Customerservice;
import com.tbs.service.Payservice;

public class Delete implements ActionListener{

	JFrame f;
	JPanel p;
	
	JLabel l1;
	JTextField t1;
	JButton b1,b2;
	
	public Delete()
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
		
		
		f.getContentPane().add(p);
		
		l1 = new JLabel("Enter the customerloyee number");
		t1 = new JTextField();
		
		b1 = new JButton("Submit");
		b2 = new JButton("Back");
		l1.setBounds(150,30,200,30);
		t1.setBounds(400,30,200,30);
		
		l1.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
		l1.setForeground(Color.white);
		
		b1.setBounds(200,80,90,30);
		b2.setBounds(250,500,110,30);
		b1.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
		b2.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		p.add(l1);
		p.add(t1);
		p.add(b1);
		p.add(b2);
		
		p.add(label);
		p.setLayout(null);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==b1)
		{
			Customervo ev = new Customervo();
			Billvo ev1 = new Billvo();
			Customerservice es = new Customerservice();
			Billservice es1 = new Billservice();
			Payvo ev2 = new Payvo();
			Payservice es2 = new Payservice();
			
			ev.setcustomerno(Integer.parseInt(t1.getText()));
			es.deleteempCustomerservice(ev);
			
			ev1.setcustomerno(Integer.parseInt(t1.getText()));
			es1.deleteemp1Billservice(ev1);
			
			ev2.setcustomerno(Integer.parseInt(t1.getText()));
			es2.deletepayEmpservice(ev2);
			
		}
		if(e.getSource()==b2)
		{
			f.setVisible(false);
			Admingui u = new Admingui();
		}
		
	}
	

}
