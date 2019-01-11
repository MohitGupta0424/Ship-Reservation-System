package com.wipro.srs.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.wipro.srs.bean.PassengerBean;
import com.wipro.srs.bean.ReservationBean;
import com.wipro.srs.dao.CustomerDao;
import com.wipro.srs.service.CustomerService;
import com.wipro.srs.ui.Customer;
import com.wipro.srs.ui.Login;
import com.wipro.srs.ui.PrintTicketUI;
import com.wipro.srs.ui.ReservationPageOne;
import com.wipro.srs.ui.ReservationPageThree;
import com.wipro.srs.ui.ReservationPageTwo;
import com.wipro.srs.util.User;

public class ReservationPageThreeListener implements ActionListener
{
	
	public static String to;
	public static String from;
	public static String creditcardno;
	ReservationPageThree reservation_page_three;
	public ReservationPageThreeListener(ReservationPageThree reservation_page_three)
	{
		this.reservation_page_three=reservation_page_three;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		
		if(e.getSource()==reservation_page_three.btn_logout)
		{
				new ReservationPageOne();
				reservation_page_three.frame1.setVisible(false);			
			
		}
		if(e.getSource()==reservation_page_three.submit)
		{
			if(reservation_page_three.txt_cardno.getText()==null||reservation_page_three.txt_cardno.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Credit Card Number Cannot Be Empty","ERROR",JOptionPane.ERROR_MESSAGE);

			}
			else if(!(reservation_page_three.txt_cardno.getText().trim().matches("[0-9]+")))
			{
				JOptionPane.showMessageDialog(null, "Credit Card Number Can Only Be In Digits","ERROR",JOptionPane.ERROR_MESSAGE);

			}
			else if(reservation_page_three.txt_cardno.getText().trim().length()!=16)
			{
				JOptionPane.showMessageDialog(null, "Credit Card Number Can Only Be 16-Digit","ERROR",JOptionPane.ERROR_MESSAGE);

			}
			else if(!(reservation_page_three.txt_to.getText().trim().matches("[0-9]+")))
			{
				JOptionPane.showMessageDialog(null, "VALID TO Field Can Only Be in Positive digits","ERROR",JOptionPane.ERROR_MESSAGE);

			}
			else if(reservation_page_three.txt_to.getText().trim().length()!=4)
			{
				JOptionPane.showMessageDialog(null, "Invalid VALID TO ","ERROR",JOptionPane.ERROR_MESSAGE);

			}
			else if(!(reservation_page_three.txt_from.getText().trim().matches("[0-9]+")))
			{
				JOptionPane.showMessageDialog(null, "VALID FROM Field Can Only Be in Positive Digits","ERROR",JOptionPane.ERROR_MESSAGE);

			}
			else if(reservation_page_three.txt_from.getText().trim().length()!=4)
			{
				JOptionPane.showMessageDialog(null, "Invalid VALID FROM","ERROR",JOptionPane.ERROR_MESSAGE);

			}
			else
			{
				creditcardno=reservation_page_three.txt_cardno.getText();
				to=reservation_page_three.txt_to.getText();
				from=reservation_page_three.txt_from.getText();
				CustomerDao obj=new CustomerDao();
				double ACbal = 0;
				try
				{
					ACbal = obj.findBalanceByCardNumber(creditcardno, from, to);
				}
				catch (ClassNotFoundException | SQLException e1) 
				{
					e1.printStackTrace();
				}
				reservation_page_three.txt_balance.setText(String.valueOf(ACbal));
			}
		}
		if(e.getSource()==reservation_page_three.book_ticket)
		{
			PassengerBean passengerbean=new PassengerBean();
			passengerbean.setName(ReservationPageTwoListener.name);
			passengerbean.setAge(ReservationPageTwoListener.age);
			passengerbean.setGender(ReservationPageTwoListener.gender);
			passengerbean.setScheduleID(ReservationPageTwoListener.scheduleID);
			
			ReservationBean reservationbean=new ReservationBean();
			reservationbean.setScheduleID(ReservationPageTwoListener.scheduleID);
			reservationbean.setJourneyDate(ReservationPageOneListener.journeydate);
			reservationbean.setNoOfSeats(ReservationPageTwoListener.no_of_seats);
			reservationbean.setTotalFare(ReservationPageTwoListener.totalfare);
			
			CustomerService obj=new CustomerService();
			String res=obj.makeReservation(ReservationPageOneListener.source,ReservationPageOneListener.destination, passengerbean, reservationbean);
			if(res.equalsIgnoreCase("SUCCESS"))
			{
				JOptionPane.showMessageDialog(null, "Booking Is Successfull","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
				new PrintTicketUI(CustomerDao.id);
				reservation_page_three.frame1.setVisible(false);
				new Customer();

			}
			else
			{
				JOptionPane.showMessageDialog(null, "Booking Unsuccessfull","ERROR",JOptionPane.ERROR_MESSAGE);

			}
		}
		if(e.getSource()==reservation_page_three.btn_cancel)
		{
				reservation_page_three.txt_balance.setText("");
				reservation_page_three.txt_cardno.setText("");
				reservation_page_three.txt_from.setText("");
				reservation_page_three.txt_to.setText("");
			
		}
		
	}

}
