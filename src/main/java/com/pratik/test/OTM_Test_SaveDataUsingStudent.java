package com.pratik.test;

import com.pratik.dao.OTO_DAO;
import com.pratik.dao.OTO_DAOFactory;
import com.pratik.utility.HibernateUtil;

public class OTM_Test_SaveDataUsingStudent {
	public static void main(String[] args) {
		OTO_DAO dao=null;
		//get DAO
		dao=OTO_DAOFactory.getInstance();
		//save objs
		dao.SaveDataUsingStudent();

		
		//close objs
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
	}//main
}//class
