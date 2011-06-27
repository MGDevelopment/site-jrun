package com.tmk.xml.feed;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

public class Feed {
	private String xmlns;
	private String xmlns_opensearch;
	private String xmlns_ppg;
	private String xmlns_gd;
	private String id;
	private Title title;
	private Link link;
	private Date updated;
	private Author author;
	private Category category;
	private Integer openSearch_totalResults;
	private Integer openSearch_startIndex;
	private Integer openSearch_itemsPerPage;
	private List entries = new ArrayList();


	
	
	public Feed() {
		
	}
	
	public void setXmlns(String xmlns) {
		this.xmlns = xmlns;
	}
	
	public void setXmlns_opensearch(String xmlns_opensearch) {
		this.xmlns_opensearch = xmlns_opensearch;
	}
	
	public void setXmlns_ppg(String xmlns_ppg) {
		this.xmlns_ppg = xmlns_ppg;
	}
	
	public void setXmlns_gd(String xmlns_gd) {
		this.xmlns_gd = xmlns_gd;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setTitle(Title title) {
		this.title = title;
	}
	
	public void setLink(Link link) {
		this.link = link;
	}
	
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	
	public void setAuthor(Author author) {
		this.author = author;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public void setOpenSearch_totalResults(Integer openSearch_totalResults) {
		this.openSearch_totalResults = openSearch_totalResults;
	}
	
	public void setOpenSearch_startIndex (Integer openSearch_startIndex) {
		this.openSearch_startIndex = openSearch_startIndex;
	}
	
	public void setOpenSearch_itemsPerPage (Integer openSearch_itemsPerPage) {
		this.openSearch_itemsPerPage = openSearch_itemsPerPage;
	} 
	
	public void addEntry(Entry entry) {
		entries.add(entry);
	}
	
/*	
	public String getXmlns() {
		return this.xmlns;
	}
	
	public String getXmlns_opensearch() {
		return this.xmlns_opensearch;
	}
	
	public String getXmlns_ppg() {
		return this.xmlns_ppg;
	}
	
	public String getId() {
		return this.id;
	}*/
}
