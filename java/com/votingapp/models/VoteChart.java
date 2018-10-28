package com.votingapp.models;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class VoteChart {
	
	public List<Chart> allCharts;
	
	public VoteChart(int id, String newOption) {
		System.out.println("IN NEWOPTION");
		SessionFactory factory = new Configuration()
		.configure()
		.addAnnotatedClass(Chart.class)
		.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			List<Chart> Charts = session.createQuery("from Chart x where x.id="+id).getResultList();
			
			for(Chart x : Charts) {
				x.setOption(newOption);
			}
			
			this.allCharts = Charts;
			session.getTransaction().commit();
		}
		catch(Exception e) {
			System.out.println("EXCEPT");
			System.out.println(e);
		}
		finally {
			factory.close();
		}
	}

}
