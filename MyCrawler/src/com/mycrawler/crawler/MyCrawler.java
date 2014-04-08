package com.mycrawler.crawler;

import com.mycrawler.entity.Company;
import com.mycrawler.filter.ContainFilter;
import com.mycrawler.filter.UrlFilter;
import com.mycrawler.staticvalues.Staticvalues;
import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;

public class MyCrawler extends WebCrawler {

	private String domain = "";
	private UrlFilter urlFilter;
	private ContainFilter containFilter;

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
		return (!Staticvalues.FILTERS.matcher(href).matches())
				&& href.contains(domain);
	}

	@Override
	public void visit(Page page) {
		String url = page.getWebURL().getURL();

		boolean bl = urlFilter.doFilter();
		if (!bl) {
			return;
		}

		if (page.getParseData() instanceof HtmlParseData) {
			HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
			htmlParseData.getHtml();

			Company c = containFilter.doFilter();

			c.setWebsite(url);
			
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
