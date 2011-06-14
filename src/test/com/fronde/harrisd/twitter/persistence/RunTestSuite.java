package com.fronde.harrisd.twitter.persistence;

import junit.framework.Test;
import junit.framework.TestSuite;

public class RunTestSuite {

	public static Test suite() {
		TestSuite suite = new TestSuite(
				"Test for com.fronde.harrisd.twitter.persistence");
		//$JUnit-BEGIN$
		suite.addTestSuite(TestPost.class);
		suite.addTestSuite(TestUser.class);
		//$JUnit-END$
		return suite;
	}

}
