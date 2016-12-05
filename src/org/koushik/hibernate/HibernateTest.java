package org.koushik.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javabrains.koushik.dto.Address;
import org.javabrains.koushik.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		
		UserDetails user = new UserDetails();
//		user.setUserId(1);
		user.setUserName("First User");
		
		Address addr = new Address();
		addr.setStreet("Street Name");
		addr.setCity("City Name");
		addr.setState("State Name");
		addr.setPincode("Pin Code");
		
		user.getListOfAddresses().add(addr);
		
		Address addr2 = new Address();
		addr2.setStreet("Second Street Name");
		addr2.setCity("Second City Name");
		addr2.setState("Second State Name");
		addr2.setPincode("Second Pin Code");
		
		user.getListOfAddresses().add(addr2);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		
	}

}
