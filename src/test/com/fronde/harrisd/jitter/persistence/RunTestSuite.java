package com.fronde.harrisd.jitter.persistence;

import junit.framework.Test;
import junit.framework.TestSuite;

public class RunTestSuite {

	public static Test suite() {
		TestSuite suite = new TestSuite(
				"Test for com.fronde.harrisd.jitter.persistence");
		//$JUnit-BEGIN$
		suite.addTestSuite(TestPost.class);
		suite.addTestSuite(TestUser.class);
		//$JUnit-END$
		return suite;
	}

}
