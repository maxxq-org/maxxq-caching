package org.maxxq.caching;

import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;

public interface IHashFunction extends BiFunction<Map<String, Object>, String, Optional<String>> {

}
