package jp.kobe_u.cs27.thin_cas.thin_cas.facade;

import java.util.List;

import jp.kobe_u.cs27.thin_cas.thin_cas.service.EvaluationEngine;
import jp.kobe_u.cs27.thin_cas.thin_cas.service.Rule;

public class EndpointEngineFacade {
	private EvaluationEngine engine;
	private RuleDAOFacade ruleDAOFacade;
	public EndpointEngineFacade(){
		engine = new EvaluationEngine();
		ruleDAOFacade = new RuleDAOFacade();
		List<Rule> allRuleList = ruleDAOFacade.dumpAllRule();
		for(Rule rule: allRuleList){
			engine.addRule(rule);
		}
	}
	
	public void executeMonitoring(){
		engine.execute(5000);/*5秒ごとに評価を実施*/
	}
	

}
