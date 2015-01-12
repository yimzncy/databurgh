package com.databurgh.controller;

import com.databurgh.pojo.Document;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.databurgh.morphia.DocMorphia;

import java.util.List;

@Controller
public class IndexController {

	private static DocMorphia morphia = DocMorphia.INSTANCE;
	
	@RequestMapping(value = "/rss", method = RequestMethod.POST)
	public ModelAndView rss() {
		List<Document> documentList = morphia.findAll();
		StringBuilder stringBuilder = new StringBuilder();
		for (Document document:documentList) {
			stringBuilder.append(document.getSource());
			stringBuilder.append("\n");
			stringBuilder.append(document.getTitle());
			stringBuilder.append("\n");
			stringBuilder.append(document.getId());
			stringBuilder.append("\n");
			stringBuilder.append(document.getDescption());
			stringBuilder.append("\n");
		}
		return new ModelAndView("index", "rss_content", stringBuilder.toString());
	}
}
