package jp.kobe_u.cs27.thin_cas.thin_cas.facade;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import jp.kobe_u.cs27.thin_cas.thin_cas.service.EvaluationEngine;
import jp.kobe_u.cs27.thin_cas.thin_cas.service.Rule;

public class EndpointEngineFacade {
	private EvaluationEngine engine;
	private RuleDAOFacade ruleDAOFacade;
	public static EndpointEngineFacade engineFacade = null;
	public static EndpointEngineFacade getInstance(){
		if(engineFacade == null){
			engineFacade = new EndpointEngineFacade();
		}
		return engineFacade;
	}
	ScheduledExecutorService scheduler =
			  Executors.newSingleThreadScheduledExecutor();
	public EndpointEngineFacade(){
		if(engine ==null){
			engine = new EvaluationEngine();
		}
		ruleDAOFacade = new RuleDAOFacade();
		List<Rule> allRuleList = ruleDAOFacade.dumpAllRule();
		for(Rule rule: allRuleList){
			engine.addRule(rule);
		}
	}
	
	public void executeMonitoring(){
		engine.execute(5000);
	}
	
	public void stoMonitoring(){
		engine.cancel();
	}

	public List<?> getCurrentObservalList() {
		return engine.getCurrentObservalList();
	}
	

}
