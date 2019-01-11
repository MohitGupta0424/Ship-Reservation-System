package com.wipro.srs.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.wipro.srs.ui.CancelTicketUI;
import com.wipro.srs.ui.ChangePassword;
import com.wipro.srs.ui.Customer;
import com.wipro.srs.ui.Login;
import com.wipro.srs.ui.ReservationPageOne;
import com.wipro.srs.ui.ViewTicketInterface;
import com.wipro.srs.util.User;

public class CustomerListener implements ActionListener
{
	Customer customerobj;
	public CustomerListener(Customer customerobj)
	{
		this.customerobj=customerobj;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		
		if(e.getSource()==customerobj.btn_logout1)
		{
			
			User obj=new User();
			String userid=LoginListener.userid;
			boolean flag=obj.logout(userid);
			if (flag==true)
			{
				Login l=new Login();
				customerobj.frame2.setVisible(false);
			}
		}
		
		if(e.getSource()==customerobj.btn_changepwd)
		{
			customerobj.frame2.setVisible(false);
			ChangePassword cpwd=new ChangePassword();
		}
		if(e.getSource()==customerobj.btn_3)
		{
			new ReservationPageOne();
			customerobj.frame2.setVisible(false);
		}
		if(e.getSource()==customerobj.btn_6)
		{
			new ViewTicketInterface();
		}
		if(e.getSource()==customerobj.btn_4)
		{
			new CancelTicketUI();
			customerobj.frame2.setVisible(false);

		}
		if(e.getSource()==customerobj.btn_5)
		{
			new ViewTicketInterface();
		}
		
	}

}
