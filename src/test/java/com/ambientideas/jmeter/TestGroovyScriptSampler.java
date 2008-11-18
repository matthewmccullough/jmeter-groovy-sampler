package com.ambientideas.jmeter;

import junit.framework.Assert;

import org.junit.Test;

public class TestGroovyScriptSampler {
	
	private static final String TEST_FILENAME = null;

	@Test
	public void testFilename() {
		GroovyScriptSampler gss = new GroovyScriptSampler();
		gss.setFilename(TEST_FILENAME);
		Assert.assertEquals(TEST_FILENAME, gss.getFilename());
	}

}
