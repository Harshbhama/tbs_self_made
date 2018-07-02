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

public class Usergui implements ActionListener {
JFrame f;
JPanel p;
//long n;
JButton b1,b2,b3,b4,b5,b6;
JLabel l;
JTextField t;
public Usergui(long n)
{
	//this.n=n;
f= new JFrame();
p = new JPanel();

ImageIcon background = new ImageIcon("E://new2.jpg");
JLabel label = new JLabel();
label.setBounds(0, 0, 700, 700);
label.setIcon(background);
//p.setPreferredSize(new Dimension(700,700));
p.setPreferredSize(new Dimension(700,700));
p.setLayout(new BorderLayout());

f.add(p);
f.pack();
f.requestFocus();
f.setFocusable(true);
f.setVisible(true);

p.setBackground(Color.LIGHT_GRAY);
f.getContentPane().add(p);

b1 = new JButton("View bill");
b2 = new JButton("View Details");
b3 = new JButton("Pay");
b4 = new JButton("Change password");
b5 = new JButton("Plans");
b6 = new JButton("Home");

b1.setBounds(150,30,110,30);
b2.setBounds(400,30,110,30);
b3.setBounds(150,150,110,30);
b4.setBounds(400,150,110,30);
b5.setBounds(250,400,110,30);
b6.setBounds(250,500,110,30);

b1.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
b2.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
b3.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
b4.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
b5.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
b6.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));

l = new JLabel("Loged in user with phone no");
l.setBounds(150,600,200,30);

l.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
l.setForeground(Color.white);

t = new JTextField();
t.setBounds(400, 600, 200, 30);

t.setText(String.valueOf(n));

p.add(b1);
p.add(b2);
p.add(b3);
p.add(l);
p.add(t);
p.add(b4);
p.add(b5);
p.add(b6);
p.setLayout(null);
p.add(label);
b1.addActionListener(this);
b3.addActionListener(this);
b2.addActionListener(this);
b4.addActionListener(this);
b5.addActionListener(this);
b6.addActionListener(this);	

}

@Override
public void actionPerformed(ActionEvent e) {
	
	if(e.getSource()==b1)
	{
		
		//Vdetail v = new Vdetail();
		long n =Long.parseLong(t.getText());
		f.setVisible(false);
		System.out.println(n);
		Vtable v = new Vtable(n);
		
	}
	if(e.getSource()==b3)
	{
		long n =Long.parseLong(t.getText());
		f.setVisible(false);
		Pay p = new Pay(n);
	}
	if(e.getSource()==b2)
	{
		long n = Long.parseLong(t.getText());
		f.setVisible(false);
		Vprofile v = new Vprofile(n);
	}
	
	if(e.getSource()==b4)
	{
		long n = Long.parseLong(t.getText());
		f.setVisible(false);
		Changepass p = new Changepass(n);
	}
	if(e.getSource()==b5)
	{
		Newplan n = new Newplan();
	
	}
	if(e.getSource()==b6)
	{
		f.setVisible(false);
		Homegui h = new Homegui();
	}
}
}
