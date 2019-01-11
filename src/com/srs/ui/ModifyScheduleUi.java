package com.wipro.srs.ui;

import java.awt.Choice;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;
import com.wipro.srs.listener.ModifyListener;


public class ModifyScheduleUi 
{
	public JFrame frame2,frame7;
	public JPanel panel;
	public JLabel lblScheduleId,lblShipId,lblRouteId,lblDate;
	public JTextField txtScheduleId,txtShipId,txtRouteId,txtDateField;
	public JButton btnModifySch,btnGet,btnCancel,btnBack,btnBck,btnCncl;
	public JOptionPane pane;
	public Choice id;
	public JDateChooser j;
	public  ModifyScheduleUi() 
	{
		frame2=new JFrame();
		frame2.setTitle("Modify Schedule");
		frame2.setLayout(null);
		frame2.setVisible(true);
		frame2.setSize(400,400);
		frame2.setResizable(false);
		frame2.setLocation(350,220);
		//frame2.setContentPane(new JLabel(new ImageIcon("src\\3.jpg")));

		lblScheduleId=new JLabel("Schedule Id");
		lblScheduleId.setBounds(10,10,80,35);
		frame2.add(lblScheduleId);
		id=new Choice();
		id.add("--Select--");
		frame2.add(id);
		id.setBounds(90,20,80,35);
		frame2.addWindowListener(new ModifyListener(this));
		frame2.add(btnGet=new JButton("Get"));
		btnGet.setBounds(190,18,70,25);
		btnGet.addActionListener(new ModifyListener(this));
		frame2.add(btnBack=new JButton("Back"));
		btnBack.addActionListener(new ModifyListener(this));
		btnBack.setBounds(40,60,80,25);
		frame2.add(btnCancel=new JButton("Cancel"));
		btnCancel.addActionListener(new ModifyListener(this));
		btnCancel.setBounds(150,60,80,25);

		frame7=new JFrame();
		frame7.setTitle("Modifying Schedule Details");
		frame7.setSize(400,400);
		frame7.setLayout(null);
		frame7.setResizable(false);
		lblShipId=new JLabel("Ship Id");
		lblShipId.setBounds(10,20,80,25);
		frame7.add(lblShipId);
		txtShipId=new JTextField(10);
		txtShipId.setBounds(100,20,165,25);
		frame7.add(txtShipId);
		txtShipId.setEditable(false);
		lblRouteId=new JLabel("Route Id");
		lblRouteId.setBounds(10,50,80,25);
		frame7.add(lblRouteId);
		txtRouteId=new JTextField(10);
		txtRouteId.setEditable(false);
		txtRouteId.setBounds(100,50,165,25);
		frame7.add(txtRouteId);
		lblDate=new JLabel("Start Date");
		lblDate.setBounds(10,80,80,25);
		frame7.add(lblDate);
		j=new JDateChooser();
		j.getDateEditor().setEnabled(false);
		frame7.add(j);
		j.setBounds(100,80,165,25);
		btnModifySch=new JButton("Modify");
		btnModifySch.setBounds(70,120, 80, 25);
		frame7.add(btnModifySch);
		btnModifySch.addActionListener(new ModifyListener(this));
		pane=new JOptionPane();
		frame7.add(btnBck=new JButton("Back"));
		btnBck.addActionListener(new ModifyListener(this));
		btnBck.setBounds(170,120, 80, 25);
		j.getDateEditor().setEnabled(false);

		btnCncl=new JButton("Cancel");
		frame7.add(btnCncl);
		btnCncl.addActionListener(new ModifyListener(this));
		btnCncl.setBounds(110,150,80,25);
		frame7.setVisible(false);
		frame7.setLocation(350,220);
		//frame7.setContentPane(new JLabel(new ImageIcon("src\\3.jpg")));
	}
}
