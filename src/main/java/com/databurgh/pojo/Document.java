package com.databurgh.pojo;

import com.databurgh.enums.DocSourceEnum;

public class Document {

	private String id;
	private DocSourceEnum source;
	private String title;
	private long pubDate;
	private String link;
	private String descption;
	
	public Document() {
	}
	
	public Document(DocSourceEnum source, String id, String link, String title, String descption) {
		this.source = source;
		this.id = id;
		this.title = title;
		this.link = link;
		this.descption = descption;
	}
	
	public Document(DocSourceEnum source, String id, String link, String title, long pubDate, String descption) {
		this.source = source;
		this.id = id;
		this.title = title;
		this.pubDate = pubDate;
		this.link = link;
		this.descption = descption;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public DocSourceEnum getSource() {
		return source;
	}

	public void setSource(DocSourceEnum source) {
		this.source = source;
	}
	
	public long getPubDate() {
		return pubDate;
	}

	public void setPubDate(long pubDate) {
		this.pubDate = pubDate;
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getLink() {
		return link;
	}
	
	public void setLink(String link) {
		this.link = link;
	}
	
	public String getDescption() {
		return descption;
	}
	
	public void setDescption(String descption) {
		this.descption = descption;
	}
	
}
