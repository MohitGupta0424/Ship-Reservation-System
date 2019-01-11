package com.wipro.srs.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.wipro.srs.listener.RouteListener;

public class RouteInterface extends JFrame 
{

	JPanel panel;
	public JButton Addbtn;
	public JButton Viewbtn;
	public JButton ViewByRoutebtn;
	public JButton Modifybtn;
	public JButton Removebtn,Exitbtn;
	public JLabel mainlbl;
	public JFrame frame;
	
	
    public RouteInterface()
    {
       frame=new JFrame();
       frame.setLayout(new GridLayout(0,1));
       frame.setTitle("Route Details");
       frame.setSize(400,400);
       frame.setLocation(350,220);
       frame.setVisible(true);
       frame.setResizable(false);
	   
	   panel=new JPanel();
	   panel.setBackground(Color.darkGray);
	   Addbtn=new JButton("Add the Route");
	   panel.add(Addbtn);
	   Addbtn.addActionListener(new RouteListener(this));
	   Font font5=new Font("Times New Roman",Font.BOLD,16);
	   Addbtn.setFont(font5);
	  
	   
 	   Viewbtn=new JButton("View All Routes");
 	   panel.add(Viewbtn);
	   Viewbtn.addActionListener(new RouteListener(this));
	   Font font4=new Font("Times New Roman",Font.BOLD,16);
	   Viewbtn.setFont(font4);
	   
	   
	   Modifybtn=new JButton("Modify the Route");
	   panel.add(Modifybtn);
	   Modifybtn.addActionListener(new RouteListener(this));
	   Font font3=new Font("Times New Roman",Font.BOLD,16);
	   Modifybtn.setFont(font3);
	   
	   
		  
	   Removebtn=new JButton("Remove the Route");
	   panel.add(Removebtn);
	   Removebtn.addActionListener(new RouteListener(this));
	   Font font2=new Font("Times New Roman",Font.BOLD,16);
	   Removebtn.setFont(font2);
	  
	 
	   ViewByRoutebtn=new JButton("View the Specific Route");
	   panel.add(ViewByRoutebtn);
	   ViewByRoutebtn.addActionListener(new RouteListener(this));
	   Font font1=new Font("Times New Roman",Font.BOLD,16);
	   ViewByRoutebtn.setFont(font1);
	  
	   
	   Exitbtn=new JButton("Exit");
	   panel.add(Exitbtn);
	   Exitbtn.addActionListener(new RouteListener(this));
	   Font font12=new Font("Times New Roman",Font.BOLD,16);
	   Exitbtn.setFont(font12);
	   
	   
	   frame.add(panel);
	  
	   frame.getContentPane().add(panel);
	}
	
    

}
