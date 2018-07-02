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
import javax.swing.RootPaneContainer;

public class Homegui implements ActionListener{

	
	JFrame f;
	JPanel p;
	JButton b1,b2,b3,b4;
	JLabel background;
	
	public Homegui()
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
		
		f.setTitle("ONLINE TBS");
		
	//	p.setBackground(Color.LIGHT_GRAY);
		f.getContentPane().add(p);
		
		
		b1 = new JButton("User login");
		b2 = new JButton("Admin login");
		b3 = new JButton("System login");
		b4 = new JButton("Unregistered user");
		b1.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
		b2.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
		b3.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
		b4.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
		b1.setBounds(100,30,120,30);
		b2.setBounds(500,30,120,30);
		b3.setBounds(100,200,120,30);
		b4.setBounds(500,200,120,30);
		
		p.add(b1);
		p.add(b2);
		p.add(b3);
		p.add(b4);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		
		p.setLayout(null);
		p.add(label);
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	if(e.getSource()==b1)
	{
	f.setVisible(false);
		Userlogin u =new Userlogin();
	}
	if(e.getSource()==b2)
	{
		f.setVisible(false);
		Adminlogin l = new Adminlogin();
	}
	if(e.getSource()==b3)
	{
		f.setVisible(false);
		Systemlogin l = new Systemlogin();
		
	}
	if(e.getSource()==b4)
	{
		//f.setVisible(false);
		Unreguser k = new Unreguser();
	}
	
		
	}

	public static void main(String[] args)
	{
		Homegui h = new Homegui();
		
	}
	
	}

