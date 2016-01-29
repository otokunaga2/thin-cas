package jp.kobe_u.cs27.thin_cas.thin_cas.helper;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import jp.kobe_u.cs27.thin_cas.thin_cas.facade.ContextFacade;
import jp.kobe_u.cs27.thin_cas.thin_cas.model.ContextModel;
import jp.kobe_u.cs27.thin_cas.thin_cas.service.Context;

public class ContextFacadeTest {
	private ContextFacade contextFacade;
	@Before
	public void setUp() throws Exception {
		contextFacade = new ContextFacade();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetContext() {
		Context result = contextFacade.getContext("a");
		assertNull(result);
	}

	@Test
	public void testConvertContext() {
		ContextModel pojo = new ContextModel("event","test","http://example.com");
		Context ctx = contextFacade.convertContext(pojo);
		assertNotNull(ctx);
		System.out.println(ctx.getName());
		assertEquals(ctx.getName(),"event");
	}

	@Test
	public void testConvertAsListFromData() {
		fail("Not yet implemented");
	}

}
