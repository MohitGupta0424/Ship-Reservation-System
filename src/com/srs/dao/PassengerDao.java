package com.wipro.srs.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;



import java.util.Iterator;

import com.wipro.srs.bean.PassengerBean;
import com.wipro.srs.bean.PassengerTempBean;
import com.wipro.srs.bean.ReservationBean;
import com.wipro.srs.bean.ScheduleBean;
import com.wipro.srs.bean.ShipBean;
import com.wipro.srs.util.DBUtil;

public class PassengerDao 
{
	public ArrayList<PassengerTempBean> viewPassenger(String shipId,Date date) throws ClassNotFoundException, SQLException
	{
		ArrayList<PassengerTempBean> passengeral=new ArrayList<PassengerTempBean>();
		ScheduleDAO scheduleDAO=new ScheduleDAO();
		ScheduleBean sBean=new ScheduleBean();
		sBean=scheduleDAO.viewBySidDate(shipId, date);
		ShipDAO sDao=new ShipDAO();
		ShipBean shipBean=new ShipBean();
		shipBean=sDao.viewByShipId(shipId);
		//PassengerTempBean pTempBean=new PassengerTempBean();
		
		ArrayList<PassengerBean> al=new ArrayList<PassengerBean>();
		PreparedStatement pmt=DBUtil.getDBConnection().prepareStatement("select * from srs_tbl_passenger where SCHEDULEID=?");
		pmt.setString(1, sBean.getScheduleID());
		ResultSet rs=pmt.executeQuery();
		while(rs.next())
		{
			PassengerBean pBean=new PassengerBean();
			pBean.setReservationID(rs.getString(1));
			pBean.setScheduleID(rs.getString(2));
			pBean.setName(rs.getString(3));
			pBean.setAge(rs.getInt(4));
			pBean.setGender(rs.getString(5));
			al.add(pBean);
			
		}
		
		
		Iterator<PassengerBean> i=al.iterator();
		while(i.hasNext())
		{
			PassengerTempBean pTempBean=new PassengerTempBean();
			PassengerBean passengerBean=new PassengerBean();
			passengerBean=i.next();
			/*PreparedStatement pmt1=DBUtil.getDBConnection().prepareStatement("Select NOOFSEATS from SRS_TBL_RESERVATION where SCHEDULEID=?");
			pmt1.setString(1, passengerBean.getScheduleID());
			ResultSet rs1=pmt1.executeQuery();
			while(rs1.next())
			{
				pTempBean.setNoOfSeats(rs.getInt(1));
			}*/
			pTempBean.setJourneyDate(date);
			pTempBean.setShipId(shipId);
			pTempBean.setShipName(shipBean.getShipName());
			pTempBean.setName(passengerBean.getName());
			pTempBean.setAge(passengerBean.getAge());
			pTempBean.setGender(passengerBean.getGender());
			passengeral.add(pTempBean);
			
			
		}
		
		
		
		return passengeral;
		
	}
}
