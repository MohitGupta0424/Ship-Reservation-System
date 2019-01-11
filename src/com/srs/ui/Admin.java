package com.wipro.srs.ui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.wipro.srs.listener.AdminListener;
import com.wipro.srs.listener.LoginListener;
import com.wipro.srs.listener.PassengerListener;

public class Admin 
{
	public JFrame frame3;
	public JButton btn_logout2;
	public JButton btn_changepwd1,btn_SHIP,btn_SCHEDULE,btn_ROUTE;
	public JLabel lbl_welcome_user,lbl_changepwd,lbl_SRS,lbl_uid;
	public JMenuBar srs;

	public JMenu ship,route,schedule;//,Passenger;
	public JMenuItem addShip,removeShip,modifyShip,viewShip;
	public JMenuItem addRoute,removeRoute,modifyRoute,viewAllRoute,viewbyIdRoute;
	public JMenuItem addSchedule,removeSchedule,modifySchedule,viewAllSchedule,viewByIdSchedule;
	public JButton Passenger;
	
	public Admin()
	{
		/*try
		{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} 
		catch (ClassNotFoundException | InstantiationException| IllegalAccessException | UnsupportedLookAndFeelException e) 
		{
			e.printStackTrace();
		}*/
		
		frame3=new JFrame("ADMIN PAGE");
		frame3.setVisible(true);
		frame3.setSize(1020,750);
		frame3.setLayout(null);
		frame3.setContentPane(new JLabel(new ImageIcon("src\\1.jpg")));
		frame3.setExtendedState((frame3.getExtendedState() & frame3.MAXIMIZED_BOTH) == frame3.MAXIMIZED_BOTH ? JFrame.NORMAL : JFrame.MAXIMIZED_BOTH);

		btn_logout2=new JButton("Logout");
		btn_logout2.addActionListener(new AdminListener(this));
		btn_logout2.setBounds(900,10,100, 20);
		frame3.add(btn_logout2);
		btn_logout2.setForeground(Color.black);
		
		lbl_changepwd=new JLabel("Want to Change Password?");
		lbl_changepwd.setForeground(Color.black);
		lbl_changepwd.setBounds(10,600,200,25);
		frame3.add(lbl_changepwd);

		btn_changepwd1=new JButton("Change Password?");
		btn_changepwd1.setBounds(180,600,180, 25);
		btn_changepwd1.addActionListener(new AdminListener(this));
		frame3.add(btn_changepwd1);
		
		lbl_SRS=new JLabel("Ship Reservation System");
		lbl_SRS.setFont(new Font("Times New Roman", Font.BOLD, 58));
		lbl_SRS.setForeground(Color.black);
		lbl_SRS.setBounds(320,20,900,100);
		frame3.add(lbl_SRS);

		lbl_uid=new JLabel();
		lbl_uid.setText(LoginListener.userid);
		lbl_uid.setFont(new Font("Times New Roman", Font.BOLD,18));
		lbl_uid.setForeground(Color.white);
		lbl_uid.setBounds(20,15,200,20);
		frame3.add(lbl_uid);
		
		srs=new JMenuBar();
		ship=new JMenu("Ship");
		route=new JMenu("Route");
		schedule=new JMenu("Schedule");
		Passenger=new JButton("Passenger");
		
		
		addShip=new JMenuItem("Add ");
		addShip.addActionListener(new AdminListener(this));
		removeShip=new JMenuItem("Delete");
		removeShip.addActionListener(new AdminListener(this));
		modifyShip=new JMenuItem("Modify");
		modifyShip.addActionListener(new AdminListener(this));
		viewShip=new JMenuItem("View");
		viewShip.addActionListener(new AdminListener(this));
		
		addRoute=new JMenuItem("Add");
		addRoute.addActionListener(new AdminListener(this));
		removeRoute=new JMenuItem("Delete");
		removeRoute.addActionListener(new AdminListener(this));
		modifyRoute=new JMenuItem("Modify");
		modifyRoute.addActionListener(new AdminListener(this));
		viewAllRoute=new JMenuItem("View All");
		viewAllRoute.addActionListener(new AdminListener(this));
		viewbyIdRoute=new JMenuItem("View By Id");
		viewbyIdRoute.addActionListener(new AdminListener(this));
		
		addSchedule=new JMenuItem("Add");
		addSchedule.addActionListener(new AdminListener(this));
		removeSchedule=new JMenuItem("Delete");
		removeSchedule.addActionListener(new AdminListener(this));
		modifySchedule=new JMenuItem("Modify");
		modifySchedule.addActionListener(new AdminListener(this));
		viewAllSchedule=new JMenuItem("View All");
		viewAllSchedule.addActionListener(new AdminListener(this));
		viewByIdSchedule=new JMenuItem("View By Id");
		viewByIdSchedule.addActionListener(new AdminListener(this));
		Passenger.setBounds(800, 10, 100, 20);
		Passenger.addActionListener(new PassengerListener(this));
		
		ship.add(addShip);
		ship.add(removeShip);
		ship.add(modifyShip);
		ship.add(viewShip);
		
		route.add(addRoute);
		route.add(removeRoute);
		route.add(modifyRoute);
		route.add(viewAllRoute);
		route.add(viewbyIdRoute);

		schedule.add(addSchedule);
		schedule.add(removeSchedule);
		schedule.add(modifySchedule);
		schedule.add(viewAllSchedule);
		schedule.add(viewByIdSchedule);

		srs.add(ship);
		srs.add(route);
		srs.add(schedule);
		//srs.add(Passenger);
		frame3.add(Passenger);
		
		frame3.setJMenuBar(srs);
		
		/*
		btn_SHIP=new JButton("SHIP");
		btn_SHIP.addActionListener(new AdminListener(this));
		btn_SHIP.setBounds(50,150,180, 60);
		frame3.add(btn_SHIP);
		
		btn_ROUTE=new JButton("ROUTE");
		btn_ROUTE.setBounds(400,150,180, 60);
		btn_ROUTE.addActionListener(new AdminListener(this));
		frame3.add(btn_ROUTE);
		
		btn_SCHEDULE=new JButton("SCHEDULE");
		btn_SCHEDULE.setBounds(750,150,180, 60);
		btn_SCHEDULE.addActionListener(new AdminListener(this));
		frame3.add(btn_SCHEDULE);*/
		
		frame3.setDefaultCloseOperation(frame3.EXIT_ON_CLOSE);
	}

}
