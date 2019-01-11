package com.wipro.srs.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.wipro.srs.listener.ViewRouteListener;


public class ViewRouteInterface extends JFrame 
{
	//JLabel mainlbl;
	
	public JTextField txtRouteId;
	public JButton Viewbtn,Cancelbtn;
	public JPanel panel;
	public JTable table;
	public Object rows[]=new Object[5];
	public DefaultTableModel model=new DefaultTableModel();
	public JScrollPane pane;
	public JFrame frame1;
	

	public ViewRouteInterface()
	{
		setTitle("View All Routes");
		setLayout(new FlowLayout());
		setLocation(350,220);
		setSize(500,500);
		setBackground(Color.WHITE);
		setVisible(true);
		setResizable(false);

		//mainlbl=new JLabel("Shows all the routes with RouteId:");
        
        Cancelbtn=new JButton("Back");
		//add(mainlbl);
		

		model=new DefaultTableModel();

		model.addColumn("Id");
		model.addColumn("Source");
		model.addColumn("Destination");
		model.addColumn("Travel Duration");
		model.addColumn("Fare");
		table=new JTable(model);
		pane=new JScrollPane(table);

		add(pane);
		add(Cancelbtn,BorderLayout.SOUTH);
		
	    addWindowListener(new ViewRouteListener(this));
		Cancelbtn.addActionListener(new ViewRouteListener(this));
        
		getContentPane().setBackground(Color.WHITE);
	}

}
