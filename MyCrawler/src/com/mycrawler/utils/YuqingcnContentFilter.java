package com.mycrawler.utils;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.mycrawler.entity.Yuqingcn;

public class YuqingcnContentFilter {
	
	public static Yuqingcn doContent(String htmlString){
		
		Yuqingcn yuqingcn=new Yuqingcn();
		Document doc= Jsoup.parse(htmlString);
		String newsContent= doc.select("div#article").text();
		String newDate=doc.select("div.resource").html();
		String newsTitle=doc.select("h1").html();
		String category=doc.select("span.nav_text").text();
		
		yuqingcn.setContent(newsContent);
		yuqingcn.setCrawlTime(new Date());
		yuqingcn.setTitle(newsTitle);
		yuqingcn.setCategory(category);
		
		Pattern filters = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");
		Matcher matcher= filters.matcher(newDate);
		while (matcher.find()) {//通过引擎的find方法查找
			yuqingcn.setDate(matcher.group());
        }
		return yuqingcn;
	}
}
