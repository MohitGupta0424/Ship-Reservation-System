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

import com.wipro.srs.listener.AddShipListener;
import com.wipro.srs.listener.RemoveShipListener;

public class RemoveShipUI 
{
	public JButton btnRemove,btnBack,btnCancel;
	public JLabel lblShipId;
	public JTextField txtShipId;
	public JFrame frame;
	public JOptionPane pane;
	public JPanel panel;
	public Choice shipId;

	public RemoveShipUI()
	{
		
		frame=new JFrame();
		frame.add(panel=new JPanel());
		frame.setTitle("Remove Ship");
		frame.setSize(400, 400);
		frame.setLocation(350,220);
		frame.setVisible(true);
		frame.setContentPane(new JLabel(new ImageIcon("src\\3.jpg")));
		frame.setResizable(false);
		frame.add(lblShipId=new JLabel("Ship Id:"));
		lblShipId.setBounds(80, 20, 80, 25);
		frame.add(lblShipId);
		
		
	
		Font font1=new Font("Times New Roman",Font.BOLD,14);
		lblShipId.setFont(font1);
		lblShipId.setForeground(Color.white);
		shipId=new Choice();
		shipId.add("--Select--");
		frame.add(shipId);
		shipId.setBounds(160, 20, 80, 25);
		//frame.add(txtShipId=new JTextField(10));
		//txtShipId.setBounds(160, 20, 100, 25);
		frame.add(btnRemove=new JButton("Delete"));
		btnRemove.setBounds(60, 50, 80, 25);
		frame.add(btnCancel=new JButton("Cancel"));
		btnCancel.setBounds(150, 50, 80, 25);
		frame.add(btnBack=new JButton("Back"));
		btnBack.setBounds(240, 50, 80, 25);
		
		btnRemove.addActionListener(new RemoveShipListener(this));
		btnBack.addActionListener(new RemoveShipListener(this));
		btnCancel.addActionListener(new RemoveShipListener(this));
		frame.addWindowListener(new RemoveShipListener(this));
		}
}
