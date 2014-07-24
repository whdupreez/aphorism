package com.willydupreez.prototype.config.provider;

import java.util.Optional;

/**
 * Adds a prefix to a key before doing a property lookup.
 * Useful to namespace certain providers such as the
 * {@link SystemPropertyProvider} or {@link JavaPropertyProvider}
 * that is essentially as a global property namespace.
 *
 * @author Willy du Preez
 *
 */
public class PrefixedPropertyProvider implements PropertyProvider {

	private String prefix;
	private PropertyProvider delegate;

	/**
	 * The provided prefix is added to every key looked up.
	 *
	 * @param prefix the key prefix
	 * @param delegate the delegate provider
	 */
	public PrefixedPropertyProvider(String prefix, PropertyProvider delegate) {
		this.prefix = prefix;
		this.delegate = delegate;
	}

	@Override
	public Optional<String> getProperty(String key) {
		String prefixedKey = prefix + key;
		return delegate.getProperty(prefixedKey);
	}

}
