/**
 * Copyright (c) 2014, Willy du Preez. All rights reserved.
 */
package com.willydupreez.aphorism.daemon;

import com.willydupreez.aphorism.config.ConfigurationFactory;

public interface ApplicationEnvironment  {

	String getApplicationHomeDirectory();
	String getDataDirectory();
	String getTempDirectory();
	String getConfigDirectory();
	String getLibDirectory();
	String getResourceDirectory();
	String getResourcePublicDirectory();

	ConfigurationFactory getConfigurationFactory();

}
