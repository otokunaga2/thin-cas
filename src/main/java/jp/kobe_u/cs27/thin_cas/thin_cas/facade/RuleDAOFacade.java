package jp.kobe_u.cs27.thin_cas.thin_cas.facade;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import jp.kobe_u.cs27.thin_cas.thin_cas.dao.RuleDAO;
import jp.kobe_u.cs27.thin_cas.thin_cas.model.ContextModel;
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
	public Rule createRuleFromDataSource(String id){
		RuleModel ruleModel = ruleDAO.find(id);
		if(ruleModel == null){
			return null;
		}
		ContextModel contextPojo  = ruleModel.getEvent();
		
		Context ctx = contextFacade.convertContext(contextPojo);
		
		return null;
		
	}
	
	public List<Rule> dumpAllRule(){
		List<RuleModel> dumpList = ruleDAO.getAllList();
		List<Rule> allRuleList = new CopyOnWriteArrayList<Rule>();
		for(RuleModel ruleModel: dumpList){
			Rule tempRule = convertFromRuleModel(ruleModel);
			allRuleList.add(tempRule);
		}
		return allRuleList;
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
