package com.wipro.srs.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.wipro.srs.bean.CredentialsBean;
import com.wipro.srs.ui.Admin;
import com.wipro.srs.ui.ChangePassword;
import com.wipro.srs.ui.Customer;
import com.wipro.srs.util.User;

public class ChangePasswordListener implements ActionListener
{
	ChangePassword cp;
	
	public ChangePasswordListener(ChangePassword cp)
	{
		this.cp=cp;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		if(e.getSource()==cp.btn_CHANGE)
		{
			String output="";
			String userid=cp.txt_userid.getText();
			String oldpassword=LoginListener.password;
			String new_password=String.valueOf(cp.pwd_NEWPASSWORD.getPassword());
			String confirm_password=String.valueOf(cp.pwd_CONFIRMPASSWORD.getPassword());
			if(oldpassword.equalsIgnoreCase((String.valueOf(cp.pwd_OLDPASSWORD.getPassword()))))
			{
				
				if(new_password.equalsIgnoreCase((confirm_password)))
				{
					User obj=new User();
					CredentialsBean credentialsBean=new CredentialsBean();
					credentialsBean.setUserID(userid);
					output=obj.changePassword(credentialsBean, new_password);
				}
				else
				{
					cp.msg=new JOptionPane();
					cp.msg.showMessageDialog(null,"PASSWORD RE-ENTERED IS NOT THE SAME ","ERROR",JOptionPane.ERROR_MESSAGE);
				}
			}
			else
			{
				System.out.println(oldpassword);
				cp.msg.showMessageDialog(null,"OLD PASSWORD INCORRECT","ERROR",JOptionPane.ERROR_MESSAGE);

			}
			
			
			if(output=="SUCCESS")
			{
				
				cp.msg.showMessageDialog(null,"PASSWORD CHANGED SUCCESSFULLY","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
				cp.pwd_NEWPASSWORD.setText("");
				cp.pwd_CONFIRMPASSWORD.setText("");
				cp.pwd_OLDPASSWORD.setText("");
				cp.btn_CHANGE.setVisible(false);
				
			}
		}
		
		if(e.getSource()==cp.btn_HOME)
		{
			if(LoginListener.usertype.equalsIgnoreCase("c"))
			{
				cp.frame5.setVisible(false);
				new Customer();
			}
			else
			{
				cp.frame5.setVisible(false);
				new Admin();
			}
		}
		
	}
	
	
}
