package jp.kobe_u.cs27.thin_cas.thin_cas.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import jp.kobe_u.cs27.thin_cas.thin_cas.service.ContextPojo;

public class ContextDAOTest {
	private ContextDAO ctxDAO;
	@Before
	public void setUp() throws Exception {
		ctxDAO = ContextDAO.getInstance();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFindAsContextModel() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateContext() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testSave() {
		ContextPojo pojo = new ContextPojo("event", "http://example.com", "event");
		String result = ctxDAO.save(pojo);
		System.out.println(result);
		assertNotNull(result);
	}

}
