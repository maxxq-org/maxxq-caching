package org.maxxq.caching;

import org.aspectj.lang.ProceedingJoinPoint;

public interface ICacheOchestrator {
    public Object getCachedOrProceed( ProceedingJoinPoint joinPoint ) throws Throwable;
}
