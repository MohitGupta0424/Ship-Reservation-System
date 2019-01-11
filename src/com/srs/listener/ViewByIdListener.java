package com.wipro.srs.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.wipro.srs.bean.ScheduleBean;
import com.wipro.srs.service.ScheduleService;
import com.wipro.srs.ui.ScheduleUi;
import com.wipro.srs.ui.ViewScheduleByIdUi;

public class ViewByIdListener implements ActionListener 
{
	ViewScheduleByIdUi viewByIdUi;
	ScheduleUi ui;
	ScheduleBean bean;
	ScheduleService service;
	
	public ViewByIdListener(ViewScheduleByIdUi viewByIdUi)
	{
		this.viewByIdUi=viewByIdUi;

	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==viewByIdUi.btnShow)
		{
			service=new ScheduleService();
		    bean=new ScheduleBean();
		    bean=service.viewByScheduleId(viewByIdUi.txtScheduleId.getText().trim());
		    if(bean==null||bean.equals(" "))
		    {
		    	viewByIdUi.frame6.setVisible(false);
				JOptionPane.showMessageDialog(null,"Enter Schedule Id ","ERROR",JOptionPane.ERROR_MESSAGE);
				viewByIdUi.txtScheduleId.setText("");
		    }
		    else
		    {
		    	viewByIdUi.frame6.setVisible(true);
		    	String col_names[]=new String[]{"ScheduleId","ShipId","RouteId","Start Date"};
				Object rows[][]=new Object[1][4];
				rows[0][0]=bean.getScheduleID();
				rows[0][1]=bean.getShipID();
				rows[0][2]=bean.getRouteID();
				SimpleDateFormat formatter=new SimpleDateFormat("dd-MMM-yyyy");
				String date = formatter.format(bean.getStartDate());
				rows[0][3]=date;
				
				viewByIdUi.tblView1=new JTable(rows,col_names);
				viewByIdUi.pane1=new JScrollPane();
				viewByIdUi.pane1.setViewportView(viewByIdUi.tblView1);
				viewByIdUi.frame6.add(viewByIdUi.pane1);
		    }
		}
		if(e.getSource()==viewByIdUi.btnBack)
		{
			viewByIdUi.frame5.setVisible(false);
		}
	}
	
}
