package com.tmk.xml.feed;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Entry {
	String id;
	Date published;
	Date updated;
	Link link;
	Category category;
	Title title;
	String summary;
	Double ppg_rating;
	List articles = new ArrayList();
	Link gd_feedLink;
	
	public Entry(String id) {
		this.id = id;
	}
	
	public void setPublished(Date published) {
		this.published = published;
	}
	
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	
	public void setLink(Link link) {
		this.link = link;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public void setTitle(Title title) {
		this.title = title;
	}
	
	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	public void setPpg_rating(Double ppg_rating) {
		this.ppg_rating = ppg_rating;
	}
	
	public void addArticle(Article article) {
		articles.add(article);
	}
	
	public void setGdFeedLink(Link gdFeedLink) {
		this.gd_feedLink = gdFeedLink;
	}
}
