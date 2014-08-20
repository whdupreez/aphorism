/**
 * Copyright (c) 2014, Willy du Preez. All rights reserved.
 */
package com.willydupreez.aphorism.server.jetty;

import org.eclipse.jetty.server.Server;

import com.willydupreez.aphorism.server.ServerException;
import com.willydupreez.aphorism.server.ServerProperties;

/**
 *
 * @author Willy du Preez
 *
 */
public class JettyServer implements com.willydupreez.aphorism.server.Server {

	private ServerProperties properties;
	private Server jetty;

	@Override
	public void init(ServerProperties properties) {
		this.properties = properties;
		jetty = new Server(properties.getBindPort());
	}

	@Override
	public void start() {
		try {
			jetty.start();
		} catch (Exception e) {
			throw new ServerException("Failed to start Jetty on port: " + properties.getBindPort(), e);
		}
	}

	@Override
	public void stop() {
		try {
			jetty.stop();
		} catch (Exception e) {
			throw new ServerException("Failed to start Jetty on port: " + properties.getBindPort(), e);
		}
	}

}
