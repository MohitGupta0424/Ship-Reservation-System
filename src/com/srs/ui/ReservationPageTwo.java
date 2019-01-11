package com.wipro.srs.ui;

import java.awt.Choice;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

import com.toedter.calendar.JDateChooser;
import com.wipro.srs.bean.TempBean;
import com.wipro.srs.listener.LoginListener;
import com.wipro.srs.listener.ReservationPageOneListener;
import com.wipro.srs.listener.ReservationPageThreeListener;
import com.wipro.srs.listener.ReservationPageTwoListener;

public class ReservationPageTwo 
{
	
	public JFrame frame1;
	public JTextField txt_UID_top,txt_SOURCE,txt_DESTINATION,txt_NAME,txt_AGE,txt_GENDER;
	public JDateChooser chooser;
	public JButton btn_logout;
	public JLabel lbl_shipid,lbl_LOGO,lbl_NAME,lbl_AGE,lbl_GENDER,lbl_progress,lbl_no_of_Seats,lbl_totalfare,lbl_totalfareRS;
	public JLabel lbl_1,lbl_2,lbl_3;
	public JButton add,make_payments,btn_cancel;
	public Choice shipIDS,no_of_seats;
	public JRadioButton male,female;
	public JTable tbl;
	public JScrollPane pane;
	public DefaultTableModel model;
	public Object col[]=new Object[8];
	
	public ReservationPageTwo() 
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
		
		lbl_1=new JLabel("1   .");
		lbl_1.setBounds(630,110,200,20);
		frame1.add(lbl_1);
		
		lbl_2=new JLabel("  2   ");
		lbl_2.setBounds(640,110,200,20);
		lbl_2.setFont(new Font("",Font.PLAIN, 28));
		frame1.add(lbl_2);
		
		lbl_1=new JLabel("  .   3");
		lbl_1.setBounds(670,110,200,20);
		frame1.add(lbl_1);
		
		txt_UID_top=new JTextField(10);
		txt_UID_top.setEditable(false);
		txt_UID_top.setText(LoginListener.userid);
		txt_UID_top.setBounds(10,5,100,20);
		frame1.add(txt_UID_top);
		
		btn_logout=new JButton("BACK");
		btn_logout.setBounds(1250, 10,100, 20);
		frame1.add(btn_logout);
		btn_logout.addActionListener(new ReservationPageTwoListener(this));
		
		model=new DefaultTableModel();
		
		model.addColumn("Ship Id");
		model.addColumn("Ship Name");
		model.addColumn("Source");
		model.addColumn("Destination");
		model.addColumn("Date");
		model.addColumn("Fare");
		model.addColumn("Schedule Id");
		model.addColumn("Seats");
		Iterator<TempBean> i=ReservationPageOneListener.al.iterator();
		while(i.hasNext())
		{
			TempBean tempBean=new TempBean();
			tempBean=i.next();
			col[0]=tempBean.getShipId();
			col[1]=tempBean.getShipName();
			col[2]=tempBean.getSource();
			col[3]=tempBean.getDestination();
			col[4]=tempBean.getDate();
			col[5]=tempBean.getFare();
			col[6]=tempBean.getScheduleId();
			col[7]=tempBean.getSeats();
			model.addRow(col);
		}
		tbl=new JTable(model);
		tbl.setSize(200,50);
		pane=new JScrollPane(tbl);
		pane.setBounds(200, 160, 700, 100);
		frame1.add(pane);
		
		lbl_shipid=new JLabel("SHIP ID");
		frame1.add(lbl_shipid);
		lbl_shipid.setBounds(50,300,100,20);
		
		
		shipIDS=new Choice();
		
		for(int j=0;j<ReservationPageOneListener.al.size();j++)
		{
			shipIDS.add(ReservationPageOneListener.al.get(j).getShipId());
		}
		shipIDS.setBounds(150,290,100,20);
		frame1.add(shipIDS);
		
		lbl_NAME=new JLabel("NAME");             txt_NAME=new JTextField(20);
		frame1.add(lbl_NAME);                    frame1.add(txt_NAME);
		lbl_NAME.setBounds(50,340,100,20);       txt_NAME.setBounds(150,340,100,20);
		
		lbl_AGE=new JLabel("AGE");               txt_AGE=new JTextField(20);
		frame1.add(lbl_AGE);                     frame1.add(txt_AGE);
		lbl_AGE.setBounds(50,370,100,20);        txt_AGE.setBounds(150,370,100,20);
		
		lbl_GENDER=new JLabel("GENDER");         
		frame1.add(lbl_GENDER);                  
		lbl_GENDER.setBounds(50,400,100,20);  
		
		male=new JRadioButton("MALE");       female=new JRadioButton("FEMALE"); 
		frame1.add(male);					 frame1.add(female);
		male.setBounds(150,400,100,20);      female.setBounds(250,400,100,20);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(male);
		bg.add(female);
		
		lbl_no_of_Seats=new JLabel("NUMBER OF SEATS");
		lbl_no_of_Seats.setBounds(50,430,150,20);
		frame1.add(lbl_no_of_Seats);
		
		no_of_seats=new Choice();
		for(int j=1;j<=5;j++)
		{
			no_of_seats.addItem(String.valueOf(j));
		}
		frame1.add(no_of_seats);
		no_of_seats.setBounds(200,430,50,20);
		
		btn_cancel=new JButton("CANCEL");
		frame1.add(btn_cancel);
		btn_cancel.setBounds(60,470,150,25);
		btn_cancel.addActionListener(new ReservationPageTwoListener(this));
		
		add=new JButton("SUBMIT DETAILS");
		add.setBounds(60,520,150,25);
		frame1.add(add);
		add.addActionListener(new ReservationPageTwoListener(this));
		
		lbl_totalfare=new JLabel("TOTAL FARE");
		lbl_totalfareRS=new JLabel("RS");
		frame1.add(lbl_totalfare);
		lbl_totalfare.setVisible(false);
		lbl_totalfareRS.setVisible(false);
		frame1.add(lbl_totalfareRS);
		lbl_totalfare.setBounds(400,300,100,20);
		lbl_totalfareRS.setBounds(400,350,100,20);
		
		make_payments=new JButton("MAKE PAYMENTS");
		frame1.add(make_payments);
	make_payments.setVisible(false);
		make_payments.setBounds(400,400,150,25);
		make_payments.addActionListener(new ReservationPageTwoListener(this));
		
	}
	

}


