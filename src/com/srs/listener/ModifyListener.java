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
import com.wipro.srs.service.ScheduleService;
import com.wipro.srs.ui.ModifyScheduleUi;

public class ModifyListener implements ActionListener,WindowListener,ItemListener
{
	ModifyScheduleUi modUi;
	ScheduleBean bean;
	ScheduleService service;
	
	public ModifyListener(ModifyScheduleUi modUi)
	{
		this.modUi=modUi;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==modUi.btnGet)
		{
			modUi.btnModifySch.setVisible(true);
			bean=new ScheduleBean();
			service=new ScheduleService();

			modUi.lblShipId.setVisible(true);
			modUi.txtShipId.setVisible(true);
			modUi.lblRouteId.setVisible(true);
			modUi.txtRouteId.setVisible(true);
			modUi.lblDate.setVisible(true);
			modUi.txtShipId.setText("");
			modUi.txtRouteId.setText("");
			modUi.j.setDate(null);
			
			bean=service.viewByScheduleId(modUi.id.getSelectedItem());
			
			if(modUi.id.getSelectedItem().equals("--Select--"))
			{
				JOptionPane.showMessageDialog(null,"Select Schedule Id","ERROR",JOptionPane.ERROR_MESSAGE);
				modUi.frame2.setVisible(true);
				modUi.frame7.setVisible(false);
			}
			else
			{
				modUi.frame2.setVisible(false);
				modUi.frame7.setVisible(true);
				modUi.frame7.setVisible(true);
				modUi.txtShipId.setText((bean.getShipID()));
				modUi.txtRouteId.setText(bean.getRouteID());
				modUi.j.setDate(bean.getStartDate());
			}
		}
		if(e.getSource()==modUi.btnModifySch)
		{
			bean=new ScheduleBean();
			service=new ScheduleService();
			bean.setShipID(modUi.txtShipId.getText());
		
			Date dt;
			Date today=new Date();
			dt = modUi.j.getDate();
			
			if(today.compareTo(dt)>0)
			{
				JOptionPane.showMessageDialog(null,"ENTER APPROPRIATE DATE","ERROR",JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				bean.setStartDate(dt);
				bean.setScheduleID(modUi.id.getSelectedItem());
				modUi.pane=new JOptionPane();
				
				if(service.modifySchedule(bean)==true)
				{
					JOptionPane.showMessageDialog(null,"Schedule Details MOdified Successfully","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
					modUi.frame7.setVisible(false);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Update only on SATURDAY","ERROR",JOptionPane.ERROR_MESSAGE);
				}
			}
		}
			if(e.getSource()==modUi.btnBack)
			{
				modUi.frame2.setVisible(false);
			}
			if(e.getSource()==modUi.btnBck)
			{
				modUi.frame7.setVisible(false);
			}
			if(e.getSource()==modUi.btnCancel)
			{
				modUi.id.select(0);
			}
			if(e.getSource()==modUi.btnCncl)
			{
				modUi.txtShipId.setText(" ");
				modUi.txtRouteId.setText(" ");
				modUi.j.setDate(null);
			}
		}
			
	@Override
	public void itemStateChanged(ItemEvent e) 
	{
		service=new ScheduleService();
		bean=new ScheduleBean();
		bean=service.viewByScheduleId(modUi.id.getSelectedItem());
		modUi.frame2.setVisible(false);
	}

	@Override
	public void windowActivated(WindowEvent e) 
	{	}
	@Override
	public void windowClosed(WindowEvent e) 
	{	}
	@Override
	public void windowClosing(WindowEvent e)
	{	}
	@Override
	public void windowDeactivated(WindowEvent e)
	{	}
	@Override
	public void windowDeiconified(WindowEvent e)
	{	}
	@Override
	public void windowIconified(WindowEvent e)
	{	}
	@Override
	public void windowOpened(WindowEvent e) 
	{
		service=new ScheduleService();
		String s="";
		ArrayList list=new ArrayList();
		list=service.getScheduleId();
		Iterator itr=list.iterator();
		while(itr.hasNext())
		{
			s=(String) itr.next();
			modUi.id.add(s);
		}
	}
}