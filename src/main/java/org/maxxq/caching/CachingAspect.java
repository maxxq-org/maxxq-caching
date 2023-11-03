package org.maxxq.caching;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class CachingAspect {
    @Pointcut( "@annotation(org.maxxq.caching.Cacheable)" )
    public void methodAnnotedWithCached() {
        //AOP PointCut for methods annotated with @Cacheable
    }

    @Pointcut( "execution(* *(..))" )
    public void executionOfMethod() {
        //Execution of any method
    }
    

    @Around( "executionOfMethod() && methodAnnotedWithCached()" )
    public Object checkCached( ProceedingJoinPoint joinPoint ) throws Throwable {
        return CacheConfiguration.getInstance().getCacheOrchestrator().getCachedOrProceed( joinPoint );
    }
}
