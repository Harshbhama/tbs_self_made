package com.tbs.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.tbs.model.Billvo;
import com.tbs.service.Billservice;

public class Newbill1 {

	public Newbill1(){
		
		JFrame f=new JFrame();
		JPanel p=new JPanel();
		f.getContentPane().add(p);
		
		p.setPreferredSize(new Dimension(700,700));
		p.setLayout(new BorderLayout());
		
		
		Object[] column={ "Duration","BroadBand usage", "Cost", "Invoice",
		"Cust-ID","Bill-stat" };
		
		
		DefaultTableModel tableModel = new DefaultTableModel(column, 0);
		Billvo ev=new Billvo();
		
		ev.setBillstatus("due");
		Billservice es=new Billservice();
		List<Billvo> l=new ArrayList<Billvo>();
		l=es.viewBillservice1(ev);
		for(Billvo e:l){
			
			Object [] data={e.getcustomerdur(),e.getcustomernet(),e.getcustomercost(),e.getcustomerinv(),e.getcustomerno(),e.getBillstatus()};
			tableModel.addRow(data);
		}
		
		JTable jt=new JTable(tableModel);
		JScrollPane sp=new JScrollPane(jt);
		p.add(sp,BorderLayout.CENTER);
		
		f.add(p);
		f.pack();
		f.requestFocus();
		f.setFocusable(true);
		f.setVisible(true);
		
	}
	
}
