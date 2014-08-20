/**
 * Copyright (c) 2014, Willy du Preez. All rights reserved.
 */
package com.willydupreez.aphorism.db;

/**
 *
 * @author Willy du Preez
 *
 */
public class PooledDataSourceProperties extends DataSourceProperties {

	private int dsMinIdleConnections;
	private int dsMaxIdleConnections;
	private int dsMaxTotalConnections;

	public int getDsMinIdleConnections() {
		return dsMinIdleConnections;
	}

	public void setDsMinIdleConnections(int dsMinIdleConnections) {
		this.dsMinIdleConnections = dsMinIdleConnections;
	}

	public int getDsMaxIdleConnections() {
		return dsMaxIdleConnections;
	}

	public void setDsMaxIdleConnections(int dsMaxIdleConnections) {
		this.dsMaxIdleConnections = dsMaxIdleConnections;
	}

	public int getDsMaxTotalConnections() {
		return dsMaxTotalConnections;
	}

	public void setDsMaxTotalConnections(int dsMaxTotalConnections) {
		this.dsMaxTotalConnections = dsMaxTotalConnections;
	}

}
