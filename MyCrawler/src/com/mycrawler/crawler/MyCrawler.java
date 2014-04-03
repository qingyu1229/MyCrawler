package com.mycrawler.crawler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.mycrawler.entity.Company;
import com.mycrawler.utils.SetValuesToBeanUtil;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;

public class MyCrawler extends WebCrawler{
	
	private String domain;
	private Map<String,String> map=new HashMap<String,String>();
	private String reg;
	private Map<String,String> regMap=new HashMap<String,String>();
	
	
	public MyCrawler(String domain,Map<String,String> map,Map<String,String> regMap){
		this.domain=domain;
		this.map=map;
		this.reg=reg;
	}
	
	
	private final static Pattern FILTERS = Pattern.compile(".*(\\.(css|js|bmp|gif|jpe?g" 
            + "|png|tiff?|mid|mp2|mp3|mp4"
            + "|wav|avi|mov|mpeg|ram|m4v|pdf" 
            + "|rm|smil|wmv|swf|wma|zip|rar|gz))$");
	
	
	
	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	}
	
	@Override
	public boolean shouldVisit(WebURL url) {
		// TODO Auto-generated method stub
		String href = url.getURL().toLowerCase();
		
        //return !FILTERS.matcher(href).matches()&&href.startsWith("http://shop")&&href.endsWith("contactinfo.htm") ;
        return !FILTERS.matcher(href).matches()&&(href.indexOf(domain)>-1) ;
	}

	@Override
	public void visit(Page page) {
		String url = page.getWebURL().getURL();
		
        System.out.println("URL: " + url);
        
        if(url.indexOf(domain)<0){
        	return;
        }
        
        if (page.getParseData() instanceof HtmlParseData) {
                HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
                
                Document doc= Jsoup.parse(htmlParseData.getHtml());
                Company c=new Company();
                c.setWebsite(url);//设置URL
                for(Map.Entry<String, String> entry:regMap.entrySet()){
                	//SetValuesToBeanUtil.convertMap(Company.class, );
                	doc.select(entry.getValue());
                	entry.getKey();
                	entry.getValue();
                }
                
                
                
                
                doc.select("");
                
                String text = htmlParseData.getText();
                String html = htmlParseData.getHtml();
                List<WebURL> links = htmlParseData.getOutgoingUrls();
                String title=htmlParseData.getTitle();
                
                
                
                System.out.println("Title:"+title);
                
                System.out.println("Text length: " + text.length());
                System.out.println("Html length: " + html.length());
                System.out.println("Number of outgoing links: " + links.size());
        }
	}
}
