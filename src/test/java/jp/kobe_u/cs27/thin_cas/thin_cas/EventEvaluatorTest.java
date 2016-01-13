package jp.kobe_u.cs27.thin_cas.thin_cas;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EventEvaluatorTest {
	private Rule rule;
	private Context event;
	private EventEvaluator evaluator;
	@Before
	public void setUp() throws Exception {
		evaluator = new EventEvaluator();
		rule = new Rule();
		event = new Context();
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
