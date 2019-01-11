package com.wipro.srs.service;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.wipro.srs.bean.RouteBean;
import com.wipro.srs.dao.RouteDAO;
import com.wipro.srs.dao.ShipDAO;

public class RouteService
{
	RouteDAO dao=new RouteDAO();

	public String addRoute(RouteBean routebean)
	{
		try 
		{
			if(routebean==null)
			{
				return "Enter the Data in blank fields";
			}
			else if(routebean.getSource()==null||routebean.getDestination()==null||routebean.getSource().isEmpty()||routebean.getDestination().isEmpty())
			{
				return "Enter the valid source and destinations"; 
			}
			else if(routebean.getSource().length()<2)
			{
				return "Enter more than 1 character in Source";
			}
			else if(routebean.getDestination().length()<2)
			{
				return "Enter more than 1 character in Destination";
			}
			
			else if(routebean.getTravelDuration()==null||routebean.getTravelDuration().isEmpty()||routebean.getTravelDuration().length()<=0)
			{
				return "Invalid Travel Duration";
			}
			else if(routebean.getTravelDuration().equals("0"))
			{
				return "Travel Duration Cannot be 0 Hours";
			}
			
			else if(routebean.getFare()<=0)
			{
				return "Fare should be greater than zero";
			}
			else
			{
				if(routebean.getSource().equalsIgnoreCase(routebean.getDestination()))
				{
					return "Source and Destination cannot be same";
				}
				else
				{
					String id=(dao.generateRouteId(routebean.getSource(),routebean.getDestination()));
					routebean.setRouteID(id);

					String result=dao.addRoute(routebean);
					if(result=="SUCCESS")
					{ 
						return "Added Successfully";
					}
					else
					{
						return "FAIL";
					}
				}
			}
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{	
			e.printStackTrace();

			//return "Invalid Data";
		}
		return null;
	}

	public ArrayList<RouteBean> viewByAllRoute()
	{
		ArrayList<RouteBean> list=new ArrayList<RouteBean>();
		try 
		{
			list=dao.viewByAllRoute();
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return list;
	}

	public int removeRoute(String routeid) 
	{
		int flag = 0;
		if(routeid!=null||!routeid.isEmpty()||routeid.matches("[0-9A-Za-z]+"))
		{
			try 
			{ 
				System.out.println("service");
				flag=dao.removeRoute(routeid);
				System.out.println(flag);
			} 
			catch (ClassNotFoundException e) 
			{
				JOptionPane.showMessageDialog(null,"Schedule Already Created.Cannot Delete the Route","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
			} 
			catch (SQLException e) 
			{
				JOptionPane.showMessageDialog(null,"Schedule Already Created.Cannot Delete the Route","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
			}
		}
		return flag;
	}

	public boolean modifyRoute(RouteBean routebean)
	{
		boolean flag=false;
		
		try 
		{
			if(routebean==null)
			{
				return false;
			}
			else if(routebean.getRouteID()==null||routebean.getRouteID().isEmpty())
			{
				return false;
			}
			else if(routebean.getSource()==null||routebean.getDestination()==null||routebean.getSource().isEmpty()||routebean.getDestination().isEmpty()||routebean.getSource().length()<2||routebean.getDestination().length()<2)
			{
				return false;
			}
			
			else if(routebean.getTravelDuration()==null||routebean.getTravelDuration().isEmpty()||routebean.getTravelDuration().length()<=0||routebean.getTravelDuration().equals("0"))
			{
				return false;
			}
			
			else
			{
				if(routebean.getSource().equalsIgnoreCase(routebean.getDestination()))
				{
					return false;
				}
				else
				{
					return  flag=dao.modifyRoute(routebean);
				}
			}
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return flag;
	} 

	public RouteBean viewByRouteId(String routeid)
	{
		RouteBean routeBean=new RouteBean();
		if(routeid!=null||!routeid.isEmpty()||routeid.matches("[0-9A-Za-z]+"))
		{
			try 
			{
				routeBean=dao.viewByRouteId(routeid);
			} 
			catch (ClassNotFoundException e) 
			{
				e.printStackTrace();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return routeBean;
	}
	public ArrayList<RouteBean> viewBySourceDestination(String Source,String Destination)
	{
		RouteDAO routeDao=new RouteDAO();
		try {
			return routeDao.viewBySourceDestination(Source, Destination);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;		
	}
	public ArrayList getRouteId()
	{
		
		RouteDAO dao=new RouteDAO();
		try 
		{
			return dao.getRouteId();
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		return null;
	}
}
