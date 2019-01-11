package com.wipro.srs.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.wipro.srs.bean.RouteBean;
import com.wipro.srs.service.RouteService;
import com.wipro.srs.ui.AddRouteInterface;



public class AddRouteListener implements ActionListener
{
	RouteBean routeBean;
	AddRouteInterface addUI;
	RouteService service;

	public AddRouteListener(AddRouteInterface addUI)
	{
		this.addUI=addUI;
	}
	public void actionPerformed(ActionEvent e) 
	{
		service=new RouteService();
		routeBean=new RouteBean();
		String result="";
		if(e.getSource()==addUI.Addbtn)
		{
			if(addUI.txtSource.getText().equals("") && addUI.txtDestination.getText().equals("")&&addUI.txtTravelDuration.equals("")&&addUI.txtFare.getText().equals(""))
			{
				result="Enter the Data in blank fields";
			}
			else if(!addUI.txtSource.getText().trim().matches("[a-zA-Z0-9]+"))
			{
				result="Source should be characters";
			}
			
			else if(!addUI.txtDestination.getText().trim().matches("[a-zA-Z0-9]+"))
			{
				result="Destination should be characters";
			}

			else if((addUI.txtSource.getText().trim().length()<2))
			{
				result="Please enter more than 1 character in Source";
			}
			else if((addUI.txtDestination.getText().trim().length()<2))
			{
				result="Please enter more than 1 character in Destination";
			}
			else if(!(addUI.txtTravelDuration.getText().trim().matches("[0-9]+"))&& !(addUI.txtTravelDuration.getText().length()<=0))
			{
				result="Only Positive Numbers are allowed in Travel Duration";
			}
			else if(!(addUI.txtFare.getText().trim().matches("[0.0-9.0]+")))
			{
				result="Only positive numbers are allowed in Fare";
			}
				
			else
			{
				try
				{			
					routeBean.setSource(addUI.txtSource.getText().trim());
					routeBean.setDestination(addUI.txtDestination.getText().trim());
					routeBean.setTravelDuration(addUI.txtTravelDuration.getText().trim());
					routeBean.setFare(Double.parseDouble(addUI.txtFare.getText().trim()));
					result=service.addRoute(routeBean);
					addUI.txtRouteId.setText(routeBean.getRouteID());

				}
				catch(NumberFormatException e1)
				{
					result="Only Numbers are allowed in travel duration and fare";
				}
			}
			if(result=="Added Successfully")
			{
				addUI.jpane.showMessageDialog(null,"Route Added Successfully","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
				addUI.frame.setVisible(false);
			}
			else
				addUI.jpane.showMessageDialog(addUI, result,"ERROR",JOptionPane.ERROR_MESSAGE);
		}
		if(e.getSource()==addUI.Cancelbtn)
		{
			addUI.txtRouteId.setText(" ");
			addUI.txtSource.setText(" ");
			addUI.txtDestination.setText(" ");
			addUI.txtTravelDuration.setText(" ");
			addUI.txtFare.setText(" ");
		}
		if(e.getSource()==addUI.Backbtn)
		{
			addUI.frame.dispose();
		}
	}
	
}

