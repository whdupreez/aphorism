/**
 * Copyright (c) 2014, Willy du Preez. All rights reserved.
 */
package com.willydupreez.aphorism.daemon;

import static java.util.Arrays.asList;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.willydupreez.aphorism.config.ConfigurationFactory;
import com.willydupreez.aphorism.config.DefaultConfigurationFactory;
import com.willydupreez.aphorism.config.provider.ClasspathPropertyProvider;

// TODO Turn Strings into Paths
public class DefaultApplicationEnvironment implements ApplicationEnvironment {

	private static final String BIN_DIR 			= "bin";
	private static final String DATA_DIR 			= "data";
	private static final String DATA_LOG_DIR 		= "log";
	private static final String DATA_SYSTEM_DIR 	= "system";
	private static final String DATA_TMP_DIR 		= "tmp";
	private static final String ETC_DIR 			= "etc";
	private static final String LIB_DIR 			= "lib";
	private static final String RES_DIR 			= "res";
	private static final String RES_PUBLIC_DIR 		= "res-public";
	private static final String SYSTEM_DIR 			= "system";

	public static class Builder {

		private Path appHomePath;

		private Builder() {
		}

		public Builder applicationHome(String appHome) {
			appHomePath = Paths.get(appHome).toAbsolutePath();
			return this;
		}

		public DefaultApplicationEnvironment build() {

			DefaultApplicationEnvironment context = new DefaultApplicationEnvironment();

			context.applicationHomeDirectory = appHomePath.toString();
			context.binDirectory = resolveRelativeDir(BIN_DIR);
			context.configDirectory = resolveRelativeDir(ETC_DIR);
			context.libDirectory = resolveRelativeDir(LIB_DIR);
			context.resourceDirectory = resolveRelativeDir(RES_DIR);
			context.resourcePublicDirectory = resolveRelativeDir(RES_PUBLIC_DIR);
			context.systemDirectory = resolveRelativeDir(SYSTEM_DIR);

			context.dataDirectory = resolveRelativeDir(DATA_DIR);
			context.tempDirectory = resolveRelativeDir(Paths.get(DATA_DIR, DATA_TMP_DIR).toString());
			context.logDirectory = resolveRelativeDir(Paths.get(DATA_DIR, DATA_LOG_DIR).toString());
			context.systemDataDirectory = resolveRelativeDir(Paths.get(DATA_DIR, DATA_SYSTEM_DIR).toString());

			context.configurationFactory = new DefaultConfigurationFactory(
					asList(new ClasspathPropertyProvider("/launcher.properties")));

			return context;
		}

		private String resolveRelativeDir(String child) {
			return appHomePath.resolve(child).toAbsolutePath().toString();
		}

	}

	public static Builder builder() {
		return new Builder();
	}

	private String applicationHomeDirectory;

	private String binDirectory;
	private String configDirectory;
	private String libDirectory;
	private String resourceDirectory;
	private String resourcePublicDirectory;
	private String systemDirectory;

	private String dataDirectory;
	private String tempDirectory;
	private String systemDataDirectory;
	private String logDirectory;

	private ConfigurationFactory configurationFactory;

	private DefaultApplicationEnvironment() {
	}

	@Override
	public String getApplicationHomeDirectory() {
		return applicationHomeDirectory;
	}

	@Override
	public String getDataDirectory() {
		return dataDirectory;
	}

	@Override
	public String getTempDirectory() {
		return tempDirectory;
	}

	@Override
	public String getConfigDirectory() {
		return configDirectory;
	}

	@Override
	public String getLibDirectory() {
		return libDirectory;
	}

	@Override
	public String getResourceDirectory() {
		return resourceDirectory;
	}

	@Override
	public String getResourcePublicDirectory() {
		return resourcePublicDirectory;
	}

	@Override
	public ConfigurationFactory getConfigurationFactory() {
		return configurationFactory;
	}

	String getSystemDirectory() {
		return systemDirectory;
	}

	String getSystemDataDirectory() {
		return systemDataDirectory;
	}

	String getLogDirectory() {
		return logDirectory;
	}

	String getBinDirectory() {
		return binDirectory;
	}

}
