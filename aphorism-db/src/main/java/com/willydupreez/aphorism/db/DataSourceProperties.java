/**
 * Copyright (c) 2014, Willy du Preez. All rights reserved.
 */
package com.willydupreez.aphorism.db;

/**
 *
 * @author Willy du Preez
 *
 */
public class DataSourceProperties {

	private String dsDriverClassname;
	private String dsConnectionUrl;

	private String dsUsername;
	private String dsPassword;

	public String getDsDriverClassname() {
		return dsDriverClassname;
	}

	public void setDsDriverClassname(String dsDriverClassname) {
		this.dsDriverClassname = dsDriverClassname;
	}

	public String getDsConnectionUrl() {
		return dsConnectionUrl;
	}

	public void setDsConnectionUrl(String dsConnectionUrl) {
		this.dsConnectionUrl = dsConnectionUrl;
	}

	public String getDsUsername() {
		return dsUsername;
	}

	public void setDsUsername(String dsUsername) {
		this.dsUsername = dsUsername;
	}

	public String getDsPassword() {
		return dsPassword;
	}

	public void setDsPassword(String dsPassword) {
		this.dsPassword = dsPassword;
	}

}
