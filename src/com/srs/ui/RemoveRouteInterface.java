package com.wipro.srs.ui;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.wipro.srs.listener.RemoveRouteListener;
import com.wipro.srs.listener.RemoveShipListener;

public class RemoveRouteInterface extends JFrame 
{
	JLabel RouteIdlbl;
	public JTextField txtRouteId;
	public Choice routeId;

	JPanel panel;
	public JButton Removebtn,Cancelbtn,Backbtn;
	public JOptionPane jpane,jpane1;
	public JFrame frame;
	public Object obj[]={"Yes","No","Exit"};
  
	public RemoveRouteInterface()
    {
		frame=new JFrame();
		frame.setTitle("Remove Route");
		frame.setLayout(null);
		frame.setLocation(350,220);
		frame.setSize(400,400);
		//frame.setBackground(Color.cyan);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setContentPane(new JLabel(new ImageIcon("src\\3.jpg")));
		
		
		RouteIdlbl=new JLabel("Route Id:");
		RouteIdlbl.setBounds(30, 20, 80, 25);
		//txtRouteId=new JTextField(10);
		//txtRouteId.setBounds(100, 20, 165, 25);
		
		frame.add(RouteIdlbl);
		Font font5=new Font("Times New Roman",Font.BOLD,14);
		RouteIdlbl.setFont(font5);
		routeId=new Choice();
		routeId.add("--Select--");
		frame.add(routeId);
		routeId.setBounds(150, 20, 80, 25);
		//frame.add(txtRouteId);
		
		Removebtn=new JButton("Remove");
		frame.add(Removebtn);
		Removebtn.addActionListener(new RemoveRouteListener(this));
		Font font1=new Font("Times New Roman",Font.BOLD,14);
		Removebtn.setFont(font1);
		Removebtn.setBounds(30, 50, 100, 25);
		
		Cancelbtn=new JButton("Cancel");
		frame.add(Cancelbtn);
		Cancelbtn.addActionListener(new RemoveRouteListener(this));
		Font font2=new Font("Times New Roman",Font.BOLD,14);
		Cancelbtn.setFont(font2);
		Cancelbtn.setBounds(155, 50, 100, 25);
		
		Backbtn=new JButton("Back");
		frame.add(Backbtn);
		Backbtn.addActionListener(new RemoveRouteListener(this));
		Font font3=new Font("Times New Roman",Font.BOLD,14);
		Backbtn.setFont(font3);
		Backbtn.setBounds(280, 50, 100, 25);
		frame.addWindowListener(new RemoveRouteListener(this));

		//frame.getContentPane().setBackground(Color.blue);
    }
	
	
}
