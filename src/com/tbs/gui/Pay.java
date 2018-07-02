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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.tbs.model.Billvo;
import com.tbs.model.Customervo;
import com.tbs.model.Payvo;
import com.tbs.service.Billservice;
import com.tbs.service.Payservice;

public class Pay implements ActionListener {

	JFrame f;
	JPanel p;
	JLabel l1,l2,l;
	JTextField t2,t;
	JButton b1,b2,b3;
	long n;
	public Pay(long n)
	{
		this.n=n;
		f = new JFrame();
		p = new JPanel();

		ImageIcon background = new ImageIcon("E://new2.jpg");
		JLabel label = new JLabel();
		label.setBounds(0, 0, 700, 700);
		label.setIcon(background);
		p.setPreferredSize(new Dimension(700,700));
		p.setLayout(new BorderLayout());

		
		
		
		
	//	p.setBackground(Color.LIGHT_GRAY);
		
		
		f.add(p);
		f.pack();
		f.requestFocus();
		f.setFocusable(true);
		f.setVisible(true);
		f.getContentPane().add(p);
		
		 l1 = new JLabel("Check amount to be paid");
	//	 t1 = new JTextField();
		 
		 l2 = new JLabel("Amount payable");
		 t2 = new JTextField();
		 
		 b1 = new JButton("Submit");
		 b2 = new JButton("PAY");
		 b3 = new JButton("Back");
			l1.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
			l2.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
			l1.setBounds(150,30,200,30);
			l2.setBounds(150,300,200,30);
			
			l1.setForeground(Color.white);
			l2.setForeground(Color.white);
		//	t1.setBounds(300,30,200,30);
			t2.setBounds(400,300,50,30);
			
			b1.setBounds(400,30,100,30);
			b2.setBounds(500,300,100,60);
			b3.setBounds(250,500,110,30);
			b1.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
			b2.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
			b3.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
			
			l = new JLabel("Loged in user with phone no");
			l.setBounds(150,600,200,30);

			l.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
			l.setForeground(Color.white);

			t = new JTextField();
			t.setBounds(400, 600, 200, 30);

			t.setText(String.valueOf(n));
			
			p.add(l1);
			p.add(l2);
		//	p.add(t1);
			p.add(t2);
			p.add(b1);
			p.add(b2);
			p.add(l);
			p.add(t);
			p.add(b3);
			b1.addActionListener(this);
			b2.addActionListener(this);
			b3.addActionListener(this);
			
			p.add(label);
			p.setLayout(null);

		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==b1)
		{
			
			/*List<customervo> l=new ArrayList<customervo>();
			l=es.viewcustomerservice();
			
			for(customervo ev:l){
				if(ev.getcustomerno()==Integer.parseInt(t1.getText())){
					//t2.setText(String.valueOf(ev.getcustomercost()));
					System.out.println(ev.getcustomercost());
				}
			}*/
			
		Billvo ev = new  Billvo();
		Billservice es = new Billservice();
		 ev = es.paycostBillservice(Long.parseLong(t.getText()));
		// System.out.println(ev.getcustomercost());
		 t2.setText(String.valueOf(ev.getcustomercost()));
		 
		 
		 
		
		
		}
		if(e.getSource()==b2)
		{
			Billvo ev= new Billvo();
			Billservice es = new Billservice();
			ev = es.sltbillstatusBillservice(n);
			if(ev.getBillstatus().equals("due"))
					{
		
				long n = Long.parseLong(t.getText());
				f.setVisible(false);
				Detail d = new Detail(n);				
				
					}
			else
			{
				JOptionPane.showMessageDialog(b2, "Payment already done");
			}
			
			
		
		}
		if(e.getSource()==b3)
		{
			f.setVisible(false);
			Usergui u = new Usergui(n);
			
		}
	}
	
}
