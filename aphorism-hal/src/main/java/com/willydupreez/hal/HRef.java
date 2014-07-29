package com.willydupreez.hal;

import static com.willydupreez.util.Equals.hashValue;
import static com.willydupreez.util.Strings.isNullOrWhitespace;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents either a {@link URI} or a URI Template [RFC6570].
 *
 * HRef is immutable.
 *
 * TODO URI Template validation / support
 *
 * @author Willy du Preez
 *
 */
public class HRef {

	private URI uri;
	private String templatedUri;

	public HRef(URI uri) {
		if (uri == null) {
			throw new IllegalArgumentException("URI cannot be null");
		}
		this.uri = uri;
	}

	public HRef(String uri, boolean templated) {

		if (isNullOrWhitespace(uri)) {
			throw new IllegalArgumentException("Invalid URI String: " + uri);
		}

		if (templated) {
			this.templatedUri = uri;
		} else {
			try {
				this.uri = new URI(uri);
			} catch (URISyntaxException e) {
				throw new IllegalArgumentException("Invalid URI syntax", e);
			}
		}
	}

	@JsonProperty(value = "href", required = true)
	public String getValue() {
		if (isTemplated()) {
			return this.templatedUri;
		} else {
			return this.uri.toString();
		}
	}

	public boolean isTemplated() {
		return this.uri == null;
	}

	@Override
	public String toString() {
		return isTemplated() ?
				"HRef [templatedUri=" + this.templatedUri + "]" :
				"HRef [uri=" + this.uri + "]";
	}

	@Override
	public int hashCode() {
		int result = 17;
		result += hashValue(templatedUri);
		result += hashValue(uri);
		return result;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}

		if (!(obj instanceof HRef)) {
			return false;
		}

		HRef other = (HRef) obj;

		return Objects.equals(this.templatedUri, other.templatedUri)
				&& Objects.equals(this.uri, other.uri);
	}

}
