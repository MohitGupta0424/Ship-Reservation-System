package com.wipro.srs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import com.wipro.srs.bean.ScheduleBean;
import com.wipro.srs.bean.ShipBean;
import com.wipro.srs.util.DBUtil;

public class ShipDAO
{
	public String addShip(ShipBean shipbean) throws SQLException, ClassNotFoundException
	{
		//System.out.println("dao 1");
		Calendar today=Calendar.getInstance();
		if(today.get(Calendar.DAY_OF_WEEK)==3)
		{
		PreparedStatement pmt=DBUtil.getDBConnection().prepareStatement("insert into SRS_TBL_Ship values(?,?,?,?)");
		pmt.setString(1, shipbean.getShipID());
		pmt.setString(2,shipbean.getShipName());
		pmt.setInt(3,shipbean.getSeatingCapacity());
		pmt.setInt(4,shipbean.getReservationCapacity());
		//pmt.setInt(5,shipbean.getReservationCapacity());
		
		int row=pmt.executeUpdate();
		if(row>0)
			return "Success";
		}
		return "Update Only on Tuesday";		
	}
	public String generateShipId(ShipBean shipBean) throws SQLException, ClassNotFoundException
	{
		//System.out.println("dao 2");
		int id = 0;
		String shipId="";
		PreparedStatement pmt=DBUtil.getDBConnection().prepareStatement("select SRS_SEQ_SHIP_ID.nextval from dual");
		ResultSet rs=pmt.executeQuery();
		while(rs.next())
		{
			id=rs.getInt(1);
		}
		shipId=shipBean.getShipName().trim().substring(0, 2).toUpperCase()+""+id;
		return shipId;
	}
	public boolean modifyShip(ShipBean Shipbean) throws ClassNotFoundException, SQLException
	{
		//System.out.println("dao 3");
		Calendar today=Calendar.getInstance();
		if(today.get(Calendar.DAY_OF_WEEK)==3)
		{
		PreparedStatement pmt=DBUtil.getDBConnection().prepareStatement("update SRS_TBL_Ship set ShipName=?,SeatingCapacity=?,ReservationCapacity=? where ShipId=?");
		pmt.setString(1, Shipbean.getShipName());
		pmt.setInt(2, Shipbean.getSeatingCapacity());
		pmt.setInt(3, Shipbean.getReservationCapacity());
		pmt.setString(4, Shipbean.getShipID());
		int row=pmt.executeUpdate();
		if(row>0){
			return true;}
		}
		return false;		
	}
	public String removeShip(String ShipId) throws ClassNotFoundException, SQLException
	{
		//System.out.println("dao 4");
		Calendar today=Calendar.getInstance();
		if(today.get(Calendar.DAY_OF_WEEK)==3)
		{
	    Connection connection=DBUtil.getDBConnection();
		PreparedStatement pmt=connection.prepareStatement("delete SRS_TBL_Ship where  ShipId=?");
		pmt.setString(1,ShipId );
		int row=pmt.executeUpdate();
		if(row>0)
		{
			return "SUCCESS";
		
		}
		else
		{
		return "INVALID USER ID";
		}
		}
		else
			return "Update only on Tuesday";
		
	}
	public ArrayList<ShipBean> viewByAllShips() throws ClassNotFoundException, SQLException
	{
		//System.out.println("dao 5");
		ArrayList<ShipBean> ai=new ArrayList<ShipBean>();	
		PreparedStatement pmt=DBUtil.getDBConnection().prepareStatement("select * from SRS_TBL_Ship");
		ResultSet rs=pmt.executeQuery();
		while(rs.next())
		{
			ShipBean shipBean=new ShipBean();
			shipBean.setShipID(rs.getString(1));
			shipBean.setShipName(rs.getString(2));
			shipBean.setSeatingCapacity(rs.getInt(3));
			shipBean.setReservationCapacity(rs.getInt(4));
			//shipBean.setFixedSeats(rs.getInt(5));
			ai.add(shipBean);
			
		}
		return ai;
	}
	public ShipBean viewByShipId(String ShipId) throws ClassNotFoundException, SQLException
	{
		//System.out.println("dao 6");
		PreparedStatement pmt=DBUtil.getDBConnection().prepareStatement("select * from SRS_TBL_Ship where ShipId=?");
		pmt.setString(1,ShipId );
		ResultSet rs=pmt.executeQuery();
		
		while(rs.next())
		{
			ShipBean shipBean=new ShipBean();
			shipBean.setShipID(rs.getString(1));
			shipBean.setShipName(rs.getString(2));
			shipBean.setSeatingCapacity(rs.getInt(3));
			shipBean.setReservationCapacity(rs.getInt(4));
			//shipBean.setFixedSeats(rs.getInt(5));
			return shipBean;
		}
		return null;
	}
	public ArrayList getShipId() throws ClassNotFoundException, SQLException
	{
		//System.out.println("dao 7");
		ArrayList list=new ArrayList<ShipBean>();
		String x="";
		PreparedStatement ps=DBUtil.getDBConnection().prepareStatement("select ShipId from srs_tbl_ship");
		ResultSet r=ps.executeQuery();
		while(r.next())
		{
			x=r.getString(1);
			list.add(x);
		}
		return list;
		
	}
}
