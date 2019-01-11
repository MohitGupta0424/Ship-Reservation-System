package com.wipro.srs.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import com.wipro.srs.bean.ScheduleBean;
import com.wipro.srs.service.ScheduleService;
import com.wipro.srs.ui.DeleteScheduleUi;

public class DeleteListener implements ActionListener,WindowListener,ItemListener
{
	DeleteScheduleUi delUi;
	ScheduleBean bean;
	ScheduleService service;
	
	public DeleteListener(DeleteScheduleUi delUi) 
	{
		this.delUi=delUi;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		int btn;
		if(e.getSource()==delUi.btnDel)
		{
			bean=new ScheduleBean();
			service=new ScheduleService();
			String schid=delUi.remove.getSelectedItem();
			String result=service.removeSchedule(schid);
			bean.setScheduleID(schid);
			if(delUi.remove.getSelectedItem().equals("--Select--"))
			{
				JOptionPane.showMessageDialog(null,"Select Schedule Id","ERROR",JOptionPane.ERROR_MESSAGE);
			}
			else
			{	
				btn=JOptionPane.showConfirmDialog(null,"Do You Really Want to Delete?");
				
				if(btn==JOptionPane.YES_OPTION)
				{
					if(result=="SUCCESS")
					{
						JOptionPane.showMessageDialog(null,"SUCCESSFULLY DELETED","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
						delUi.frame3.setVisible(false);
					}
					else 
					{
						JOptionPane.showMessageDialog(null,"Update only on Saturday","ERROR",JOptionPane.ERROR_MESSAGE);
						delUi.frame3.setVisible(false);
					}
				}
				else if (btn==JOptionPane.NO_OPTION)
				{
					bean.setScheduleID(delUi.remove.getSelectedItem());
				}
			}	
		}
		if(e.getSource()==delUi.btnBack)
		{
			delUi.frame3.setVisible(false);
		}
		if(e.getSource()==delUi.btnCancel)
		{
			delUi.remove.select(0);

		}
	}

	@Override
	public void windowActivated(WindowEvent e)
	{ }

	@Override
	public void windowClosed(WindowEvent e) 
	{ }

	@Override
	public void windowClosing(WindowEvent e) 
	{ }

	@Override
	public void windowDeactivated(WindowEvent e) 
	{ }

	@Override
	public void windowDeiconified(WindowEvent e) 
	{ }

	@Override
	public void windowIconified(WindowEvent e)
	{ }

	@Override
	public void windowOpened(WindowEvent e) 
	{
		service=new ScheduleService();
		String s="";
		ArrayList list=new ArrayList();
		list=service.getScheduleId();
		Iterator itr=list.iterator();
		while(itr.hasNext())
		{
			s=(String) itr.next();
			delUi.remove.add(s);
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) 
	{
		service=new ScheduleService();
		int btn;
		if(e.getSource()==delUi.remove)
		{
			String schid=delUi.remove.getSelectedItem();
			//delUi.txtScheduleId.setText(schid);
			String result=service.removeSchedule(schid);
		}
	}
}