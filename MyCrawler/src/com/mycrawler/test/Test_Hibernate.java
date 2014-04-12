package com.mycrawler.test;

import org.hibernate.Session;
import org.junit.Test;

import com.mycrawler.entity.Company;
import com.mycrawler.factory.HibernateSessionFactory;

public class Test_Hibernate {
	
	@Test
	public void test_save(){
		Session session= HibernateSessionFactory.getSession();
		session.beginTransaction();
		Company company=new Company();
		company.setAddress("公司地址");
		company.setLinkman("linkman");
		company.setName("name");
		session.save(company);
		session.getTransaction().commit();
		session.close();
		
	}
}
