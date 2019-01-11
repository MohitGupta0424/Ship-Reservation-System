package com.wipro.srs.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.wipro.srs.service.PassengerService;
import com.wipro.srs.ui.Admin;
import com.wipro.srs.ui.PassengerUi;

public class PassengerListener implements ActionListener 
{
	Admin admin;
	PassengerService passengerService;
	
	public PassengerListener(Admin admin) 
	{
		// TODO Auto-generated constructor stub
		this.admin=admin;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		if(e.getSource()==admin.Passenger)
		{
			new PassengerUi();
		}
		
	}

}
