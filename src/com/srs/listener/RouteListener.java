package com.wipro.srs.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.wipro.srs.ui.AddRouteInterface;
import com.wipro.srs.ui.ModifyRouteInterface;
import com.wipro.srs.ui.RemoveRouteInterface;
import com.wipro.srs.ui.RouteInterface;
import com.wipro.srs.ui.ViewByRouteInterface;
import com.wipro.srs.ui.ViewRouteInterface;

public class RouteListener  implements ActionListener 
{
	RouteInterface routeUI;
	public RouteListener(RouteInterface routeUI)
	{
		this.routeUI=routeUI;
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==routeUI.Addbtn)
		{
			new AddRouteInterface();
		}

		if(e.getSource()==routeUI.Viewbtn)
		{
			new ViewRouteInterface();
		}

		if(e.getSource()==routeUI.Modifybtn)
		{
			new ModifyRouteInterface();
		}

		if(e.getSource()==routeUI.Removebtn)
		{
			new RemoveRouteInterface();
		}

		if(e.getSource()==routeUI.ViewByRoutebtn)
		{
			new ViewByRouteInterface();
		}
		if(e.getSource()==routeUI.Exitbtn)
		{
			routeUI.frame.dispose();
		}
	}
}
