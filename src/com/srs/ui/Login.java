package com.wipro.srs.ui;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.wipro.srs.listener.LoginListener;

public class Login 
{

	public JFrame frame1;
	public JLabel lbl_logo,lbl_title,lbl_login,lbl_username,lbl_password,lbl_newuser;
	public JTextField txt_username;
	public JPasswordField pwd_password;
	public JButton btn_aboutus,btn_contactus,btn_login,btn_register;
	public JOptionPane msg;
	public Login()
	{
		frame1=new JFrame();
		frame1.setTitle("Login Page");
		frame1.setVisible(true);
		frame1.setSize(1020,750);
		frame1.setLayout(null);
		frame1.setContentPane(new JLabel(new ImageIcon("src\\FULL-HD-WALLPAPERS-48.jpg")));
		frame1.setExtendedState((frame1.getExtendedState() & frame1.MAXIMIZED_BOTH) == frame1.MAXIMIZED_BOTH ? JFrame.NORMAL : JFrame.MAXIMIZED_BOTH);

		lbl_logo=new JLabel();
		
		lbl_logo.setBounds(10,10,90,40);
		txt_username=new JTextField(15);
		txt_username.setOpaque(false);
	
		pwd_password=new JPasswordField(15);
		lbl_title=new JLabel("Ship Reservation System");
		lbl_title.setBounds(180,20,900,100);
		lbl_title.setFont(new Font("Times New Roman", Font.BOLD, 58));
		lbl_title.setForeground(Color.white);
		lbl_login=new JLabel("Login Page");
		lbl_login.setForeground(Color.black);
		lbl_login.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,28));
		lbl_login.setBounds(150,140,250,80);
		lbl_username=new JLabel("User Name");
		lbl_username.setBounds(150,240, 200, 14);
		lbl_username.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
		lbl_username.setForeground(Color.black);
		lbl_password=new JLabel("Password");
		lbl_password.setBounds(150,285,200, 16);
		lbl_password.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
		lbl_password.setForeground(Color.black);
		txt_username=new JTextField(30);
		txt_username.setBounds(260,240,150,20);
		pwd_password=new JPasswordField(20);
		pwd_password.setBounds(260,285,150,20);
		frame1.add(lbl_logo);
		frame1.add(lbl_title);
		frame1.add(lbl_login);
		frame1.add(lbl_username);
		frame1.add(txt_username);
		frame1.add(lbl_password);
		frame1.add(pwd_password);
		btn_login=new JButton("Login");
		btn_login.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 18));
		btn_login.setForeground(Color.black);
		btn_login.setBounds(420,285, 100, 22);
		btn_login.addActionListener(new LoginListener(this));
		frame1.add(btn_login);
		
		btn_contactus=new JButton("Contact Us");
		btn_contactus.setBorderPainted(false);
		btn_contactus.setOpaque(false);
		btn_contactus.setBackground(Color.cyan);
		btn_contactus.setForeground(Color.white);
		btn_contactus.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 18));
		btn_contactus.setBounds(1000,15,140, 20);
		btn_aboutus=new JButton("About Us");
		btn_aboutus.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 18));
		btn_aboutus.setForeground(Color.white);
		btn_aboutus.setBounds(1100,15,140, 20);
		btn_aboutus.setOpaque(false);
		btn_aboutus.setBorderPainted(false);
		btn_aboutus.setBackground(Color.CYAN);
		frame1.add(btn_aboutus);
		frame1.add(btn_contactus);
		btn_aboutus.addActionListener(new LoginListener(this));
		btn_contactus.addActionListener(new LoginListener(this));
		
		lbl_newuser=new JLabel("New User?");
		lbl_newuser.setForeground(Color.black);
		lbl_newuser.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,18));
		lbl_newuser.setBounds(150,315,180,20);
		btn_register=new JButton("Register Here");
		btn_register.setBorderPainted(false);
		btn_register.setOpaque(false);
		btn_register.setBackground(Color.cyan);
		btn_register.setForeground(Color.black);
		btn_register.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,16));
		btn_register.setBounds(220,315,180, 20);
		frame1.add(lbl_newuser);
		frame1.add(btn_register);
		lbl_newuser.setBounds(150,330,100, 20);
		btn_register.setBounds(220,330,150, 20);
		btn_register.addActionListener(new LoginListener(this));
		
		frame1.getContentPane().setBackground(Color.CYAN);
		frame1.setDefaultCloseOperation(frame1.EXIT_ON_CLOSE);
		
	}
	public static void main(String args[])
	{
		new Login();
		
	}
		
}
