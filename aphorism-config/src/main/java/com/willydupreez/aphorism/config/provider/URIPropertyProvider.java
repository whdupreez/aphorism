/**
 * Copyright (c) 2014, Willy du Preez. All rights reserved.
 */
package com.willydupreez.aphorism.config.provider;

import static com.willydupreez.util.Resources.asPropertiesMap;
import static com.willydupreez.util.Resources.fromUri;

import java.net.URI;

public class URIPropertyProvider extends MapPropertyProvider {

	public URIPropertyProvider(String uri) {
		super(asPropertiesMap(fromUri(uri)));
	}

	public URIPropertyProvider(URI uri) {
		super(asPropertiesMap(fromUri(uri)));
	}

}
