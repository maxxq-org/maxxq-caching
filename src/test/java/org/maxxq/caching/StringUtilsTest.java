package org.maxxq.caching;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringUtilsTest {
	@Test
	public void isEmpty() {
		Assertions.assertTrue(StringUtils.isEmpty(null));
		Assertions.assertTrue(StringUtils.isEmpty(""));
	}

	@Test
	public void isNotEmpty() {
		Assertions.assertFalse(StringUtils.isEmpty("a"));
	}

}
