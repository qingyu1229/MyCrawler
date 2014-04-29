package com.mycrawler.crawler;

import java.util.regex.Pattern;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mycrawler.entity.Yuqingcn;
import com.mycrawler.factory.HibernateSessionFactory;
import com.mycrawler.utils.YuqingcnContentFilter;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;

public class YuqingcnCrawler extends WebCrawler {
	private final static Pattern FILTERS = Pattern.compile(".*(\\.(css|js|bmp|gif|jpe?g" + "|png|tiff?|mid|mp2|mp3|mp4"
			+ "|wav|avi|mov|mpeg|ram|m4v|pdf" + "|rm|smil|wmv|swf|wma|zip|rar|gz))$");
	
	/**
	 * You should implement this function to specify whether the given url
	 * should be crawled or not (based on your crawling logic).
	 */
	@Override
	public boolean shouldVisit(WebURL url) {
		String href = url.getURL().toLowerCase();
		return !FILTERS.matcher(href).matches() && href.startsWith("http://www.yuqingcn.cn/");
	}
	
	
	/**
	 * This function is called when a page is fetched and ready to be processed
	 * by your program.
	 */
	@Override
	public void visit(Page page) {
		int docid = page.getWebURL().getDocid();
		String url = page.getWebURL().getURL();
		/*String domain = page.getWebURL().getDomain();
		String path = page.getWebURL().getPath();
		String subDomain = page.getWebURL().getSubDomain();
		String parentUrl = page.getWebURL().getParentUrl();*/
		System.out.println("Docid: " + docid);
		System.out.println("URL: " + url);
		
		/*System.out.println("Domain: '" + domain + "'");
		System.out.println("Sub-domain: '" + subDomain + "'");
		System.out.println("Path: '" + path + "'");
		System.out.println("Parent page: " + parentUrl);*/
		
		if (page.getParseData() instanceof HtmlParseData) {
			HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
			//String text = htmlParseData.getText();
			String html = htmlParseData.getHtml();
			//List<WebURL> links = htmlParseData.getOutgoingUrls();
			
			Yuqingcn yuqingcn=new Yuqingcn();
			
			if(url.startsWith("http://www.yuqingcn.cn/www/show")){
				 yuqingcn= YuqingcnContentFilter.doContent(html);
				 yuqingcn.setUrl(url);
					System.out.println(yuqingcn.toString());
					Session session= HibernateSessionFactory.getSession();
					try {
						Transaction tx = null; 
						tx=session.getTransaction();
						tx.begin();
						session.save(yuqingcn);
						tx.commit();
						
					} catch (HibernateException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally{
						session.close();
					}
			}
			
			/*System.out.println("Text length: " + text.length());
			System.out.println("Html length: " + html.length());
			System.out.println("Number of outgoing links: " + links.size());*/
		}

		System.out.println("====================================================");
	}
	
}
