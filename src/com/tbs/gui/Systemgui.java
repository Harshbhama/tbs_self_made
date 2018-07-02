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

public class Systemgui implements ActionListener {
JFrame f;
JPanel p;

JButton b1,b2,b3,b4;

public Systemgui()
{
f= new JFrame();
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

b1 = new JButton("New connection");


b1.setBounds(300,30,150,30);

b1.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));


p.add(b1);





b1.addActionListener(this);
p.add(label);
p.setLayout(null);
	
}

@Override
public void actionPerformed(ActionEvent e) 
{
	f.setVisible(false);
Newconn n = new Newconn();	
	
	
}
}
