package jp.kobe_u.cs27.thin_cas.thin_cas.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import jp.kobe_u.cs27.thin_cas.thin_cas.model.ContextModel;
import jp.kobe_u.cs27.thin_cas.thin_cas.model.RuleModel;
import jp.kobe_u.cs27.thin_cas.thin_cas.service.Context;

public class RuleDAOTest {

	private RuleDAO ruleDAO;
	@Before
	public void setUp() throws Exception {
		ruleDAO = new RuleDAO();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSave() {
		RuleModel ruleModel = new RuleModel();
		//Context ctx = new Context("event","test","http://example.com");
		ContextModel ctx = new ContextModel("event","http://example.com","test_event");
		List<ContextModel> ctxList = new ArrayList<ContextModel>();
		List<ContextModel> actionList = new ArrayList<ContextModel>();
		ContextModel condition = new ContextModel("condition","http://test2.com","test2");
		ctxList.add(condition);
		ContextModel action = new ContextModel("action","http://test2.com","test3");
		actionList.add(action);
		ruleModel.setEvent(ctx);
		ruleModel.setCondition(ctxList);
		ruleModel.setAction(actionList);
		ruleDAO.save(ruleModel);
	}

	@Test
	public void testGetAllList() {
		List<RuleModel> shouldNotEmpty = ruleDAO.getAllList();
		assertFalse(shouldNotEmpty.isEmpty());
		for(RuleModel rule:shouldNotEmpty){
			ContextModel ctx = (ContextModel) rule.getAction();
			System.out.println(ctx.getUrl());
			assertNotNull(rule.getEvent());
			assertFalse(rule.getCondition().isEmpty());
		}
		
		
		
	}
	@Test
	public void find(){
		
	
	}

}
