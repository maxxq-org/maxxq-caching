package org.maxxq.caching;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CacheConfigurationTest {
    @Mock
    private ICacheOchestrator cacheOrchestrator;

    @Test
    public void getInstance() {
        Assertions.assertNotNull( CacheConfiguration.getInstance() );
    }

    @Test
    public void setGetCacheOrchestrator() {
        CacheConfiguration.getInstance().setCacheOrchestrator( cacheOrchestrator );

        Assertions.assertSame( cacheOrchestrator, CacheConfiguration.getInstance().getCacheOrchestrator() );
    }
}
