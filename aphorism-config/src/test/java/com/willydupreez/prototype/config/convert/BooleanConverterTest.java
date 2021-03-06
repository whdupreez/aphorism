/**
 * Copyright (c) 2014, Willy du Preez. All rights reserved.
 */
package com.willydupreez.prototype.config.convert;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.willydupreez.aphorism.config.convert.BooleanConverter;
import com.willydupreez.aphorism.config.convert.TypeConversionException;

public class BooleanConverterTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testConvertToType() {
		assertThat(new BooleanConverter().convertToType("true"), is(true));
		assertThat(new BooleanConverter().convertToType("false"), is(false));
	}

	@Test
	public void testConvertToType_InvalidValue() {
		thrown.expect(TypeConversionException.class);
		thrown.expectMessage(containsString("yes"));

		new BooleanConverter().convertToType("yes");
	}

}
