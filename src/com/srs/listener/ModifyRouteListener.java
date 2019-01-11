package com.wipro.srs.listener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import com.wipro.srs.bean.RouteBean;
import com.wipro.srs.service.RouteService;
import com.wipro.srs.ui.ModifyRouteInterface;

public class ModifyRouteListener implements ActionListener
{
	  ModifyRouteInterface modifyUI;
	  RouteBean routeBean;
	  RouteService service;
	  
	  public ModifyRouteListener(ModifyRouteInterface modifyUI)
	  {
		  this.modifyUI=modifyUI;
	  }

	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==modifyUI.Modifybtn)
		{
			if(modifyUI.txtRouteId.getText().trim().equals(""))
			{
				modifyUI.jpane.showMessageDialog(modifyUI,"Enter a Route Id","ERROR",JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				service=new RouteService();
				routeBean=new RouteBean();
				routeBean =service.viewByRouteId(modifyUI.txtRouteId.getText());
				
				if(routeBean==null)
				{
					modifyUI.jpane.showMessageDialog(modifyUI,"Please Enter a valid Id","ERROR",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					modifyUI.frame1.setVisible(false);
					modifyUI.txtRouteId1.setText(routeBean.getRouteID());
					modifyUI.txtSource.setText(routeBean.getSource());
					modifyUI.txtDestination.setText(routeBean.getDestination());
					modifyUI.txtTravelDuration.setText(routeBean.getTravelDuration());
					modifyUI.txtFare.setText(String.valueOf(routeBean.getFare()));

					if(service.modifyRoute(routeBean)==true)
					{
						modifyUI.frame2.setVisible(true);
					}
					else
					{
						modifyUI.frame2.setVisible(true);
					}
				}
			}
		}
		if(e.getSource()==modifyUI.Cancelbtn)
		{
			
			modifyUI.txtRouteId.setText(" ");
			modifyUI.txtSource.setText(" ");
			modifyUI.txtDestination.setText(" ");
			modifyUI.txtTravelDuration.setText(" ");
			modifyUI.txtFare.setText(" ");
		}
		
		if(e.getSource()==modifyUI.Modifybtn2)
		{
			service=new RouteService();
			routeBean=new RouteBean();
			String result="";
			if(modifyUI.txtSource.getText().equals("")&& modifyUI.txtDestination.getText().equals("")&& modifyUI.txtTravelDuration.equals("")&& modifyUI.txtFare.getText().equals(""))
			{
				result="Enter the Data in blank fields";
				modifyUI.jpane.showMessageDialog(modifyUI, result,"ERROR",JOptionPane.ERROR_MESSAGE);
			}
			else if(!modifyUI.txtSource.getText().trim().matches("[a-zA-Z0-9]+"))
			{
				result="Source should be characters";
				modifyUI.jpane.showMessageDialog(modifyUI, result,"ERROR",JOptionPane.ERROR_MESSAGE);
			}
		
			else if(!modifyUI.txtDestination.getText().trim().matches("[a-zA-Z0-9]+"))
			{
				result="Destination should be characters";
				modifyUI.jpane.showMessageDialog(modifyUI, result,"ERROR",JOptionPane.ERROR_MESSAGE);
			}
			
			else if(!(modifyUI.txtSource.getText().length()>=2))
			{
				result="Please enter more than 1 character in Source";
				modifyUI.jpane.showMessageDialog(modifyUI, result,"ERROR",JOptionPane.ERROR_MESSAGE);
			}
			else if(!(modifyUI.txtDestination.getText().length()>=2))
			{
				result="Please enter more than 1 character in Destination";
				modifyUI.jpane.showMessageDialog(modifyUI, result,"ERROR",JOptionPane.ERROR_MESSAGE);
			}
			else if(!(modifyUI.txtTravelDuration.getText().trim().matches("[0-9]+")))
			{
				result="Only Positive Numbers are allowed in Travel Duration";
				modifyUI.jpane.showMessageDialog(modifyUI, result,"ERROR",JOptionPane.ERROR_MESSAGE);
			}
			else if(modifyUI.txtTravelDuration.getText().equals("0"))
			{
				result="Travel Duration cannot Be 0 Hours";
				modifyUI.jpane.showMessageDialog(modifyUI, result,"ERROR",JOptionPane.ERROR_MESSAGE);

			}
			
			else if(!(modifyUI.txtFare.getText().trim().matches("[0-9]+")))
			{
				result="Only positive numbers are allowed in Fare";
				modifyUI.jpane.showMessageDialog(modifyUI, result,"ERROR",JOptionPane.ERROR_MESSAGE);
			}
			
			else if(Double.parseDouble(modifyUI.txtFare.getText())<=0.0)
			{
				result="Fare should be greater than 0";
				modifyUI.jpane.showMessageDialog(modifyUI, result,"ERROR",JOptionPane.ERROR_MESSAGE);
			}
			else
			{
		        try
		        {	
		        	modifyUI.frame1.setVisible(false);
		            routeBean.setRouteID(modifyUI.txtRouteId1.getText());
					routeBean.setSource(modifyUI.txtSource.getText().trim());
					routeBean.setDestination(modifyUI.txtDestination.getText().trim());
					routeBean.setTravelDuration(modifyUI.txtTravelDuration.getText().trim());
					routeBean.setFare(Double.parseDouble(modifyUI.txtFare.getText().trim()));
					boolean flag=service.modifyRoute(routeBean);
		        	modifyUI.txtRouteId.setText(routeBean.getRouteID());
		        	if(flag==true)
		        	{
		        		modifyUI.jpane.showMessageDialog(modifyUI,"Route Details Updated Succesfully","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
		        		modifyUI.frame2.setVisible(false);
		        	}
		        	else
		        	{
		        		modifyUI.jpane.showMessageDialog(modifyUI,"FAIL","ERROR",JOptionPane.ERROR_MESSAGE);
		        		modifyUI.frame2.setVisible(false);
		        	}	
		        }
		        catch(NumberFormatException e1)
		        {
		        	result="Only Numbers are allowed in travel duration and fare";
					modifyUI.jpane.showMessageDialog(modifyUI, result);
		        }
			}
		}
		if(e.getSource()==modifyUI.Cancelbtn2)
		{
		
				modifyUI.txtRouteId1.setText(" ");
				modifyUI.txtSource.setText(" ");
				modifyUI.txtDestination.setText(" ");
				modifyUI.txtTravelDuration.setText(" ");
				modifyUI.txtFare.setText(" ");
		}
	}


	
}

