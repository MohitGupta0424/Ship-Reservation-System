package com.wipro.srs.ui;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.wipro.srs.listener.ViewListener;



public class ViewScheduleUi
{
	public JFrame frame4;
	public JLabel lblScheduleId;
	public JTextField txtScheduleId;
	public JTable tblView;
	public JScrollPane pane;
	public JButton btnBack,btnShow;
	public Object rows[]=new Object[4];
	public JPanel panel;
	public DefaultTableModel model;
	
	public ViewScheduleUi()
	{
		frame4=new JFrame();
		frame4.setTitle("View All Schedule");
		frame4.setLayout(new FlowLayout());
		frame4.setVisible(true);
		frame4.setSize(500,500);
		frame4.setResizable(false);
		model=new DefaultTableModel();
		model.addColumn("ScheduleId");
		model.addColumn("ShipId");
		model.addColumn("RouteId");
		model.addColumn("Start");
		tblView=new JTable(model);
		tblView.setSize(200,50);
		pane=new JScrollPane(tblView);
		pane.setBounds(50,80,300,100);
		frame4.add(pane);
		frame4.add(btnBack=new JButton("Back"));

		btnBack.addActionListener(new ViewListener(this));
		frame4.addWindowListener(new ViewListener(this));

		//frame4.setBounds(30,30,500,300);
		frame4.setLocation(300,150);
		frame4.getContentPane().setBackground(Color.WHITE);
		
	}
}
