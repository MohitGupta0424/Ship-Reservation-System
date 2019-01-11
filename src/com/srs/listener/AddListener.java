package com.wipro.srs.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.swing.JOptionPane;

import com.wipro.srs.bean.ScheduleBean;
import com.wipro.srs.dao.ScheduleDAO;
import com.wipro.srs.service.RouteService;
import com.wipro.srs.service.ScheduleService;
import com.wipro.srs.service.ShipService;
import com.wipro.srs.ui.AddScheduleUi;

public class AddListener implements ActionListener, WindowListener
{
	AddScheduleUi addUi;
	ScheduleBean bean;
	ScheduleService service;
	ShipService shipS;
	RouteService routeS;
	String s="";

	public AddListener(AddScheduleUi addUi)
	{
		this.addUi=addUi;
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==addUi.btnAddSch)
		{
			bean=new ScheduleBean();
			service=new ScheduleService();
			if(addUi.shipId.getSelectedItem().equals("--Select--"))
			{
				JOptionPane.showMessageDialog(null,"Select Ship Id","ERROR",JOptionPane.ERROR_MESSAGE);
			}
			else if(addUi.routeId.getSelectedItem().equals("--Select--"))
			{
				JOptionPane.showMessageDialog(null,"Select Route Id","ERROR",JOptionPane.ERROR_MESSAGE);
			}
				
			else
			{
				
				bean.setShipID(addUi.shipId.getSelectedItem());
				bean.setRouteID(addUi.routeId.getSelectedItem());
				bean.setStartDate(addUi.j.getDate());
				Date today=new Date();
				if(addUi.j.getDate()==null)
				{
					JOptionPane.showMessageDialog(null,"Select DATE","ERROR",JOptionPane.ERROR_MESSAGE);
				}
				else
				if(today.compareTo(addUi.j.getDate())>0)
				{
					JOptionPane.showMessageDialog(null,"ENTER APPROPRIATE DATE","ERROR",JOptionPane.ERROR_MESSAGE);
				}
				else
				{	
					ScheduleDAO sDao=new ScheduleDAO();
					bean.setStartDate(addUi.j.getDate());
					String s=service.addSchedule(bean);
					
					if(s=="SUCCESS")
					{
						addUi.txtScheduleId.setText(bean.getScheduleID());
						JOptionPane.showMessageDialog(null,"Schedule Added Successfully","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
						addUi.frame1.setVisible(false);
					}
					else if(s=="Update only on Saturday")
					{
						JOptionPane.showMessageDialog(null,s,"ERROR",JOptionPane.ERROR_MESSAGE);
						addUi.frame1.setVisible(false);
					}
					else
					{
						JOptionPane.showMessageDialog(null,s);
					}
				}
				
			}
		}
		if(e.getSource()==addUi.btnCancel)
		{
			addUi.txtScheduleId.setText(" ");
			addUi.shipId.select(0);
			addUi.routeId.select(0);
			addUi.j.setDate(null);
			
		}
		if(e.getSource()==addUi.btnBack)
		{
			addUi.frame1.setVisible(false);
		}
	}
	@Override
	public void windowOpened(WindowEvent e) 
	{
		shipS=new ShipService();
		routeS=new RouteService();
		
		String s="";
		String r="";
		ArrayList list1=new ArrayList();
		list1=shipS.getShipId();
		Iterator itr=list1.iterator();
		while(itr.hasNext())
		{
			s=(String) itr.next();
			addUi.shipId.add(s);
		}
		ArrayList list2=new ArrayList();

		list2=routeS.getRouteId();
		Iterator itr2=list2.iterator();
		while(itr2.hasNext())
		{
			r=(String) itr2.next();
			addUi.routeId.add(r);
		}
		
	}
	@Override
	public void windowClosing(WindowEvent e)
	{ }
	@Override
	public void windowClosed(WindowEvent e)
	{ }
	@Override
	public void windowIconified(WindowEvent e)
	{ }
	
	@Override
	public void windowDeiconified(WindowEvent e)
	{ }
	@Override
	public void windowActivated(WindowEvent e)
	{ }
	@Override
	public void windowDeactivated(WindowEvent e)
	{ }
	
	
}