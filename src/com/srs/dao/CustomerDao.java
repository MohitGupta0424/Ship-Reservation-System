package com.wipro.srs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import com.wipro.srs.bean.PassengerBean;
import com.wipro.srs.bean.ReservationBean;
import com.wipro.srs.bean.RouteBean;
import com.wipro.srs.bean.ScheduleBean;
import com.wipro.srs.bean.ShipBean;
import com.wipro.srs.bean.TempBean;
import com.wipro.srs.listener.ReservationPageOneListener;
import com.wipro.srs.listener.ReservationPageThreeListener;
import com.wipro.srs.listener.ReservationPageTwoListener;
import com.wipro.srs.service.RouteService;
import com.wipro.srs.service.ScheduleService;
import com.wipro.srs.service.ShipService;
import com.wipro.srs.ui.ReservationPageTwo;
import com.wipro.srs.util.DBUtil;

public class CustomerDao 
{
	public static String id;
	public ArrayList<TempBean> viewScheduleByRoute(String source, String destination, Date date)
	{
		ScheduleService scheduleService=new ScheduleService();
		RouteService routeService=new RouteService();
		ShipService adminService=new ShipService();
		TempBean tempBean=new TempBean();
		ArrayList<RouteBean> routeIds=new ArrayList<RouteBean>();
		
		ScheduleBean scBean=new ScheduleBean();
		ShipBean shipBean=new ShipBean();
				
		routeIds=routeService.viewBySourceDestination(source.toUpperCase(), destination.toUpperCase());
		Iterator<RouteBean> ri=routeIds.iterator();
				
		
		ArrayList<ScheduleBean> scheduleBeans1=new ArrayList<ScheduleBean>();
		
		System.out.println("out");
		while(ri.hasNext())
		{
			RouteBean routeBean=new RouteBean();
			System.out.println("in");
			ArrayList<ScheduleBean> scheduleBeans=new ArrayList<ScheduleBean>();
			routeBean=ri.next();
			System.out.println("1"+routeBean);
			
			scheduleBeans=scheduleService.viewByRidDate(routeBean.getRouteID(), date);
			scheduleBeans1.addAll(scheduleBeans);
			System.out.println(scheduleBeans1);
		}
		Iterator<ScheduleBean> sci=scheduleBeans1.iterator();
		ArrayList<TempBean> result=new ArrayList<TempBean>();
		System.out.println(sci.hasNext());
		while(sci.hasNext())
		{
			RouteBean routeBean=new RouteBean();
			System.out.println("hiii");
			scBean=sci.next();
			routeBean=routeService.viewByRouteId(scBean.getRouteID());
			shipBean=adminService.viewByShipId(scBean.getShipID());
			tempBean.setDate(date);
			tempBean.setDestination(destination);
			tempBean.setFare(routeBean.getFare());
			tempBean.setScheduleId(scBean.getScheduleID());
			tempBean.setSeats(shipBean.getReservationCapacity());
			tempBean.setShipId(shipBean.getShipID());
			tempBean.setShipName(shipBean.getShipName());
			tempBean.setSource(source);
			result.add(tempBean);
		}
		return result;		
	}
	///////////////////////////////////////////////////////////////////////
	public String generateReservationID(String source,String destination) throws ClassNotFoundException, SQLException
	{
		String reservation_id="";
		
		Connection connection=DBUtil.getDBConnection();
		PreparedStatement pstmt=connection.prepareStatement("select SRS_SEQ_RESERVATION_ID.nextval from dual");
		ResultSet rs=pstmt.executeQuery();
		if(rs.next())
		{
			reservation_id=source.substring(0, 1).toUpperCase()+destination.substring(0, 1).toUpperCase()+rs.getInt(1);
		}
		
		return reservation_id;
		
	}
	
