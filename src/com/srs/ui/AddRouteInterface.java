package com.wipro.srs.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.wipro.srs.listener.AddRouteListener;

public class AddRouteInterface extends JFrame 
{

	public JFrame frame,frame1;
	JPanel panel; 
	JLabel RouteIdlbl,Sourcelbl,Destinationlbl,TravelDurationlbl,Farelbl;
	public JTextField txtRouteId;
	public JTextField txtSource;
	public JTextField txtDestination;
	public JTextField txtTravelDuration;
	public JTextField txtFare;
	public JButton Addbtn,Cancelbtn,Backbtn;
	public JOptionPane jpane;
	
	public AddRouteInterface()
	{
		frame=new JFrame();
		frame.setTitle("Add Route");
		frame.setLayout(null);
		frame.setLocation(350,220);
		frame.setSize(400,400);
		frame.setBackground(Color.GRAY);
		frame.setVisible(true);
		frame.setContentPane(new JLabel(new ImageIcon("src\\3.jpg")));
		
		
		frame.setResizable(false);
		
		
		RouteIdlbl =new JLabel("Route Id:");
		RouteIdlbl.setBounds(10, 20, 190, 25);
		Sourcelbl =new JLabel("Source:");
		Sourcelbl.setBounds(10, 50, 190, 25);
		Destinationlbl =new JLabel("Destination:");
		Destinationlbl.setBounds(10, 80, 190, 25);
		TravelDurationlbl =new JLabel("Travel Duration(in hours):");
		TravelDurationlbl.setBounds(10, 110, 190, 25);
		Farelbl =new JLabel("Fare:");
		Farelbl.setBounds(10, 140, 190, 25);

		txtRouteId=new JTextField(10);
		txtRouteId.setEditable(false);
		txtRouteId.setBounds(200, 20, 165, 25);
		txtSource=new JTextField(10);
		txtSource.setBounds(200, 50, 165, 25);
		txtDestination=new JTextField(10);
		txtDestination.setBounds(200, 80, 165, 25);
		txtTravelDuration=new JTextField(10);
		txtTravelDuration.setBounds(200, 110, 165, 25);
		txtFare=new JTextField(10);
		txtFare.setBounds(200, 140, 165, 25);
	
		
		frame.add(RouteIdlbl);
		Font font1=new Font("Times New Roman",Font.BOLD,14);
		RouteIdlbl.setFont(font1);
		RouteIdlbl.setForeground(Color.white);
		
		frame.add(txtRouteId);
		
		frame.add(Sourcelbl);
		Font font2=new Font("Times New Roman",Font.BOLD,14);
		Sourcelbl.setFont(font2);
		Sourcelbl.setForeground(Color.white);
		
		frame.add(txtSource);
		
		frame.add(Destinationlbl);
		Font font3=new Font("Times New Roman",Font.BOLD,14);
		Destinationlbl.setFont(font3);
		Destinationlbl.setForeground(Color.white);
		
		frame.add(txtDestination);
		
		frame.add(TravelDurationlbl);
		Font font4=new Font("Times New Roman",Font.BOLD,14);
		TravelDurationlbl.setFont(font4);
		TravelDurationlbl.setForeground(Color.white);
		
		frame.add(txtTravelDuration);
		
		frame.add(Farelbl);
		Font font5=new Font("Times New Roman",Font.BOLD,14);
		Farelbl.setFont(font5);
		Farelbl.setForeground(Color.white);
		
		frame.add(txtFare);
		
		frame.setLayout(null);

		Addbtn=new JButton("Add");
		frame.add(Addbtn,BorderLayout.CENTER);
		Addbtn.addActionListener(new AddRouteListener(this));
		Font font=new Font("Times New Roman",Font.BOLD,14);
		Addbtn.setFont(font);
		Addbtn.setBounds(60, 200, 80, 25);
			
		Cancelbtn=new JButton("Cancel");
		frame.add(Cancelbtn,BorderLayout.CENTER);
		Cancelbtn.addActionListener(new AddRouteListener(this));
		Font font6=new Font("Times New Roman",Font.BOLD,14);
		Cancelbtn.setFont(font6);
		Cancelbtn.setBounds(145, 200, 80, 25);
		
		Backbtn=new JButton("Back");
		frame.add(Backbtn,BorderLayout.CENTER);
		Backbtn.addActionListener(new AddRouteListener(this));
		Font font7=new Font("Times New Roman",Font.BOLD,14);
		Backbtn.setFont(font7);
		Backbtn.setBounds(230, 200, 80, 25);
		
		
		jpane=new JOptionPane();
		frame.add(jpane);
		jpane.setVisible(false);
		frame.getContentPane().setBackground( Color.lightGray );
		
		}
}
