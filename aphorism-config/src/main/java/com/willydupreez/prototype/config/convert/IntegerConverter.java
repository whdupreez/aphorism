/**
 * Copyright (c) 2014, Willy du Preez. All rights reserved.
 */
package com.willydupreez.prototype.config.convert;

public class IntegerConverter implements TypeConverter<Integer> {

	@Override
	public Integer convertToType(String property) {
		try {
			return Integer.valueOf(property);
		} catch (NumberFormatException e) {
			throw new TypeConversionException("Cannot convert to Integer: " + property, e);
		}
	}

	@Override
	public Class<Integer> getType() {
		return Integer.class;
	}

}
