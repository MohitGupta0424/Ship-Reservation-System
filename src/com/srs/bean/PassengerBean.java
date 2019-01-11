package com.wipro.srs.bean;

public class PassengerBean 
{
	String reservationID;
	String scheduleID;
	String name;
	int age;
	String gender;
	
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
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public int getAge() 
	{
		return age;
	}
	
	public void setAge(int age) 
	{
		this.age = age;
	}
	
	public String getGender() 
	{
		return gender;
	}
	
	public void setGender(String gender) 
	{
		this.gender = gender;
	}
}
