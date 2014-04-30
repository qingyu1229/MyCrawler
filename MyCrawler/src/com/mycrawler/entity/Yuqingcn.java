package com.mycrawler.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Yuqingcn {
	
	private int yuqingcn_id;
	private String content;
	private String title;
	private String date;
	private String url;
	private String category;
	private Date crawlTime;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)  
	public int getYuqingcn_id() {
		return yuqingcn_id;
	}
	public void setYuqingcn_id(int yuqingcn_id) {
		this.yuqingcn_id = yuqingcn_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Date getCrawlTime() {
		return crawlTime;
	}
	public void setCrawlTime(Date crawlTime) {
		this.crawlTime = crawlTime;
	}
	@Override
	public String toString() {
		return "Yuqingcn [yuqingcn_id=" + yuqingcn_id + ", content=" + content
				+ ", title=" + title + ", date=" + date + ", url=" + url
				+ ", category=" + category + ", crawlTime=" + crawlTime + "]";
	}
	
	
}
