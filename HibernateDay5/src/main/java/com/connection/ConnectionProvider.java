package com.connection;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConnectionProvider {

	private static SessionFactory factory=null;
	
	public ConnectionProvider() {
		
	}
	
	public static SessionFactory getConnection() {
		if(factory==null) {
			Configuration cnf=new Configuration();
			cnf.configure("resource/hibernate-cnf.xml");
			factory=cnf.buildSessionFactory();
		}
		return factory;
	}
}
