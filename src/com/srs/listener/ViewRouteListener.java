package com.wipro.srs.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Iterator;

import com.wipro.srs.bean.RouteBean;
import com.wipro.srs.service.RouteService;
import com.wipro.srs.ui.ViewRouteInterface;

public class ViewRouteListener implements ActionListener,WindowListener
{
	ViewRouteInterface viewUI;
	RouteService service;
	
	public ViewRouteListener(ViewRouteInterface viewUI) 
	{
		this.viewUI=viewUI;
	}

	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==viewUI.Cancelbtn)
		{
			viewUI.dispose();
		}
	}

	@Override
	public void windowOpened(WindowEvent e)
	{
		viewUI.model.getDataVector().removeAllElements();
		service=new RouteService();
		ArrayList<RouteBean> list=service.viewByAllRoute();
		
		Iterator itr=list.iterator();

		while(itr.hasNext())
		{
			RouteBean routeBean=new RouteBean();
			routeBean=(RouteBean) itr.next();
			viewUI.rows[0]=routeBean.getRouteID();
			viewUI.rows[1]=routeBean.getSource();
			viewUI.rows[2]=routeBean.getDestination();
			viewUI.rows[3]=routeBean.getTravelDuration();
			viewUI.rows[4]=routeBean.getFare();
			viewUI.model.addRow(viewUI.rows);
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

	