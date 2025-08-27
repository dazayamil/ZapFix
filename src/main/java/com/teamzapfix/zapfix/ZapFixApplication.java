package com.teamzapfix.zapfix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@SpringBootApplication
public class ZapFixApplication {
	public static void main(String[] args) {
		SpringApplication.run(ZapFixApplication.class, args);
	}
}