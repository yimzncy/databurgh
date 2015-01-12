package com.databurgh.morphia;

import java.util.List;

import com.databurgh.pojo.Document;
import com.github.jmkgreen.morphia.Datastore;

public enum DocMorphia {

	INSTANCE;
	
	private static Datastore datastore;
	
	static {
		datastore = MorphiaUtil.getLocalDatastore();
	}
	
	public long count() {
		return datastore.createQuery(Document.class).countAll();
	}
	
	public void save(Document document) {
		String id = document.getId();
		if (find(id) != null)
			return;
		datastore.save(document);
	}
	
	public void delete(String id) {
		datastore.delete(datastore.createQuery(Document.class).filter("id =", id));
	}

	public void deleteAll() {
		datastore.delete(datastore.createQuery(Document.class));
	}

	public Document find(String id) {
		Document document = datastore.find(Document.class, "id =", id).get();
		return document;
	}
	
	public List<Document> findAll() {
		List<Document> documentList = datastore.find(Document.class).asList();
		return documentList;
	}
}
