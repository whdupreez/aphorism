/**
 * Copyright (c) 2014, Willy du Preez. All rights reserved.
 */
package com.willydupreez.prototype.config;

public interface ConfigurationFactory {

	public <T> T create(Class<T> propertiesBeanType);

}
