package com.myhaimi.sms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmsApplication.class, args);
		System.out.println("Hi Kashish , Please manually click http://localhost:8080/swagger-ui/index.html");
	}

}
