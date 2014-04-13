package com.mycrawler.crawler;

import org.apache.log4j.Logger;

import com.mycrawler.dao.CompanyImp;
import com.mycrawler.entity.Company;
import com.mycrawler.filter.ContainFilter;
import com.mycrawler.filter.UrlFilter;
import com.mycrawler.staticvalues.Staticvalues;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;

public class MyCrawler extends WebCrawler {

	protected static final Logger logger = Logger.getLogger(MyCrawler.class.getName());
	
	private String domain = "";
	private UrlFilter urlFilter;
	private ContainFilter containFilter;
	
	
	/**
	 * 
	 * @param domain 主域名 例如“http://www.baidu.com” 的domain为'baidu'
	 * @param urlFilter 设置需要抓取内容的URL
	 * @param containFilter 设置抓取内容的规则
	 */
	public MyCrawler(String domain, UrlFilter urlFilter,
			ContainFilter containFilter) {
		this.domain = domain;
		this.urlFilter = urlFilter;
		this.containFilter = containFilter;
	}

	@Override
	public void onStart() {
		super.onStart();
	}

	@Override
	public boolean shouldVisit(WebURL url) {
		String href = url.getURL().toLowerCase();
		logger.info("判断URL-"+url);
		return (!Staticvalues.FILTERS.matcher(href).matches())
				&& href.contains(domain);//仅限本站内抓取
	}

	@Override
	public void visit(Page page) {
		String url = page.getWebURL().getURL();

		boolean bl = urlFilter.doFilter(url);
		if (!bl) {
			return;
		}
		
		if (page.getParseData() instanceof HtmlParseData) {
			HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
			String htmlString= htmlParseData.getHtml();

			Company c = containFilter.doFilter(htmlString);

			c.setWebsite(url);
			CompanyImp ci=new CompanyImp();
			ci.addCompany(c);
			
			logger.info("抓取URL--"+url);
			/*String text = htmlParseData.getText();
			String html = htmlParseData.getHtml();
			List<WebURL> links = htmlParseData.getOutgoingUrls();
			String title = htmlParseData.getTitle();*/
/*
			System.out.println("Title:" + title);

			System.out.println("Text length: " + text.length());
			System.out.println("Html length: " + html.length());
			System.out.println("Number of outgoing links: " + links.size());*/
		}
	}
}
