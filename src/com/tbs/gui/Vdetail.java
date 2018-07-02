package com.tbs.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class Vdetail implements ActionListener {

	JFrame f;
	JPanel p;
	
	JLabel l1;
	JTextField t1;
	JButton b1;
	
	public Vdetail()
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
		
		l1 = new JLabel("Enter Empno for the Detail");
		l1.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
		
		
		t1 = new JTextField();
		
		l1.setBounds(150,30,200,30);
		l1.setForeground(Color.white);
		t1.setBounds(400, 30, 200, 30);
		
		b1 = new JButton("Submit");
		b1.setBounds(300,80,90,30);
		b1.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
		
		p.add(l1);
		p.add(t1);
		p.add(b1);
		p.add(label);
		p.setLayout(null);

		b1.addActionListener(this);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==b1)
		{
		//Empservice es = new Empservice();
		//Empvo ev = new Empvo();
		//int n =Integer.parseInt(t1.getText());
		//ev = es.vdetailEmpservice(n);
		
		//List<Empvo> l = new ArrayList<Empvo>();
		
		//Vtable v = new Vtable(n);
		
			
		}
		
		
	}
	
}
