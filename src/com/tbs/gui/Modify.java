package com.tbs.gui;

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

import com.tbs.model.Customervo;
import com.tbs.service.Customerservice;

public class Modify implements ActionListener{

	JFrame f;
	public static JLabel l1,l2,l3,l4,l5,l6,l7;
	public static JTextField t1,t2,t3,t4,t5,t6;
	public JButton b1,b2,b3,b4,b5,b6,b7,b8;
	Customerservice ts;
	static int x;
	public static Customervo tv;
	public JPanel p;
	public Modify(){
		
			f=new JFrame("Modify Record");
			p=new JPanel();
			
			ImageIcon background = new ImageIcon("E://new2.jpg");
			JLabel label = new JLabel();
			label.setBounds(0, 0, 700, 700);
			label.setIcon(background);
			
			p.setPreferredSize(new Dimension(700,700));
		//	p.setBackground(Color.LIGHT_GRAY);

			f.add(p);
			f.pack();
			f.setFocusable(true);
			f.requestFocus();
			f.setVisible(true);
			
			
			l1=new JLabel("Modify Customer Record");
			l2=new JLabel("customer no");
			l3=new JLabel("Address");
			l4=new JLabel("Phone no");
			l5=new JLabel("Country");
			l6=new JLabel("State");
			l7=new JLabel("Name");
			
		
			l1.setBounds(80,30,200,30);
			l2.setBounds(80,70,200,30);
			l3.setBounds(80,110,200,30);
			l4.setBounds(80,150,200,30);
			l5.setBounds(80,190,200,30);
			l6.setBounds(80,230,200,30);
			l7.setBounds(80,270,200,30);
			
			l1.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
			l2.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
			l3.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
			l4.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
			l5.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
			l6.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
			l7.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
			
			l1.setForeground(Color.white);
			l2.setForeground(Color.white);
			l3.setForeground(Color.white);
			l4.setForeground(Color.white);
			l5.setForeground(Color.white);
			l6.setForeground(Color.white);
			l7.setForeground(Color.white);
			
			t1=new JTextField();
			t2=new JTextField();
			t3=new JTextField();
			t4=new JTextField();
			t5=new JTextField();
			t6=new JTextField();
			
			t1.setBounds(300,70,200,30);
			t2.setBounds(300,110,200,30);
			t3.setBounds(300,150,200,30);
			t4.setBounds(300,190,200,30);
			t5.setBounds(300,230,200,30);
			t6.setBounds(300,270,200,30);
			
			b1=new JButton("Modify");
			b2=new JButton("Modify");
			b3=new JButton("Modify");
			b4=new JButton("Modify");
			b5=new JButton("Modify");
			b6=new JButton("Clear");
			b7=new JButton("Home");
			b8 = new JButton("Back");
			
			b1.setBounds(520, 110, 100, 30);
			b2.setBounds(520, 150, 100, 30);
			b3.setBounds(520, 190, 100, 30);
			b4.setBounds(520, 230, 100, 30);
			b5.setBounds(520, 270, 100, 30);
			b6.setBounds(170, 350, 100, 30);
			b7.setBounds(290, 350, 100, 30);
			b8.setBounds(250,500,110,30);
			
			b1.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
			b2.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
			b3.setFont(new Font("Monotype corsiva", Font.ITALIC, 18));
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
			
			p.add(l1);
			p.add(l2);
			p.add(l3);
			p.add(l4);
			p.add(l5);
			p.add(l6);
			p.add(l7);
			
			p.add(t1);
			p.add(t2);
			p.add(t3);
			p.add(t4);
			p.add(t5);
			p.add(t6);
			
			p.add(b1);
			p.add(b2);
			p.add(b3);
			p.add(b4);
			p.add(b5);
			p.add(b6);
			p.add(b7);
			p.add(b8);
			
			
			p.add(label);
			p.setLayout(null);
			
	}
	
	
public void actionPerformed(ActionEvent e) {
		
	if(e.getSource()==b1)
	{
		Customervo ev = new Customervo();
		ev.setcustomerno(Integer.parseInt(t1.getText()));
		ev.setcustomeradd(t2.getText());
		
		Customerservice es = new Customerservice();
		es.modifyaddCustomerservice(ev);
		
	}
	
	else if (e.getSource()==b2)
	{
		
		Customervo ev = new Customervo();
		ev.setcustomerno(Integer.parseInt(t1.getText()));
		ev.setcustomermob(Long.parseLong(t3.getText()));
		
		Customerservice es = new Customerservice();
		es.modifynoCustomerservice(ev);
	}
	else if(e.getSource()==b3)
	{
		
		Customervo ev = new Customervo();
		ev.setcustomerno(Integer.parseInt(t1.getText()));
		ev.setCountry(t4.getText());
		
		Customerservice es = new Customerservice();
		es.modifyconCustomerservice(ev);
	}
	else if (e.getSource()==b4)
	{
		
		Customervo ev = new Customervo();
		ev.setcustomerno(Integer.parseInt(t1.getText()));
		ev.setState(t5.getText());
		
		Customerservice es = new Customerservice();
		es.modifysteCustomerservice(ev);
	}
	
	
	else if (e.getSource()==b5)
	{
		
		Customervo ev = new  Customervo();
		ev.setcustomerno(Integer.parseInt(t1.getText()));
		ev.setcustomername(t6.getText());
		
		Customerservice es = new Customerservice();
		es.modifynameCustomerservice(ev);
	}
	else if (e.getSource()==b8)
	{
		f.setVisible(false);
		Admingui a = new Admingui();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*if(e.getSource()==b1){
			ts=new Customerservice();
			tv=new Customervo();
			tv.setCustId(Integer.parseInt(t1.getText()));
			tv.setCustName(t2.getText());
			x=ts.modifyNameSevice(tv);
			if(x>0){
				 JOptionPane.showMessageDialog(b1, "Name modified Successfully");
			}
		}
			else if(e.getSource()==b2){
				ts=new TbsService();
				tv=new TbsVo();
				tv.setCustId(Integer.parseInt(t1.getText()));
				tv.setAge(Integer.parseInt(t3.getText()));
				x=ts.modifyAgeService(tv);
				if(x>0){
					 JOptionPane.showMessageDialog(b2, "Age modified Successfully");
				}
			}
			else if (e.getSource()==b3){
				ts=new TbsService();
				tv=new TbsVo();
				tv.setCustId(Integer.parseInt(t1.getText()));
				tv.setCustDOJ(t4.getText());
				x=ts.modifyDOJSevice(tv);
				if(x>0){
					 JOptionPane.showMessageDialog(b3, "DOJ modified Successfully");
				}
			}
			else if(e.getSource()==b4){
				ts=new TbsService();
				tv=new TbsVo();
				tv.setCustId(Integer.parseInt(t1.getText()));
				tv.setCustAdd(t5.getText());
				x=ts.modifyAddService(tv);
				if(x>0){
					 JOptionPane.showMessageDialog(b4, "Address modified Successfully");
				}
			}
			else if(e.getSource()==b5){
				ts=new TbsService();
				tv=new TbsVo();
				tv.setCustId(Integer.parseInt(t1.getText()));
				tv.setCustPhone(Long.parseLong(t6.getText()));
				x=ts.modifyPhoneService(tv);
				if(x>0){
					 JOptionPane.showMessageDialog(b5, "Phone modified Successfully");
				}
			}
			
		
		else if(e.getSource()==b6){
			
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
			t6.setText("");
			
		}
		else {
			new TbsGuiMenu();
		}
		
	}*/
	
}
}
