package com.mycrawler.entity;

import java.util.Date;

public class Company {
	
	private Long id;
	private String name; //公司名称
	private String industry; //行业
	private String province;//省份
	private String city;//市
	private String town;//镇
	private String linkman; //联系人
	private String  LealPerson ;//法人代表
	private String main_products;//主营产品
	private Date  regDate;//注册时间
	private int regMoney;//注册资金
	private String mobilePhone;//手机
	private String telePhone;//电话
	private String address;//地址
	private String fax;//传真
	private String website;//网站
	private String pro;//简介
	private Date storeDate;//抓取时间
	private int empCount;//员工人数
	private int turnover;//年营业额（单位万元）
	private String website_id;//黄页网上的id或其他唯一标识
	private String parent_web;//所在的黄页网
	private String parent_web_name;//所在的黄页网名称
	
	/*
	public void setValues(String property,String value){
		
	}*/
	
	
	public String getParent_web_name() {
		return parent_web_name;
	}
	public void setParent_web_name(String parent_web_name) {
		this.parent_web_name = parent_web_name;
	}
	public int getEmpCount() {
		return empCount;
	}
	public void setEmpCount(int empCount) {
		this.empCount = empCount;
	}
	public int getTurnover() {
		return turnover;
	}
	public void setTurnover(int turnover) {
		this.turnover = turnover;
	}
	public String getWebsite_id() {
		return website_id;
	}
	public void setWebsite_id(String website_id) {
		this.website_id = website_id;
	}
	public String getParent_web() {
		return parent_web;
	}
	public void setParent_web(String parent_web) {
		this.parent_web = parent_web;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getLinkman() {
		return linkman;
	}
	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}
	public String getLealPerson() {
		return LealPerson;
	}
	public void setLealPerson(String lealPerson) {
		LealPerson = lealPerson;
	}
	public String getMain_products() {
		return main_products;
	}
	public void setMain_products(String main_products) {
		this.main_products = main_products;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getRegMoney() {
		return regMoney;
	}
	public void setRegMoney(int regMoney) {
		this.regMoney = regMoney;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getTelePhone() {
		return telePhone;
	}
	public void setTelePhone(String telePhone) {
		this.telePhone = telePhone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getPro() {
		return pro;
	}
	public void setPro(String pro) {
		this.pro = pro;
	}
	public Date getStoreDate() {
		return storeDate;
	}
	public void setStoreDate(Date storeDate) {
		this.storeDate = storeDate;
	} 
}
