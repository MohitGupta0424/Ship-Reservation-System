package com.wipro.srs.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.wipro.srs.bean.PassengerBean;
import com.wipro.srs.bean.PassengerTempBean;
import com.wipro.srs.bean.ReservationBean;
import com.wipro.srs.dao.PassengerDao;

public class PassengerService 
{
	public ArrayList<PassengerTempBean> viewPassenger(String shipId,Date date)
	{
		PassengerDao passengerDao=new PassengerDao();
		try {
			return passengerDao.viewPassenger(shipId, date);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
}
