package com.mycrawler.dao;

import org.hibernate.Session;

import com.mycrawler.entity.Company;
import com.mycrawler.factory.HibernateSessionFactory;

public class CompanyImp implements CompanyDao {

	@Override
	public Company getCompany(Company company) {
		// TODO Auto-generated method stub
		
		
		
		return null;
	}

	@Override
	public boolean addCompany(Company company) {
		// TODO Auto-generated method stub
		Session session= HibernateSessionFactory.getSession();
		session.beginTransaction();
		session.save(company);
		session.getTransaction().commit();
		session.close();
		return true;
	}

	@Override
	public boolean existCompany(Company company) {
		// TODO Auto-generated method stub
		
		
		
		return false;
	}

	@Override
	public boolean addOrUpdateCompany(Company company) {
		// TODO Auto-generated method stub
		
		
		
		
		return false;
	}

}
