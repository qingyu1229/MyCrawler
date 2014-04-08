package com.mycrawler.test;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;


public class Test_Jsoup {
	
	@Test
	public void Test1(){
		Document doc;
		Connection conn= Jsoup.connect("http://vmagnet.1688.com/?tracelog=p4p");
		try {
			doc=conn.get();
			Elements elements= doc.select("span.info");
			Element element=elements.get(0);
			System.out.println("htlm()--"+element.html());
			System.out.println("baseUri)--"+element.baseUri());
			System.out.println("data()--"+element.data());
			
			System.out.println("outerHtml()--"+element.outerHtml());
			System.out.println("ownText()--"+element.ownText());
			System.out.println("text()--"+element.text());
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
