package com.mycrawler.filter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class UrlFilter implements FilterInterface {
	
	private List<String> containList=new ArrayList<String>();//URL中是否包含指定字符串
	private List<String> regularList=new ArrayList<String>();//正则匹配
	
	private String url="";
	
	private UrlFilter()
	{
		
	}
	public UrlFilter(String url,List<String> containList,List<String> regularList)
	{
		this.url=url;
		this.containList=containList;
		this.regularList=regularList;
	}
	
	
	@Override
	public boolean doFilter() 
	{
		if(containList!=null)
		{
			for(String s:containList)
			{
				if(url.indexOf(s)<0)
				{
					return false;
				}
				
			}
		}
		if(regularList!=null)
		{
			for(String s:regularList)
			{
				Pattern pattern=Pattern.compile(s);//利用正则匹配url
				if(!pattern.matcher(url).matches()){
					return false;
				};
			}
		}
		return true;
	}

}
