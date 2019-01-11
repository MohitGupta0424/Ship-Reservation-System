package com.wipro.srs.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.wipro.srs.bean.RouteBean;
import com.wipro.srs.service.RouteService;
import com.wipro.srs.ui.ViewByRouteInterface;

public class ViewByRouteListener implements ActionListener
{
	ViewByRouteInterface viewUI;
	RouteService service;
	
	public ViewByRouteListener(ViewByRouteInterface viewUI)
	{
		this.viewUI=viewUI;
	}

	public void actionPerformed(ActionEvent e) 
	{
        RouteBean routeBean=new RouteBean();
        
        if(e.getSource()==viewUI.viewButton)
        {
        	viewUI.model.getDataVector().removeAllElements();
        	String routeid=viewUI.txtRouteId.getText();
        	service=new RouteService();
        	
        	routeBean=service.viewByRouteId(routeid);
        	
			if(routeBean==null||routeBean.equals(" "))
			{
				
			   JOptionPane.showMessageDialog(null, "Please Enter A Valid RouteId","ERROR",JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				viewUI.rows[0]=routeBean.getSource();
				viewUI.rows[1]=routeBean.getDestination();
				viewUI.rows[2]=routeBean.getTravelDuration();
				viewUI.rows[3]=routeBean.getFare();
				viewUI.model.addRow(viewUI.rows);
				//JOptionPane.showMessageDialog(null, "Data is entered in table");
			}
	     }
        if(e.getSource()==viewUI.Cancelbtn)
        {
        	viewUI.txtRouteId.setText(" ");
        }
        
        if(e.getSource()==viewUI.Backbtn)
        {
        	viewUI.dispose();
        }
     }
}
