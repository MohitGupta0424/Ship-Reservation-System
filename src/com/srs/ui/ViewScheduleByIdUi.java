package com.wipro.srs.ui;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.wipro.srs.listener.ViewByIdListener;


public class ViewScheduleByIdUi 
{
	public JFrame frame5,frame6;
	public JLabel lblScheduleId;
	public JTextField txtScheduleId;
	public JTable tblView1;
	public JScrollPane pane1;
	public JButton btnBack,btnShow;
	
	public ViewScheduleByIdUi()
	{
		frame5=new JFrame();
		frame5.setTitle("View Schedule By Id");
		frame5.setLayout(new FlowLayout());
		frame5.setSize(400,400);
		frame5.setResizable(false);
		frame5.add(lblScheduleId=new JLabel("Schedule Id"));
		frame5.add(txtScheduleId=new JTextField(10));
		frame5.add(btnShow=new JButton("View"));
		btnShow.addActionListener(new ViewByIdListener(this));
		frame5.add(btnBack=new JButton("Back"));
		btnBack.addActionListener(new ViewByIdListener(this));
		frame5.setVisible(true);
		frame5.setLocation(350,220);
		frame6=new JFrame();
		frame6.setTitle("Details of the Input Id");
		frame6.setLayout(new FlowLayout());
		frame6.setSize(500,500);
		frame6.setResizable(false);
		//frame6.add(btnBack=new JButton("Back"));
		//btnBack.addActionListener(new ViewByIdListener(this));
		frame6.setVisible(false);
		frame6.setLocation(350,220);
		frame5.getContentPane().setBackground(Color.WHITE);
		frame6.getContentPane().setBackground(Color.WHITE);
		
	}
}
