package com.wipro.srs.ui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.wipro.srs.listener.ModifyShipListener;


public class ModifyShipUI 
{
	public JFrame frame1,frame2;
	public JPanel panel1,panel2,panel3;
	public JLabel lblShipId,lblShipId1,lblShipName,lblSeatingCapacity,lblReservationCapacity;
	public JTextField txtShipId1,txtShipId2,txtShipName,txtSeatingCapacity,txtReservationCapacity;
	public JButton btnModify,btnModify2;
	public JOptionPane pane;
	public ModifyShipUI()
	{
		frame1=new JFrame();
		frame1.setTitle("Modify Ship");
		panel1=new JPanel();
		panel1.setBackground(Color.WHITE);
		panel1.add(lblShipId=new JLabel("Ship Id"));
		panel1.add(txtShipId1=new JTextField(10));
		panel1.add(btnModify=new JButton("MODIFY"));
		frame1.add(panel1);
		frame1.setSize(400, 400);
		frame1.setVisible(true);
		frame1.setResizable(false);
		frame1.setLayout(new GridLayout(0,1));
		frame1.setLocation(350,220);

		frame2=new JFrame();
		frame2.setTitle("Modifying Ship Details");
		panel2=new JPanel();
		panel3=new JPanel();
		panel2.setBackground(Color.WHITE);
		panel2.add(lblShipId1=new JLabel("Ship ID"));
		panel2.add(txtShipId2=new JTextField(10));
		panel2.add(lblShipName=new JLabel("Ship Name"));
		panel2.add(txtShipName=new JTextField(10));
		panel2.add(lblSeatingCapacity=new JLabel("Seating Capacity"));
		panel2.add(txtSeatingCapacity=new JTextField(10));
		panel2.add(lblReservationCapacity=new JLabel("Reservation Capacity"));
		panel2.add(txtReservationCapacity=new JTextField(10));
		panel2.setLayout(new GridLayout(0,2));
		panel3.add(btnModify2=new JButton("MODIFY"));
		
		frame2.setLayout(new FlowLayout());
		frame2.add(panel2);
		frame2.add(panel3);
		frame2.setSize(300, 300);
		frame2.setVisible(false);
		frame2.setResizable(false);
		frame2.setLocation(350,250);
		
		btnModify.addActionListener(new ModifyShipListener(this));
		btnModify2.addActionListener(new ModifyShipListener(this));
		
	}
}
