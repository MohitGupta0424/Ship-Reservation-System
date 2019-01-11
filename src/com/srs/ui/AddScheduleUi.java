package com.wipro.srs.ui;

import java.awt.Choice;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;
import com.wipro.srs.listener.AddListener;

public class AddScheduleUi 
{
	public JFrame frame1;
	public JLabel lblScheduleId,lblShipId,lblRouteId,lblDate;
	public JTextField txtScheduleId,txtShipId,txtRouteId;
	public JButton btnAddSch,btnCancel,btnBack;
	public JOptionPane pane;
	public JDateChooser j;
	public Choice shipId,routeId;
	
	public AddScheduleUi()
	{
		frame1=new JFrame();
		frame1.setTitle("Add Schedule");
		frame1.setLayout(null);
		frame1.setVisible(true);
		frame1.setSize(400,400);
		frame1.setResizable(false);
		frame1.setContentPane(new JLabel(new ImageIcon("src\\3.jpg")));

		lblScheduleId=new JLabel("Schedule Id");
		lblScheduleId.setBounds(10,20,80,25);
		frame1.add(lblScheduleId);
		txtScheduleId=new JTextField(10);
		txtScheduleId.setBounds(100,20,165,25);
		txtScheduleId.setEditable(false);
		frame1.add(txtScheduleId);
		lblShipId=new JLabel("Ship Id");
		lblShipId.setBounds(10,50,80,25);
		frame1.add(lblShipId);
		//txtShipId=new JTextField(10);
		//txtShipId.setBounds(100,50,165,25);
		shipId=new Choice();
		shipId.add("--Select--");
		frame1.add(shipId);
		shipId.setBounds(100,50,90,25);
		//frame1.add(txtShipId);
		lblRouteId=new JLabel("Route Id");
		lblRouteId.setBounds(10,80,80,25);
		frame1.add(lblRouteId);
		routeId=new Choice();
		routeId.add("--Select--");
		frame1.add(routeId);
		routeId.setBounds(100,80,90,25);
		//txtRouteId=new JTextField(10);
		//txtRouteId.setBounds(100,80,165,25);
		//frame1.add(txtRouteId);
		j=new JDateChooser();
		j.setBounds(100,110,200,25);
		frame1.add(j);
		lblDate=new JLabel("Start Date");
    	lblDate.setBounds(10,110,80,25);
		frame1.add(lblDate);
		j.getDateEditor().setEnabled(false);
		j.setMinSelectableDate(new Date());
		btnAddSch=new JButton("Add");
		btnAddSch.setBounds(50,170,60,25);
		frame1.add(btnAddSch);
		pane=new JOptionPane();
		btnAddSch.addActionListener(new AddListener(this));
		frame1.add(btnCancel=new JButton("Cancel"));
		btnCancel.addActionListener(new AddListener(this));
		btnCancel.setBounds(120,170,80,25);
		frame1.add(btnBack=new JButton("Back"));
		btnBack.addActionListener(new AddListener(this));
		btnBack.setBounds(220,170,80,25);
		frame1.setLocation(350,220);
		frame1.addWindowListener(new AddListener(this));
	}
}
