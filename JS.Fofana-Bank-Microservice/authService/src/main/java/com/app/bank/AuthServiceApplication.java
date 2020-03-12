package com.app.bank;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.app.bank.data.UserData;
import com.app.bank.model.User;

@SpringBootApplication
@EnableEurekaClient
public class AuthServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner fillerData(UserData userData) 
	{ return args -> {
				
				User u1 = new User();
				u1.setId(1);
				u1.setFirstname("Amir");
				u1.setLastname("Kamara");
				u1.setEmail("master@gmail.com");
				u1.setPassword("demo");
				userData.save(u1);
				
				User u2 = new User();
				u2.setId(2);
				u2.setFirstname("Zara");
				u2.setLastname("Mansary");
				u2.setEmail("system@gmail.com");
				u2.setPassword("admin");
				userData.save(u2);
			};
		
	}
}
