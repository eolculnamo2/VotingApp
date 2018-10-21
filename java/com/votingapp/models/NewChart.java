package com.votingapp.models;

//import javax.security.auth.login.Configuration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class NewChart {
	
	public NewChart(String question, String option, int value, String creator) {
		SessionFactory factory = new Configuration()
		.configure()
		.addAnnotatedClass(Chart.class)
		.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			Chart newChart = new Chart(question,option,value,creator);
			session.beginTransaction();
			session.save(newChart);
			session.getTransaction().commit();
			System.out.println("SAVED");
		}
		finally {
			factory.close();
		}
	}

}
