package com.xworkz.mobile.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.xworkz.mobile.entity.MobileEntity;

public class MobileDAOImpl implements MobileDAO {

	@Override
	public void saveMobileEntity() {

		System.out.println("Invoked saveMobileEntiy");
		Transaction tran = null;
		Session session = null;
		SessionFactory sf = null;
		try {
			
			//step 1
			Configuration con = new Configuration();
			con.addAnnotatedClass(MobileEntity.class);
			con.configure("hibernate.cfg.xml");
			
			//step 2
			sf = con.buildSessionFactory();
			
			//step 3
			session = sf.openSession();
			
			MobileEntity mobileEntity = new MobileEntity(2, "MI", 20000.00, "124GB", "Blue", 15, true, "Android");
			
			//step 4(transaction)
			tran = session.beginTransaction();
			session.save(mobileEntity);
			
			tran.commit();
			tran.rollback();
			
			session.close();
			sf.close();
			System.out.println("Done");
			
		} catch (HibernateException e) {

			System.out.println("catch block..");
		} finally {
			
			if (session != null) {
				session.close();
				System.out.println("session is closed");
			} else {
				System.out.println("session is not closed");
			}
			if (sf != null) {
				sf.close();
				System.out.println("sessionFactory is closed");
			} else {
				System.out.println("sessionFactory is not closed");
			}
		}
	}

	@Override
	public void getMobileEntity() {

		//to get data only 3 steps are required
		//step 1 configure
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		con.addAnnotatedClass(MobileEntity.class);
		
		//step 2
		SessionFactory sf = con.buildSessionFactory();
		
		//step 3
		Session sessn = sf.openSession();
		MobileEntity mobileEntity = sessn.get(MobileEntity.class, 1);
		
		System.out.println("Mobile entity data " +mobileEntity);
		
		
	}

}
