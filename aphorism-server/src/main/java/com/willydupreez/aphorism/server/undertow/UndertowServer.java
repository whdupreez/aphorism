/**
 * Copyright (c) 2014, Willy du Preez. All rights reserved.
 */
package com.willydupreez.aphorism.server.undertow;

import io.undertow.Undertow;

import com.willydupreez.aphorism.server.Server;
import com.willydupreez.aphorism.server.ServerProperties;

/**
 *
 * @author Willy du Preez
 *
 */
public class UndertowServer implements Server {

	private ServerProperties properties;

	private Undertow undertow;

	@Override
	public void init(ServerProperties properties) {
		this.properties = properties;

		undertow = Undertow.builder()
				.addHttpListener(this.properties.getBindPort(), this.properties.getBindAddress())
				.build();
	}

	@Override
	public void start() {
		undertow.start();
	}

	@Override
	public void stop() {
		undertow.stop();
	}

}
