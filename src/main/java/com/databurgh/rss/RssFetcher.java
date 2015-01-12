package com.databurgh.rss;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import com.databurgh.consts.SourceConst;
import com.databurgh.enums.DocSourceEnum;

public class RssFetcher {
	
	public void fetch() {
		for (DocSourceEnum source:SourceConst.sourceList) {
			fetch(source);
		}
	}
	
	private void fetch(DocSourceEnum source) {
		StringBuilder data = new StringBuilder();
		try {
			URL url = new URL(SourceConst.sourceMap.get(source));
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(url.openStream()));
			String line;
			while ((line = reader.readLine()) != null)
				data.append(line);
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		RssParser.parse(source, data.toString());
	}
	
	public static void main(String[] args) {
		new RssFetcher().fetch();
	}

}
