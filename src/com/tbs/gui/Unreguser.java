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




public class Unreguser implements ActionListener {

	JFrame f;
	JPanel p;
	
	JLabel l1,l2;
	JTextField t1;
	JPasswordField p1;
	JButton b1,b2;
	
	
	public Unreguser()
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
		
	
		b1 = new JButton("Check Plans");
		b2 = new JButton("Home");
		b1.setBounds(200, 130, 130, 30);
		b2.setBounds(200,180,130,30);
		b1.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
		

		
		b1.addActionListener(this);
		b2.addActionListener(this);
	
		p.add(b1);
		p.add(b2);
		p.setLayout(null);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		p.add(label);
		p.setLayout(null);
		
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==b1)
		{
			f.setVisible(false);
			Newplan n = new Newplan();
		}
		if(e.getSource()==b2)
		{
			f.setVisible(false);
			Homegui h = new Homegui();
		}
	
	}
		
}

