package com.databurgh.morphia;

import java.net.UnknownHostException;

import com.github.jmkgreen.morphia.Datastore;
import com.github.jmkgreen.morphia.Morphia;
import com.mongodb.MongoClient;

public class MorphiaUtil {

	public static Datastore getLocalDatastore() {
		Datastore datastore = null;
    	try {
    		Morphia morphia = new Morphia();
    		MongoClient mongoClient = new MongoClient("localhost", 27017);
//    		MongoClient mongoClient = new MongoClient("mongodb://192.168.163.201:27017/");
        	datastore = morphia.createDatastore(mongoClient, "databurgh");
        	datastore.ensureIndexes();
        	datastore.ensureCaps();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return datastore;
	}

}
