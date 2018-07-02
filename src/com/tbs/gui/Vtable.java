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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.tbs.model.Billvo;
import com.tbs.model.Customervo;
import com.tbs.service.Billservice;


public class Vtable implements ActionListener {
	JFrame f;
	JPanel p;
	
	JLabel l1,l2,l3,l4,l5;
	JTextField t1,t2,t3,t4,t5;
	JButton b1;
	long n;

	public Vtable(long n){
		
		this.n=n;
		JFrame f=new JFrame();
		JPanel p=new JPanel();

ImageIcon background = new ImageIcon("E://new2.jpg");
JLabel label = new JLabel();
label.setBounds(0, 0, 700, 700);
label.setIcon(background);
		
		f.getContentPane().add(p);
		p.setPreferredSize(new Dimension(700,700));
		p.setLayout(new BorderLayout());
		
		f.add(p);
		f.pack();
		f.requestFocus();
		f.setFocusable(true);
		f.setVisible(true);
		
		
		
	//	p.setBackground(Color.LIGHT_GRAY);
		
		l1 = new JLabel("customer duration");
		l2 = new JLabel("customer net usage");
		l3 = new JLabel("customer cost");
		l4 = new JLabel("customer invoice");
		
		t1 = new JTextField();
		t2 = new JTextField();
		t3 = new JTextField();
		t4 = new JTextField();
		
		l1.setBounds(150,30,200,30);
		l2.setBounds(150,80,200,30);
		l3.setBounds(150,130,200,30);
		l4.setBounds(150,180,200,30);
		
		t1.setBounds(400, 30, 200, 30);
		t2.setBounds(400, 80, 200, 30);
		t3.setBounds(400, 130, 200, 30);
		t4.setBounds(400,180,200,30);
		
		l1.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
		l2.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
		l3.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
		l4.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
		
		l1.setForeground(Color.white);
		l2.setForeground(Color.white);
		l3.setForeground(Color.white);
		l4.setForeground(Color.white);
		
		l5 = new JLabel("Payment status");
		l5.setBounds(150,600,200,30);
		
		l5.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
		l5.setForeground(Color.white);
		t5 = new JTextField();
		t5.setBounds(400,600,200,30);
		
		b1 = new JButton("BACK");
		
		b1.setBounds(250,500,110,30);
		
		b1.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
		p.add(l1);
		p.add(l2);
		p.add(l3);
		p.add(l4);
		
		p.add(t1);
		p.add(t2);
		p.add(t3);
		p.add(t4);
		p.add(b1);
		
		p.add(l5);
		p.add(t5);
		
		p.add(label);
		p.setLayout(null);
		
		
	
		Billservice es = new Billservice();
		Billvo ev = new Billvo();
		ev = es.vdetailBillservice(n);
		System.out.println(ev.getcustomerdur() + " "+ev.getcustomernet());
		t1.setText(String.valueOf((ev.getcustomerdur())));
		t2.setText(String.valueOf((ev.getcustomernet())));
		t3.setText(String.valueOf((ev.getcustomercost())));
		t4.setText(String.valueOf(ev.getcustomerinv()));
		b1.addActionListener(this);
	
		
		Billvo ev1 = new Billvo();
		Billservice es1 = new Billservice();
		
		ev1 = es1.sltbillstatusBillservice(n);
		t5.setText(ev1.getBillstatus());
		
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource()==b1)
		{
			
			//f.setVisible(false);
			Usergui u = new Usergui(n);
			
			
		}
		
	}
	
}

