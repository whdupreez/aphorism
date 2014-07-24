/**
 * Copyright (c) 2014, Willy du Preez. All rights reserved.
 */
package com.willydupreez.prototype.config.convert;

public class LongConverter implements TypeConverter<Long> {

	@Override
	public Long convertToType(String property) {
		try {
			return Long.valueOf(property);
		} catch (NumberFormatException e) {
			throw new TypeConversionException("Cannot convert to Long: " + property, e);
		}
	}

	@Override
	public Class<Long> getType() {
		return Long.class;
	}

}
