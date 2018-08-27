package com.prem.proxy.springproxygateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringProxyGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringProxyGatewayApplication.class, args);
	}
}
