package com.willydupreez.util;

import java.util.Objects;

/**
 * Utility methods to ease implementation of <code>equals</code>.
 *
 * <p><em>Arrays are not handled by this class</em>. This is because the
 * {@link Objects#deepEquals(Object, Object)} method should be used
 * for array fields.</p>
 *
 * <p><em>Objects are not handled by this class</em>. This is because the
 * {@link Objects#equals(Object)} method should be used for objects.</p>
 *
 * @author Willy du Preez
 */
public final class Equals {

	static int PRIME = 31;

	private Equals() {
	}

	/**
     * Returns {@code true} if the arguments are equal to each other
     * and {@code false} otherwise.
     *
     * @param a a primitive boolean
     * @param b a primitive boolean to be compared with {@code a} for
     * equality
     * @return {@code true} if the arguments are equal to each other
     * and {@code false} otherwise
	 */
	public static boolean primitiveEquals(boolean a, boolean b) {
		return a == b;
	}

	/**
     * Returns {@code true} if the arguments are equal to each other
     * and {@code false} otherwise.
     *
     * @param a a primitive char
     * @param b a primitive char to be compared with {@code a} for
     * equality
     * @return {@code true} if the arguments are equal to each other
     * and {@code false} otherwise
	 */
	public static boolean primitiveEquals(char a, char b) {
		return a == b;
	}

	/**
     * Returns {@code true} if the arguments are equal to each other
     * and {@code false} otherwise.
     *
     * <p><em>Note:</em> byte, short and int are handled by this method through
     * implicit conversion.</p>
     *
     * @param a a primitive long
     * @param b a primitive long to be compared with {@code a} for
     * equality
     * @return {@code true} if the arguments are equal to each other
     * and {@code false} otherwise
	 */
	public static boolean primitiveEquals(long a, long b) {
		return a == b;
	}

	/**
     * Returns {@code true} if the arguments are equal to each other
     * and {@code false} otherwise.
     *
     * @param a a primitive float
     * @param b a primitive float to be compared with {@code a} for
     * equality
     * @return {@code true} if the arguments are equal to each other
     * and {@code false} otherwise
	 */
	public static boolean primitiveEquals(float a, float b) {
		return Float.floatToIntBits(a) == Float.floatToIntBits(b);
	}

	/**
     * Returns {@code true} if the arguments are equal to each other
     * and {@code false} otherwise.
     *
     * @param a a primitive double
     * @param b a primitive double to be compared with {@code a} for
     * equality
     * @return {@code true} if the arguments are equal to each other
     * and {@code false} otherwise
	 */
	public static boolean primitiveEquals(double a, double b) {
		return Double.doubleToLongBits(a) == Double.doubleToLongBits(b);
	}

	public static int hashValue(Object obj) {
		return obj == null ? 0 : obj.hashCode() * PRIME;
	}

}
