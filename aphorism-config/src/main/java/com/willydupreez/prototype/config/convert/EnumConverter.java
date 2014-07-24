package com.willydupreez.prototype.config.convert;

public class EnumConverter<E extends Enum<E>> implements TypeConverter<E> {

	private Class<E> type;

	public EnumConverter(Class<E> type) {
		this.type = type;
	}

	@Override
	public E convertToType(String property) {
		try {
			return Enum.valueOf(type, property);
		} catch (IllegalArgumentException | NullPointerException e) {
			throw new TypeConversionException("Failed to convert value to enum [" + type + "]: " + property);
		}
	}

	@Override
	public Class<E> getType() {
		return type;
	}

}
