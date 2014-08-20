package com.willydupreez.aphorism.server.undertow;

import org.junit.Before;
import org.junit.Test;

import com.willydupreez.aphorism.server.ServerProperties;

public class UndertowServerTest {

	private ServerProperties properties;
	private UndertowServer server;

	@Before
	public void before() {
		this.properties = new ServerProperties();
		this.properties.setBindAddress("localhost");
		this.properties.setBindPort(80);
	}

	@Test
	public void test() throws Exception {
		server = new UndertowServer();
		server.init(properties);
		server.start();
		server.stop();
	}

}
