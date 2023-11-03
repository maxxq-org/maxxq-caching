package org.maxxq.caching;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.beanutils.PropertyUtilsBean;

public class DefaultHashFunction implements IHashFunction {
	private final PropertyUtilsBean beanUtils = new PropertyUtilsBean();

	@Override
	public Optional<String> apply(Map<String, Object> paramMap, String key) {
		if (paramMap.isEmpty()) {
			return Optional.empty();
		}
		if (StringUtils.isEmpty(key)) {
			return Optional.empty();
		}
		try {
			return Optional.of(beanUtils.getProperty(paramMap, key).toString());
		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			throw new IllegalArgumentException("Could not derive key '" + key + "' from object : '" + paramMap + "'", e);
		}
	}
}
