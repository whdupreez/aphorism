/**
 * Copyright (c) 2014, Willy du Preez. All rights reserved.
 */
package com.willydupreez.aphorism.config;

import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.willydupreez.aphorism.config.bean.DefaultPropertiesBeanBuilder;
import com.willydupreez.aphorism.config.bean.PropertiesBeanBuilder;
import com.willydupreez.aphorism.config.provider.PropertyProvider;

public class EnvironmentConfigurationFactory implements ConfigurationFactory {

	public static class Builder {

		private final String environment;

		private Path directory;

		private PropertiesBeanBuilder builder;
		private List<PropertyProvider> providers;

		public Builder(String environment) {
			this.environment = environment;
		}

		public Builder withPropertiesBeanBuilder(PropertiesBeanBuilder builder) {
			this.builder = builder;
			return this;
		}

		public Builder withPropertiesDirectory(String path) {
			try {
				this.directory = Paths.get(path);
			} catch (InvalidPathException e) {
				throw new ConfigurationException("Invalid Path: " + path, e);
			}
			if (!Files.isDirectory(directory)) {
				throw new ConfigurationException("Path is not a directory: " + path);
			}
			return this;
		}

		public ConfigurationFactory build() {
			if (this.builder == null) {
				this.builder = new DefaultPropertiesBeanBuilder();
			}
			return new EnvironmentConfigurationFactory(environment, builder);
		}

	}

	private PropertiesBeanBuilder builder;
	private String environment;

	private EnvironmentConfigurationFactory(String environment, PropertiesBeanBuilder builder) {
		this.environment = environment;
		this.builder = builder;
	}

	@Override
	public <T> T create(Class<T> propertiesBeanType) {
		return null;
	}

}
