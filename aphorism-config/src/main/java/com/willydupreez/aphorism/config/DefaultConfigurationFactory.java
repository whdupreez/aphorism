/**
 * Copyright (c) 2014, Willy du Preez. All rights reserved.
 */
package com.willydupreez.aphorism.config;

import java.util.List;

import com.willydupreez.aphorism.config.bean.DefaultPropertiesBeanBuilder;
import com.willydupreez.aphorism.config.bean.PropertiesBeanBuilder;
import com.willydupreez.aphorism.config.provider.PropertyProvider;

public class DefaultConfigurationFactory implements ConfigurationFactory {

	private List<PropertyProvider> providers;
	private PropertiesBeanBuilder beanBuilder;

	public DefaultConfigurationFactory(List<PropertyProvider> providers) {
		this(new DefaultPropertiesBeanBuilder(), providers);
	}

	public DefaultConfigurationFactory(PropertiesBeanBuilder builder, List<PropertyProvider> providers) {
		this.beanBuilder = builder;
		this.providers = providers;
	}

	@Override
	public <T> T create(Class<T> propertiesBeanType) {
		return beanBuilder.buildPropertiesBean(propertiesBeanType, providers);
	}

}
