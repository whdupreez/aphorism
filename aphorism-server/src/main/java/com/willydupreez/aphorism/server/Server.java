/**
 * Copyright (c) 2014, Willy du Preez. All rights reserved.
 */
package com.willydupreez.aphorism.server;

/**
 *
 * @author Willy du Preez
 *
 */
public interface Server {

	void init(ServerProperties properties);
	void start();
	void stop();

}
