package com.willydupreez.prototype.config;

import java.util.List;

import com.willydupreez.prototype.config.bean.DefaultPropertiesBeanBuilder;
import com.willydupreez.prototype.config.bean.PropertiesBeanBuilder;
import com.willydupreez.prototype.config.provider.PropertyProvider;

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
