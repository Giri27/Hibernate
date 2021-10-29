package com.xworkz.tester;

import com.xworkz.mobile.dao.MobileDAO;
import com.xworkz.mobile.dao.MobileDAOImpl;

public class MobileTester {
	
	public static void main(String[] args) {
		
		MobileDAO dao = new MobileDAOImpl();
		//dao.saveMobileEntity();
		
		//dao.getMobileEntity();
		
		//dao.updateMobileEntity();
		
		dao.deleteMobileEntity();
	}

}
