package com.willydupreez.util;

/**
 * Basic String utilities without the need for external dependencies.
 *
 * @author Willy du Preez
 *
 */
public final class Strings {

	private Strings() {
	}

	/**
	 * Returns true if the string is null or empty.
	 *
	 * @param value the value to check
	 * @return true if the string is null or empty
	 */
	public static boolean isNullOrEmpty(String value) {
		return value == null || value.isEmpty();
	}

	/**
	 * Returns true if the string is null, empty, or consists only
	 * of whitespace characters.
	 *
	 * @param value the value to check
	 * @return true if the string is null, empty, or whitespace
	 */
	public static boolean isNullOrWhitespace(String value) {
		return value == null || value.trim().isEmpty();
	}

}
