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
import javax.swing.JTextField;

import com.tbs.model.Billvo;
import com.tbs.service.Billservice;

public class Newcomplain implements ActionListener {

	JFrame f;
	JPanel p;
	
	JLabel l;
	JTextField t;
	JButton b,b1;
	public Newcomplain()
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
		
		l = new JLabel("Enter the respective Customer ID");
		t = new JTextField();
		
		l.setBounds(150,30,200,30);
		
		l.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
		l.setForeground(Color.WHITE);
		
		t.setBounds(400,30,200,30);
		
		//int n = Integer.parseInt(t.getText());
		
		b = new JButton("Submit");
		b1 = new JButton("Back");
		b.setBounds(300,80,110,30);
		b1.setBounds(300,130,110,30);
		b.addActionListener(this);
		b1.addActionListener(this);
		b.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
		b1.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
		
		p.add(l);
		p.add(t);
		p.add(b);
		p.add(b1);
		p.add(label);
		p.setLayout(null);
		
		
		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource()==b)
		{
			int n1 =Integer.parseInt(t.getText());
			Billvo ev = new Billvo();
			Billservice es = new Billservice();
			ev.setcustomerno(n1);
			ev.setCustomercomplain("Done");
			es.addcomplainBillservice(ev);
			JOptionPane.showMessageDialog(b, "Complain sent to the respective user");
		}
		if(e.getSource()==b1)
		{
			f.setVisible(false);
			Admingui g = new Admingui();
			
		}
		
	}
	
	
}
