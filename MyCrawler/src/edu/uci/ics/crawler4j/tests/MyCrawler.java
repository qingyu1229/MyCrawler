package edu.uci.ics.crawler4j.tests;

import java.util.List;
import java.util.regex.Pattern;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;

public class MyCrawler extends WebCrawler{
	
	private static int count=0;
	
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
        return !FILTERS.matcher(href).matches() ;
	}

	@Override
	public void visit(Page page) {
		String url = page.getWebURL().getURL();
		
		count++;
        System.out.println("URL: " + url);
        System.out.println("第"+count+"个网站");
        if (page.getParseData() instanceof HtmlParseData) {
                HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
                
                
                
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
