package jp.kobe_u.cs27.thin_cas.thin_cas.dao;

import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.Query;

import jp.kobe_u.cs27.thin_cas.thin_cas.model.ContextPojo;

public class ContextDAO {
	private static final String ID_KEY = "_id"; /*ObjectIdのままだとjacksonに変換できなかったため、Stringに変換*/
	private MorphiaUtil morphia;
	private Datastore dataStore =null;
	private static ContextDAO self = null;
	public ContextDAO(){
		dataStore = MorphiaUtil.getInstance();
	}
	public static ContextDAO getInstance(){
		if(self == null){
			self = new ContextDAO();
		}
		return self;
	}
	public ContextPojo findAsContextModel(String id){
		return dataStore.find(ContextPojo.class).field(ID_KEY).equal(id).get();
	}
	
	public List<ContextPojo> findAsEvent(){
		return dataStore.find(ContextPojo.class).field("type").equal("event").asList();
	}
	
	public List<ContextPojo> findWithParam(final String param){
		return dataStore.find(ContextPojo.class).field("type").equal(param).asList();
	}
	
	public List<ContextPojo> findAsAction(){
		return dataStore.find(ContextPojo.class).field("type").equal("action").asList();
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
	
}
