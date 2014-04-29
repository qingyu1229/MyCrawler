package com.mycrawler;

import com.mycrawler.crawler.YuqingcnCrawler;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

public class YuqingcnCrawlerController {
	
	
	public static void main(String[] args) throws Exception {
		/*if (args.length != 2) {
			System.out.println("Needed parameters: ");
			System.out.println("\t rootFolder (it will contain intermediate crawl data)");
			System.out.println("\t numberOfCralwers (number of concurrent threads)");
			return;
		}*/

		/*
		 * crawlStorageFolder is a folder where intermediate crawl data is
		 * stored.
		 * 存储临时数据的路径
		 */
		String crawlStorageFolder = "D:\\yuqing";

		/*
		 * numberOfCrawlers shows the number of concurrent threads that should
		 * be initiated for crawling.
		 * 
		 * 并发线程数
		 * 
		 */
		int numberOfCrawlers = Integer.parseInt("10");
		
		CrawlConfig config = new CrawlConfig();

		//设置临时数据路径
		config.setCrawlStorageFolder(crawlStorageFolder);

		/*
		 * Be polite: Make sure that we don't send more than 1 request per
		 * second (1000 milliseconds between requests).
		 * 
		 * 设置发送两次请求的时间间隔
		 */
		config.setPolitenessDelay(200);

		/*
		 * You can set the maximum crawl depth here. The default value is -1 for
		 * unlimited depth
		 * 设置抓取深度（-1时为不限深度）
		 * 
		 */
		config.setMaxDepthOfCrawling(6);

		/*
		 * You can set the maximum number of pages to crawl. The default value
		 * is -1 for unlimited number of pages
		 * 
		 * 设置能够抓取的最大页面数
		 */
		config.setMaxPagesToFetch(-1);

		/*
		 * 以下代码可以用来设置代理
		 * Do you need to set a proxy? If so, you can use:
		 * config.setProxyHost("proxyserver.example.com");
		 * config.setProxyPort(8080);
		 * 
		 * If your proxy also needs authentication:
		 * config.setProxyUsername(username); config.getProxyPassword(password);
		 */

		/*
		 * This config parameter can be used to set your crawl to be resumable
		 * (meaning that you can resume the crawl from a previously
		 * interrupted/crashed crawl). Note: if you enable resuming feature and
		 * want to start a fresh crawl, you need to delete the contents of
		 * rootFolder manually.
		 * 设置爬虫是否可断点抓取，如果设置为可以断点抓取，则再次抓取时需要手动的删除对应文件夹
		 */
		config.setResumableCrawling(true);

		/*
		 * Instantiate the controller for this crawl.
		 * 初始化爬虫的controller
		 */
		PageFetcher pageFetcher = new PageFetcher(config);
		
		
		
		RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
		
		robotstxtConfig.setEnabled(false);//设置不遵循Robots.txt协议
		//robotstxtConfig.setUserAgentName("myCrawler4J");//设置爬虫名称
		//robotstxtConfig.setCacheSize(1000);
		
		
		RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
		
		
		
		CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);

		/*
		 * For each crawl, you need to add some seed urls. These are the first
		 * URLs that are fetched and then the crawler starts following links
		 * which are found in these pages
		 */

		controller.addSeed("http://www.yuqingcn.cn/");
		/*controller.addSeed("http://www.ics.uci.edu/~lopes/");
		controller.addSeed("http://www.ics.uci.edu/~welling/");*/
		
		/*
		 * Start the crawl. This is a blocking operation, meaning that your code
		 * will reach the line after this only when crawling is finished.
		 */
		controller.start(YuqingcnCrawler.class, numberOfCrawlers);
		/*Thread.sleep(30 * 1000);
		controller.Shutdown();
		controller.waitUntilFinish();*/
	}
}
