package jp.kobe_u.cs27.thin_cas.thin_cas.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import jp.kobe_u.cs27.thin_cas.thin_cas.model.ContextModel;

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
		ContextModel pojo = new ContextModel("event", "http://example.com", "event");
		ContextModel shouldFound = ctxDAO.findAsContextModel("56a9d6c118365940e50f68f3");
		
		assertNull(shouldFound);
	}

	@Test
	public void testUpdateContext() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		ContextModel pojo = new ContextModel("event", "http://example.com", "event");
		String savedId = ctxDAO.save(pojo);
		boolean shouldExistingDeleteId = ctxDAO.delete(savedId);
		assertTrue(shouldExistingDeleteId);
	}

	@Test
	public void testSave() {
		ContextModel pojo = new ContextModel("event", "http://example.com", "event");
		String result = ctxDAO.save(pojo);
		System.out.println(result);
		assertNotNull(result);
	}
	
	@Test
	public void findAsList(){
		List<ContextModel> givenList = ctxDAO.findWithParam("event");
		assertFalse(givenList.isEmpty());
	}

}
