package com.wipro.srs.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.wipro.srs.bean.ProfileBean;
import com.wipro.srs.ui.Login;
import com.wipro.srs.ui.Register;
import com.wipro.srs.util.User;

public class RegisterListener implements ActionListener
{
	Register registerobj;
	ProfileBean profilebean=new ProfileBean();
	
	public RegisterListener(Register registerobj)
	{
		this.registerobj=registerobj;
	}
	
	public String email()
	{
		int flag1=0;
		int flag2=0;
		String email=registerobj.txt_email.getText();
		String arr1[]=email.split("@");
		
		if(arr1[0].matches("[a-zA-Z0-9]+"))
		{
			String arr2[]=arr1[1].split("\\.");
			
			if(arr2[0].matches("[a-zA-Z]+"))
			{
				flag1=1;
				
				
			}
			if(arr2[1].matches("[a-zA-Z]+"))
			{
				if(arr2[1].length()==2 ||arr2[1].length()==3)
				{
					flag2=1;
				}
			}
			
			
					
		}
		if(flag1==1 && flag2==1)
		{
			return"VALID ID";
		}
		else
		{
			return"INVALID ID";
		}
	}

	
	
	

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		registerobj.msg1=new JOptionPane();
		
		
		
		// TODO Auto-generated method stub
		
			if(registerobj.btn_female.isSelected())
			{
				profilebean.setGender(registerobj.btn_female.getText());
			}
		
			if(registerobj.btn_male.isSelected())
			{
				profilebean.setGender(registerobj.btn_male.getText());
			}
		
