/**
 * Copyright (c) 2014, Willy du Preez. All rights reserved.
 */
package com.willydupreez.aphorism.server;

/**
 *
 * @author Willy du Preez
 *
 */
public class ServerException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ServerException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServerException(String message) {
		super(message);
	}

}
