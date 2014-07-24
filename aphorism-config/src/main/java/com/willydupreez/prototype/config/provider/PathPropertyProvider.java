package com.willydupreez.prototype.config.provider;

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
