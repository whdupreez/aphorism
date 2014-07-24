/**
 * Copyright (c) 2014, Willy du Preez. All rights reserved.
 */
package com.willydupreez.util;

public class BeanException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BeanException(String message, Throwable cause) {
		super(message, cause);
	}

	public BeanException(String message) {
		super(message);
	}

}
