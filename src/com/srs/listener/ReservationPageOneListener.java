package com.wipro.srs.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import com.wipro.srs.bean.TempBean;
import com.wipro.srs.service.CustomerService;
import com.wipro.srs.ui.Customer;
import com.wipro.srs.ui.Login;
import com.wipro.srs.ui.ReservationPageOne;
import com.wipro.srs.ui.ReservationPageTwo;
import com.wipro.srs.util.User;

public class ReservationPageOneListener implements ActionListener
{
	ReservationPageOne reservation_page_one;
	public static String source;
	public static String destination;
	public static ArrayList<TempBean> al;
	public static Date journeydate;
	CustomerService customerService;
	public ReservationPageOneListener(ReservationPageOne reservation_page_one)
	{
		this.reservation_page_one=reservation_page_one;
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		
		
		
		if(e.getSource()==reservation_page_one.btn_logout)
		{
				new Customer();
				reservation_page_one.frame1.setVisible(false);			
			
		}

		if(e.getSource()==reservation_page_one.btn_cancel)
		{
				
				reservation_page_one.chooser.setDate(null);
				reservation_page_one.txt_SOURCE.setText("");
				reservation_page_one.txt_DESTINATION.setText("");
			
		}
		
		if(e.getSource()==reservation_page_one.btn_searchShips)
		{
			if(reservation_page_one.txt_SOURCE.getText()==null||reservation_page_one.txt_SOURCE.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null,"Enter Valid Source","ERROR",JOptionPane.ERROR_MESSAGE);
			}
			else if(reservation_page_one.txt_DESTINATION.getText()==null||reservation_page_one.txt_DESTINATION.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null,"Enter Valid Destination","ERROR",JOptionPane.ERROR_MESSAGE);

			}
			
			else if(reservation_page_one.txt_SOURCE.getText().equals(reservation_page_one.txt_DESTINATION.getText()))
			{
				JOptionPane.showMessageDialog(null,"Source And Destination Cannot Be Same","ERROR",JOptionPane.INFORMATION_MESSAGE);

			}
			else if(reservation_page_one.chooser.getDate().equals("")||reservation_page_one.chooser.getDate().equals(null))
			{
				JOptionPane.showMessageDialog(null,"Select Date","ERROR",JOptionPane.ERROR_MESSAGE);

			}
			else
			{	
				source=reservation_page_one.txt_SOURCE.getText().trim();
				destination=reservation_page_one.txt_DESTINATION.getText().trim();
				journeydate=reservation_page_one.chooser.getDate();
				customerService=new CustomerService();
				al=new ArrayList<TempBean>();
				al=customerService.viewScheduleByRoute(source, destination, journeydate);
				if(al==null)
				{
					JOptionPane.showMessageDialog(null,"No Ships Available","ERROR",JOptionPane.ERROR_MESSAGE);
					reservation_page_one.frame1.setVisible(true);

				}
				else
				{	
					reservation_page_one.frame1.setVisible(false);
					new ReservationPageTwo();
				}
			}
		}
		
	}
	
	
}
