package com.wipro.srs.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JOptionPane;

import com.wipro.srs.bean.RouteBean;
import com.wipro.srs.bean.ScheduleBean;
import com.wipro.srs.util.DBUtil;

public class RouteDAO
{
	public String addRoute(RouteBean routebean) throws SQLException, ClassNotFoundException 
	{
		Calendar today=Calendar.getInstance();
		if(today.get(Calendar.DAY_OF_WEEK)==3)
		{
		String result="FAIL";
		PreparedStatement ps=DBUtil.getDBConnection().prepareStatement("insert into SRS_TBL_Route values(?,?,?,?,?)");
		ps.setString(1,routebean.getRouteID());
		ps.setString(2,routebean.getSource().toUpperCase());
		ps.setString(3,routebean.getDestination().toUpperCase());
		ps.setString(4,routebean.getTravelDuration());
		ps.setDouble(5, routebean.getFare());
		int rows=ps.executeUpdate();
		if(rows==1)
		{
			return result="SUCCESS";
		}
		else
		{
			return result;
		}
		}
		else
			return "Update only on Tuesday";
	}
	
	public String generateRouteId(String source,String destination) throws SQLException, ClassNotFoundException
	{
		String id="";
		int seq = 0;
		PreparedStatement ps=DBUtil.getDBConnection().prepareStatement("select SRS_SEQ_ROUTE_ID.nextval from dual");
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			seq=rs.getInt(1);
		}
		id=source.substring(0,2).toUpperCase()+destination.substring(0,2).toUpperCase()+seq;
		return id;
		
	}


	public ArrayList<RouteBean> viewByAllRoute() throws SQLException, ClassNotFoundException
    {
		ArrayList<RouteBean> list=new ArrayList<RouteBean>();
		
		PreparedStatement ps=DBUtil.getDBConnection().prepareStatement("select * from SRS_TBL_Route ");
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			RouteBean routeBean=new RouteBean();
			routeBean.setRouteID(rs.getString(1));
			routeBean.setSource(rs.getString(2).toUpperCase());
			routeBean.setDestination(rs.getString(3).toUpperCase());
			routeBean.setTravelDuration(rs.getString(4));
			routeBean.setFare(rs.getDouble(5));
			list.add(routeBean);
		}
		return list;
	}
	
	public int removeRoute(String routeid) throws ClassNotFoundException, SQLException 
	{
		Calendar today=Calendar.getInstance();
		int flag=0;
		if(today.get(Calendar.DAY_OF_WEEK)==3)
		{
	
		PreparedStatement ps=DBUtil.getDBConnection().prepareStatement("delete from SRS_TBL_Route where RouteId=?"); 
		ps.setString(1,routeid);
		int rows=ps.executeUpdate();
		if(rows==1)
		{
			return flag=1;
		}
		else
		{
			return flag;
		}
		}
		else
			JOptionPane.showMessageDialog(null,"Update Only On Tuesday","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
		return flag;
		

	}
	
	public boolean modifyRoute(RouteBean routebean) throws ClassNotFoundException, SQLException
	{
		boolean flag=false;
		Calendar today=Calendar.getInstance();
		if(today.get(Calendar.DAY_OF_WEEK)==3)
		{
		
		PreparedStatement ps=DBUtil.getDBConnection().prepareStatement("update SRS_TBL_Route set Source=?, Destination=?, TravelDuration=?, Fare=? where RouteId=?"); 
		ps.setString(1,routebean.getSource().toUpperCase());
		ps.setString(2,routebean.getDestination().toUpperCase());
		ps.setString(3,routebean.getTravelDuration());
		ps.setDouble(4,routebean.getFare());
		ps.setString(5,routebean.getRouteID());
		int rows=ps.executeUpdate();
	    if(rows>0)
		{
			return true;
		}
	    else
		{
			return flag;
		}
		}
		else
			JOptionPane.showMessageDialog(null,"Update Only On Tuesday","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
		return flag;

	}
	
	public RouteBean viewByRouteId(String routeid) throws ClassNotFoundException, SQLException
	{
		RouteBean routeBean=new RouteBean();
		PreparedStatement ps=DBUtil.getDBConnection().prepareStatement("select * from SRS_TBL_Route where RouteId=?");
		ps.setString(1,routeid);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			routeBean.setRouteID(rs.getString(1));
			routeBean.setSource(rs.getString(2).toUpperCase());
			routeBean.setDestination(rs.getString(3).toUpperCase());
			routeBean.setTravelDuration(rs.getString(4));
			routeBean.setFare(rs.getDouble(5));
			return routeBean;
		}
		return null;
		
	}
	public ArrayList<RouteBean> viewBySourceDestination(String Source,String Destination) throws ClassNotFoundException, SQLException
	{
		
		ArrayList<RouteBean> ai=new ArrayList<RouteBean>();
		PreparedStatement ps=DBUtil.getDBConnection().prepareStatement("select * from SRS_TBL_Route where SOURCE=? and DESTINATION=?");
		ps.setString(1, Source);
		ps.setString(2, Destination);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			
			RouteBean routeBean=new RouteBean();
			routeBean.setRouteID(rs.getString(1));
			routeBean.setSource(rs.getString(2));
			routeBean.setDestination(rs.getString(3));
			routeBean.setTravelDuration(rs.getString(4));
			routeBean.setFare(rs.getDouble(5));
			ai.add(routeBean);			
		}
		return ai;
	}
	public ArrayList getRouteId() throws ClassNotFoundException, SQLException
	{
		ArrayList list=new ArrayList<RouteBean>();
		String x2="";
		PreparedStatement ps=DBUtil.getDBConnection().prepareStatement("select RouteId from SRS_TBL_Route");
		ResultSet r=ps.executeQuery();
		while(r.next())
		{
			x2=r.getString(1);
			list.add(x2);
		}
		return list;
	}

}
