package com.mycrawler.test;

import org.hibernate.Session;
import org.junit.Test;

import com.mycrawler.dao.CompanyImp;
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
	
	@Test
	public void test_CompantImp(){
		CompanyImp cm=new CompanyImp();
		Company c=new Company();
		c.setWebsite_id("123");
		c.setAddress("address");
		c.setLinkman("联系人");
		c.setName("百度在线");
		cm.addOrUpdateCompany(c);
		
	}
	
}
