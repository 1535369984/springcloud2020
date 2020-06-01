package com.wl.springcloud.utils;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Configuration
public class RestTemplateConfig {

	@Resource private RestTemplateBuilder restTemplateBuilder;

	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = restTemplateBuilder
				.build();
		return restTemplate;
	}


}

