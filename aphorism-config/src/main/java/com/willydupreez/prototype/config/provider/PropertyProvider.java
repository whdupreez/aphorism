package com.willydupreez.prototype.config.provider;

import java.util.Optional;

/**
 * Provides properties.
 *
 * @author Willy du Preez
 *
 */
public interface PropertyProvider {

	/**
	 * Gets the property value for the specified key.
	 *
	 * @param key the key
	 * @return the value
	 */
	Optional<String> getProperty(String key);

}
