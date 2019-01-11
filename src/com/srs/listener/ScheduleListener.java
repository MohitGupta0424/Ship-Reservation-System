package com.wipro.srs.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.wipro.srs.ui.AddScheduleUi;
import com.wipro.srs.ui.DeleteScheduleUi;
import com.wipro.srs.ui.ModifyScheduleUi;
import com.wipro.srs.ui.ScheduleUi;
import com.wipro.srs.ui.ViewScheduleByIdUi;
import com.wipro.srs.ui.ViewScheduleUi;

public class ScheduleListener implements ActionListener
{
	ScheduleUi ui;
	ViewScheduleUi viewUi;
	
	public ScheduleListener(ScheduleUi ui) 
	{
		this.ui=ui;
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==ui.btnAdd)
		{
			new AddScheduleUi();
		}
		if(e.getSource()==ui.btnDelete)
		{
			new DeleteScheduleUi();
		}
		if(e.getSource()==ui.btnModify)
		{
			new ModifyScheduleUi();
		}
		if(e.getSource()==ui.btnView)
		{
			new ViewScheduleUi();
		}
		if(e.getSource()==ui.btnViewId)
		{
			new ViewScheduleByIdUi();
		}
		if(e.getSource()==ui.btnBack)
		{
			ui.frame.setVisible(false);
		}
		
	}
}