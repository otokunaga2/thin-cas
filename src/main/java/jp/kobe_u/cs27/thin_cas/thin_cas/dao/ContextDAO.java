package jp.kobe_u.cs27.thin_cas.thin_cas.dao;

import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;

import com.mongodb.WriteResult;

import jp.kobe_u.cs27.thin_cas.thin_cas.model.ContextModel;

public class ContextDAO {
	private static final String ID_KEY = "_id"; /*ObjectIdのままだとjacksonに変換できなかったため、Stringに変換*/
	private static final String URL ="url";
	private static final String NAME ="name";
	
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
	public ContextModel findAsContextModel(String id){
		ObjectId oid;
		try{
			oid = new ObjectId(id);
		}catch(IllegalArgumentException e){
			e.printStackTrace();
			return null;
		}
		
		return dataStore.find(ContextModel.class).field(ID_KEY).equal(oid).get();
	}
	
	
	public List<ContextModel> findWithParam(final String param){
		
		return dataStore.find(ContextModel.class).field("type").equal(param).asList();
	}
	
	
	

	
	public boolean updateContext(String id, ContextModel pojo){
		System.out.println(id);
		ObjectId oid = convertToObjectId(id);
		Query<ContextModel> updateQuery = dataStore.createQuery(ContextModel.class).field(ID_KEY).equal(oid);
		
		UpdateOperations<ContextModel> updateTarget = dataStore.createUpdateOperations(ContextModel.class).set(URL, pojo.getUrl()).set(NAME, pojo.getName());
		UpdateResults updateRes = dataStore.update(updateQuery,updateTarget);
		
		
		return updateRes.getUpdatedExisting();
	}
	/**
	 * todo
	 *  delete now not working well
	 * @param id
	 * @return
	 */
	public boolean delete(String id){
		ObjectId oid = convertToObjectId(id);
		System.out.println("deleteId"+id);
		ContextModel deletaModel = findAsContextModel(id);
		WriteResult result = dataStore.delete(deletaModel);
		System.out.println();
		return result.isUpdateOfExisting();
	}
	
	public String save(ContextModel ctx){
		Key<ContextModel> key = dataStore.save(ctx);
		return (String)key.getId();
	}
	private ObjectId convertToObjectId(String id){
		ObjectId oid = new ObjectId(id);
		return oid;
	}
	
}
