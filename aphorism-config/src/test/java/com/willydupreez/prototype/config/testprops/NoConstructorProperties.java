/**
 * Copyright (c) 2014, Willy du Preez. All rights reserved.
 */
package com.willydupreez.prototype.config.testprops;

public class NoConstructorProperties {

	private NoConstructorProperties() {
	}

	public NoConstructorProperties(String val) {
		this();
	}

}
