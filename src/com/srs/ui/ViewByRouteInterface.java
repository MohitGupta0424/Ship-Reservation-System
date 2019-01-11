package com.wipro.srs.ui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.wipro.srs.listener.ViewByRouteListener;

public class ViewByRouteInterface extends JFrame 
{
    public  JLabel RouteIdlbl;
    public  JTextField txtRouteId;
    public JButton viewButton,Cancelbtn,Backbtn;
    public   JPanel panel;
    public JTable table;
	public Object rows[]=new Object[4];
	public DefaultTableModel model=new DefaultTableModel();
	public JScrollPane pane;
	public JOptionPane jpane1;
   
   public ViewByRouteInterface()
   {
	    setTitle("View By RouteId");
	    setLayout(new GridLayout(0,1));
		setLocation(350,220);
		setSize(400,400);
		setVisible(true);
		setResizable(false);
		
		panel=new JPanel();
		
		RouteIdlbl=new JLabel("Route Id:");
		txtRouteId=new JTextField(10);
		
		panel.add(RouteIdlbl);
		panel.add(txtRouteId);
	
		
		model=new DefaultTableModel();
        model.addColumn("Source");
		model.addColumn("Destination");
		model.addColumn("Travel Duration");
		model.addColumn("Fare");
		table=new JTable(model);
		pane=new JScrollPane(table);

		add(pane);
		
		viewButton=new JButton("View By Route Id");
		panel.add(viewButton);
		viewButton.addActionListener(new ViewByRouteListener(this));
		
		Cancelbtn=new JButton("Cancel");
		panel.add(Cancelbtn);
		Cancelbtn.addActionListener(new ViewByRouteListener(this));
		
		Backbtn=new JButton("Back");
		panel.add(Backbtn);
		Backbtn.addActionListener(new ViewByRouteListener(this));
		panel.setBackground(Color.WHITE);
		getContentPane().add(panel);
   }
   
   public static void main(String[] args)
   {
	   ViewByRouteInterface viewUI=new ViewByRouteInterface();
	   viewUI.setVisible(true);
   }
 
}
