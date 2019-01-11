package com.wipro.srs.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

import com.wipro.srs.bean.ScheduleBean;
import com.wipro.srs.service.ScheduleService;
import com.wipro.srs.ui.ScheduleUi;
import com.wipro.srs.ui.ViewScheduleUi;

public class ViewListener implements ActionListener,WindowListener
{
	ViewScheduleUi viewUi;
	ScheduleUi ui;
	
	ScheduleService service;
	
	public ViewListener(ViewScheduleUi viewUi)
	{
		this.viewUi=viewUi;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
			
		if(e.getSource()==viewUi.btnBack)
		{
			viewUi.frame4.setVisible(false);;
		}
	}

	
	@Override
	public void windowActivated(WindowEvent e)
	{ }

	@Override
	public void windowClosed(WindowEvent e)
	{ }

	@Override
	public void windowClosing(WindowEvent e) 
	{ }

	@Override
	public void windowDeactivated(WindowEvent e)
	{ }

	@Override
	public void windowDeiconified(WindowEvent e)
	{ }

	@Override
	public void windowIconified(WindowEvent e)
	{ }

	@Override
	public void windowOpened(WindowEvent e)
	{
		viewUi.model.getDataVector().removeAllElements();
		service=new ScheduleService();
	    
		ArrayList<ScheduleBean> al=new ArrayList<ScheduleBean>();
		al=service.viewByAllSchedule();
		
		Iterator<ScheduleBean> i= al.iterator();
	
		while(i.hasNext())
		{
		    ScheduleBean bean=new ScheduleBean();

			bean=i.next();
			viewUi.rows[0]=bean.getScheduleID();
			viewUi.rows[1]=bean.getShipID();
			viewUi.rows[2]=bean.getRouteID();
			SimpleDateFormat formatter=new SimpleDateFormat("dd-MMM-yyyy");
			String date = formatter.format(bean.getStartDate());
			viewUi.rows[3]=date;
			viewUi.model.addRow(viewUi.rows);

		}
		
	}		
}


