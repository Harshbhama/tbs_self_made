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

public class Admingui implements ActionListener {
JFrame f;
JPanel p;

JButton b1,b2,b3,b4,b5,b6,b7,b8;

public Admingui()
{
f= new JFrame();
p = new JPanel();

ImageIcon background = new ImageIcon("E://new2.jpg");
JLabel label = new JLabel();
label.setBounds(0, 0, 700, 700);
label.setIcon(background);
p.setPreferredSize(new Dimension(700,700));

//p.setPreferredSize(new Dimension(700,700));
p.setLayout(new BorderLayout());

f.add(p);
f.pack();
f.requestFocus();
f.setFocusable(true);
f.setVisible(true);

p.setBackground(Color.LIGHT_GRAY);
f.getContentPane().add(p);

b1 = new JButton("Bill History");
b2 = new JButton("Modify user");
b3 = new JButton("Delete user");
b4 = new JButton("Update user");
b5 = new JButton("Bill generation");
b6 = new JButton("Back");
b7 = new JButton("Customer bill");
b8 = new JButton("Customer complain");

b1.setBounds(150,30,130,30);
b2.setBounds(400,30,110,30);
b3.setBounds(150,150,110,30);
b4.setBounds(400,150,110,30);
b5.setBounds(150,300,110,30);
b7.setBounds(400,300,140,30);
b6.setBounds(250,600,110,30);
b8.setBounds(250,380,160,30);

p.add(b1);
p.add(b2);
p.add(b3);
p.add(b4);
p.add(b5);
p.add(b6);
p.add(b7);
p.add(b8);
b1.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
b2.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
b3.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
b4.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
b4.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
b5.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
b6.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
b7.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
b8.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));

b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);

b4.addActionListener(this);
b5.addActionListener(this);
b6.addActionListener(this);
b7.addActionListener(this);
b8.addActionListener(this);
p.add(label);
p.setLayout(null);

	
}

@Override
public void actionPerformed(ActionEvent e) {
	
	if(e.getSource()==b1)
	{
	//	f.setVisible(false);
		Newbill n1 = new Newbill();
	}
	if(e.getSource()==b2)
	{
		f.setVisible(false);
		Modify m = new Modify();
	}
	if(e.getSource()==b3)
	{
		f.setVisible(false);
	Delete d = new Delete();
	}
	if(e.getSource()==b4)
	{
		f.setVisible(false);
		Usage1 u = new Usage1();
		
	}
	if(e.getSource()==b5)
	{
		Newbill1 n2 = new Newbill1();
		
	}
	if(e.getSource()==b6)
	{
		f.setVisible(false);
		Homegui h = new Homegui();
	}
	if(e.getSource()==b7)
	{
		f.setVisible(false);
		Newbillgui g = new Newbillgui();
	
	}
	if(e.getSource()==b8)
	{
		f.setVisible(false);
		Newcomplain n = new Newcomplain();
	}
}
}
