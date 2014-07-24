package com.willydupreez.prototype.config;

public interface ConfigurationFactory {

	public <T> T create(Class<T> propertiesBeanType);

}
