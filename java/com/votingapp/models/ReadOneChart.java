package com.votingapp.models;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadOneChart {
	public List<Chart> allCharts;
	
	public ReadOneChart(int id) {
		
		SessionFactory factory = new Configuration()
		.configure()
		.addAnnotatedClass(Chart.class)
		.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			List<Chart> Charts = session.createQuery("from Chart x where x.id="+id).getResultList();
			
			for(Chart x : Charts) {
				System.out.println(x.getQuestion());
			}
			
			this.allCharts = Charts;
			session.getTransaction().commit();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			factory.close();
		}
	}
	

}
