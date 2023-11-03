package org.maxxq.caching;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DefaultHashFunctionTest {
	private DefaultHashFunction hashFunction = new DefaultHashFunction();

	@Test
	public void apply() {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("employee", new Person().setName("Guy"));

		Assertions.assertEquals("Guy", hashFunction.apply(paramMap, "employee.name").get());
	}

	@Test
	public void applyEmptyKey() {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("employee", new Person().setName("Guy"));

		Assertions.assertFalse(hashFunction.apply(paramMap, "").isPresent());
	}

	@Test
	public void applyNonExistingKey() {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("employee", new Person().setName("Guy"));

		Assertions.assertThrows(IllegalArgumentException.class,
				() -> hashFunction.apply(paramMap, "employee.name.nonexistingkey"));
	}

	@Test
	public void applyNoParams() {
		Assertions.assertEquals(Optional.empty(), hashFunction.apply(new HashMap<String, Object>(), "someKey"));
	}

}
