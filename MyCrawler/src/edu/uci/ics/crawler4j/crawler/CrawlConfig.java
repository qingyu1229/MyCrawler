/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package edu.uci.ics.crawler4j.crawler;

public class CrawlConfig {

	/**
	 * The folder which will be used by crawler for storing the intermediate
	 * crawl data. The content of this folder should not be modified manually.
	 * 保存爬取数据的目录
	 * 
	 */
	private String crawlStorageFolder;

	/**
	 * If this feature is enabled, you would be able to resume a previously
	 * stopped/crashed crawl. However, it makes crawling slightly slower
	 * 如果为true，在构造时会打开对应env中的database(PendingURLsDB)，获取上一次遗留的未处理的urls
	 */
	private boolean resumableCrawling = false;

	/**
	 * Maximum depth of crawling For unlimited depth this parameter should be
	 * set to -1
	 * 爬取深度
	 */
	private int maxDepthOfCrawling = -1;

	/**
	 * Maximum number of pages to fetch For unlimited number of pages, this
	 * parameter should be set to -1
	 * 最大抓取数
	 * 
	 */
	private int maxPagesToFetch = -1;

	/**
	 * user-agent string that is used for representing your crawler to web
	 * servers. See http://en.wikipedia.org/wiki/User_agent for more details
	 * user-ahent
	 * 
	 */
	private String userAgentString = "crawler4j (http://code.google.com/p/crawler4j/)";

	/**
	 * Politeness delay in milliseconds (delay between sending two requests to
	 * the same host).
	 * 连续发起两次同样的请求的时间间隔 （单位毫秒）
	 * 
	 */
	private int politenessDelay = 200;

	/**
	 * Should we also crawl https pages?
	 * 是否抓取Https 加密的网站
	 * 
	 */
	private boolean includeHttpsPages = false;

	/**
	 * Should we fetch binary content such as images, audio, ...?
	 * 是否抓取多媒体数据
	 * 
	 */
	private boolean includeBinaryContentInCrawling = false;

	/**
	 * Maximum Connections per host
	 * 每个host的最大连接数
	 * 
	 */
	private int maxConnectionsPerHost = 100;

	/**
	 * Maximum total connections
	 * 最大连接数
	 * 
	 */
	private int maxTotalConnections = 100;

	/**
	 * Socket timeout in milliseconds
	 * Socket超时时间
	 */
	private int socketTimeout = 20000;

	/**
	 * Connection timeout in milliseconds
	 * 连接超时时间设置
	 * 
	 */
	private int connectionTimeout = 30000;

	/**
	 * Max number of outgoing links which are processed from a page
	 * 从每个页面中获取的最大输出链接数
	 * 
	 */
	private int maxOutgoingLinksToFollow = 5000;

	/**
	 * Max allowed size of a page. Pages larger than this size will not be
	 * fetched.
	 * 页面最大允许大小，超过这个值的页面将不会被保存
	 * 
	 */
	private int maxDownloadSize = 1048576;

	/**
	 * Should we follow redirects?
	 * 
	 * 是否抓取重定向的网页
	 */
	private boolean followRedirects = true;

	/**
	 * If crawler should run behind a proxy, this parameter can be used for
	 * specifying the proxy host.
	 * 代理服务器地址
	 * 
	 */
	private String proxyHost = null;

	/**
	 * If crawler should run behind a proxy, this parameter can be used for
	 * specifying the proxy port.
	 * 
	 * 代理服务器接口
	 */
	private int proxyPort = 80;

	/**
	 * If crawler should run behind a proxy and user/pass is needed for
	 * authentication in proxy, this parameter can be used for specifying the
	 * username.
	 * 代理名
	 * 
	 */
	private String proxyUsername = null;

	/**
	 * If crawler should run behind a proxy and user/pass is needed for
	 * authentication in proxy, this parameter can be used for specifying the
	 * password.
	 * 
	 * 代理密码
	 */
	private String proxyPassword = null;

	public CrawlConfig() {
	}

