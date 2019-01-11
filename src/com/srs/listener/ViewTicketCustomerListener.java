package com.wipro.srs.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import com.wipro.srs.bean.ReservationBean;
import com.wipro.srs.ui.PrintTicketUI;
import com.wipro.srs.ui.ViewTicketInterface;

public class ViewTicketCustomerListener extends JFrame implements ActionListener
{
	ViewTicketInterface viewTicketUI;
	ReservationBean reservationBean;
	PrintTicketUI I;
  public ViewTicketCustomerListener(ViewTicketInterface viewTicketUI)
  {
	  this.viewTicketUI=viewTicketUI;
  }

  public void actionPerformed(ActionEvent e) 
  {
	if(e.getSource()==viewTicketUI.printButton)
	{
		I=new PrintTicketUI(viewTicketUI.txtreservationId.getText().trim());
		
	}
	
	if(e.getSource()==viewTicketUI.Cancelbtn)
	{
		viewTicketUI.txtreservationId.setText("");
	}
	
	if(e.getSource()==viewTicketUI.Backbtn)
	{
		viewTicketUI.frame.setVisible(false);
	}
  }
}
