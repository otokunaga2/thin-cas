package jp.kobe_u.cs27.thin_cas.thin_cas.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import jp.kobe_u.cs27.thin_cas.thin_cas.model.ContextPojo;
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
		ContextPojo ctx = new ContextPojo("event","http://example.com","test_event");
		List<ContextPojo> ctxList = new ArrayList<ContextPojo>();
		List<ContextPojo> actionList = new ArrayList<ContextPojo>();
		ContextPojo condition = new ContextPojo("condition","http://test2.com","test2");
		ctxList.add(condition);
		ContextPojo action = new ContextPojo("action","http://test2.com","test3");
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
		
	}
	@Test
	public void find(){
		
	
	}

}
