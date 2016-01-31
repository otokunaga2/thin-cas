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
		ContextModel pojo = new ContextModel("event", "http://example.com", "sample event");
		String savedId = ctxDAO.save(pojo);
		ContextModel shouldFound = ctxDAO.findAsContextModel(savedId);
		
		assertNotNull(shouldFound);
	}

	@Test
	public void testUpdateContext() {
		ContextModel updateModel = new ContextModel("event", "http://example.com", "event");
		String savedId = ctxDAO.save(updateModel);
		String replacedName = "replaced event";
		ContextModel replacedModel = new ContextModel("event","http://example.com",replacedName);
		boolean isExstingUpdate = ctxDAO.updateContext(savedId,replacedModel);
		assertTrue(isExstingUpdate);
	}

	@Test
	public void testDelete() {
		ContextModel pojo = new ContextModel("event", "http://example.com", "should delete");
		String savedId = ctxDAO.save(pojo);
		boolean shouldExistingDeleteId = ctxDAO.delete(savedId);
		System.out.println();
		assertFalse(shouldExistingDeleteId);
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
