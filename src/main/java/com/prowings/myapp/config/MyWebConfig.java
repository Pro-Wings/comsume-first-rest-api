package com.prowings.myapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.prowings.myapp")
public class MyWebConfig implements WebMvcConfigurer{


	@Bean
	public RestTemplate restTemplate()
	{
		return new RestTemplate();
	}

}
