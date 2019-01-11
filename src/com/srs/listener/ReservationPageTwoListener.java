package com.wipro.srs.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.wipro.srs.bean.PassengerBean;
import com.wipro.srs.bean.TempBean;
import com.wipro.srs.ui.Customer;
import com.wipro.srs.ui.Login;
import com.wipro.srs.ui.ReservationPageOne;
import com.wipro.srs.ui.ReservationPageThree;
import com.wipro.srs.ui.ReservationPageTwo;
import com.wipro.srs.util.User;

public class ReservationPageTwoListener implements ActionListener,ItemListener
{
	ReservationPageTwo reservation_page_two;
	public static int no_of_seats,age,seats_in_ship;
	public static String shipID,gender,name,scheduleID;
	public static double totalfare;
	
	public ReservationPageTwoListener(ReservationPageTwo reservation_page_two)
	{
		this.reservation_page_two=reservation_page_two;
	}

	@Override
	public void itemStateChanged(ItemEvent e) 
	{
		// TODO Auto-generated method stub
		
		if(e.getSource()==reservation_page_two.shipIDS)
		{
			shipID=reservation_page_two.shipIDS.getSelectedItem();
		}
		
		if(e.getSource()==reservation_page_two.no_of_seats)
		{
			/*no_of_seats=Integer.parseInt(reservation_page_two.no_of_seats.getSelectedItem());
			System.out.println(no_of_seats);*/
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		ArrayList<TempBean> al=new ArrayList<TempBean>();
		
		if(reservation_page_two.female.isSelected())
		{
			gender="FEMALE";
		}
	
		if(reservation_page_two.male.isSelected())
		{
			gender="MALE";
		}
		
		
		
		if(e.getSource()==reservation_page_two.btn_logout)
		{
				new ReservationPageOne();
				reservation_page_two.frame1.setVisible(false);			
			
		}
		
		if(e.getSource()==reservation_page_two.add)
		{	
			if(reservation_page_two.txt_NAME.getText()==null||reservation_page_two.txt_NAME.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null,"Enter Name","ERROR",JOptionPane.ERROR_MESSAGE);

			}
			else if(reservation_page_two.txt_NAME.getText().trim().length()<2)
			{
				JOptionPane.showMessageDialog(null,"Name Length Should Be Greater Than 2 Characters","ERROR",JOptionPane.ERROR_MESSAGE);

			}
			
			else if(reservation_page_two.txt_AGE.getText()==null||reservation_page_two.txt_AGE.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null,"Enter Age ","ERROR",JOptionPane.ERROR_MESSAGE);

			}
			else if(!(reservation_page_two.txt_NAME.getText().matches("[a-zA-Z]+")))
			{
				JOptionPane.showMessageDialog(null,"Name should be in Characters Only","ERROR",JOptionPane.ERROR_MESSAGE);

			}
			else if(reservation_page_two.txt_AGE.getText().equals("0"))
			{
				JOptionPane.showMessageDialog(null,"Age Cannot Be 0","ERROR",JOptionPane.ERROR_MESSAGE);

			}
			else if(!(reservation_page_two.txt_AGE.getText().matches("[0-9]+")))
			{
				JOptionPane.showMessageDialog(null,"Age should be in positive digits Only","ERROR",JOptionPane.ERROR_MESSAGE);

			}
			else if(!(reservation_page_two.male.isSelected())&&!(reservation_page_two.female.isSelected()))
			{
				JOptionPane.showMessageDialog(null, "Select Gender","ERROR",JOptionPane.ERROR_MESSAGE);
			}
			else
			{	
				name=reservation_page_two.txt_NAME.getText().trim();
				age=Integer.parseInt(reservation_page_two.txt_AGE.getText().trim());
				no_of_seats=Integer.parseInt(reservation_page_two.no_of_seats.getSelectedItem());
				int index=reservation_page_two.shipIDS.getSelectedIndex();
				double fare=ReservationPageOneListener.al.get(index).getFare();
				int seats_in_ship=ReservationPageOneListener.al.get(index).getSeats();
				scheduleID=ReservationPageOneListener.al.get(index).getScheduleId();
				totalfare=fare*no_of_seats;
				reservation_page_two.lbl_totalfareRS.setText(String.valueOf(totalfare));
				reservation_page_two.lbl_totalfareRS.setVisible(true);
				reservation_page_two.lbl_totalfare.setVisible(true);
				reservation_page_two.make_payments.setVisible(true);
				
			}
		}
		
		if(e.getSource()==reservation_page_two.make_payments)
		{
			
			
			reservation_page_two.frame1.setVisible(false);
			ReservationPageThree rp3=new ReservationPageThree();
		}
		
		if(e.getSource()==reservation_page_two.btn_cancel)
		{
				
				
				reservation_page_two.txt_NAME.setText("");
				reservation_page_two.txt_AGE.setText("");
				reservation_page_two.no_of_seats.select(0);
				reservation_page_two.shipIDS.select(0);
			
		}
		
	}
}