	/**
	 * Validates the configs specified by this instance.
	 * 程序验证
	 * @throws Exception
	 */
	public void validate() throws Exception {
		if (crawlStorageFolder == null) {
			throw new Exception("Crawl storage folder is not set in the CrawlConfig.");
		}
		if (politenessDelay < 0) {
			throw new Exception("Invalid value for politeness delay: " + politenessDelay);
		}
		if (maxDepthOfCrawling < -1) {
			throw new Exception("Maximum crawl depth should be either a positive number or -1 for unlimited depth.");
		}
		if (maxDepthOfCrawling > Short.MAX_VALUE) {
			throw new Exception("Maximum value for crawl depth is " + Short.MAX_VALUE);
		}

	}

	public String getCrawlStorageFolder() {
		return crawlStorageFolder;
	}

	/**
	 * The folder which will be used by crawler for storing the intermediate
	 * crawl data. The content of this folder should not be modified manually.
	 */
	public void setCrawlStorageFolder(String crawlStorageFolder) {
		this.crawlStorageFolder = crawlStorageFolder;
	}

	public boolean isResumableCrawling() {
		return resumableCrawling;
	}

	/**
	 * If this feature is enabled, you would be able to resume a previously
	 * stopped/crashed crawl. However, it makes crawling slightly slower
	 */
	public void setResumableCrawling(boolean resumableCrawling) {
		this.resumableCrawling = resumableCrawling;
	}

	public int getMaxDepthOfCrawling() {
		return maxDepthOfCrawling;
	}

	/**
	 * Maximum depth of crawling For unlimited depth this parameter should be
	 * set to -1
	 */
	public void setMaxDepthOfCrawling(int maxDepthOfCrawling) {
		this.maxDepthOfCrawling = maxDepthOfCrawling;
	}

	public int getMaxPagesToFetch() {
		return maxPagesToFetch;
	}

	/**
	 * Maximum number of pages to fetch For unlimited number of pages, this
	 * parameter should be set to -1
	 */
	public void setMaxPagesToFetch(int maxPagesToFetch) {
		this.maxPagesToFetch = maxPagesToFetch;
	}

	public String getUserAgentString() {
		return userAgentString;
	}

	/**
	 * user-agent string that is used for representing your crawler to web
	 * servers. See http://en.wikipedia.org/wiki/User_agent for more details
	 */
	public void setUserAgentString(String userAgentString) {
		this.userAgentString = userAgentString;
	}

	public int getPolitenessDelay() {
		return politenessDelay;
	}

	/**
	 * Politeness delay in milliseconds (delay between sending two requests to
	 * the same host).
	 * 
	 * @param politenessDelay
	 *            the delay in milliseconds.
	 */
	public void setPolitenessDelay(int politenessDelay) {
		this.politenessDelay = politenessDelay;
	}

	public boolean isIncludeHttpsPages() {
		return includeHttpsPages;
	}

	/**
	 * Should we also crawl https pages?
	 */
	public void setIncludeHttpsPages(boolean includeHttpsPages) {
		this.includeHttpsPages = includeHttpsPages;
	}

	public boolean isIncludeBinaryContentInCrawling() {
		return includeBinaryContentInCrawling;
	}

	/**
	 * Should we fetch binary content such as images, audio, ...?
	 */
	public void setIncludeBinaryContentInCrawling(boolean includeBinaryContentInCrawling) {
		this.includeBinaryContentInCrawling = includeBinaryContentInCrawling;
	}

	public int getMaxConnectionsPerHost() {
		return maxConnectionsPerHost;
	}

	/**
	 * Maximum Connections per host
	 */
	public void setMaxConnectionsPerHost(int maxConnectionsPerHost) {
		this.maxConnectionsPerHost = maxConnectionsPerHost;
	}

	public int getMaxTotalConnections() {
		return maxTotalConnections;
	}

	/**
	 * Maximum total connections
	 */
	public void setMaxTotalConnections(int maxTotalConnections) {
		this.maxTotalConnections = maxTotalConnections;
	}

	public int getSocketTimeout() {
		return socketTimeout;
	}

