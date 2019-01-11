package com.wipro.srs.util;

import java.sql.SQLException;

import com.wipro.srs.bean.CredentialsBean;
import com.wipro.srs.bean.ProfileBean;

public class User
{
	public String login(CredentialsBean credentialsBean)
	{
		//Return value must be either: "A", "C", "FAIL", “INVALID”
		//A->Admin, C->Customer
		//Wrong username/password should return INVALID.
		String output="";
		int f=0;
		String op="";
		try
		{
			if(credentialsBean==null)
			{
				return "INVALID";
			}
			else
			{
				if(credentialsBean.getUserID()==null || credentialsBean.getPassword()==null)
				{
					return "INVALID USERNAME or PASSWORD";
				}
				else if(credentialsBean.getUserID().isEmpty()|| credentialsBean.getPassword().isEmpty())
				{
					return "INVALID USERNAME or PASSWORD";
				}
				else
				{
					Authentication obj=new Authentication();
					boolean authenticate=obj.authenticate(credentialsBean);
					String authorize=obj.authorize(credentialsBean.getUserID());
					if(authenticate==true && (authorize.equalsIgnoreCase("a")||authorize.equalsIgnoreCase("c")))
					{
						boolean flag=obj.changeLoginStatus(credentialsBean.getUserID(), 1);
						f=1;
						op=authorize;
						credentialsBean.setLoginStatus(1);
					}
					else
					{
						return "INVALID";
					}
				
				}
			}
			if(f==1)
			{
				output=op;
			}
			else
			{
				output="FAIL";
			}
		}
		 catch (ClassNotFoundException e) 
		 {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 } 
		 catch (SQLException e) 
		 {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return output;
	}
	
	public boolean logout(String userId)
	{
		boolean flag=false;
		try 
		{
			
			Authentication obj=new Authentication();
			CredentialsBean credentialsBean=obj.findByUserID(userId);
			if(credentialsBean.getLoginStatus()==1)
			{
				flag=obj.changeLoginStatus(userId, 0);
			}
			if(flag==true)
			{
				credentialsBean.setLoginStatus(0);
			}
		} 
		catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	public String changePassword(CredentialsBean credentialsBean, String newPassword)
	{
		//Return value must be either: "SUCCESS", "FAIL", “INVALID”
		Authentication obj=new Authentication();
		String output="";
		try 
		{
			boolean flag=obj.changePassword(credentialsBean, newPassword);
			if(flag==true)
			{
				output="SUCCESS";
			}
			else
			{
				output="FAIL";
			}
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return output;
		
	}
	
	public String register(ProfileBean profileBean)
	{
		//Return value must be either: <userId of lenght 6>, "FAIL"
		//Note: userId-> first 2 letter of first name followed by 4 digit auto generated number
		Authentication obj=new Authentication();
		String output="";
		try 
		{
			String id=obj.generateUserID(profileBean.getFirstName());
			profileBean.setUserID(id);
			output=obj.register(profileBean);
		} 
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return output;
		
	}
	
}
