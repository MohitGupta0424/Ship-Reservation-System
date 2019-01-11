package com.wipro.srs.ui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.wipro.srs.bean.PassengerBean;
import com.wipro.srs.bean.ReservationBean;
import com.wipro.srs.service.CustomerService;

public class PrintTicketUI extends JFrame 
{
	
	   public JFrame frame1,frame2;
	   public JPanel panel1,panel2;
	   public JLabel reservationIdlbl1,bookingDatelbl,namelbl,agelbl,genderlbl,noOfSeatslbl,totalFarelbl,journeyDatelbl,bookingStatuslbl;
	   public JLabel txtresservationId,txtreservationId1,txtbookingDate,txtname,txtage,txtgender,txtnoOfSeats,txttotalFare,txtjourneyDate,txtbookingStatus;
	   public JButton printbtn;
	   PassengerBean passengerBean=new PassengerBean();
	   ReservationBean reservationBean=new ReservationBean();
	   CustomerService service=new CustomerService();
	   
	   public PrintTicketUI(String reservationId)
	   {
		   passengerBean=service.printTicket1(reservationId);
		   reservationBean=service.printTicket(reservationId);
		   frame2=new JFrame();
		   frame2.setTitle("Ticket");
		   frame2.setLayout(null);
		   frame2.setSize(600,220);
		   frame2.setLocation(350,220);
		   frame2.setVisible(true);
		   frame2.setResizable(false);
		   
		   
		   reservationIdlbl1=new JLabel("Reservation Id:");
		   reservationIdlbl1.setBounds(10, 20, 150, 25);
		   Font font1=new Font("Times New Roman",Font.BOLD,14);
		   reservationIdlbl1.setFont(font1);
		   reservationIdlbl1.setForeground(Color.black);
		  
		   
		  
		   bookingDatelbl=new JLabel("Booking Date:");
		   bookingDatelbl.setBounds(350, 20, 120, 25);
		   Font font11=new Font("Times New Roman",Font.BOLD,14);
		   bookingDatelbl.setFont(font11);
		   bookingDatelbl.setForeground(Color.black);
		   
		   namelbl=new JLabel("Name:");
		   namelbl.setBounds(10, 50, 80, 25);
		   Font font12=new Font("Times New Roman",Font.BOLD,14);
		   namelbl.setFont(font12);
		   namelbl.setForeground(Color.black);
		   
		   agelbl=new JLabel("Age:");
		   agelbl.setBounds(230, 50, 120, 25);
		   Font font13=new Font("Times New Roman",Font.BOLD,14);
		   agelbl.setFont(font13);
		   agelbl.setForeground(Color.black);
		   
		   genderlbl=new JLabel("Gender:");
		   genderlbl.setBounds(420, 50, 120, 25);
		   Font font14=new Font("Times New Roman",Font.BOLD,14);
		   genderlbl.setFont(font14);
		   genderlbl.setForeground(Color.black);
		   
		   noOfSeatslbl=new JLabel("No of seats:");
		   noOfSeatslbl.setBounds(80, 80, 120, 25);
		   Font font15=new Font("Times New Roman",Font.BOLD,14);
		   noOfSeatslbl.setFont(font15);
		   noOfSeatslbl.setForeground(Color.black);
		   
		   totalFarelbl=new JLabel("Total Fare:");
		   totalFarelbl.setBounds(350, 80, 120, 25);
		   Font font16=new Font("Times New Roman",Font.BOLD,14);
		   totalFarelbl.setFont(font16);
		   totalFarelbl.setForeground(Color.black);
		   
		   journeyDatelbl=new JLabel("Journey Date:");
		   journeyDatelbl.setBounds(200, 110, 120, 25);
		   Font font17=new Font("Times New Roman",Font.BOLD,14);
		   journeyDatelbl.setFont(font17);
		   journeyDatelbl.setForeground(Color.black);
		   
		   bookingStatuslbl=new JLabel("Booking Status:");
		   bookingStatuslbl.setBounds(200, 140, 120, 25);
		   Font font18=new Font("Times New Roman",Font.BOLD,14);
		   bookingStatuslbl.setFont(font18);
		   bookingStatuslbl.setForeground(Color.black);
		   
		   txtreservationId1=new JLabel(reservationBean.getReservationID());
		   txtreservationId1.setBounds(110, 20, 120, 25);
		   Font font19=new Font("Times New Roman",Font.BOLD,14);
		   txtreservationId1.setFont(font19);
		   txtreservationId1.setForeground(Color.red);
		   
		   txtbookingDate=new JLabel(String.valueOf(reservationBean.getBookingDate()));
		   txtbookingDate.setBounds(440, 20, 120, 25);
		   Font font21=new Font("Times New Roman",Font.BOLD,14);
		   txtbookingDate.setFont(font21);
		   txtbookingDate.setForeground(Color.red);
		   
		   txtname=new JLabel(passengerBean.getName());
		   txtname.setBounds(50, 50, 120, 25);
		   Font font31=new Font("Times New Roman",Font.BOLD,14);
		   txtname.setFont(font31);
		   txtname.setForeground(Color.red);
		   
		   txtage=new JLabel(String.valueOf(passengerBean.getAge()));
		   txtage.setBounds(260, 50, 120, 25);
		   Font font41=new Font("Times New Roman",Font.BOLD,14);
		   txtage.setFont(font41);
		   txtage.setForeground(Color.red);
		   
		   txtgender=new JLabel(passengerBean.getGender());
		   txtgender.setBounds(470, 50, 120, 25);
		   Font font51=new Font("Times New Roman",Font.BOLD,14);
		   txtgender.setFont(font51);
		   txtgender.setForeground(Color.red);
		   
		   txtnoOfSeats=new JLabel(String.valueOf(reservationBean.getNoOfSeats()));
		   txtnoOfSeats.setBounds(160, 80, 120, 25);
		   Font font61=new Font("Times New Roman",Font.BOLD,14);
		   txtnoOfSeats.setFont(font61);
		   txtnoOfSeats.setForeground(Color.red);
		   
		   txttotalFare=new JLabel(String.valueOf(reservationBean.getTotalFare()));
		   txttotalFare.setBounds(420, 80, 120, 25);
		   Font font71=new Font("Times New Roman",Font.BOLD,14);
		   txttotalFare.setFont(font71);
		   txttotalFare.setForeground(Color.red);
		   
		   txtjourneyDate=new JLabel(String.valueOf(reservationBean.getJourneyDate()));
		   txtjourneyDate.setBounds(290, 110, 120, 25);
		   Font font81=new Font("Times New Roman",Font.BOLD,14);
		   txtjourneyDate.setFont(font81);
		   txtjourneyDate.setForeground(Color.red);
		   
		   txtbookingStatus=new JLabel(reservationBean.getBookingStatus());
		   txtbookingStatus.setBounds(300, 140, 120, 25);
		   Font font91=new Font("Times New Roman",Font.BOLD,14);
		   txtbookingStatus.setFont(font91);
		   txtbookingStatus.setForeground(Color.red);
		  
		   frame2.add(reservationIdlbl1);
		   frame2.add(txtreservationId1);
		   frame2.add(bookingDatelbl);
		   frame2.add(txtbookingDate);
		   frame2.add(namelbl);
		   frame2.add(txtname);
		   frame2.add(agelbl);
		   frame2.add(txtage);
		   frame2.add(genderlbl);
		   frame2.add(txtgender);
		   frame2.add(noOfSeatslbl);
		   frame2.add(txtnoOfSeats);
		   frame2.add(totalFarelbl);
		   frame2.add(txttotalFare);
		   frame2.add(journeyDatelbl);
		   frame2.add(txtjourneyDate);
		   frame2.add(bookingStatuslbl);
		   frame2.add(txtbookingStatus);
		  
		
		   frame2.getContentPane().setBackground(Color.white);  
		  // frame2.setContentPane(new JLabel(new ImageIcon("D:\\SRSbyabhilasha\\SRS\\src\\com\\wipro\\srs\\ui\\ticket1.jpg")));
	   }
	   
	}


