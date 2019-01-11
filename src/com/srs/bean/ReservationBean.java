package com.wipro.srs.bean;

import java.util.Date;

public class ReservationBean 
{
	String reservationID;
	String scheduleID;
	String userID;
	Date bookingDate;
	Date journeyDate;
	int noOfSeats;
	double totalFare;
	String bookingStatus;
	String creditCardNumber;
	
	public String getReservationID() 
	{
		return reservationID;
	}
	
	public void setReservationID(String reservationID) 
	{
		this.reservationID = reservationID;
	}
	
	public String getScheduleID() 
	{
		return scheduleID;
	}
	
	public void setScheduleID(String scheduleID) 
	{
		this.scheduleID = scheduleID;
	}
	
	public String getUserID() 
	{
		return userID;
	}
	
	public void setUserID(String userID)
    {
		this.userID = userID;
	}
	
	public Date getBookingDate() 
	{
		return bookingDate;
	}
	
	public void setBookingDate(Date bookingDate) 
	{
		this.bookingDate = bookingDate;
	}
	
	public Date getJourneyDate()
	{
		return journeyDate;
	}
	
	public void setJourneyDate(Date journeyDate)
	{
		this.journeyDate = journeyDate;
	}
	
	public int getNoOfSeats() 
	{
		return noOfSeats;
	}
	
	public void setNoOfSeats(int noOfSeats) 
	{
		this.noOfSeats = noOfSeats;
	}
	
	public double getTotalFare() 
	{
		return totalFare;
	}
	
	public void setTotalFare(double totalFare) 
	{
		this.totalFare = totalFare;
	}
	
	public String getBookingStatus() 
	{
		return bookingStatus;
	}
	
	public void setBookingStatus(String bookingStatus) 
	{
		this.bookingStatus = bookingStatus;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	
}
