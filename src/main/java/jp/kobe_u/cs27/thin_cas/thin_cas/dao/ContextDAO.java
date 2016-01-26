package jp.kobe_u.cs27.thin_cas.thin_cas.dao;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.Query;

import jp.kobe_u.cs27.thin_cas.thin_cas.service.Context;

import jp.kobe_u.cs27.thin_cas.thin_cas.service.ContextPojo;

public class ContextDAO {
	private static final String ID_KEY = "_id"; /*ObjectIdのままだとjacksonに変換できなかったため、Stringに変換*/
	private MorphiaUtil morphia;
	private Datastore dataStore =null;
	public ContextDAO(){
		dataStore = MorphiaUtil.getInstance();
	}
	public ContextPojo findAsContextModel(String id){
		return dataStore.find(ContextPojo.class).field(ID_KEY).equal(id).get();
	}
	
	public ContextPojo updateContext(String id, ContextPojo pojo){
		Query<ContextPojo> updateQuery = dataStore.createQuery(ContextPojo.class).field(ID_KEY).equal(id);
		
		
		return null;
	}
	public String delete(ContextPojo ctx){
		return "deletedId";
	}
	
	public String save(ContextPojo ctx){
		Key<ContextPojo> key = dataStore.save(ctx);
		return (String)key.getId();
	}
	public void saveContext(){
		Datastore ds = morphia.getInstance();
		
		ds.save();
	}
	
}
