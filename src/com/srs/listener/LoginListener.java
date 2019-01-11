package com.wipro.srs.listener;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.wipro.srs.bean.CredentialsBean;
import com.wipro.srs.ui.Admin;
import com.wipro.srs.ui.Customer;
import com.wipro.srs.ui.Login;
import com.wipro.srs.ui.Register;
import com.wipro.srs.util.User;

public class LoginListener implements ActionListener
{
	Login loginobj;
	public static String usertype;
	public static String userid;
	public static String password;
	public LoginListener(Login loginobj)
	{
		this.loginobj=loginobj;	
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		if(e.getSource()==loginobj.btn_login)
		{
			System.out.println("1123");
			userid=loginobj.txt_username.getText();
			password=String.valueOf(loginobj.pwd_password.getPassword());
			User obj=new User();
			CredentialsBean credentialsBean=new CredentialsBean();
			if(loginobj.txt_username.getText().isEmpty())
			{
				loginobj.msg=new JOptionPane();
				loginobj.msg.showMessageDialog(null,"USERNAME CAN'T BE LEFT EMPTY","ERROR",JOptionPane.ERROR_MESSAGE);
				
			}
			else if(String.valueOf(loginobj.pwd_password.getPassword()).isEmpty())
			{
				loginobj.msg.showMessageDialog(null,"PASSWORD CAN'T BE LEFT EMPTY","ERROR",JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				credentialsBean.setUserID(loginobj.txt_username.getText());
				credentialsBean.setPassword(String.valueOf(loginobj.pwd_password.getPassword()));
				String output=obj.login(credentialsBean);
				usertype=output;
				if(output.equalsIgnoreCase("c"))
				{
					loginobj.frame1.setVisible(false);
					Customer cust=new Customer();
				
				}
				else if(output.equalsIgnoreCase("a"))
				{
					loginobj.frame1.setVisible(false);
					Admin adm=new Admin();
				}
				else
				{
					
					loginobj.msg.showMessageDialog(null,"USERNAME OR PASSWORD INCORRECT","ERROR",JOptionPane.ERROR_MESSAGE);
				}
			
			
			}
		}
		if(e.getSource()==loginobj.btn_register)
		{
			loginobj.frame1.setVisible(false);
			Register reg=new Register();
		}
	}
}
		
		
		
		
		
