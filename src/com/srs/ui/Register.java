package com.wipro.srs.ui;

import java.awt.Color;
import java.awt.Font;
import java.util.Date;
import java.util.Locale;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;
import com.wipro.srs.listener.RegisterListener;

public class Register 
{

	public JFrame RegistrationFrame;
	public JLabel lbl_CustomerDetails,lbl_firstname,lbl_lastname,lbl_dob,lbl_gender,lbl_street,lbl_userid;
	public JLabel lbl_location,lbl_city,lbl_state,lbl_pin,lbl_mobile,lbl_email,lbl_password;
	public JTextField txt_date,txt_firstname,txt_lastname,txt_street,txt_location,txt_city;
	public JTextField txt_state,txt_pin,txt_mobile,txt_email;
	public JComboBox dropdown_date,dropdown_month,dropdown_year;
	public JRadioButton btn_male,btn_female;
	public JPasswordField pwd;
	public JButton btn_submit,btn_finalsubmit,btn_back;
	public JDateChooser chooser;
	public JTextField window;
	public JOptionPane msg1;
	
	public Register()
	{
		RegistrationFrame=new JFrame("REGISTRATION FORM");
		RegistrationFrame.setVisible(true);
		RegistrationFrame.setSize(1020,500);
		RegistrationFrame.setLayout(null);
		//RegistrationFrame.getContentPane().setForeground(Color.white);
		
		lbl_CustomerDetails=new JLabel("USER   DETAILS");
		lbl_CustomerDetails.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,26));
		lbl_CustomerDetails.setBounds(400,20,300,50);
		lbl_CustomerDetails.setForeground(Color.WHITE);
		RegistrationFrame.add(lbl_CustomerDetails);
		RegistrationFrame.setContentPane(new JLabel(new ImageIcon("src\\1.jpg")));
		RegistrationFrame.setExtendedState((RegistrationFrame.getExtendedState() & RegistrationFrame.MAXIMIZED_BOTH) == RegistrationFrame.MAXIMIZED_BOTH ? JFrame.NORMAL : JFrame.MAXIMIZED_BOTH);

		lbl_firstname=new JLabel("FIRST NAME");     txt_firstname=new JTextField(20);
		lbl_firstname.setBounds(10,70,150,20);      txt_firstname.setBounds(110,70,150,20); 
		lbl_lastname=new JLabel("LAST NAME");       txt_lastname=new JTextField(20);
		lbl_lastname.setBounds(10,100,150,20);      txt_lastname.setBounds(110,100,150,20);
		lbl_dob=new JLabel("DATE OF BIRTH");        //
		lbl_dob.setBounds(10,130,150,20);           //
		lbl_gender=new JLabel("GENDER");            //
		lbl_gender.setBounds(10,160,150,20);        //
		lbl_street=new JLabel("STREET");            txt_street=new JTextField(20);
		lbl_street.setBounds(10,190,150,20);        txt_street.setBounds(110,190,150,20);
		lbl_location=new JLabel("LOCATION");        txt_location=new JTextField(20);
		lbl_location.setBounds(10,220,150,20);      txt_location.setBounds(110,220,150,20);
		lbl_city=new JLabel("CITY");                txt_city=new JTextField(20);
		lbl_city.setBounds(10,250,150,20);          txt_city.setBounds(110,250,150,20);
		lbl_state=new JLabel("STATE");              txt_state=new JTextField(20);
		lbl_state.setBounds(10,280,150,20);         txt_state.setBounds(110,280,150,20);
		lbl_pin=new JLabel("PIN CODE");             txt_pin=new JTextField(20);
		lbl_pin.setBounds(10,310,150,20);           txt_pin.setBounds(110,310,150,20);
		lbl_mobile=new JLabel("MOBILE");            txt_mobile=new JTextField(20);
		lbl_mobile.setBounds(10,340,150,20);        txt_mobile.setBounds(110,340,150,20);
		lbl_email=new JLabel("EMAIL ID");           txt_email=new JTextField(20);
		lbl_email.setBounds(10,370,150,20);         txt_email.setBounds(110,370,150,20);
		
		RegistrationFrame.add(lbl_firstname);
		RegistrationFrame.add(lbl_lastname);
		RegistrationFrame.add(lbl_dob);
		RegistrationFrame.add(lbl_gender);
		RegistrationFrame.add(lbl_street);
		RegistrationFrame.add(lbl_location);
		RegistrationFrame.add(lbl_city);
		RegistrationFrame.add(lbl_state);
		RegistrationFrame.add(lbl_pin);
		RegistrationFrame.add(lbl_mobile);
		RegistrationFrame.add(lbl_email);
		
		
		lbl_firstname.setForeground(Color.white);
		lbl_lastname.setForeground(Color.white);
		lbl_dob.setForeground(Color.white);
		lbl_gender.setForeground(Color.white);
		lbl_street.setForeground(Color.white);
		lbl_location.setForeground(Color.white);
		lbl_city.setForeground(Color.white);
		lbl_state.setForeground(Color.white);
		lbl_pin.setForeground(Color.white);
		lbl_mobile.setForeground(Color.white);
		lbl_email.setForeground(Color.white);
		
		
		RegistrationFrame.add(txt_firstname);
		RegistrationFrame.add(txt_lastname);
		RegistrationFrame.add(txt_street);
		RegistrationFrame.add(txt_location);
		RegistrationFrame.add(txt_city);
		RegistrationFrame.add(txt_state);
		RegistrationFrame.add(txt_pin);
		RegistrationFrame.add(txt_mobile);
		RegistrationFrame.add(txt_email);
		
		
		btn_male=new JRadioButton("MALE");
		btn_male.setBounds(110,160,70,20);     
		btn_female=new JRadioButton("FEMALE");
		btn_female.setBounds(200,160,70,20);     
		ButtonGroup bg=new ButtonGroup();
		bg.add(btn_male);
		bg.add(btn_female);
		btn_female.addActionListener(new RegisterListener(this));
		btn_male.addActionListener(new RegisterListener(this));
		RegistrationFrame.add(btn_male);
		RegistrationFrame.add(btn_female);
		
		chooser=new JDateChooser();
		//txt_date=new JTextField(20);
		chooser.setLocale(Locale.US);
		//txt_date.setBounds(110,130,150,20);
		//RegistrationFrame.add(txt_date);
		chooser.setBounds(110,130,150,20); 
		RegistrationFrame.add(chooser);
		chooser.setMaxSelectableDate(new Date());
		
		btn_submit=new JButton("SUBMIT");
		btn_submit.setBounds(60,400,150,20);
		btn_finalsubmit=new JButton("GENERATE USER ID");
		
		RegistrationFrame.add(btn_submit);
		RegistrationFrame.add(btn_finalsubmit);
		lbl_password=new JLabel("ENTER A PASSWORD");
		lbl_password.setVisible(false);
		lbl_password.setForeground(Color.WHITE);
		lbl_password.setBounds(500,170,150,20);
		lbl_userid=new JLabel("USER ID");
		lbl_userid.setFont(new Font("ariel", Font.ITALIC, 22));
		lbl_userid.setVisible(false);
		lbl_userid.setForeground(Color.WHITE);
		lbl_userid.setBounds(500,70,150,20);
		window=new JTextField();
		window.setBounds(500,100,200,20);
		pwd=new JPasswordField(20);
		pwd.setBounds(500,190,150,20);
		pwd.setVisible(false);
		btn_finalsubmit.setBounds(500,220, 250, 20);
		window.setVisible(false);
		window.setEditable(false);
		pwd.setEditable(true);
		btn_finalsubmit.setVisible(false);
		btn_back=new JButton("BACK");
		btn_back.addActionListener(new RegisterListener(this));
		btn_back.setBounds(1250, 10, 100, 20);
		
		RegistrationFrame.add(lbl_userid);
		RegistrationFrame.add(window);
		RegistrationFrame.add(pwd);
		RegistrationFrame.add(lbl_password);
		RegistrationFrame.add(btn_back);
		RegistrationFrame.setDefaultCloseOperation(RegistrationFrame.EXIT_ON_CLOSE);
		btn_submit.addActionListener(new RegisterListener(this));
		btn_finalsubmit.addActionListener(new RegisterListener(this));
		
	}
	
	
}
