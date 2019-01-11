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

import com.wipro.srs.listener.ChangePasswordListener;
import com.wipro.srs.listener.LoginListener;

public class ChangePassword 
{
	public JFrame frame5;
	public JLabel lbl_CHANGE_PASSWORD,lbl_USERID,lbl_OLD_PASSWORD,lbl_NEW_PASSWORD,lbl_CONFIRM_PASSWORD,lbl_WELCOME,lbl_uid_top;
	public JTextField txt_userid;
	public JPasswordField pwd_NEWPASSWORD,pwd_CONFIRMPASSWORD,pwd_OLDPASSWORD;
	public JButton btn_HOME,btn_CHANGE;
	public JOptionPane msg;
	public ChangePassword()
	{
		frame5=new JFrame("CHANGE PASSWORD");
		frame5.setVisible(true);
		frame5.setLayout(null);
		frame5.setSize(1020,1000);
		frame5.setExtendedState((frame5.getExtendedState() & frame5.MAXIMIZED_BOTH) == frame5.MAXIMIZED_BOTH ? JFrame.NORMAL : JFrame.MAXIMIZED_BOTH);
		
		frame5.setContentPane(new JLabel(new ImageIcon("src\\1.jpg")));
		lbl_CHANGE_PASSWORD=new JLabel("CHANGE  PASSWORD");
		lbl_CHANGE_PASSWORD.setFont(new Font("Times New Roman", Font.BOLD, 42));
		lbl_CHANGE_PASSWORD.setBounds(380,100,800,50);
		lbl_CHANGE_PASSWORD.setForeground(Color.WHITE);
		frame5.add(lbl_CHANGE_PASSWORD);
		
		lbl_WELCOME=new JLabel("Welcome User ");
		lbl_WELCOME.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lbl_WELCOME.setBounds(10,15,180,20);
		lbl_WELCOME.setForeground(Color.white);
		frame5.add(lbl_WELCOME);
		
		lbl_uid_top=new JLabel();
		lbl_uid_top.setText(LoginListener.userid);
		lbl_uid_top.setBounds(150,15,200,20);
		frame5.add(lbl_uid_top);
		
		//------------------------//---------------------------//
		
		
		lbl_USERID=new JLabel("User ID:");
		lbl_USERID.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lbl_USERID.setBounds(350,180,200,25);
		frame5.add(lbl_USERID);
		
		lbl_OLD_PASSWORD=new JLabel("Old Password:");
		lbl_OLD_PASSWORD.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lbl_OLD_PASSWORD.setBounds(350,230,200,25);
		frame5.add(lbl_OLD_PASSWORD);
		
		lbl_NEW_PASSWORD=new JLabel("New Password:");
		lbl_NEW_PASSWORD.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lbl_NEW_PASSWORD.setBounds(350,280,200,25);
		frame5.add(lbl_NEW_PASSWORD);
		
		lbl_CONFIRM_PASSWORD=new JLabel("Confirm Password:");
		lbl_CONFIRM_PASSWORD.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lbl_CONFIRM_PASSWORD.setBounds(350,330,200,25);
		frame5.add(lbl_CONFIRM_PASSWORD);
		
		//-----------------------//-------------------------------//
		
		txt_userid=new JTextField(20);
		txt_userid.setEditable(false);
		txt_userid.setText(LoginListener.userid);
		txt_userid.setBounds(500, 180, 200, 30);
		frame5.add(txt_userid);
		
		pwd_OLDPASSWORD=new JPasswordField(20);
		pwd_OLDPASSWORD.setBounds(500, 230, 200, 30);
		frame5.add(pwd_OLDPASSWORD);
		
		pwd_NEWPASSWORD=new JPasswordField(20);
		pwd_NEWPASSWORD.setBounds(500, 280, 200, 30);
		frame5.add(pwd_NEWPASSWORD);
		
		pwd_CONFIRMPASSWORD=new JPasswordField(20);
		pwd_CONFIRMPASSWORD.setBounds(500, 330, 200, 30);
		frame5.add(pwd_CONFIRMPASSWORD);
		
		btn_CHANGE=new JButton("Change Password");
		btn_CHANGE.setBounds(420, 410, 200, 30);
		btn_CHANGE.setFont(new Font("Arial", Font.BOLD, 14));
		frame5.add(btn_CHANGE);
		btn_CHANGE.addActionListener(new ChangePasswordListener(this));
		
		btn_HOME=new JButton("Home");
		btn_HOME.setBounds(1250,10,100, 30);
		btn_HOME.setFont(new Font("Arial", Font.BOLD, 14));
		frame5.add(btn_HOME);
		btn_HOME.addActionListener(new ChangePasswordListener(this));
		frame5.setDefaultCloseOperation(frame5.EXIT_ON_CLOSE);
		
		frame5.getContentPane().setBackground(Color.black);
		
	}
}
	