	/**
	 * Socket timeout in milliseconds
	 */
	public void setSocketTimeout(int socketTimeout) {
		this.socketTimeout = socketTimeout;
	}

	public int getConnectionTimeout() {
		return connectionTimeout;
	}

	/**
	 * Connection timeout in milliseconds
	 */
	public void setConnectionTimeout(int connectionTimeout) {
		this.connectionTimeout = connectionTimeout;
	}

	public int getMaxOutgoingLinksToFollow() {
		return maxOutgoingLinksToFollow;
	}

	/**
	 * Max number of outgoing links which are processed from a page
	 */
	public void setMaxOutgoingLinksToFollow(int maxOutgoingLinksToFollow) {
		this.maxOutgoingLinksToFollow = maxOutgoingLinksToFollow;
	}

	public int getMaxDownloadSize() {
		return maxDownloadSize;
	}

	/**
	 * Max allowed size of a page. Pages larger than this size will not be
	 * fetched.
	 */
	public void setMaxDownloadSize(int maxDownloadSize) {
		this.maxDownloadSize = maxDownloadSize;
	}

	public boolean isFollowRedirects() {
		return followRedirects;
	}

	/**
	 * Should we follow redirects?
	 */
	public void setFollowRedirects(boolean followRedirects) {
		this.followRedirects = followRedirects;
	}

	public String getProxyHost() {
		return proxyHost;
	}

	/**
	 * If crawler should run behind a proxy, this parameter can be used for
	 * specifying the proxy host.
	 */
	public void setProxyHost(String proxyHost) {
		this.proxyHost = proxyHost;
	}

	public int getProxyPort() {
		return proxyPort;
	}

	/**
	 * If crawler should run behind a proxy, this parameter can be used for
	 * specifying the proxy port.
	 */
	public void setProxyPort(int proxyPort) {
		this.proxyPort = proxyPort;
	}

	public String getProxyUsername() {
		return proxyUsername;
	}

	/**
	 * If crawler should run behind a proxy and user/pass is needed for
	 * authentication in proxy, this parameter can be used for specifying the
	 * username.
	 */
	public void setProxyUsername(String proxyUsername) {
		this.proxyUsername = proxyUsername;
	}

	public String getProxyPassword() {
		return proxyPassword;
	}

	/**
	 * If crawler should run behind a proxy and user/pass is needed for
	 * authentication in proxy, this parameter can be used for specifying the
	 * password.
	 */
	public void setProxyPassword(String proxyPassword) {
		this.proxyPassword = proxyPassword;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Crawl storage folder: " + getCrawlStorageFolder() + "\n");
		sb.append("Resumable crawling: " + isResumableCrawling() + "\n");
		sb.append("Max depth of crawl: " + getMaxDepthOfCrawling() + "\n");
		sb.append("Max pages to fetch: " + getMaxPagesToFetch() + "\n");
		sb.append("User agent string: " + getUserAgentString() + "\n");
		sb.append("Include https pages: " + isIncludeHttpsPages() + "\n");
		sb.append("Include binary content: " + isIncludeBinaryContentInCrawling() + "\n");
		sb.append("Max connections per host: " + getMaxConnectionsPerHost() + "\n");
		sb.append("Max total connections: " + getMaxTotalConnections() + "\n");
		sb.append("Socket timeout: " + getSocketTimeout() + "\n");
		sb.append("Max total connections: " + getMaxTotalConnections() + "\n");
		sb.append("Max outgoing links to follow: " + getMaxOutgoingLinksToFollow() + "\n");
		sb.append("Max download size: " + getMaxDownloadSize() + "\n");
		sb.append("Should follow redirects?: " + isFollowRedirects() + "\n");
		sb.append("Proxy host: " + getProxyHost() + "\n");
		sb.append("Proxy port: " + getProxyPort() + "\n");
		sb.append("Proxy username: " + getProxyUsername() + "\n");
		sb.append("Proxy password: " + getProxyPassword() + "\n");
		return sb.toString();
	}

}
