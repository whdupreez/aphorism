/**
 * Copyright (c) 2014, Willy du Preez. All rights reserved.
 */
package com.willydupreez.aphorism.config.provider;

import static com.willydupreez.util.Resources.asPropertiesMap;
import static com.willydupreez.util.Resources.fromPath;

import java.nio.file.Path;

/**
 * Provides properties from a Java properties file.
 *
 * @author Willy du Preez
 *
 */
public class PathPropertyProvider extends MapPropertyProvider {

	public PathPropertyProvider(String path) {
		super(asPropertiesMap(fromPath(path)));
	}

	public PathPropertyProvider(Path path) {
		super(asPropertiesMap(fromPath(path)));
	}

}
