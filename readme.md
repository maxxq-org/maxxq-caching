# EE Core Caching

This library provides the ability to put caching with annotations on libraries.
The caching can be connected to the preferred caching library e.g. ehcache.

## Getting Started

In the pom.xml of the library you are building, create a dependency with this library

	<dependency>
		<groupId>org.maxxq.maven</groupId>
		<artifactId>maxxq-caching</artifactId>
		<version>1.0.0</version>
	</dependency>
	
In the library use the @Cacheable annotation

The following properties can be given:

- cacheManager : logical name of the cache
- key : The key that will be used to uniquely identify the incoming parameters.  
- hashFunction : class containing a function which has the ability to transform the given 'key' to hash with the given input parameters

## Using your library somewhere else

Create a dependency with your library.

Create a dependency with a cache adapter library.

Initialise the cached configuration with
	
	CacheConfiguration.getInstance().setCacheOrchestrator(someOrchestratorFromTheImplementation)
	

	
## Basic implementation

A basic implementation is given in 

	<dependency>
		<groupId>org.maxxq</groupId>
		<artifactId>maxxq-basiccaching</artifactId>
		<version>1.0.0</version>
	</dependency>
	
	
Cache configuration can be done like:

	  CacheConfiguration.getInstance()
            .setCacheOrchestrator(
                new DefaultCacheOrchestrator(
                    new MultiLevelCacheProvider()
                        .addCacheProvider( new InMemoryCacheProvider() )
                        .addCacheProvider( new FileCacheProvider( new File( "c:/temp/cache" ) ) ),
                    new JoinPointOperationsFactory( new MethodParamsToMap() ) )
                        .setAllowAsynCacheRefresh( false ) );
