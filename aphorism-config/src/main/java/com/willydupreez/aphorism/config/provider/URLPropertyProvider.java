/**
 * Copyright (c) 2014, Willy du Preez. All rights reserved.
 */
package com.willydupreez.aphorism.config.provider;

import static com.willydupreez.util.Resources.asPropertiesMap;
import static com.willydupreez.util.Resources.fromUri;

import java.net.URL;
import java.util.Optional;

/**
 * Provides properties from the specified URL.
 *
 * @author Willy du Preez
 *
 */
public class URLPropertyProvider extends MapPropertyProvider {

	public URLPropertyProvider(String url) {
		super(asPropertiesMap(fromUri(url)));
	}

	public URLPropertyProvider(URL url) {
		super(asPropertiesMap(Optional.of(url)));
	}

}
