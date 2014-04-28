package com.mycrawler.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import com.mycrawler.entity.Company;
import com.mycrawler.factory.HibernateSessionFactory;

public class CompanyImp implements CompanyDao {

	@Override
	public Company getCompany(Company company) {
		
		
		
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
		String checkSql="select id from Company  where website_id=? and parent_web_name=?";
		
		Long id=0L;
		Session session= HibernateSessionFactory.getSession();
		session.beginTransaction();
		Query query=session.createQuery(checkSql);
		query.setString(0, company.getWebsite_id());
		query.setString(1, company.getParent_web_name());
		id= (Long) query.uniqueResult();
		System.out.println("--"+id);
		company.setId(id);
		if(id>0){
			session.update(company);
		}
		session.getTransaction().commit();
		session.close();
		return true;
	}

}
