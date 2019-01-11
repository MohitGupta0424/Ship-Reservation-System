package com.wipro.srs.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.wipro.srs.bean.ShipBean;
import com.wipro.srs.service.ShipService;
import com.wipro.srs.ui.ModifyShipUI;

public class ModifyShipListener implements ActionListener 
{
	ModifyShipUI modifyShipUI;
	ShipService aService;
	ShipBean shipBean;
	public ModifyShipListener(ModifyShipUI modifyShipUI) 
	{
		this.modifyShipUI=modifyShipUI;
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==modifyShipUI.btnModify)
		{
			//modifyShipUI.frame1.setVisible(false);
			aService=new ShipService();
			shipBean=new ShipBean();
			shipBean=aService.viewByShipId(modifyShipUI.txtShipId1.getText());
			
			if(shipBean!=null)
			{
				modifyShipUI.txtShipId2.setText(shipBean.getShipID());
				modifyShipUI.txtShipName.setText(shipBean.getShipName());
				modifyShipUI.txtSeatingCapacity.setText(String.valueOf(shipBean.getSeatingCapacity()));
				modifyShipUI.txtReservationCapacity.setText(String.valueOf(shipBean.getReservationCapacity()));
				modifyShipUI.txtShipId2.setEditable(false);
				modifyShipUI.frame2.setVisible(true);
			}
			else
			{
				modifyShipUI.pane.showMessageDialog(null,"ID DOES NOT EXIST","ERROR",JOptionPane.ERROR_MESSAGE);
				
			}
		}
		if(e.getSource()==modifyShipUI.btnModify2)
		{
			aService=new ShipService();
			shipBean=new ShipBean();
			if(modifyShipUI.txtSeatingCapacity.getText().trim().matches("[0-9]+"))//&& modifyShipUI.txtReservationCapacity.getText().matches("[0-9]+") && Integer.parseInt(modifyShipUI.txtSeatingCapacity.getText())>=Integer.parseInt(modifyShipUI.txtReservationCapacity.getText()))
			{
				if(modifyShipUI.txtReservationCapacity.getText().matches("[0-9]+") && Integer.parseInt(modifyShipUI.txtSeatingCapacity.getText())>=Integer.parseInt(modifyShipUI.txtReservationCapacity.getText()))
				{
					if(modifyShipUI.txtShipName.getText().trim().matches("[a-zA-Z]+") && modifyShipUI.txtShipName.getText().trim().length()>1)
					{
						shipBean.setShipID(modifyShipUI.txtShipId2.getText().trim());
						shipBean.setShipName(	modifyShipUI.txtShipName.getText().trim());
						shipBean.setSeatingCapacity(Integer.parseInt(modifyShipUI.txtSeatingCapacity.getText().trim()));
						shipBean.setReservationCapacity(Integer.parseInt(modifyShipUI.txtReservationCapacity.getText().trim()));
						if(aService.modifyShip(shipBean)==true)
						{
							modifyShipUI.pane.showMessageDialog(null,"Ship Details Modified Successfully","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
							modifyShipUI.frame2.setVisible(false);
						}
						else
						{
							modifyShipUI.pane.showMessageDialog(null,"FAIL");
							modifyShipUI.frame2.setVisible(false);
						}
					}
					else
					{
						modifyShipUI.pane.showMessageDialog(null,"Ship Name should Be Non-Empty and greater tha 2 characters","ERROR",JOptionPane.ERROR_MESSAGE);
					}
				}
				else
				{
					modifyShipUI.pane.showMessageDialog(null,"Reservation Capacity should be in digits and greater than Seating Capacity","ERROR",JOptionPane.ERROR_MESSAGE);
				}
			}
			else
			{
				modifyShipUI.pane.showMessageDialog(null,"Seating Capacity should be in digits and greater than Zero","ERROR",JOptionPane.ERROR_MESSAGE);

			}
		}
	}
}
