package com.willydupreez.prototype.structure;

import com.willydupreez.prototype.config.ConfigurationFactory;

public interface LauncherContext  {

	String getApplicationHomeDirectory();
	String getDataDirectory();
	String getTempDirectory();
	String getConfigDirectory();
	String getLibDirectory();
	String getResourceDirectory();
	String getResourcePublicDirectory();

	ConfigurationFactory getConfigurationFactory();

}
