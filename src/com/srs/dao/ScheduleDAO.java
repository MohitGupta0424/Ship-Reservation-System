package com.wipro.srs.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.wipro.srs.bean.ScheduleBean;
import com.wipro.srs.util.DBUtil;

public class ScheduleDAO 
{
	public String generateScheduleId(ScheduleBean schedulebean) throws ClassNotFoundException, SQLException
	{
		int s=0;
		String seq=" ";
		PreparedStatement ps=DBUtil.getDBConnection().prepareStatement("select SRS_SEQ_SCHEDULE_ID.nextval from dual");
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			s=rs.getInt(1);
		}
		seq=schedulebean.getRouteID().substring(0,4).toUpperCase()+s;
		return seq;
		
	}
	public String addSchedule(ScheduleBean schedulebean) throws ClassNotFoundException, SQLException
	{
		String s="FAIL";
		Calendar today=Calendar.getInstance();
		if(today.get(Calendar.DAY_OF_WEEK)==3)
		{
		PreparedStatement pst=DBUtil.getDBConnection().prepareStatement("select * from SRS_TBL_Schedule where ShipId=? and trunc(StartDate)=?");
		pst.setString(1, schedulebean.getShipID());
		pst.setDate(2, new java.sql.Date( schedulebean.getStartDate().getTime()));
		ResultSet rs=pst.executeQuery();
		while(rs.next())
		{
			//System.out.println("hihi");
			return "Cannot Assign different Schedule to the Same Ship On Same Date";
		}
		//System.out.println("hjkl");
		
		Date dt=schedulebean.getStartDate();
		java.sql.Date date=new java.sql.Date(dt.getTime());
		PreparedStatement ps=DBUtil.getDBConnection().prepareStatement("insert into SRS_TBL_Schedule  values(?,?,?,?)");
		ps.setString(1,schedulebean.getScheduleID());
		ps.setString(2,schedulebean.getShipID());
		ps.setString(3,schedulebean.getRouteID());
		ps.setDate(4,date);
		int rows=ps.executeUpdate();
		if(rows>0)
		{
			s="SUCCESS";
		}
		}
		else
			s="Update only on TUESDAY";
		return s;
	}
	public boolean modifySchedule(ScheduleBean schedulebean) throws ClassNotFoundException, SQLException
	{
		//System.out.println("3");
		boolean f=false;
		Calendar today=Calendar.getInstance();
		if(today.get(Calendar.DAY_OF_WEEK)==3)
		{
			Date dt=schedulebean.getStartDate();
			java.sql.Date date=new java.sql.Date(dt.getTime());
			PreparedStatement ps=DBUtil.getDBConnection().prepareStatement("update SRS_TBL_Schedule set shipId=?,RouteId=?,StartDate=? where scheduleId=?");
			ps.setString(1,schedulebean.getShipID());
			ps.setString(2,schedulebean.getRouteID());
			ps.setDate(3,date);
			ps.setString(4,schedulebean.getScheduleID());
			int rows=ps.executeUpdate();
			if(rows>0)
			{
				f=true;
			}
		}
		
		return f;
		
	}
	public String removeSchedule(String scheduleid) throws ClassNotFoundException, SQLException
	{
		Calendar today=Calendar.getInstance();
		if(today.get(Calendar.DAY_OF_WEEK)==3)
		{
			PreparedStatement ps=DBUtil.getDBConnection().prepareStatement("delete from  SRS_TBL_Schedule where scheduleId=?");
			ps.setString(1,scheduleid);
			int rt=ps.executeUpdate();

			if(rt>0)
			{
				return "SUCCESS";
				
			}
		}
		else
		{
			return "Update only on TUESDAY";
		}
		
		return "Update only on Tuesday";
	}
	public ArrayList<ScheduleBean> viewByAllSchedule() throws ClassNotFoundException, SQLException
	{
		ArrayList<ScheduleBean> al=new ArrayList<ScheduleBean>();
		PreparedStatement ps=DBUtil.getDBConnection().prepareStatement("select * from  SRS_TBL_Schedule");
		ResultSet r=ps.executeQuery();
		while(r.next())
		{
			ScheduleBean bean=new ScheduleBean();
			bean.setScheduleID(r.getString(1));
			bean.setShipID(r.getString(2));
			bean.setRouteID(r.getString(3));
			bean.setStartDate(r.getDate(4));
			al.add(bean);
		}
		return al;
		
	}
	public ScheduleBean viewByScheduleId(String scheduleid) throws ClassNotFoundException, SQLException, ParseException
	{
		PreparedStatement ps=DBUtil.getDBConnection().prepareStatement("select * from  srs_tbl_schedule where ScheduleId=?");
		ps.setString(1,scheduleid);
		ResultSet rst=ps.executeQuery();
		while(rst.next())
		{
			ScheduleBean bean=new ScheduleBean();
			bean.setScheduleID(rst.getString(1));
			bean.setShipID(rst.getString(2));
			bean.setRouteID(rst.getString(3));
			//SimpleDateFormat formatter=new SimpleDateFormat("dd-MMM-yyyy");
			//String date = formatter.format(rst.getDate(4));
			//Date utilDate=formatter.parse(date);
			bean.setStartDate(rst.getDate(4));
			
			return bean;
		}
		
			return null;
		
	}
	public ArrayList getScheduleId() throws ClassNotFoundException, SQLException
	{
		ArrayList list=new ArrayList<ScheduleBean>();
		String x="";
		PreparedStatement ps=DBUtil.getDBConnection().prepareStatement("select ScheduleId from srs_tbl_schedule");
		ResultSet r=ps.executeQuery();
		while(r.next())
		{
			x=r.getString(1);
			list.add(x);
		}
		return list;
		
	}
	public ArrayList<ScheduleBean> viewByRidDate(String RouteId,Date date) throws ClassNotFoundException, SQLException
	{
		
		
		ArrayList<ScheduleBean> ai=new ArrayList<ScheduleBean>();
		
		PreparedStatement ps=DBUtil.getDBConnection().prepareStatement("Select * from srs_tbl_schedule where ROUTEID=? and trunc(STARTDATE)=?");
		ps.setString(1, RouteId);
		ps.setDate(2,new java.sql.Date(date.getTime()));
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			System.out.println("yu");
			ScheduleBean scheduleBean=new ScheduleBean();
			scheduleBean.setScheduleID(rs.getString(1));
			scheduleBean.setShipID(rs.getString(2));
			scheduleBean.setRouteID(rs.getString(3));
			scheduleBean.setStartDate(date);
			ai.add(scheduleBean);
		}
		return ai;
	}
	public ScheduleBean viewBySidDate(String ShipId,Date date) throws ClassNotFoundException, SQLException 
	{

		ScheduleBean scheduleBean=new ScheduleBean();
		PreparedStatement ps=DBUtil.getDBConnection().prepareStatement("Select * from srs_tbl_schedule where SHIPID=? and trunc(STARTDATE)=?");
		ps.setString(1, ShipId);
		ps.setDate(2,new java.sql.Date(date.getTime()));
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			//System.out.println("yu");
			
			scheduleBean.setScheduleID(rs.getString(1));
			scheduleBean.setShipID(rs.getString(2));
			scheduleBean.setRouteID(rs.getString(3));
			scheduleBean.setStartDate(date);
		
		}
		return scheduleBean;
	}

}
