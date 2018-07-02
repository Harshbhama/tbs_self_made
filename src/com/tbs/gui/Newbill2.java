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

public class Newbill2 {

	public Newbill2(int n){
		
		JFrame f=new JFrame();
		JPanel p=new JPanel();
		f.getContentPane().add(p);
		
		p.setPreferredSize(new Dimension(700,700));
		p.setLayout(new BorderLayout());
		
		
		Object[] column={ "Duration","BroadBand usage", "Cost",
		"Cust-ID","Invoice","Bill-stat" };
		
		
		DefaultTableModel tableModel = new DefaultTableModel(column, 0);
		Billvo ev=new Billvo();
		
		
		Billservice es=new Billservice();
		List<Billvo> l=new ArrayList<Billvo>();
		ev.setcustomerno(n);
		l = es.view2Billservice(ev);
		for(Billvo e:l){
			
			Object [] data={e.getcustomerdur(),e.getcustomernet(),e.getcustomercost(),e.getcustomerno(),e.getcustomerinv(),e.getBillstatus()};
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
