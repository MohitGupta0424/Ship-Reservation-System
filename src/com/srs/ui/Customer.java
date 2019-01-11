package com.wipro.srs.ui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.wipro.srs.listener.CustomerListener;
import com.wipro.srs.listener.LoginListener;

public class Customer 
{
	public JFrame frame2;
	public JButton btn_logout1,btn_changepwd;
	public JButton btn_1,btn_2,btn_3,btn_4,btn_5,btn_6;
	public JLabel lbl_welcome_user,lbl_changepwd,lbl_SRS,lbl_uid;
	public Customer()
	{
		frame2=new JFrame("CUSTOMER PAGE");
		frame2.setVisible(true);
		frame2.setExtendedState((frame2.getExtendedState()&frame2.MAXIMIZED_BOTH)==frame2.MAXIMIZED_BOTH?JFrame.NORMAL:JFrame.MAXIMIZED_BOTH);
		frame2.setLayout(null);
		frame2.setContentPane(new JLabel(new ImageIcon("src\\main_customer.jpg")));

		
		btn_logout1=new JButton("LOGOUT");
		btn_logout1.addActionListener(new CustomerListener(this));
		frame2.add(btn_logout1);
		btn_logout1.setBounds(1200, 50, 100, 20);
		
		btn_changepwd=new JButton("CHANGE PASSWORD");
		btn_changepwd.addActionListener(new CustomerListener(this));
		frame2.add(btn_changepwd);
		btn_changepwd.setBounds(1150,10,180, 20);
		
		btn_3=new JButton("MAKE RESERVATION");
		btn_4=new JButton("CANCEL RESERVATION");
		btn_5=new JButton("PRINT TICKET");
		btn_6=new JButton("VIEW TICKET");
		
		frame2.add(btn_3);
		frame2.add(btn_4);
		frame2.add(btn_5);
		frame2.add(btn_6);
		btn_6.setBounds(200,200,200,20);
		
		btn_5.setBounds(400,290,200,20);
		btn_4.setBounds(600,200,200,20);
		btn_3.setBounds(400,120,200,20);
		
		
		/*lbl_changepwd=new JLabel("CHANGE PASSWORD??");
		frame2.add(lbl_changepwd);
		lbl_changepwd.setForeground(Color.black);
		lbl_changepwd.setBounds(1000,600,200,20);
		lbl_changepwd.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 14));*/
		
		lbl_SRS=new JLabel("SRS");
		lbl_SRS.setFont(new Font("OLD ENGLISH TEXT MT", Font.BOLD, 48));
		frame2.add(lbl_SRS);
		lbl_SRS.setBounds(440, 190,200,50);
		
		lbl_welcome_user=new JLabel(" WELCOME USER ");
		frame2.add(lbl_welcome_user);
		lbl_welcome_user.setBounds(30,15,180,20);
		
		lbl_uid=new JLabel();
		lbl_uid.setText(LoginListener.userid);
		lbl_uid.setBounds(150,15,200,20);
		frame2.add(lbl_uid);
		frame2.setDefaultCloseOperation(frame2.EXIT_ON_CLOSE);
		btn_3.addActionListener(new CustomerListener(this));
		btn_6.addActionListener(new CustomerListener(this));
		btn_4.addActionListener(new CustomerListener(this));
		btn_5.addActionListener(new CustomerListener(this));
	}

}
