package com.willydupreez.hal;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests {@link HRef}.
 *
 * @author Willy du Preez
 *
 */
public class HRefTest {

	private static final String URI = "href";
	private static final String TEMPLATED_URI = "href/{id}";

	private URI uri;
	private String templatedUri;

	@Before
	public void before() throws URISyntaxException {
		uri = new URI(URI);
		templatedUri = TEMPLATED_URI;
	}

	@Test
	public void testUri() {
		HRef href = new HRef(uri);
		assertThat(href.getValue(), is(URI));
		assertThat(href.isTemplated(), is(false));
	}

	@Test
	public void testUriFromString() {
		HRef href = new HRef(uri.toString(), false);
		assertThat(href.getValue(), is(URI));
		assertThat(href.isTemplated(), is(false));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidUriFromString() {
		new HRef(uri.toString() + "{}", false);
	}

	@Test
	public void testUriTemplate() {
		HRef href = new HRef(templatedUri, true);
		assertThat(href.getValue(), is(TEMPLATED_URI));
		assertThat(href.isTemplated(), is(true));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testUri_Null() {
		new HRef(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testUriFromString_Null() {
		new HRef(null, true);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testUriFromString_Empty() {
		new HRef("   ", true);
	}

}
