package com.databurgh.rss;

import java.io.StringReader;
import java.util.List;

import com.databurgh.enums.DocSourceEnum;
import com.databurgh.morphia.DocMorphia;
import com.databurgh.pojo.Document;
import com.databurgh.util.MD5Util;
import com.rsslibj.elements.Channel;
import com.rsslibj.elements.Item;
import com.rsslibj.elements.RSSReader;

import electric.xml.ParseException;

public class RssParser {
	
	private static DocMorphia morphia = DocMorphia.INSTANCE;

	public static void parse(DocSourceEnum source, String data) {
		StringReader stringReader = new StringReader(data);
		RSSReader rssReader = new RSSReader();
		try {
			rssReader.setReader(stringReader);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Channel channel = rssReader.getChannel();
		String t = channel.getTitle();
		System.out.println("fetch " + t);
		@SuppressWarnings("unchecked")
		List<Item> itemList = channel.getItems();
		if (itemList != null) {
			for (Item item : itemList) {
				String id = MD5Util.encodeMD5(item.getDescription());
				String link = item.getLink();
				String title = item.getTitle();
				String description = item.getDescription();
				Document document = new Document(source, id, link, title, description);
				morphia.save(document);
			}
		}
	}

}
