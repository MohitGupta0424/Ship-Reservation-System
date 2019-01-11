package com.wipro.srs.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.wipro.srs.service.CustomerService;
import com.wipro.srs.ui.CancelTicketUI;

public class CancelTicketListener implements ActionListener 
{
	CancelTicketUI cancelTicketUI;
	public CancelTicketListener(CancelTicketUI cancelTicketUI) 
	{
		this.cancelTicketUI=cancelTicketUI;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==cancelTicketUI.btnBack)
		{
			cancelTicketUI.frame.setVisible(false);
		}
		if(e.getSource()==cancelTicketUI.btnCAncel)
		{
			if(cancelTicketUI.txtReservationId.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null,"Enter Reservation ID","ERROR",JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				CustomerService cService=new CustomerService();
				String result=cService.CancelTicket(cancelTicketUI.txtReservationId.getText().trim());
				JOptionPane.showMessageDialog(null,result,"NOTIFICATION",JOptionPane.INFORMATION_MESSAGE);
			}
			
		}
		
	}

}
