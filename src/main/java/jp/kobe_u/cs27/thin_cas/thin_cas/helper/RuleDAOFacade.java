package jp.kobe_u.cs27.thin_cas.thin_cas.helper;

import java.util.List;

import jp.kobe_u.cs27.thin_cas.thin_cas.dao.RuleDAO;
import jp.kobe_u.cs27.thin_cas.thin_cas.model.ContextPojo;
import jp.kobe_u.cs27.thin_cas.thin_cas.model.RuleModel;
import jp.kobe_u.cs27.thin_cas.thin_cas.service.Context;
import jp.kobe_u.cs27.thin_cas.thin_cas.service.Rule;

public class RuleDAOFacade {
	private final String ID_KEY = "_id";
	private RuleDAO ruleDAO;
	private ContextFacade contextFacade;
	public RuleDAOFacade(){
		ruleDAO = new RuleDAO();
		contextFacade = new ContextFacade();
	}
	public List<Rule> createRuleFromDataSource(String id){
		RuleModel ruleModel = ruleDAO.find(id);
		if(ruleModel == null){
			return null;
		}
		ContextPojo contextPojo  = ruleModel.getEvent();
		
		Context ctx = contextFacade.convertContext(contextPojo);
		
		return null;
		
	}
	
	public RuleModel saveRuleModel(ContextPojo event, ContextPojo condition, ContextPojo action){
		
		RuleModel ruleModel = new RuleModel();
		ruleModel.setEvent(event);
		ruleModel.setSingleCondition(condition);
		ruleModel.setSingleAction(action);
		ruleDAO.save(ruleModel);
		return null;
	}
	private Rule convertFromRuleModel(RuleModel ruleModel){
		Rule rule = new Rule();
		Context event = contextFacade.convertContext(ruleModel.getEvent());
		List<Context> condition = contextFacade.convertAsListFromData(ruleModel.getCondition());
		List<Context> action = contextFacade.convertAsListFromData(ruleModel.getAction());
		rule.setEvent(event);
		rule.setCondition(condition);
		rule.setAction(action);
		return rule;
	}
	
}
