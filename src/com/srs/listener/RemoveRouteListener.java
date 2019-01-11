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
import com.wipro.srs.ui.RemoveRouteInterface;

public class RemoveRouteListener implements ActionListener, WindowListener
{
	RemoveRouteInterface removeUI;
	RouteBean routeBean;
	RouteService service;

	public RemoveRouteListener(RemoveRouteInterface removeUI)
	{
		this.removeUI=removeUI;
	}

	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==removeUI.Removebtn)
		{      
			service=new RouteService();
            //routeBean=service.viewByRouteId(removeUI.txtRouteId.getText());
        	
            if(removeUI.routeId.getSelectedItem().equals("--Select--"))
			{
				JOptionPane.showMessageDialog(null,"Select Route Id","ERROR",JOptionPane.ERROR_MESSAGE);
			}
			
			else
			{
					int btn=JOptionPane.showConfirmDialog(removeUI, "Do You Want to Delete the Route Id?");

					if(btn==JOptionPane.YES_OPTION)
					{
						int row=0;
						 row=service.removeRoute(removeUI.routeId.getSelectedItem());
						if(row==1){
						removeUI.jpane.showMessageDialog(removeUI,"Route Id is removed Successfully","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
						removeUI.setVisible(false);}
					}

					else if(btn==JOptionPane.NO_OPTION)
					{
						removeUI.routeId.select(0);
					}
					else if(btn==JOptionPane.CANCEL_OPTION)
					{
						removeUI.routeId.select(0);
					}


				}
		}
		
		if(e.getSource()==removeUI.Cancelbtn)
		{
			removeUI.routeId.select(0);

		}
		if(e.getSource()==removeUI.Backbtn)
		{
			removeUI.frame.dispose();
		}
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) 
	{
		String r="";
		service=new RouteService();
		ArrayList list2=new ArrayList();

		list2=service.getRouteId();
		Iterator itr2=list2.iterator();
		while(itr2.hasNext())
		{
			r=(String) itr2.next();
			removeUI.routeId.add(r);
		}
	}
}

