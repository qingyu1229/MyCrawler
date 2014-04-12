package com.mycrawler.dao;

import com.mycrawler.entity.Company;

public interface CompanyDao {
	
	public Company getCompany(Company company);
	public boolean addCompany(Company company);
	public boolean existCompany(Company company);
	public boolean addOrUpdateCompany(Company company);
	
}
