/**
 * Copyright (c) 2014, Willy du Preez. All rights reserved.
 */
package com.willydupreez.prototype.config.provider;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PrefixedPropertyProviderTest {

	private static final String PREFIX = "PREFIX_";

	private static final String KEY = "system.prop.test";
	private static final String PREFIXED_KEY = PREFIX + "system.prop.test";
	private static final String VALUE = "systemValue";

	@Before
	public void before() {
		System.setProperty(PREFIXED_KEY, VALUE);
	}

	@After
	public void after() {
		System.clearProperty(PREFIXED_KEY);
	}

	@Test
	public void testJavaPropertyProvider() {
		JavaPropertyProvider delegate = new JavaPropertyProvider();
		PrefixedPropertyProvider provider = new PrefixedPropertyProvider(PREFIX, delegate);
		assertThat(provider.getProperty(KEY).get(), is(VALUE));
		assertThat(provider.getProperty("non.existent").isPresent(), is(false));
	}

}
