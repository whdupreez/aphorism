/**
 * Copyright (c) 2014, Willy du Preez. All rights reserved.
 */
package com.willydupreez.aphorism.config.convert;

/**
 * Converts a string to a type. Used to provide type-safe properties.
 *
 * @author Willy du Preez
 *
 * @param <T> the value type to convert the property to
 */
public interface TypeConverter<T> {

	/**
	 * Converts the string argument to the type.
	 *
	 * @param property the property to convert.
	 * @return the converted type.
	 */
	T convertToType(String property);

	/**
	 * The Class type that the converter converts to.
	 *
	 * @return the class type
	 */
	Class<T> getType();

}
