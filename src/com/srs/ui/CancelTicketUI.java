package com.wipro.srs.ui;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import com.wipro.srs.listener.CancelTicketListener;

public class CancelTicketUI extends JFrame 
{
	public JLabel lblReservationId;
	public JButton btnCAncel,btnBack;
	public JTextField txtReservationId;
	public JOptionPane pane;
	public JFrame frame;
	public CancelTicketUI()
	{
		frame=new JFrame();
		frame.setTitle("TICKET CANCELLATION");
		frame.setSize(400,400);
		frame.setVisible(true);
		frame.setLayout(new FlowLayout());
		frame.add(lblReservationId=new JLabel("Reservation id"));
		frame.add(txtReservationId=new JTextField(10));
		frame.add(btnCAncel=new JButton("Cancel Ticket"));
		frame.add(btnBack=new JButton("BACK"));
		btnBack.addActionListener(new CancelTicketListener(this));
		btnCAncel.addActionListener(new CancelTicketListener(this));
		pane=new JOptionPane();
		frame.setLocation(350,220);
	}
	
}
