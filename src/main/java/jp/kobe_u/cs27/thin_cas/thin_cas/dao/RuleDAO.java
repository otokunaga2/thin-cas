package jp.kobe_u.cs27.thin_cas.thin_cas.dao;

import java.util.List;

import org.mongodb.morphia.Datastore;

import jp.kobe_u.cs27.thin_cas.thin_cas.model.RuleModel;

public class RuleDAO {
	private static final String ID_KEY = "_id"; /*ObjectIdのままだとjacksonに変換できなかったため、Stringに変換*/
	private MorphiaUtil morphia;
	private Datastore dataStore =null;
	private static RuleDAO self = null;
	public RuleDAO() {
		dataStore = MorphiaUtil.getInstance();
	}
	
	public static RuleDAO getInstance(){
		if(self == null){
			self = new RuleDAO();
		}
		return self;
	}
	public String save(RuleModel ruleModel){
		return dataStore.save(ruleModel).toString();
	}
	
	public RuleModel find(String id){
		return (RuleModel)dataStore.find(RuleModel.class);
	}
	
	public List<RuleModel> getAllList(){
		return dataStore.find(RuleModel.class).asList();
	}
	
	
	
}
