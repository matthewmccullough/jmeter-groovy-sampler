package com.ambientideas.jmeter;

import junit.framework.Assert;

import org.junit.Test;

public class TestGroovyScriptSampler {
	
	private static final String TEST_SETUP_FILENAME = "setuptest.groovy";
	private static final String TEST_PRIMARY_FILENAME = "primarytest.groovy";

	@Test
	public void testFilename() {
		GroovyScriptSampler gss = new GroovyScriptSampler();
		
		gss.setSetupScriptFilename(TEST_SETUP_FILENAME);
		Assert.assertEquals(TEST_SETUP_FILENAME, gss.getSetupScriptFilename());
		
		gss.setPrimaryScriptFilename(TEST_PRIMARY_FILENAME);
		Assert.assertEquals(TEST_PRIMARY_FILENAME, gss.getPrimaryScriptFilename());
	}
}
