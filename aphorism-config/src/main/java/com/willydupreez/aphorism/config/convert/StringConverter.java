/**
 * Copyright (c) 2014, Willy du Preez. All rights reserved.
 */
package com.willydupreez.aphorism.config.convert;

public class StringConverter implements TypeConverter<String> {

	@Override
	public String convertToType(String property) {
		return property;
	}

	@Override
	public Class<String> getType() {
		return String.class;
	}

}
