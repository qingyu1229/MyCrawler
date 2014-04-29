package com.mycrawler.test;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.Session;
import org.junit.Test;

import com.mycrawler.entity.Yuqingcn;
import com.mycrawler.factory.HibernateSessionFactory;

public class TestReg {
	
	
	@Test
	public void Test(){
		Pattern filters = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");
		// \d{4}-\d{2}-\d{2}
		Matcher matcher= filters.matcher("发布日期：2014-04-29  来源：中国企业舆情网  作者：任子鹏");
	/*	boolean bl=matcher.find();
		System.out.println(bl);
		System.out.println(matcher.groupCount());
		//"\\d{4}-\\d{2}-\\d{2}"
*/		while (matcher.find()) {//通过引擎的find方法查找
            System.out.println(matcher.group() + "...." + "start:"
                + matcher.start() + "---->end:" + matcher.end());
        }
	}
	
	@Test
	public void test2(){
		Yuqingcn yuqingcn=new Yuqingcn();
		yuqingcn.setCategory("category");
		yuqingcn.setContent("content");
		yuqingcn.setCrawlTime(new Date());
		yuqingcn.setTitle("title");
		yuqingcn.setUrl("url");
		yuqingcn.setDate("2014-2-2");
		
		Session session= HibernateSessionFactory.getSession();
		session.beginTransaction();
		session.save(yuqingcn);
		session.getTransaction().commit();
		session.close();
	}
}
