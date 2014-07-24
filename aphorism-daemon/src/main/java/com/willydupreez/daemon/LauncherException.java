/**
 * Copyright (c) 2014, Willy du Preez. All rights reserved.
 */
package com.willydupreez.daemon;

public class LauncherException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public LauncherException(String message, Throwable cause) {
		super(message, cause);
	}

	public LauncherException(String message) {
		super(message);
	}

}
