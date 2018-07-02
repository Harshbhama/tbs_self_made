package com.tbs.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import com.tbs.model.Planvo;
import com.tbs.service.Planservice;

public class Newplan {

	JFrame f;
	JPanel p;
	
	public Newplan()
	{
		
		f = new JFrame();
		p = new JPanel();
		
		
		f.getContentPane().add(p);
		
		p.setPreferredSize(new Dimension(700,700));
		p.setLayout(new BorderLayout());
		
		
		Object[] column ={ "Plan Name","Plan code","Plan validity","Plan cost","Cost_per_min","Cost_per_MB" };
		
		DefaultTableModel table1 = new DefaultTableModel(column,0);
		
		Planservice es = new Planservice();
		List<Planvo> l = new ArrayList<Planvo>();
		l = es.planEmpservice();
		for(Planvo e:l)
		{
			Object[] data = { e.getPlanname(),e.getPlancode(),e.getPlanval(),e.getPlancost(),e.getCostmin(),e.getCostmb() };
			table1.addRow(data);
			
		}
		
		JTable jt = new JTable(table1);
		JScrollPane sp = new JScrollPane(jt);
		
	p.add(sp,BorderLayout.CENTER);
	f.add(p);
	f.pack();
	f.requestFocus();
	f.setFocusable(true);
	f.setVisible(true);
		
		
		
	}
	
}
