package org.maxxq.caching;

public class StringUtils {
	private StringUtils() {
	}

	public static boolean isEmpty(final CharSequence cs) {
		return cs == null || cs.length() == 0;
	}
}
