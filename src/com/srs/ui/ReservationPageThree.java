package com.wipro.srs.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;
import com.wipro.srs.listener.LoginListener;
import com.wipro.srs.listener.ReservationPageThreeListener;
import com.wipro.srs.listener.ReservationPageTwoListener;

public class ReservationPageThree 
{
	public JFrame frame1;
	public JTextField txt_UID_top,txt_totalfare,txt_cardno,txt_to,txt_from,txt_balance;
	public JButton btn_logout,btn_BOOKTICKET,btn_submit;
	public JLabel lbl_LOGO,lbl_progress;
	public JLabel total_fare,creditCardNumber,to,from,Balance;
	public JButton submit,book_ticket,btn_cancel;
	public JLabel lbl_1,lbl_3;
	
	
	public ReservationPageThree()
	{
		frame1=new JFrame("RESERVATION PAGE");
		frame1.setVisible(true);
		frame1.setBackground(Color.WHITE);
		frame1.setExtendedState((frame1.getExtendedState()&frame1.MAXIMIZED_BOTH)==frame1.MAXIMIZED_BOTH?JFrame.NORMAL:JFrame.MAXIMIZED_BOTH);
		frame1.setLayout(null);
		frame1.setContentPane(new JLabel(new ImageIcon("src\\money.jpg")));

		
		lbl_LOGO=new JLabel("SRS");
		lbl_LOGO.setFont(new Font("OLD ENGLISH TEXT MT", Font.BOLD, 48));
		frame1.add(lbl_LOGO);
		lbl_LOGO.setBounds(600,30,200,50);
		
		lbl_progress=new JLabel("PROGRESS");
		lbl_progress.setBounds(630,80,200,20);
		frame1.add(lbl_progress);
		
		lbl_1=new JLabel("1   .   2   .   ");
		lbl_1.setBounds(630,110,200,20);
		
		frame1.add(lbl_1);
		
		lbl_3=new JLabel(" 3");
		lbl_3.setBounds(680,110,200,20);
		lbl_3.setFont(new Font("",Font.PLAIN, 28));
		frame1.add(lbl_3);
		
		txt_UID_top=new JTextField(10);
		txt_UID_top.setEditable(false);
		txt_UID_top.setText(LoginListener.userid);
		txt_UID_top.setBounds(10,5,100,20);
		frame1.add(txt_UID_top);
		
		btn_logout=new JButton("BACK");
		btn_logout.setBounds(1250, 10,100, 20);
		frame1.add(btn_logout);
		btn_logout.addActionListener(new ReservationPageThreeListener(this));
		
		
		total_fare=new JLabel("TOTAL FARE");
		frame1.add(total_fare);
		total_fare.setBounds(200,150,100,20);
		
		
		
		creditCardNumber=new JLabel("CREDITCARD NO.");
		frame1.add(creditCardNumber);
		creditCardNumber.setBounds(200,180,100,20);
		
		to=new JLabel("VALIDITY TO");
		frame1.add(to);
		to.setBounds(200,210,100,20);
		
		from=new JLabel("VALIDITY FROM");
		frame1.add(from);
		from.setBounds(200,240,100,20);
		
		
		txt_totalfare=new JTextField(20);
		txt_totalfare.setEditable(false);
		txt_totalfare.setBounds(350,150,100,20);
		frame1.add(txt_totalfare);
		txt_totalfare.setText(String.valueOf(ReservationPageTwoListener.totalfare));

		
		txt_cardno=new JTextField(20);
		txt_cardno.setBounds(350,180,100,20);
		frame1.add(txt_cardno);
		
		txt_to=new JTextField(10);
		txt_to.setBounds(350,210,100,20);
		frame1.add(txt_to);
		
		txt_from=new JTextField(10);
		txt_from.setBounds(350,240,100,20);
		frame1.add(txt_from);
		
		submit=new JButton("SUBMIT");
		frame1.add(submit);
		submit.setBounds(250,280,150,20);
		
		btn_cancel=new JButton("CANCEL");
		frame1.add(btn_cancel);
		btn_cancel.setBounds(250,320,150,20);
		btn_cancel.addActionListener(new ReservationPageThreeListener(this));
		
		Balance=new JLabel("A/C BALANCE");
		frame1.add(Balance);
		Balance.setBounds(450,280,100,20);
		
		txt_balance=new JTextField(20);
		txt_balance.setEditable(false);
		txt_balance.setBounds(600,280,100,20);
		frame1.add(txt_balance);
		
		book_ticket=new JButton("BOOK TICKET");
		frame1.add(book_ticket);
		book_ticket.setBounds(250,360,150,20);
		submit.addActionListener(new ReservationPageThreeListener(this));
		book_ticket.addActionListener(new ReservationPageThreeListener(this));
		
		
		
		
		
	}
	

	
}
