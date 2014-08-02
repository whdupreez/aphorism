/**
 * Copyright (c) 2014, Willy du Preez. All rights reserved.
 */
package com.willydupreez.prototype.config.convert;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

import com.willydupreez.aphorism.config.convert.StringConverter;

public class StringConverterTest {

	private static final String PROPERTY = "property";

	@Test
	public void testConvertToType() {
		assertThat(PROPERTY, is(new StringConverter().convertToType(PROPERTY)));
	}

}
