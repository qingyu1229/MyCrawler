package com.mycrawler.filter;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.mycrawler.entity.Company;
import com.mycrawler.utils.SetValuesToBeanUtil;

public class StrongContainFilter {

	private Map<String,String> map=new HashMap<String,String>();
	private String htmlString="";
	private Map<String,Integer> elementIndexMap=new HashMap<String,Integer>();
	
	@SuppressWarnings("unused")
	private StrongContainFilter()
	{}
	
	public StrongContainFilter(Map<String,String> map,String htmlString,Map<String,Integer> elementIndexMap){
		this.map=map;
		this.htmlString=htmlString;
		this.elementIndexMap=elementIndexMap;
	}
	
	
	public Company doFilter(){
		Company company=new Company();
		Document doc= Jsoup.parse(htmlString);
		Map<String,String> reslutMap=new HashMap<String,String>();
        for(Map.Entry<String, String> entry:map.entrySet()){
        	String key=entry.getKey();
           	String v=doc.select(entry.getValue()).get(elementIndexMap.get(key)).html();
           	reslutMap.put(key, v);
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
