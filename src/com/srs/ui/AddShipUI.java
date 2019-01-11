package com.wipro.srs.ui;

import java.awt.Choice;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.wipro.srs.listener.AddShipListener;

public class AddShipUI 
{
	public JFrame frame;
	public JPanel panel1,panel2;
	public JLabel lblShipName,lblSeatingCapacity,lblReservationCapacity,lblShipId;
	public JTextField txtShipName,txtSeatingCapacity,txtReservationCapacity,txtShipId;
	public JButton btnAdd,btnBack,btnCancel;
	public JOptionPane pane;
	public AddShipUI()
	{
		frame=new JFrame();
		frame.setTitle("Add Ship");
		frame.setSize(400,400);
		frame.setLocation(350,220);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setContentPane(new JLabel(new ImageIcon("src\\3.jpg")));
		
		frame.add(lblShipId=new JLabel("Ship Id"));
		
		//shipId.setBounds(200, 20, 165, 25);

		lblShipId.setBounds(10, 20, 190, 25);
		frame.add(txtShipId=new JTextField(10));
		txtShipId.setEditable(false);
		txtShipId.setBounds(200, 20, 165, 25);
		frame.add(lblShipName=new JLabel("Ship Name"));
		lblShipName.setBounds(10, 50, 190, 25);
		frame.add(txtShipName=new JTextField(10));
		txtShipName.setBounds(200, 50, 165, 25);
		frame.add(lblSeatingCapacity=new JLabel("Seating Capacity"));
		lblSeatingCapacity.setBounds(10, 80, 190, 25);
		frame.add(txtSeatingCapacity=new JTextField(10));
		txtSeatingCapacity.setBounds(200, 80, 165, 25);
		frame.add(lblReservationCapacity=new JLabel("Reservation Capacity"));
		lblReservationCapacity.setBounds(10, 110, 190, 25);
		frame.add(txtReservationCapacity=new JTextField(10));
		txtReservationCapacity.setBounds(200, 110, 165, 25);
		
		frame.add(lblShipId);
		Font font1=new Font("Times New Roman",Font.BOLD,14);
		lblShipId.setFont(font1);
		lblShipId.setForeground(Color.white);
		
		
		frame.add(lblShipName);
		Font font2=new Font("Times New Roman",Font.BOLD,14);
		lblShipName.setFont(font2);
		lblShipName.setForeground(Color.white);
		
		frame.add(lblSeatingCapacity);
		Font font3=new Font("Times New Roman",Font.BOLD,14);
		lblSeatingCapacity.setFont(font3);
		lblSeatingCapacity.setForeground(Color.white);
		
		frame.add(lblReservationCapacity);
		Font font4=new Font("Times New Roman",Font.BOLD,14);
		lblReservationCapacity.setFont(font4);
		lblReservationCapacity.setForeground(Color.white);
		
		
		frame.add(btnAdd=new JButton("Add"));
		btnAdd.setBounds(60, 200, 80, 25);
		frame.add(btnCancel=new JButton("Cancel"));
		btnCancel.setBounds(145, 200, 80, 25);
		frame.add(btnBack=new JButton("Back"));
		btnBack.setBounds(230, 200, 80, 25);
		
		
		
		btnAdd.addActionListener(new AddShipListener(this));
		btnBack.addActionListener(new AddShipListener(this));
		btnCancel.addActionListener(new AddShipListener(this));
		
	}
}
