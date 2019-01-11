package com.wipro.srs.ui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;
import com.wipro.srs.bean.PassengerTempBean;
import com.wipro.srs.bean.TempBean;
import com.wipro.srs.dao.PassengerDao;
import com.wipro.srs.listener.ReservationPageOneListener;

public class PassengerUi extends JFrame implements ActionListener
{
	public JLabel lblShipId,lblDate;
	public JTextField txtShipId;//,txtDate;
	public JButton btnSubmit;
	public JTable tbl;
	public JScrollPane pane;
	public DefaultTableModel model;
	public Object col[]=new Object[7];
	public JDateChooser j;
	public PassengerUi() 
	{
	setContentPane(new JLabel(new ImageIcon("src\\1.jpg")));
		setTitle("View Details");
		setVisible(true);
		//setSize(500, 500);
		setLayout(new FlowLayout());
		add(lblShipId=new JLabel("Ship Id"));
		lblShipId.setForeground(Color.white);
		add(txtShipId=new JTextField(10));
		add(lblDate=new JLabel("Date"));
		lblDate.setForeground(Color.white);
		j=new JDateChooser();
		add(j);
		
		
		add(btnSubmit=new JButton("Submit"));
		
		btnSubmit.addActionListener(this);
		
		
		
		/**/
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		if(e.getSource()==btnSubmit)
		{
			ArrayList<PassengerTempBean > al=new ArrayList<>();
			PassengerDao pDao=new PassengerDao();
			try {
				al=pDao.viewPassenger(txtShipId.getText().trim(), j.getDate());
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			model=new DefaultTableModel();
			
			model.addColumn("Ship Id");
			model.addColumn("Ship Name");
			model.addColumn("Jorney Date");
			model.addColumn("Name");
			model.addColumn("Age");
			model.addColumn("Gender");
		//	model.addColumn("No. Of Seats");
			
			Iterator<PassengerTempBean> i=al.iterator();
			while(i.hasNext())
			{
				PassengerTempBean tempBean=new PassengerTempBean();
				tempBean=i.next();
				col[0]=tempBean.getShipId();
				col[1]=tempBean.getShipName();
				col[2]=tempBean.getJourneyDate();
				col[3]=tempBean.getName();
				col[4]=tempBean.getAge();
				col[5]=tempBean.getGender();
				//col[6]=tempBean.getNoOfSeats();
				//col[7]=tempBean.getSeats();
				model.addRow(col);
			}
			
							
		
			
			tbl=new JTable(model);
			tbl.setSize(200,50);
			pane=new JScrollPane(tbl);
			pane.setBounds(200, 160, 700, 100);
			add(pane);
		}
		
	}
}
