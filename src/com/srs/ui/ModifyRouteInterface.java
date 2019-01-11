package com.wipro.srs.ui;

import java.awt.Choice;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.wipro.srs.listener.ModifyRouteListener;

public class ModifyRouteInterface extends JFrame 
{
	public JLabel RouteIdlbl,RouteIdlbl1,Sourcelbl,Destinationlbl,TravelDurationlbl,Farelbl;;
	public JTextField txtRouteId,txtRouteId1;
	public JTextField txtSource;
	public JTextField txtDestination;
	public JTextField txtTravelDuration;
	public JTextField txtFare;
	public JPanel panel1,panel2,panel3;
	public JFrame frame1,frame2,frame;
	public JButton Modifybtn,Modifybtn2,Cancelbtn,Cancelbtn2;
	public JOptionPane jpane,jpane1;
	

	
		public ModifyRouteInterface()
		{
			frame1=new JFrame();
			panel1 = new JPanel();
			//panel1.setLayout(new GridLayout(0,2,6,6));
			panel1.setBackground(Color.WHITE);
			
			panel1.add(RouteIdlbl=new JLabel("Route Id:"));
			Font font8=new Font("Times New Roman",Font.BOLD,14);
			RouteIdlbl.setFont(font8);
			RouteIdlbl.setForeground(Color.black);
			
			RouteIdlbl.setBounds(10, 20, 80, 25);
			panel1.add(txtRouteId=new JTextField(10));
			
			
			
			panel1.add(Modifybtn=new JButton("Modify"));
			Font font9=new Font("Times New Roman",Font.BOLD,14);
			Modifybtn.setFont(font9);
			panel1.add(Cancelbtn=new JButton("Cancel"));
			Font font10=new Font("Times New Roman",Font.BOLD,14);
			Cancelbtn.setFont(font10);
			
			frame1.add(panel1);
			frame1.setLayout(new GridLayout(1,0));
			frame1.setTitle("Modify Route");
			frame1.setLocation(350,220);
			frame1. setSize(400,400);
			frame1.setResizable(false);
			frame1.setBackground(Color.WHITE);
			frame1.setVisible(true);

			frame2=new JFrame();
			panel2=new JPanel();
			panel2.setBackground(Color.WHITE);
			panel3=new JPanel();
			panel2.add(RouteIdlbl1=new JLabel("Route Id:"));
			Font font7=new Font("Times New Roman",Font.BOLD,14);
			RouteIdlbl1.setFont(font7);
			
			
			panel2.add(txtRouteId1=new JTextField(17));
			txtRouteId1.setEditable(false);
			
			panel2.add(Sourcelbl =new JLabel("Source:"));
			Font font3=new Font("Times New Roman",Font.BOLD,14);
			Sourcelbl.setFont(font3);
			
			
			panel2.add(txtSource=new JTextField(17));
			panel2.add(Destinationlbl =new JLabel("Destination:"));
			Font font=new Font("Times New Roman",Font.BOLD,14);
			Destinationlbl.setFont(font);
			
			
			panel2.add(txtDestination=new JTextField(17));
			panel2.add(TravelDurationlbl =new JLabel("Travel Duration(in hours):"));
			Font font5=new Font("Times New Roman",Font.BOLD,14);
			TravelDurationlbl.setFont(font5);
			
			
			panel2.add(txtTravelDuration=new JTextField(17));
			panel2.add(Farelbl =new JLabel("Fare:"));
			Font font6=new Font("Times New Roman",Font.BOLD,14);
			Farelbl.setFont(font6);
			
			panel2.add(txtFare=new JTextField(17));
			panel2.setLayout(new GridLayout(0,2));
			panel3.add(Modifybtn2=new JButton("Modify"));
			Font font1=new Font("Times New Roman",Font.BOLD,14);
			Modifybtn2.setFont(font1);
			panel3.add(Cancelbtn2=new JButton("Cancel"));
			Font font2=new Font("Times New Roman",Font.BOLD,14);
			Cancelbtn2.setFont(font2);
			
			frame2.setLayout(new FlowLayout());
			frame2.add(panel2);
			frame2.add(panel3);
			frame2.setTitle("Modifying Route Details");
			frame2.setLocation(350,220);
			frame2.setSize(400,400);
			frame2.setBackground(Color.cyan);
			frame2.setVisible(false);
			frame2.setResizable(false);

			Modifybtn.addActionListener(new ModifyRouteListener(this));
			Modifybtn2.addActionListener(new ModifyRouteListener(this));
			Cancelbtn.addActionListener(new ModifyRouteListener(this));
			Cancelbtn2.addActionListener(new ModifyRouteListener(this));
			
			//frame1.getContentPane().setBackground(Color.light_gray);
			//frame2.getContentPane().setBackground(Color.blue);
		
	}

}