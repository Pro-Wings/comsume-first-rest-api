package com.prowings.myapp.interceptor;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.StreamUtils;

public class HeaderModificationInterceptor implements ClientHttpRequestInterceptor {

	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {
		System.out.println(">>> inside Header Modifier Interceptor!!!");
		ClientHttpResponse response = execution.execute(request, body);
		
		response.getHeaders().add("aaa", "zzz");
		
		return response;
	}


}
