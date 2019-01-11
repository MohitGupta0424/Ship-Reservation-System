package com.wipro.srs.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import com.wipro.srs.bean.ScheduleBean;
import com.wipro.srs.dao.RouteDAO;
import com.wipro.srs.dao.ScheduleDAO;
import com.wipro.srs.dao.ShipDAO;

public class ScheduleService
{
	public String addSchedule(ScheduleBean schedulebean) 
	{
		String st=" ";
		ScheduleDAO dao= new ScheduleDAO();
		if(schedulebean==null )
		{
			return "Enter The Data In Blank Fields";
		}
		/*else if(schedulebean.getShipID()==null||schedulebean.getShipID().isEmpty())
		{
			return "Enter Valid Ship Id";
		}
		else if(schedulebean.getShipID().length()<6)
		{
			return "INVALID SHIP ID";
		}
		else if(schedulebean.getRouteID()==null||schedulebean.getRouteID().isEmpty())
		{
			return "Enter Valid Route Id";
		}
		else if(schedulebean.getRouteID().length()<8)
		{
			return "INVALID ROUTE ID";
		}*/
		else if(schedulebean.getStartDate()==null||schedulebean.getStartDate().toString().isEmpty())
		{
			return "Enter Appropriate Date";
		}
		try 
		{
			schedulebean.setScheduleID(dao.generateScheduleId(schedulebean));
		} 
		catch (ClassNotFoundException | SQLException e1) 
		{
			st="INVALID DATA";
		}
		try 
		{
			RouteDAO rDao=new RouteDAO();
			ShipDAO sDao=new ShipDAO();
			if(sDao.viewByShipId(schedulebean.getShipID())==null)
			{
				st="Invalid Ship Id";
			}
			else if(rDao.viewByRouteId(schedulebean.getRouteID())==null)
			{
				st="Invalid Route Id";
			}
			else	
			return dao.addSchedule(schedulebean);
			
			
		} 
		catch (ClassNotFoundException | SQLException e)
		{
			st="INVALID ROUTE ID OR SHIP ID";
		}
		
		return st;
		
	}
	public boolean modifySchedule(ScheduleBean schedulebean)
	{
		boolean fl=false;
		
		ScheduleDAO dao= new ScheduleDAO();
		try 
		{
			if(dao.modifySchedule(schedulebean)==true)
			{
				fl=true;
			}
		}
		catch (ClassNotFoundException | SQLException e)
		{
			fl=false;
		}
		return fl;
		
	}
	public String removeSchedule(String scheduleid)
	{
		ScheduleDAO dao= new ScheduleDAO();
		
		try
		{
			if(dao.removeSchedule(scheduleid).equalsIgnoreCase("SUCCESS"))
			{
				return "SUCCESS";
			}
			
		} 
		catch (ClassNotFoundException | SQLException e)
		{
			
			e.printStackTrace();
		}
		return "FAIL";
		
	}
	public ArrayList<ScheduleBean> viewByAllSchedule()
	{
		ScheduleDAO dao= new ScheduleDAO();

		try
		{
			return dao.viewByAllSchedule();
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		return null;
		
	}
	public ScheduleBean viewByScheduleId(String scheduleid)
	{
		ScheduleDAO dao= new ScheduleDAO();
		ScheduleBean bean=new ScheduleBean();
		boolean flag=false;
		try
		{
			try 
			{
				bean=dao.viewByScheduleId(scheduleid);
				flag=true;
				
			} 
			catch (ParseException e) 
			{
				e.printStackTrace();
			}
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		if(flag==true)
		{
			return bean;
		}
		else
		{
			return null;
		}
	}
	public ArrayList getScheduleId()
	{
		ScheduleDAO dao= new ScheduleDAO();
		try 
		{
			return dao.getScheduleId();
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<ScheduleBean> viewByRidDate(String RouteId,Date date)
	{
		ScheduleDAO scheduleDao=new ScheduleDAO();
		try 
		{
			return scheduleDao.viewByRidDate(RouteId, date);
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*public ScheduleBean viewBySidDate(String ShipId,Date date)
	{
		ScheduleDAO dao=new ScheduleDAO();
		try {
			return dao.viewBySidDate(ShipId, date);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}*/
}
