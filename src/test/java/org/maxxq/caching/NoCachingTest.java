package org.maxxq.caching;

import org.aspectj.lang.ProceedingJoinPoint;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class NoCachingTest {
    private final NoCaching noCaching = new NoCaching();
    
    @Mock
    private ProceedingJoinPoint joinPoint;
    
    @Test
    public void checkCached() throws Throwable {
        noCaching.getCachedOrProceed( joinPoint );
        
        Mockito.verify( joinPoint ).proceed();
    }
}
