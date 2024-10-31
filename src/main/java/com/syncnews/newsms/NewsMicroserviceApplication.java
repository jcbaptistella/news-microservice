package com.syncnews.newsms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class NewsMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewsMicroserviceApplication.class, args);
	}

}
