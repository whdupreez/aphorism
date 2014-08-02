/**
 * Copyright (c) 2014, Willy du Preez. All rights reserved.
 */
package com.willydupreez.prototype.config.convert;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.willydupreez.aphorism.config.convert.EnumConverter;
import com.willydupreez.aphorism.config.convert.TypeConversionException;

public class EnumConverterTest {

	public static enum TestEnum {
		ONE, TWO, THREE;
	}

	private EnumConverter<TestEnum> converter = new EnumConverter<>(TestEnum.class);

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testConvertToType() {
		assertThat(converter.convertToType("ONE"), is(TestEnum.ONE)); ;
		assertThat(converter.convertToType("TWO"), is(TestEnum.TWO)); ;
		assertThat(converter.convertToType("THREE"), is(TestEnum.THREE)); ;
	}

	@Test
	public void testConvertToType_CaseMismatch() {
		thrown.expect(TypeConversionException.class);
		converter.convertToType("one");
	}

	@Test
	public void testConvertToType_NoMatch() {
		thrown.expect(TypeConversionException.class);
		converter.convertToType("FOUR");
	}

}
