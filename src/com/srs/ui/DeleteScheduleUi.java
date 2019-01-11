package com.wipro.srs.ui;
import java.awt.Choice;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.wipro.srs.listener.DeleteListener;


public class DeleteScheduleUi 
{
	public JFrame frame3;
	public JLabel lblScheduleId,lblShipId,lblRouteId,lblDate;
	public JTextField txtScheduleId,txtShipId,txtRouteId,txtDateField;
	public JButton btnDel,btnBack,btnCancel;
	public JOptionPane pane;
	public Choice remove;
	public DeleteScheduleUi()
	{

		frame3=new JFrame();
		frame3.setTitle("Delete Schedule");
		frame3.setLayout(null);
		frame3.setVisible(true);
		frame3.setSize(400,400);
		frame3.setResizable(false);
		frame3.setContentPane(new JLabel(new ImageIcon("src\\3.jpg")));
		
		lblScheduleId=new JLabel("Schedule Id");
		lblScheduleId.setBounds(10,10,80,25);
		frame3.add(lblScheduleId);
		
		remove=new Choice();
		remove.add("--Select--");
		frame3.add(remove);
		remove.setBounds(90,15,90,25);
		frame3.addWindowListener(new DeleteListener(this));
		frame3.add(btnDel=new JButton("Delete"));
		btnDel.setBounds(200,14,80,25);
		btnDel.addActionListener(new DeleteListener(this));
		frame3.add(btnBack=new JButton("Back"));
		btnBack.setBounds(40,60,80,25);
		btnBack.addActionListener(new DeleteListener(this));
		frame3.add(btnCancel=new JButton("Cancel"));
		btnCancel.setBounds(140,60,80,25);
		btnCancel.addActionListener(new DeleteListener(this));
		
		frame3.setLocation(350,220);
	}
}
