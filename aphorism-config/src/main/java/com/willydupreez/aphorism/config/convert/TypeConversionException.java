/**
 * Copyright (c) 2014, Willy du Preez. All rights reserved.
 */
package com.willydupreez.aphorism.config.convert;

public class TypeConversionException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public TypeConversionException(String message) {
		super(message);
	}

	public TypeConversionException(String message, Throwable cause) {
		super(message, cause);
	}

}
