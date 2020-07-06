package com.perusitadev.pokebattleapi.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApiConfig {

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@Bean
	public HttpHeaders getHeaders(){
		HttpHeaders headers = new HttpHeaders();
		headers.set("User-Agent", "poke api");
        return headers;
	}
	
	@Bean
    public HttpEntity<String> stringHttpEntity() {
        return new HttpEntity<>(getHeaders());
    }
}
