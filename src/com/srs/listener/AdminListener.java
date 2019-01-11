package com.wipro.srs.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import oracle.jdbc.util.Login;

import com.wipro.srs.ui.AddRouteInterface;
import com.wipro.srs.ui.AddScheduleUi;
import com.wipro.srs.ui.AddShipUI;
import com.wipro.srs.ui.Admin;
import com.wipro.srs.ui.ChangePassword;
import com.wipro.srs.ui.DeleteScheduleUi;
import com.wipro.srs.ui.ModifyRouteInterface;
import com.wipro.srs.ui.ModifyScheduleUi;
import com.wipro.srs.ui.ModifyShipUI;
import com.wipro.srs.ui.RemoveRouteInterface;
import com.wipro.srs.ui.RemoveShipUI;
import com.wipro.srs.ui.ShipUI;
import com.wipro.srs.ui.ViewByRouteInterface;
import com.wipro.srs.ui.ViewRouteInterface;
import com.wipro.srs.ui.ViewScheduleByIdUi;
import com.wipro.srs.ui.ViewScheduleUi;
import com.wipro.srs.util.User;



public class AdminListener implements ActionListener
{
	Admin adminobj;
	Login logobj;
	ShipUI shipobj;

	 public AdminListener(Admin adminobj) 
	{
		this.adminobj=adminobj;
	}
	 
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==adminobj.btn_logout2)
		{
			
			User obj=new User();
			String userid=LoginListener.userid;
			boolean flag=obj.logout(userid);
			if (flag==true)
			{
				adminobj.frame3.setVisible(false);
			}
		}
		if(e.getSource()==adminobj.btn_changepwd1)
		{
			adminobj.frame3.setVisible(false);
			ChangePassword cpwd=new ChangePassword();
		}
		if(e.getSource()==adminobj.addShip)
		{
			new AddShipUI();
		}
		if(e.getSource()==adminobj.removeShip)
		{
			new RemoveShipUI();
		}
		if(e.getSource()==adminobj.modifyShip)
		{
			new ModifyShipUI();
		}
		if(e.getSource()==adminobj.viewShip)
		{
			new ShipUI();
		}
		if(e.getSource()==adminobj.addRoute)
		{
			new AddRouteInterface();
		}
		if(e.getSource()==adminobj.removeRoute)
		{
			new RemoveRouteInterface();
		}
		if(e.getSource()==adminobj.modifyRoute)
		{
			new ModifyRouteInterface();
		}
		if(e.getSource()==adminobj.viewAllRoute)
		{
			new ViewRouteInterface();
		}
		if(e.getSource()==adminobj.viewbyIdRoute)
		{
			new ViewByRouteInterface();
		}
		if(e.getSource()==adminobj.addSchedule)
		{
			new AddScheduleUi();
		}
		if(e.getSource()==adminobj.removeSchedule)
		{
			new DeleteScheduleUi();
		}
		if(e.getSource()==adminobj.modifySchedule)
		{
			new ModifyScheduleUi();
		}
		if(e.getSource()==adminobj.viewAllSchedule)
		{
			new ViewScheduleUi();
		}
		if(e.getSource()==adminobj.viewByIdSchedule)
		{
			new ViewScheduleByIdUi();
		}
	}

}
