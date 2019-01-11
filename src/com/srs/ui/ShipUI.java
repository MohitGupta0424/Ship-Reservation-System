package com.wipro.srs.ui;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.wipro.srs.bean.ShipBean;
import com.wipro.srs.service.ShipService;

public class ShipUI 
{
	public JFrame frameUI,frame2;
	public JButton btnAdd,btnModify,btnView,btnRemove,btnViewByShipId;
	public JScrollPane scrollPane;
	public JTable table;
	public JButton btnBack;
	public JPanel panel;
	ShipService adminService;
	public ShipUI()
	{
		
		
		
		
			
		adminService=new ShipService();
			ArrayList<ShipBean> ai=new ArrayList<ShipBean>();
			frame2=new JFrame();
			frame2.setLayout(new GridLayout(0,1));
			frame2.setSize(470,500);
			frame2.setTitle("View Ship");
			frame2.add(panel=new JPanel());
			String column_names[]={"Ship ID","Ship Name","Seating Capacity","Reservation Capacity"};
			ai=adminService.viewByAllShips();
			Iterator<ShipBean> i=ai.iterator();
			Object row[][]=new Object[ai.size()][4];
			int l=0;
			while(i.hasNext())
			{
				ShipBean shipBean = new ShipBean();
				shipBean=i.next();
				row[l][0]=shipBean.getShipID();
				row[l][1]=shipBean.getShipName();
				row[l][2]=shipBean.getSeatingCapacity();
				row[l][3]=shipBean.getReservationCapacity();
				l++;				
			}
			table=new JTable(row,column_names);
			scrollPane=new JScrollPane();
			scrollPane.setViewportView(table);
			panel.add(scrollPane);
			//panel.add(btnBack=new JButton("BACK"));
		//btnBack.addActionListener(new AdminListener(this));
		
			frame2.setVisible(true);
			frame2.setLocation(300,200);
		}
	
		//frame2.setLocation(350,250);
		
	}
	

