package org.maxxq.caching;

import org.aspectj.lang.ProceedingJoinPoint;

public class NoCaching implements ICacheOchestrator {

    @Override
    public Object getCachedOrProceed( ProceedingJoinPoint joinPoint ) throws Throwable {
        return joinPoint.proceed();
    }

}
