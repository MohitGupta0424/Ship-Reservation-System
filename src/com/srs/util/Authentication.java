package com.wipro.srs.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wipro.srs.bean.CredentialsBean;
import com.wipro.srs.bean.ProfileBean;

public class Authentication 
{
	public boolean authenticate(CredentialsBean credentialsBean) throws ClassNotFoundException, SQLException
	{
		boolean flag=false;
		Connection connection=DBUtil.getDBConnection();
		PreparedStatement pstmt =connection.prepareStatement("select * from SRS_TBL_User_Credentials where UserId=? and Password=?");
		pstmt.setString(1, credentialsBean.getUserID());
		pstmt.setString(2, credentialsBean.getPassword());
		ResultSet rs=pstmt.executeQuery();
		if(rs.next())
		{
			flag=true;
		}
		return flag;
		
	}
	
	public String authorize(String userId) throws ClassNotFoundException, SQLException
	{
		String flag="";
		Connection connection=DBUtil.getDBConnection();
		PreparedStatement pstmt =connection.prepareStatement("select UserType from SRS_TBL_User_Credentials where UserId=?");
		pstmt.setString(1, userId);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next())
		{
			if(rs.getString(1).equalsIgnoreCase("a")||rs.getString(1).equalsIgnoreCase("c"))
			{
				flag=rs.getString(1);
			}
		}
		return flag;
	}
	
	public boolean changeLoginStatus(String userID, int loginStatus) throws ClassNotFoundException, SQLException
	{
		boolean flag=false;
		Connection connection=DBUtil.getDBConnection();
		PreparedStatement pstmt =connection.prepareStatement("update SRS_TBL_User_Credentials set LoginStatus=? where UserId=? ");
		pstmt.setInt(1, loginStatus);
		pstmt.setString(2, userID);
		int check=pstmt.executeUpdate();
		if(check>0)
		{
			flag=true;
		}
		return flag;
	}
	
	public CredentialsBean findByUserID(String userID) throws ClassNotFoundException, SQLException
	{
		int flag=0;
		Connection connection=DBUtil.getDBConnection();
		PreparedStatement pstmt =connection.prepareStatement("select * from SRS_TBL_User_Credentials where UserId=?");
		pstmt.setString(1, userID);
		ResultSet rs=pstmt.executeQuery();
		CredentialsBean credentialsbean=new CredentialsBean();
		while(rs.next())
		{
			flag=1;
			credentialsbean.setUserID(rs.getString(1));
			credentialsbean.setPassword(rs.getString(2));
			credentialsbean.setUserType(rs.getString(3));
			credentialsbean.setLoginStatus(rs.getInt(4));
		}
		if(flag==1)
		{
			return credentialsbean;
		}
		else
		{
			return null;
		}
		
	}
	
	public boolean changePassword(CredentialsBean credentialsBean,String newPassword) throws ClassNotFoundException, SQLException
	{
		boolean flag=false;
		Connection connection=DBUtil.getDBConnection();
		PreparedStatement pstmt =connection.prepareStatement("update SRS_TBL_User_Credentials set Password=? where UserId=? ");
		pstmt.setString(1, newPassword);
		pstmt.setString(2, credentialsBean.getUserID());
		int check=pstmt.executeUpdate();
		if(check>0)
		{
			flag=true;
		}
		return flag;
		
		
	}
	
	public String register(ProfileBean profileBean) throws ClassNotFoundException, SQLException
	{
		String output="INVALID";
		Connection connection=DBUtil.getDBConnection();
		PreparedStatement pstmt1=connection.prepareStatement("insert into SRS_TBL_User_Credentials(UserId,Password) values(?,?)");
		pstmt1.setString(1,profileBean.getUserID());
		pstmt1.setString(2,profileBean.getPassword());
		
		PreparedStatement pstmt2 =connection.prepareStatement("insert into SRS_TBL_User_Profile(FirstName,LastName,DateOfBirth,Gender,Street,Location,City,State,PinCode,MobileNo,EmailId,UserId) values(?,?,?,?,?,?,?,?,?,?,?,?)");
		java.sql.Date dob=new java.sql.Date(profileBean.getDateOfBirth().getTime());
		pstmt2.setString(1, profileBean.getFirstName());
		pstmt2.setString(2, profileBean.getLastName());
		pstmt2.setDate(3, dob);
		pstmt2.setString(4, profileBean.getGender());
		pstmt2.setString(5, profileBean.getStreet());
		pstmt2.setString(6, profileBean.getLocation());
		pstmt2.setString(7, profileBean.getCity());
		pstmt2.setString(8, profileBean.getState());
		pstmt2.setString(9, profileBean.getPincode());
		pstmt2.setString(10, profileBean.getMobileNo());
		pstmt2.setString(11, profileBean.getEmailID());
		pstmt2.setString(12, profileBean.getUserID());
		
		int check1=pstmt1.executeUpdate();
		int check2=pstmt2.executeUpdate();
		
		if(check1>0 && check2>0)
		{
			output=profileBean.getUserID();
		}
		else
		{
			output="FAIL";
		}
		return output;
	}
	
	public String generateUserID(String firstname) throws ClassNotFoundException, SQLException
	{
		String id="";
		Connection connection=DBUtil.getDBConnection();
		PreparedStatement pstmt=connection.prepareStatement("select SRS_SEQ_USER_ID.nextval from dual");
		ResultSet rs=pstmt.executeQuery();
		if(rs.next())
		{
			id=firstname.substring(0, 2).toUpperCase()+rs.getInt(1);
		}
		return id;
	}


}
