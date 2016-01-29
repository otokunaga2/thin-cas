package jp.kobe_u.cs27.thin_cas.thin_cas.helper;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import jp.kobe_u.cs27.thin_cas.thin_cas.facade.RuleDAOFacade;

public class RuleDAOFacadeTest {
	RuleDAOFacade ruleDAOFacade;
	@Before
	public void setUp() throws Exception {
		ruleDAOFacade = new RuleDAOFacade();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateRuleFromDataSource() {
		ruleDAOFacade.createRuleFromDataSource("5681");
	}

}
