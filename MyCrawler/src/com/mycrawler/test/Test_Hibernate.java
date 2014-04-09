package com.mycrawler.test;

import org.hibernate.Session;

import com.mycrawler.entity.Company;
import com.mycrawler.factory.HibernateSessionFactory;

public class Test_Hibernate {
	
	public void test_save(){
		Session session= HibernateSessionFactory.getSession();
		
		Company company=new Company();
		company.setAddress("公司地址");
		
		session.save(company);
	}
}
