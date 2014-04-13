package com.mycrawler.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.mycrawler.filter.UrlFilter;


public class Test_UrlFilter {
	
	
	@Test
	public void Test1(){
		
		List<String> containList=new ArrayList<String>();
		List<String> regularList=new ArrayList<String>();
		
		containList.add("baidu");
		containList.add("com");
		String s="(http|https)://[^\\s]*";
		regularList.add(s);
		
	/*	UrlFilter urlfilter=new UrlFilter("http://www.baidu.com/",containList,regularList);
		boolean bl=urlfilter.doFilter();
		System.out.println(bl);*/
		
	}
}
