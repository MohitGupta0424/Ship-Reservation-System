package com.wipro.srs.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import com.wipro.srs.bean.ShipBean;
import com.wipro.srs.dao.ShipDAO;
import com.wipro.srs.service.ShipService;
import com.wipro.srs.ui.AddShipUI;

public class AddShipListener implements ActionListener
{
	AddShipUI addShipUI;
	ShipBean shipBean;

	ShipService aService;
	public AddShipListener(AddShipUI addShipUI)
	{
		this.addShipUI=addShipUI;
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==addShipUI.btnAdd)
		{
			shipBean=new ShipBean();
			aService=new ShipService();
			ShipDAO aDao=new ShipDAO();
			
			
				if(addShipUI.txtShipName.getText().trim().matches("[a-zA-Z]+") && addShipUI.txtShipName.getText().trim().length()>=2)
				{
					shipBean.setShipName(addShipUI.txtShipName.getText().trim() );
					if(addShipUI.txtSeatingCapacity.getText().matches("[0-9]+")) 
					{
						
							if(addShipUI.txtReservationCapacity.getText().matches("[0-9]+")) 
							{
								shipBean.setSeatingCapacity(Integer.parseInt(addShipUI.txtSeatingCapacity.getText().trim()));
								shipBean.setReservationCapacity(Integer.parseInt(addShipUI.txtReservationCapacity.getText().trim()));
								try 
								{
									String id=aDao.generateShipId(shipBean);
									shipBean.setShipID(id);
								} 
								catch (ClassNotFoundException | SQLException e1)
								{
									e1.printStackTrace();
								}
								if(Integer.parseInt(addShipUI.txtSeatingCapacity.getText())>=Integer.parseInt(addShipUI.txtReservationCapacity.getText().trim()))
								{
									 String s=aService.addShip(shipBean);
									 addShipUI.txtShipId.setText(shipBean.getShipID());
									 addShipUI.pane.showMessageDialog(null,"Ship Added Successfully","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
									 addShipUI.frame.setVisible(false);
								}
								else
								{
									addShipUI.pane.showMessageDialog(null, "RESERVED SEATS INVALID","ERROR",JOptionPane.ERROR_MESSAGE);
									addShipUI.txtReservationCapacity.setText("");
								}
						}
						else
						{	
							addShipUI.pane.showMessageDialog(null, "Reservation Capacity Should Be in Digits and Less Than Seating Capacity ","ERROR",JOptionPane.ERROR_MESSAGE);
							addShipUI.txtReservationCapacity.setText("");
						}
						}
					else
					{
						addShipUI.pane.showMessageDialog(null, "Seating Capacity Should Be in Digits and Non Empty ","ERROR",JOptionPane.ERROR_MESSAGE);
						addShipUI.txtSeatingCapacity.setText("");
					}
				}
				else
				{
					addShipUI.pane.showMessageDialog(null, "Ship Name should Be greater than 2 Characters","ERROR",JOptionPane.ERROR_MESSAGE);
					addShipUI.txtShipName.setText("");
				}			
			}
			
			
			if(e.getSource()==addShipUI.btnCancel)
			{
				addShipUI.txtShipId.setText(" ");
				addShipUI.txtShipName.setText(" ");
				addShipUI.txtSeatingCapacity.setText(" ");
				addShipUI.txtReservationCapacity.setText(" ");
				
			}
			
			if(e.getSource()==addShipUI.btnBack)
			{
				addShipUI.frame.setVisible(false);
			}
			
	}
	
}
