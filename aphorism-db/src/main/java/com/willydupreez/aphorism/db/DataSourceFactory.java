/**
 * Copyright (c) 2014, Willy du Preez. All rights reserved.
 */
package com.willydupreez.aphorism.db;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author Willy du Preez
 *
 */
public class DataSourceFactory {

	public DataSource createDataSource(DataSourceProperties dsProps) {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(dsProps.getDsDriverClassname());
		ds.setUsername(dsProps.getDsUsername());
		ds.setPassword(dsProps.getDsPassword());
		ds.setUrl(dsProps.getDsConnectionUrl());
		return ds;
	}

	public DataSource createPooledDataSource(PooledDataSourceProperties dsProps) {
		BasicDataSource ds = (BasicDataSource) createDataSource(dsProps);
//		ds.setMaxConnLifetimeMillis(maxConnLifetimeMillis);
		ds.setMinIdle(dsProps.getDsMinIdleConnections());
		ds.setMaxIdle(dsProps.getDsMaxIdleConnections());
		ds.setMaxTotal(dsProps.getDsMaxTotalConnections());
		return ds;
	}

}
