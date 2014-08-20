package com.willydupreez.aphorism.server.jetty;

import org.junit.Before;
import org.junit.Test;

import com.willydupreez.aphorism.server.ServerProperties;

public class JettyServerTest {

	private ServerProperties properties;
	private JettyServer server;

	@Before
	public void before() {
		this.properties = new ServerProperties();
		this.properties.setBindAddress("localhost");
		this.properties.setBindPort(8080);
	}

	@Test
	public void test() throws Exception {
		server = new JettyServer();
		server.init(properties);
		server.start();
		server.stop();
	}

}
