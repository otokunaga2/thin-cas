package jp.kobe_u.cs27.thin_cas.thin_cas.dao;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.mongodb.morphia.Datastore;

import jp.kobe_u.cs27.thin_cas.thin_cas.model.ContextModel;
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
		
		return dataStore.save(ruleModel).getId().toString();
	}
	
	public RuleModel find(String id){
		return (RuleModel)dataStore.find(RuleModel.class);
	}
	
	public List<RuleModel> getAllList(){
		List<RuleModel> ruleModelList = dataStore.find(RuleModel.class).asList();
		List<RuleModel> resultModelList = new CopyOnWriteArrayList<>();

		for(RuleModel ruleModel:ruleModelList){
			RuleModel tempRuleModel = new RuleModel();
			List<ContextModel> tempConditionList = new CopyOnWriteArrayList<>();
			List<ContextModel> tempActionList = new CopyOnWriteArrayList<>();
			ContextModel event = ruleModel.getEvent();
			tempRuleModel.setEvent(event);
			List<ContextModel> currentContextList = ruleModel.getCondition();
			for(ContextModel contextModel:currentContextList){
				if("condition".equals(contextModel.getType())){
					tempConditionList.add(contextModel);
				}else if("action".equals(contextModel.getType())){
					tempActionList.add(contextModel);
				}
			}
			tempRuleModel.setCondition(tempConditionList);
			tempRuleModel.setAction(tempActionList);
			resultModelList.add(tempRuleModel);
		}
		
		return resultModelList;
	}
	
	
	
}
