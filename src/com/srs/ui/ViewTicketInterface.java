package com.wipro.srs.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.wipro.srs.listener.ViewByRouteListener;
import com.wipro.srs.listener.ViewTicketCustomerListener;


public class ViewTicketInterface 
{
	public  JLabel reservationIdlbl;

	public  JTextField txtreservationId;
	public JButton printButton,Cancelbtn,Backbtn;
	public JFrame frame;

	public ViewTicketInterface()
	{

        frame=new JFrame();
		frame.setTitle("View By RouteId");
		frame.setLayout(null);
		frame.setLocation(350,220);
		frame.setSize(400,400);
		frame.setVisible(true);
		frame.setResizable(false);


		reservationIdlbl=new JLabel("Reservation Id:");
		reservationIdlbl.setBounds(30, 20, 120, 25);
		txtreservationId=new JTextField(10);
		txtreservationId.setBounds(130, 20, 165, 25);

		frame.add(reservationIdlbl);
		Font font1=new Font("Times New Roman",Font.BOLD,14);
		reservationIdlbl.setFont(font1);

        frame.add(txtreservationId);
		
        printButton=new JButton("Print Ticket");
        printButton.setBounds(30, 50, 110, 25);
		Font font11=new Font("Times New Roman",Font.BOLD,14);
		printButton.setFont(font11);
		

		Cancelbtn=new JButton("Cancel");
		Cancelbtn.setBounds(150, 50, 80, 25);
		Font font12=new Font("Times New Roman",Font.BOLD,14);
		Cancelbtn.setFont(font12);
		
		Backbtn=new JButton("Back");
		Backbtn.setBounds(240, 50, 80, 25);
		Font font13=new Font("Times New Roman",Font.BOLD,14);
		Backbtn.setFont(font13);
		
		frame.add(printButton);
		frame.add(Cancelbtn);
		frame.add(Backbtn);
		
		printButton.addActionListener(new ViewTicketCustomerListener(this));
		Cancelbtn.addActionListener(new ViewTicketCustomerListener(this));
		Backbtn.addActionListener(new ViewTicketCustomerListener(this));

		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
	}
	
	public static void main(String[] args)
	{
		new ViewTicketInterface();
	}
}
