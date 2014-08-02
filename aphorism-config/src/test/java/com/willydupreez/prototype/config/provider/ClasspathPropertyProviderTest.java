/**
 * Copyright (c) 2014, Willy du Preez. All rights reserved.
 */
package com.willydupreez.prototype.config.provider;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.willydupreez.aphorism.config.provider.ClasspathPropertyProvider;

public class ClasspathPropertyProviderTest {

	private static final String LOCATION = "/classpath/cp-test.properties";

	@Test
	public void before() {
		ClasspathPropertyProvider provider = new ClasspathPropertyProvider(LOCATION);

		assertThat(provider.getProperty("cp.test.one").get(), is("1"));
		assertThat(provider.getProperty("cp.test.two").get(), is("2"));
		assertThat(provider.getProperty("cp.test.three").isPresent(), is(false));
	}

}