		if(e.getSource()==registerobj.btn_submit)
		{
			
			if(registerobj.txt_firstname.getText().trim().isEmpty())
			{
				registerobj.msg1.showMessageDialog(null, "FIRST NAME  CAN'T BE EMPTY","ERROR",JOptionPane.ERROR_MESSAGE);
			}
			else if(registerobj.txt_lastname.getText().trim().isEmpty())
			{
				registerobj.msg1.showMessageDialog(null, "LAST NAME  CAN'T BE EMPTY","ERROR",JOptionPane.ERROR_MESSAGE);

			}
			else if(!(registerobj.txt_firstname.getText().trim().matches("[a-zA-Z]+"))||registerobj.txt_firstname.getText().trim().length()<2)
			{
				registerobj.msg1.showMessageDialog(null, "FIRST NAME CAN ONLY CONTAIN ALPHABETS & Size>2","ERROR",JOptionPane.ERROR_MESSAGE);
			}
			else if(!(registerobj.txt_lastname.getText().trim().matches("[a-zA-Z]+"))||registerobj.txt_lastname.getText().trim().length()<2)
			{
				registerobj.msg1.showMessageDialog(null, "LAST NAME CAN ONLY CONTAIN ALPHABETS & SIZE>2","ERROR",JOptionPane.ERROR_MESSAGE);
			}
			else if(!(registerobj.btn_male.isSelected())&&!(registerobj.btn_female.isSelected()))
			{
				registerobj.msg1.showMessageDialog(null, "SELECT GENDER","ERROR",JOptionPane.ERROR_MESSAGE);
				
			}
			else if(registerobj.txt_street.getText().trim().isEmpty())
			{
				registerobj.msg1.showMessageDialog(null, "STREET CAN'T BE EMPTY","ERROR",JOptionPane.ERROR_MESSAGE);
			}
			
			else if(registerobj.txt_location.getText().trim().isEmpty()||!(registerobj.txt_location.getText().trim().matches("[a-zA-Z]+"))||registerobj.txt_location.getText().trim().length()<2)
			{
				registerobj.msg1.showMessageDialog(null, "LOCATION CAN ONLY CONTAIN ALPHABETS & SIZE>2","ERROR",JOptionPane.ERROR_MESSAGE);

			}
			else if(registerobj.txt_city.getText().trim().isEmpty()||!(registerobj.txt_city.getText().trim().matches("[a-zA-Z]+"))||registerobj.txt_city.getText().trim().length()<2)
			{
				registerobj.msg1.showMessageDialog(null, "CITY CAN ONLY CONTAIN ALPHABETS & SIZE>2","ERROR",JOptionPane.ERROR_MESSAGE);

			}
			else if(registerobj.txt_state.getText().trim().isEmpty()||!(registerobj.txt_state.getText().trim().matches("[a-zA-Z]+"))||registerobj.txt_state.getText().trim().length()<2)
			{
				registerobj.msg1.showMessageDialog(null, "STATE CAN ONLY CONTAIN ALPHABETS & SIZE>2","ERROR",JOptionPane.ERROR_MESSAGE);
				
			}
			//int pin=Integer.parseInt(registerobj.txt_pin.getText().trim());
			//int mobile=Integer.parseInt(registerobj.txt_mobile.getText().trim());
			else if(registerobj.txt_pin.getText().trim().length()!=6||!(registerobj.txt_pin.getText().matches("[0-9]+")))
			{
				registerobj.msg1.showMessageDialog(null, "Pin code can only be 6 digits and only positive digits","ERROR",JOptionPane.ERROR_MESSAGE);

			}
			else if(registerobj.txt_mobile.getText().trim().length()!=10||!(registerobj.txt_mobile.getText().matches("[0-9]+")))
			{
				registerobj.msg1.showMessageDialog(null, "Mobile Number can only be 10 digits and onlypositive digits","ERROR",JOptionPane.ERROR_MESSAGE);

			}
			else if(email().equalsIgnoreCase("INVALID ID"))
			{
				registerobj.msg1.showMessageDialog(null, "INVALID EMAIL ID","ERROR",JOptionPane.ERROR_MESSAGE);

			}
			else
			{
				registerobj.btn_finalsubmit.setVisible(true);
				registerobj.lbl_password.setVisible(true);
				registerobj.window.setVisible(true);
				registerobj.lbl_userid.setVisible(true);
				registerobj.pwd.setVisible(true);
				registerobj.btn_submit.setVisible(false);
				
			}
			
			
			
		}
		if(e.getSource()==registerobj.btn_finalsubmit)
		{
			//SimpleDateFormat format=new SimpleDateFormat("dd-MMM-yyyy");
			//try 
				//{
					//java.util.Date dob=format.parse(registerobj.txt_date.getText());
					profilebean.setFirstName(registerobj.txt_firstname.getText().trim().toUpperCase());
					profilebean.setLastName(registerobj.txt_lastname.getText().trim().toUpperCase());
					profilebean.setStreet(registerobj.txt_street.getText().toUpperCase());
					profilebean.setLocation(registerobj.txt_location.getText().trim().toUpperCase());
					profilebean.setCity(registerobj.txt_city.getText().trim().toUpperCase());
					profilebean.setState(registerobj.txt_state.getText().trim().toUpperCase());
					profilebean.setPincode(registerobj.txt_pin.getText().trim().toUpperCase());
					profilebean.setMobileNo(registerobj.txt_mobile.getText().trim().toUpperCase());
					profilebean.setEmailID(registerobj.txt_email.getText().toUpperCase());
					profilebean.setPassword(String.valueOf(registerobj.pwd.getPassword()));
					profilebean.setDateOfBirth(registerobj.chooser.getDate());
				
				//} 
				//catch (ParseException e1) 
				//{
				// TODO Auto-generated catch block
			//	e1.printStackTrace();
				//}
			
			
			User obj=new User();
			String output=obj.register(profilebean);
			if(output.equalsIgnoreCase("fail"))
			{
				
				registerobj.msg1.showMessageDialog(null, output);
			}
			else
			{
				registerobj.msg1.showMessageDialog(null, "REGISTERTAION SUCCESSFULL..PLEASE NOTE YOUR USER ID","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
				registerobj.window.setText(output);
				registerobj.btn_finalsubmit.setVisible(false);
			}
		}
		if(e.getSource()==registerobj.btn_back)
		{
			new Login();
			registerobj.RegistrationFrame.setVisible(false);
		}
		
		
	}
	
	

}
