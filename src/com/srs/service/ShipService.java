package com.wipro.srs.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.wipro.srs.bean.ShipBean;
import com.wipro.srs.dao.ScheduleDAO;
import com.wipro.srs.dao.ShipDAO;

public class ShipService 
{
	public String addShip(ShipBean shipbean)
	{
		System.out.println("service 1");
		if(shipbean==null || shipbean.getShipName().isEmpty() || shipbean.getShipName().length()<2)
			return "FAIL";
		ShipDAO aDao=new ShipDAO();
		try 
		{
			return aDao.addShip(shipbean);
				
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			return "FAILED";
		}			
	}
	public ShipBean viewByShipId(String ShipId)
	{
		System.out.println("service 2");
		ShipDAO aDao=new ShipDAO();
		try 
		{
			return aDao.viewByShipId(ShipId);
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			return null;
		}
	}
	public boolean modifyShip(ShipBean Shipbean)
	{
		System.out.println("service 3");
		if(Shipbean==null)
			return false;
		ShipDAO aDao=new ShipDAO();
		try 
		{
			return aDao.modifyShip(Shipbean);
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			return false;
		}		
	}
	public String removeShip(String ShipId)
	{
		System.out.println("service 4");
		ShipDAO aDao=new ShipDAO();
		try 
		{
			return aDao.removeShip(ShipId);
		} 
		catch (ClassNotFoundException | SQLException e)
		{

			return "FAIL";
		}
		
	}
	public ArrayList<ShipBean> viewByAllShips()
	{
		System.out.println("service 5");
		ShipDAO aDao=new ShipDAO();
		try 
		{
			return aDao.viewByAllShips();
		} 
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		return null;		
	}
	public ArrayList getShipId()
	{
		System.out.println("service 6");
		ShipDAO dao=new ShipDAO();
		try 
		{
			return dao.getShipId();
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		return null;
	}
}
