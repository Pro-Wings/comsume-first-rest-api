package com.prowings.myapp.config;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.DefaultUriBuilderFactory;

import lombok.Getter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.prowings.myapp")
@PropertySource("classpath:application.properties")
@Getter
public class MyWebConfig implements WebMvcConfigurer {

	@Value("${base_url}")
	private String url;

	@Value("${timeout}")
	int requestTimeout;

	@Bean
    public CloseableHttpClient httpClient() {
        return HttpClients.createDefault();
    }
	
//	@Bean
//	public RestTemplate restTemplate() {
//		return new RestTemplate();
//	}
	
	@Bean
	public RestTemplate restTemplate() {
//		return new RestTemplate();
		RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory());
		restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory(url));
		restTemplate.setErrorHandler(new MyRestTemplateResponseErrorHandler());
		return restTemplate;
	}

	private ClientHttpRequestFactory clientHttpRequestFactory() {
		HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		clientHttpRequestFactory.setHttpClient(httpClient());
		clientHttpRequestFactory.setConnectionRequestTimeout(requestTimeout);
		clientHttpRequestFactory.setConnectTimeout(requestTimeout);
		clientHttpRequestFactory.setReadTimeout(requestTimeout);
		return clientHttpRequestFactory;
	}

}
