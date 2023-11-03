package org.maxxq.caching;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target( { ElementType.TYPE, ElementType.METHOD } )
@Retention( RetentionPolicy.RUNTIME )
public @interface Cacheable {

    public String cacheManager();

    public String key() default "";
    
    public Class<? extends IHashFunction> hashFunction() default DefaultHashFunction.class;
}
