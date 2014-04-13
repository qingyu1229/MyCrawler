package com.mycrawler.filter;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.mycrawler.entity.Company;
import com.mycrawler.utils.SetValuesToBeanUtil;

public class ContainFilter {

	private Map<String,String> map=new HashMap<String,String>();
	private String htmlString="";
	
	@SuppressWarnings("unused")
	private ContainFilter()
	{}
	
	public ContainFilter(Map<String,String> map){
		this.map=map;
	}
	
	
	public Company doFilter(String htmlString){
		Company company=new Company();
		Document doc= Jsoup.parse(htmlString);
		Map<String,String> reslutMap=new HashMap<String,String>();
        for(Map.Entry<String, String> entry:map.entrySet()){
           	String v=doc.select(entry.getValue()).get(0).html();
           	reslutMap.put(entry.getKey(), v);
           }
        try {
			company=(Company) SetValuesToBeanUtil.convertMap(Company.class, reslutMap);
		} catch (IntrospectionException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return company;
	}
	
}
