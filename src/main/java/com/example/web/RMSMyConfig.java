package com.example.web;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;

public class RMSMyConfig {
	@Bean
	public ResourceConfig getJersey() {
		ResourceConfig config=new ResourceConfig();
		/*config.register(CompteRestService.class);*/
		return config;
	}
}

