package com.wipro.srs.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import com.wipro.srs.bean.ShipBean;
import com.wipro.srs.service.ShipService;
import com.wipro.srs.ui.RemoveShipUI;

public class RemoveShipListener implements ActionListener,WindowListener
{
	RemoveShipUI removeShipUI;
	ShipService adminService;
	ShipBean shipBean;
	public RemoveShipListener(RemoveShipUI removeShipUI) 
	{
		this.removeShipUI=removeShipUI;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==removeShipUI.btnRemove)
		{
			shipBean=new ShipBean();
		
			adminService=new ShipService();
			//if(removeShipUI.txtShipId.getText().trim())
			if(removeShipUI.shipId.getSelectedItem().equals("--Select--"))
			{
				JOptionPane.showMessageDialog(null,"Select Ship Id","ERROR",JOptionPane.ERROR_MESSAGE);
			}
			else
			{	
				String s=adminService.removeShip(removeShipUI.shipId.getSelectedItem());
				if(s.equalsIgnoreCase("SUCCESS"))
				{
					removeShipUI.pane.showMessageDialog(null,"Ship ID Removed Successfully","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
				}
				else if(s.equalsIgnoreCase("FAIL"))
				{
					removeShipUI.pane.showMessageDialog(null,"Ship Cannot Be Deleted.Schedule is already Created","ERROR",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					removeShipUI.pane.showMessageDialog(null,s);
				}
				
				if(s=="SUCCESS")
				removeShipUI.frame.setVisible(false);
				else
				removeShipUI.txtShipId.setText("");
		}}
		
		if(e.getSource()==removeShipUI.btnCancel)
		{
			removeShipUI.shipId.select(0);
		}
		if(e.getSource()==removeShipUI.btnBack)
		{
			removeShipUI.frame.setVisible(false);
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
		adminService=new ShipService();
		String s="";
		ArrayList list1=new ArrayList();
		list1=adminService.getShipId();
		Iterator itr=list1.iterator();
		while(itr.hasNext())
		{
			s=(String) itr.next();
			removeShipUI.shipId.add(s);
		}		
	}
}