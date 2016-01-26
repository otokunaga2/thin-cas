package jp.kobe_u.cs27.thin_cas.thin_cas.dao;

import java.net.UnknownHostException;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.mapping.Mapper;

import com.mongodb.MongoClient;



public class MorphiaUtil {
	private static Morphia morphia = null;
	private static final String IPADDRESS = "192.168.0.117";
	private static final String DATABASE = "thin-cas";
	public static Datastore getInstance(){
		 if(morphia == null){
			 morphia = new Morphia();
		 }
		 /*モデルに利用するパッケージ名*/
		morphia.mapPackage("jp.kobe_u.cs27.location.beacon_service.model");
		Mapper morphiaMapper = morphia.getMapper();
	
		Datastore datastore = null;
		datastore = morphia.createDatastore(new MongoClient(IPADDRESS , 27017), DATABASE);
		return datastore;
	}
}
