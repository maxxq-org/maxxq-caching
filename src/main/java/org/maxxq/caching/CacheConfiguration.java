package org.maxxq.caching;

public class CacheConfiguration {
    private static final CacheConfiguration SINGLETON         = new CacheConfiguration();

    private ICacheOchestrator         cacheOrchestrator = new NoCaching();

    public static CacheConfiguration getInstance() {
        return SINGLETON;
    }

    public ICacheOchestrator getCacheOrchestrator() {
        return cacheOrchestrator;
    }

    public void setCacheOrchestrator( ICacheOchestrator cacheOrchestrator ) {
        this.cacheOrchestrator = cacheOrchestrator;
    }
}
