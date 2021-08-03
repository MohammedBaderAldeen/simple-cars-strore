package com.example.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.session.data.redis.config.ConfigureRedisAction;


@SpringBootApplication
@EnableCaching
public class CarWebApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(CarWebApplication.class, args);
	}
	
	  @Bean
	    public CacheManager cacheManager() {
	        return new ConcurrentMapCacheManager("parametars-cache");
	    }
	
	
	@Bean
    public ConfigureRedisAction configureRedisAction() {
        return ConfigureRedisAction.NO_OP;
    }

}
