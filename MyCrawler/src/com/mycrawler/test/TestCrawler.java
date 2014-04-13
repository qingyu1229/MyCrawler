package com.mycrawler.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.mycrawler.crawler.MyCrawler;
import com.mycrawler.filter.ContainFilter;
import com.mycrawler.filter.UrlFilter;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;

public class TestCrawler {
	
	
	
	@Test
	public void Test1(){
		String domain = "";
		
		List<String> containList=new ArrayList<String>();
		List<String> regularList=new ArrayList<String>();
		UrlFilter urlFilter=new UrlFilter(containList,regularList);
		
		Map<String,String> map=new HashMap<String,String>();
		
		ContainFilter containFilter=new ContainFilter(map);
		
		MyCrawler mycrawler=new MyCrawler(domain,urlFilter,containFilter);
		
		
		
		
	}
}
