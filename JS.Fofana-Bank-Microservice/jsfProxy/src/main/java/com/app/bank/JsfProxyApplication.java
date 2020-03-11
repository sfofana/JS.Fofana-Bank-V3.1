package com.app.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class JsfProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(JsfProxyApplication.class, args);
	}

}
