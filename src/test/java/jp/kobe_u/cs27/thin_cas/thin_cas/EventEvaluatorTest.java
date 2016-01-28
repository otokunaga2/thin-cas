package jp.kobe_u.cs27.thin_cas.thin_cas;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import jp.kobe_u.cs27.thin_cas.thin_cas.service.Context;
import jp.kobe_u.cs27.thin_cas.thin_cas.service.EvaluationEngine;
import jp.kobe_u.cs27.thin_cas.thin_cas.service.Rule;

public class EventEvaluatorTest {
	private Rule rule;
	private Context event;
	private EvaluationEngine evaluator;
	@Before
	public void setUp() throws Exception {
		evaluator = new EvaluationEngine();
		rule = new Rule();
		event = new Context("event","name","http://192.168.100.107:8080/eca-test-event/webapi/myresource/true");
		rule.setEvent(event);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEventEvaluator() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddRule() {
		
		
	}

	@Test
	public void testExecute() {
		evaluator.execute(1000);
	}

}
