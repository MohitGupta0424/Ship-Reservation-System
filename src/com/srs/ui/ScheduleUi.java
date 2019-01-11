package com.wipro.srs.ui;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.wipro.srs.listener.ScheduleListener;


public class ScheduleUi 
{
	public JFrame frame;
	public JButton btnAdd,btnDelete,btnModify,btnView,btnViewId,btnBack;
	public ScheduleUi()
	{
	
		try
		{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} 
		catch (ClassNotFoundException | InstantiationException| IllegalAccessException | UnsupportedLookAndFeelException e) 
		{
			e.printStackTrace();
		}
		
		frame=new JFrame();
		frame.setTitle("Schedule Options");
		frame.setLayout(new FlowLayout());
		frame.setSize(300,300);
		frame.setVisible(true);
		frame.setResizable(false);
		
		
		btnAdd=new JButton("Add Schedule");
		frame.add(btnAdd);
		btnAdd.addActionListener(new ScheduleListener(this));
		frame.add(btnDelete=new JButton("Remove Schedule"));
		btnDelete.addActionListener(new ScheduleListener(this));
		frame.add(btnModify=new JButton("Modify Schedule"));
		btnModify.addActionListener(new ScheduleListener(this));
		frame.add(btnView=new JButton("View All Schedule"));
		btnView.addActionListener(new ScheduleListener(this));
		frame.add(btnViewId=new JButton("View Schedule By Id"));
		btnViewId.addActionListener(new ScheduleListener(this));
		frame.add(btnBack=new JButton("EXIT"));
		btnBack.addActionListener(new ScheduleListener(this));
		
		frame.setLocation(350,220);
	}
	
}