	public int findBalanceByCardNumber( String cardnumber, String validFrom , String validTo) throws ClassNotFoundException, SQLException
	{
		int  balance=0;
		Connection connection=DBUtil.getDBConnection();
		PreparedStatement pstmt=connection.prepareStatement("Select Balance from SRS_TBL_CreditCard where CreditCardNumber=? and ValidFrom=? and ValidTo=?");
		pstmt.setString(1, cardnumber);
		pstmt.setString(2, validFrom);
		pstmt.setString(3, validTo);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next())
		{
			balance=rs.getInt(1);
			
		}
		return balance;
		
	}
	
	
	
	
	public String updatePassengerBalance(String cardnumber,double new_balance) throws ClassNotFoundException, SQLException
	{
		System.out.println("update balance");
		String output="fail";
		Connection connection=DBUtil.getDBConnection();
		PreparedStatement pstmt=connection.prepareStatement("Update SRS_TBL_CreditCard set Balance=Balance+? where CreditCardNumber=?  ");
		pstmt.setString(2, cardnumber);
		pstmt.setDouble(1, new_balance);
		int check=pstmt.executeUpdate();
		if(check>0)
		{
			output="SUCCESS";
		}
		
		return output;
		
	}
	
	
	public boolean updateSeatsInShip(String shipId,int updated_seats) throws ClassNotFoundException, SQLException
	{
		boolean flag=false;
		Connection connection=DBUtil.getDBConnection();
		PreparedStatement pstmt=connection.prepareStatement("Update SRS_TBL_Ship set ReservationCapacity=RESERVATIONCAPACITY+? where ShipId=?  ");
		pstmt.setInt(1, updated_seats);
		pstmt.setString(2, shipId);
		int check=pstmt.executeUpdate();
		if(check>0)
		{
			
			flag=true;
		}
		return flag;
	}
	
	public String makeReservation(String source,String destination, PassengerBean passengerBean, ReservationBean reservationbean) throws ClassNotFoundException, SQLException
	{
		String output1="FAIL";
		String output2="FAIL";
		String finaloutput="FAIL";
		Connection connection=DBUtil.getDBConnection();
		
		id=generateReservationID(source,destination );
		reservationbean.setReservationID(id);
		
		
		
		Date date=new Date();
		
		PreparedStatement pstmt1=connection.prepareStatement("Insert into SRS_TBL_Reservation values(?,?,?,?,?,?,?,?)");
		pstmt1.setString(1, id);
		pstmt1.setString(2, reservationbean.getScheduleID());
		pstmt1.setDate(3, new java.sql.Date(date.getTime()));
		pstmt1.setDate(4,new java.sql.Date(reservationbean.getJourneyDate().getTime()));
		pstmt1.setInt(5,reservationbean.getNoOfSeats());
		pstmt1.setDouble(6,reservationbean.getTotalFare());
		pstmt1.setString(7,"BOOKED");		
		pstmt1.setString(8, ReservationPageThreeListener.creditcardno);
		int check1=pstmt1.executeUpdate();
		if(check1>0)
		{
			output2="SUCCESS";
		}
		PreparedStatement pstmt=connection.prepareStatement("Insert into SRS_TBL_PASSENGER values(?,?,?,?,?)");
		pstmt.setString(1, id );
		pstmt.setString(2, ReservationPageTwoListener.scheduleID );
		pstmt.setString(3, passengerBean.getName());
		pstmt.setInt(4, passengerBean.getAge());
		pstmt.setString(5,passengerBean.getGender() );
		int check=pstmt.executeUpdate();
		System.out.println("2nd check"+check);
		if(check>0)
		{
			output1="SUCCESS";
		}
		
		if(output1.equalsIgnoreCase("SUCCESS")&&output2.equalsIgnoreCase("SUCCESS"))
		{
			finaloutput="SUCCESS";
		}
				
		System.out.println("DAO "+finaloutput);		
		return finaloutput;
	}
	public ReservationBean printTicket(String reservationId) throws SQLException, ClassNotFoundException
		{
			PreparedStatement ps=DBUtil.getDBConnection().prepareStatement("select ReservationId,BookingDate,JourneyDate,NoOfSeats,TotalFare,BookingStatus from SRS_TBL_Reservation where ReservationId=?");
			ps.setString(1, reservationId);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				ReservationBean reservationBean=new ReservationBean();
				reservationBean.setReservationID(rs.getString(1));
				reservationBean.setBookingDate(rs.getDate(2));
				reservationBean.setJourneyDate(rs.getDate(3));
				reservationBean.setNoOfSeats(rs.getInt(4));
				reservationBean.setTotalFare(rs.getDouble(5));
				reservationBean.setBookingStatus(rs.getString(6));
				return reservationBean;
				
			}
			return null;
		}
		
		public PassengerBean printTicket1(String reservationId) throws ClassNotFoundException, SQLException
		{
			PreparedStatement ps=DBUtil.getDBConnection().prepareStatement("select Name,Age,Gender from SRS_TBL_Passenger where ReservationId=?");
			ps.setString(1, reservationId);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				PassengerBean passengerBean=new PassengerBean();
				passengerBean.setName(rs.getString(1));
				passengerBean.setAge(rs.getInt(2));
				passengerBean.setGender(rs.getString(3));
				return passengerBean;
				
			}
			return null;
		}
		public String CancelTicket(String reservationID) throws ClassNotFoundException, SQLException, ParseException 
		{
			String result="CANCELLATION FAILED";
			int flag=0;
			PreparedStatement ps=DBUtil.getDBConnection().prepareStatement("delete from SRS_TBL_PASSENGER where RESERVATIONID=?");
			ps.setString(1, reservationID);
			int row=ps.executeUpdate();
			if(row>0)
			{
				System.out.println("in 1st func");
				flag=1;
			}
			if(flag==1)
			{
				System.out.println("in 2nd");
				ReservationBean rBean=new ReservationBean();
				rBean=findByReservationId(reservationID);
				PreparedStatement pst=DBUtil.getDBConnection().prepareStatement("update SRS_TBL_RESERVATION set BOOKINGSTATUS='CANCELLED' where RESERVATIONID=?");
				pst.setString(1, reservationID);
				int row1=pst.executeUpdate();
				if(row1>0)
				{
					System.out.println("in 3rd");
					updatePassengerBalance(rBean.getCreditCardNumber(),rBean.getTotalFare());
					ScheduleBean sBean=new ScheduleBean();
					ScheduleDAO scheduleDAO=new ScheduleDAO();
					sBean=scheduleDAO.viewByScheduleId(rBean.getScheduleID());
					updateSeatsInShip(sBean.getShipID(), rBean.getNoOfSeats());
					result="CANCELLATION SUCCESSFULL";
				}
			}
			
			return result;
		}
		public ReservationBean findByReservationId(String reservationId) throws ClassNotFoundException, SQLException
		{
			PreparedStatement ps=DBUtil.getDBConnection().prepareStatement("select * from srs_tbl_reservation where RESERVATIONID=?");
			ps.setString(1, reservationId);
			ResultSet rs=ps.executeQuery();
			ReservationBean reservationBean=new ReservationBean();
			while(rs.next())
			{
				reservationBean.setReservationID(rs.getString(1));
				reservationBean.setScheduleID(rs.getString(2));
				reservationBean.setBookingDate(rs.getDate(3));
				reservationBean.setJourneyDate(rs.getDate(4));
				reservationBean.setNoOfSeats(rs.getInt(5));
				reservationBean.setTotalFare(rs.getDouble(6));
				reservationBean.setBookingStatus(rs.getString(7));
				reservationBean.setCreditCardNumber(rs.getString(8));
				return reservationBean;
			}
			return null;
			
			
		}
}
