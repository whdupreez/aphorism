/**
 * Copyright (c) 2014, Willy du Preez. All rights reserved.
 */
package com.willydupreez.prototype.config.convert;

public class TypeConversionException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public TypeConversionException(String message) {
		super(message);
	}

	public TypeConversionException(String message, Throwable cause) {
		super(message, cause);
	}

}
