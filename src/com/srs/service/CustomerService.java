package com.wipro.srs.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import com.wipro.srs.bean.PassengerBean;
import com.wipro.srs.bean.ReservationBean;
import com.wipro.srs.bean.ScheduleBean;
import com.wipro.srs.bean.TempBean;
import com.wipro.srs.dao.CustomerDao;
import com.wipro.srs.dao.ScheduleDAO;
import com.wipro.srs.listener.ReservationPageThreeListener;
import com.wipro.srs.listener.ReservationPageTwoListener;
import com.wipro.srs.ui.ReservationPageOne;

public class CustomerService 
{
	CustomerDao dao=new CustomerDao();
	ReservationBean reservationBean=new ReservationBean();
	PassengerBean passengerBean=new PassengerBean();
	public ReservationBean printTicket(String reservationId)
	{
		try 
		{
			reservationBean=dao.printTicket(reservationId);
		} 
		catch (ClassNotFoundException e) 
		{	
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return reservationBean;
	}

	public PassengerBean printTicket1(String reservationId)
	{
		try 
		{
			passengerBean=dao.printTicket1(reservationId);
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return passengerBean;
	}
	public ArrayList<TempBean> viewScheduleByRoute(String source, String destination, Date date)
	{
		CustomerDao customerDao=new CustomerDao();
		return customerDao.viewScheduleByRoute(source, destination, date);		
	}
	/*public static void main(String args[]) throws ClassNotFoundException, SQLException
	{
		//new ReservationPageThree();
		//new ReservationPageTwo();
		new ReservationPageOne();
		
		
	}*/
	
	
	
	public String makeReservation(String Source ,String Destination, PassengerBean passengerbean, ReservationBean reservationbean)
	{
		String output="FAIL";
		if(Source==null || Destination==null || passengerbean==null || reservationbean==null)
		{
			return "FAIL";
		}
		else
		{
			java.sql.Date bookingdate=new java.sql.Date(new Date().getTime());
			java.sql.Date dateOfJourney=new java.sql.Date(reservationbean.getJourneyDate().getTime());
			System.out.println(dateOfJourney);
			System.out.println(bookingdate);
			if(dateOfJourney.compareTo(bookingdate)>0)
			{
				reservationbean.setJourneyDate(dateOfJourney);
				reservationbean.setBookingDate(bookingdate);
				reservationbean.setScheduleID(reservationbean.getScheduleID());
				
				int no_of_seats_reserved=reservationbean.getNoOfSeats();
				
				
				double totalfare=reservationbean.getTotalFare();
				
				CustomerDao obj=new CustomerDao();
				double balance;
				try 
				{
					balance = dao.findBalanceByCardNumber(ReservationPageThreeListener.creditcardno, ReservationPageThreeListener.from, ReservationPageThreeListener.to);
					System.out.println(balance);
					System.out.println(totalfare);
					if(balance>=totalfare)
					{
						System.out.println("12");
						output=dao.makeReservation(Source,Destination, passengerbean, reservationbean);
						System.out.println("service"+output);
						if(output.equalsIgnoreCase("SUCCESS"))
						{
							//double new_balance=balance-totalfare;
							String flag1=obj.updatePassengerBalance(ReservationPageThreeListener.creditcardno, -totalfare);
							
							if(flag1.equalsIgnoreCase("SUCCESS"))
							{
								//int updated_seats=ReservationPageTwoListener.seats_in_ship-no_of_seats_reserved;
								ScheduleBean sBean=new ScheduleBean();
								ScheduleDAO scheduleDAO=new ScheduleDAO();
								try {
									sBean=scheduleDAO.viewByScheduleId(reservationbean.getScheduleID());
								} catch (ParseException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								boolean flag2=obj.updateSeatsInShip(sBean.getShipID(), -no_of_seats_reserved);
								
								if(flag2==true)
								{
									reservationbean.setNoOfSeats(no_of_seats_reserved);
									reservationbean.setTotalFare(totalfare);
									reservationbean.setBookingStatus("CONFIRM");
									
									
								}
							}
						}
							
							
					}

				} 
				catch (ClassNotFoundException e) 
				{
					// TODO Auto-generated catch block
					System.out.println("in catch 1");
					e.printStackTrace();
				}
				catch (SQLException e) 
				{
					// TODO Auto-generated catch block
					System.out.println("in catch 2");
					e.printStackTrace();
				}
								
				
			}
			
			
		}
		return output;
	}
	public String CancelTicket(String reservationID)
	{
		CustomerDao customerDao=new CustomerDao();
		try {
			return customerDao.CancelTicket(reservationID);
		} catch (ClassNotFoundException | SQLException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
