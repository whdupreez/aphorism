/**
 * Copyright (c) 2014, Willy du Preez. All rights reserved.
 */
package com.willydupreez.aphorism.config.provider;

import com.willydupreez.util.Resources;

/**
 * Provides Java properties supplied using the -D environment
 * or set using {@link System#setProperty(String, String)} or
 * {@link System#setProperties(java.util.Properties)}.
 *
 * Note that these properties are not namespaced, and are
 * therefore considered to be in the global namespace.
 *
 * @author Willy du Preez
 *
 */
public class JavaPropertyProvider extends MapPropertyProvider {

	public JavaPropertyProvider() {
		super(Resources.asPropertiesMap(System.getProperties()));
	}

}
