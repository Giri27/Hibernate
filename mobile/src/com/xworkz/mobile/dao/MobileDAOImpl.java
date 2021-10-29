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
			
			MobileEntity mobileEntity = new MobileEntity(4, "IPhone", 90000.00, "256GB", "Red", 50, true, "IOS");
			
			//step 4(transaction)
			tran = session.beginTransaction();
			session.save(mobileEntity);
			
			tran.commit();
			
			
			session.close();
			sf.close();
			System.out.println("Done");
			
		} catch (HibernateException e) {

			System.out.println("catch block..");
			tran.rollback();
			System.out.println("transaction rolled back");
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
		MobileEntity mobileEntity = sessn.get(MobileEntity.class, 3);
		MobileEntity mobileEntity1 = sessn.get(MobileEntity.class, 4);
		
		System.out.println("Mobile entity data " +mobileEntity);
		System.out.println("Mobile entity data " +mobileEntity1);
		
		
	}

	@Override
	public void updateMobileEntity() {
		
		System.out.println("Invoked updateMobileEntity");
		Configuration con = null;
		SessionFactory sf = null;
		Session session = null;
		Transaction tran = null;
		
		try {
			con = new Configuration();
			con.configure("hibernate.cfg.xml");
			con.addAnnotatedClass(MobileEntity.class);
			sf = con.buildSessionFactory();
			session = sf.openSession();
			
			MobileEntity me = session.get(MobileEntity.class, 2);
			System.out.println("mobile entity "+me);
			me.setBrand("Oppo");
			me.setColor("Silver");
			
			tran = session.beginTransaction();
			session.update(me);
			tran.commit();
			System.out.println("Updated");
			
		} catch (Exception e) {

			System.out.println("Catch block...");
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
	public void deleteMobileEntity() {

		System.out.println("Invoked deleteMobileEntity");
		Configuration con = null;
		SessionFactory sf = null;
		Session session = null;
		Transaction tran = null;
		
		try {
			
			con = new Configuration();
			con.configure("hibernate.cfg.xml");
			con.addAnnotatedClass(MobileEntity.class);
			sf = con.buildSessionFactory();
			session = sf.openSession();
			
			MobileEntity me = session.get(MobileEntity.class, 3);
			System.out.println("mobile entity "+me);
			
			tran = session.beginTransaction();
			session.delete(me);
			tran.commit();
			System.out.println("deleted");
			
		} catch (HibernateException e) {

			System.out.println("Catch block!.");
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

}
