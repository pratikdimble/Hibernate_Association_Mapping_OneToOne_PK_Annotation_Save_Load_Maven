package com.pratik.dao;


import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pratik.domain.HallTicket;
import com.pratik.domain.Student;
import com.pratik.utility.HibernateUtil;

public class OTO_DAOImpl implements OTO_DAO {
 
	
	@Override
	public void SaveDataUsingStudent() {
	
		Session ses=null;
		Transaction tx=null;
		
		//get the session
		ses=HibernateUtil.getSession();
		//create the object and set the data
		
		Student stud=new Student();
			stud.setStudId(101);
			stud.setStudName("Pratik");
		HallTicket hall=new HallTicket();
			hall.setExam("GATE");
			
				//save objs (parent to child)
				stud.setHall(hall);
				hall.setStud(stud);
				try{
				 tx=ses.beginTransaction();
				   ses.save(stud);
				 tx.commit();
				 System.out.println("Objects are saved....");
				  }//try
				  catch(Exception e){
				    tx.rollback();
				    }
		
	}//SaveDataUsingstudent() method
	
	@Override
	public void loadDataUsingStudent() {
		Session ses=null;
		Query query=null;
		List<Student> studList=null;
		
		//get Session
		ses=HibernateUtil.getSession();
		//create Query obj
		query=ses.createQuery("from Student");
		//execute Query
		studList=query.list();
		//process the Results
		for(Student student:studList){
			System.out.println("Student---->"+student.getStudId()+" "+student.getStudName());
			//get  child of parent
			HallTicket hall=student.getHall();
		
					System.out.println("HallTicket--->"+hall.getTicketId()+" "+hall.getExam());
					
			}//for
	}//loadDataUsingstudent() method
	
	@Override
	public void SaveDataUsingHallTicket() {
		
		Session ses=null;
		Transaction tx=null;
		
		//get the session
		ses=HibernateUtil.getSession();
		//create the object and set the data
		
		Student stud=new Student();
			stud.setStudId(102);
			stud.setStudName("Rohit");
		HallTicket hall=new HallTicket();
			hall.setExam("CAT");
			
				//save objs (parent to child)
				stud.setHall(hall);
				hall.setStud(stud);
				try{
				 tx=ses.beginTransaction();
				   ses.save(hall);
				 tx.commit();
				 System.out.println("Objects are saved....");
				  }//try
				  catch(Exception e){
				    tx.rollback();
				    }
		
	}//SaveDataUsingHallTicket() method

	
	@Override
	public void loadDataUsingHallTicket() {
		Session ses=null;
		Query query=null;
		List<HallTicket> hallList=null;
		
		//get Session
		ses=HibernateUtil.getSession();
		//create Query obj
		query=ses.createQuery("from HallTicket");
		//execute Query
		hallList=query.list();
		//process the Results
		for(HallTicket hall:hallList){
			System.out.println("HallTicket--->"+hall.getTicketId()+" "+hall.getExam());
			
			//get parent of childs
			Student student=hall.getStud();
	
			System.out.println("Student---->"+student.getStudId()+" "+student.getStudName());	
			}//for
	}//loadDataUsingHallTicket()
	
}//class
