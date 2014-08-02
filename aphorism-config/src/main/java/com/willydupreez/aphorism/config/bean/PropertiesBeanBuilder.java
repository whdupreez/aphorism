/**
 * Copyright (c) 2014, Willy du Preez. All rights reserved.
 */
package com.willydupreez.aphorism.config.bean;

import java.util.List;

import com.willydupreez.aphorism.config.provider.PropertyProvider;

public interface PropertiesBeanBuilder {

	<T> T buildPropertiesBean(Class<T> propertiesBeanType, List<PropertyProvider> providers);

}
