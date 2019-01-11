package com.wipro.srs.ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;
import com.wipro.srs.listener.LoginListener;
import com.wipro.srs.listener.ReservationPageOneListener;
import com.wipro.srs.listener.ReservationPageThreeListener;

public class ReservationPageOne 
{
	public JFrame frame1;
	public JTextField txt_UID_top,txt_SOURCE,txt_DESTINATION;
	public JDateChooser chooser;
	public JButton btn_logout,btn_searchShips,btn_cancel;
	public JLabel lbl_LOGO,lbl_source,lbl_Destination,lbl_dateofjourney,lbl_progress;
	public JLabel lbl_1,lbl_23;
	
	public JTabbedPane pane=new JTabbedPane();
	public ReservationPageOne()
	{
		frame1=new JFrame("RESERVATION PAGE");
		frame1.setVisible(true);
		frame1.setExtendedState((frame1.getExtendedState()&frame1.MAXIMIZED_BOTH)==frame1.MAXIMIZED_BOTH?JFrame.NORMAL:JFrame.MAXIMIZED_BOTH);
		frame1.setLayout(null);
		frame1.setContentPane(new JLabel(new ImageIcon("src\\reservation.jpg")));

		
		lbl_LOGO=new JLabel("SRS");
		lbl_LOGO.setFont(new Font("OLD ENGLISH TEXT MT", Font.BOLD, 48));
		frame1.add(lbl_LOGO);
		lbl_LOGO.setBounds(600,30,200,50);
		
		lbl_progress=new JLabel("PROGRESS");
		lbl_progress.setBounds(630,80,200,20);
		frame1.add(lbl_progress);
		
		lbl_1=new JLabel("1");
		lbl_1.setBounds(630,105,200,20);
		lbl_1.setFont(new Font("",Font.PLAIN, 28));
		frame1.add(lbl_1);
		
		lbl_23=new JLabel("   .  2  .  3");
		lbl_23.setBounds(640,110,200,20);
		frame1.add(lbl_23);
		
		txt_UID_top=new JTextField(10);
		txt_UID_top.setEditable(false);
		txt_UID_top.setText(LoginListener.userid);
		txt_UID_top.setBounds(10,5,100,20);
		frame1.add(txt_UID_top);
		
		btn_logout=new JButton("BACK");
		btn_logout.setBounds(1250, 10,100, 20);
		frame1.add(btn_logout);
		
		
		
		btn_searchShips=new JButton("SEARCH SHIPS");
		btn_searchShips.setBounds(600,350,150,20);
		frame1.add(btn_searchShips);
		
		btn_cancel=new JButton("CANCEL");
		frame1.add(btn_cancel);
		btn_cancel.setBounds(600,380,150,20);
		btn_cancel.addActionListener(new ReservationPageOneListener(this));
		
		lbl_source=new JLabel("SOURCE");
		lbl_Destination=new JLabel("DESTINATION");
		lbl_dateofjourney=new JLabel("JOURNEY DATE");
		frame1.add(lbl_source);
		frame1.add(lbl_Destination);
		frame1.add(lbl_dateofjourney);
		lbl_source.setBounds(500, 170, 130, 30);
		lbl_Destination.setBounds(500, 220, 130, 30);
		lbl_dateofjourney.setBounds(500, 270, 130, 30);
		
		lbl_source.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 16));
		lbl_Destination.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 16));
		lbl_dateofjourney.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 16));
		
		
		
		txt_SOURCE=new JTextField(20);
		txt_DESTINATION=new JTextField(20);
		chooser=new JDateChooser();
		chooser.getDateEditor().setEnabled(false);
		frame1.add(txt_SOURCE);
		frame1.add(txt_DESTINATION);
		frame1.add(chooser);
		txt_SOURCE.setBounds(700,170,100,20);
		txt_DESTINATION.setBounds(700,220,100,20);
		chooser.setBounds(700,270,100,20);
		chooser.setMinSelectableDate(new Date());
		
		
		
		btn_logout.addActionListener(new ReservationPageOneListener(this));
		btn_searchShips.addActionListener(new ReservationPageOneListener(this) );
		
		
	}
	
	
}
